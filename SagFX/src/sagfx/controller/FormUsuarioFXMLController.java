/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Catalogo;
import sagfx.model.beans.Rancho;
import sagfx.model.beans.Usuario;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class FormUsuarioFXMLController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellidoP;
    @FXML
    private TextField txt_apellidoM;
    @FXML
    private TextField txt_celular;
    @FXML
    private TextField txt_usuario;
    @FXML
    private PasswordField txt_contrasena;
    @FXML
    private ComboBox cmb_rol;
    @FXML
    private CheckBox chb_estatus;
    @FXML
    private ComboBox cmb_rancho;
    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cancelar;
    
    Usuario usuario = null;
    Boolean isNew = null;
    private HashMap<String, Object> context;
    List<Catalogo> listComboRol;
    List<Rancho> listComboRancho;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  
    
    //Para pasar datos en cada controlador
    public void setData(Usuario usuario, Boolean isNew, HashMap<String, Object> context) {
        this.usuario = usuario;
        this.isNew = isNew;
        this.context=context;
        this.cargarUsuarios();
        this.cargarRolesUsuario();
        this.cargarRanchos();
    }
    
    public void cargarUsuarios() {
        if (!this.isNew) {
            this.txt_nombre.setText(usuario.getNombre());
            this.txt_apellidoP.setText(usuario.getApellidoPaterno());
            this.txt_apellidoM.setText(usuario.getApellidoMaterno());
            this.txt_celular.setText(usuario.getCelular());
            this.txt_usuario.setText(usuario.getUsuario());
            this.txt_contrasena.setText(usuario.getContrasena());
            if ("S".equals(usuario.getEstatus())) {
                this.chb_estatus.setText("Activo");
                this.chb_estatus.setSelected(true);
            } else {
                this.chb_estatus.setText("Inaactivo");
                this.chb_estatus.setSelected(false);
            }
        }
    }
    
    private void checkEstatus(ActionEvent event) {
        if (this.chb_estatus.isSelected()) {
            this.chb_estatus.setText("Activo");
        } else {
            this.chb_estatus.setText("Inactivo");
        }
    }
    
    public void cargarRolesUsuario(){
        String respuesta = "";
        respuesta = Requests.get("/catalogo/getAllRolesUsuario/");
        Gson gson = new Gson();
        TypeToken<List<Catalogo>> token = new TypeToken<List<Catalogo>>(){
        };
        this.listComboRol  = gson.fromJson(respuesta, token.getType());
        
        ObservableList<String> comboListaRolesU = FXCollections.observableArrayList();
        
        
        listComboRol.forEach(e ->{
            comboListaRolesU.add(e.getNombre());
        });
        
        this.cmb_rol.setItems(comboListaRolesU);
    }
    
    private Boolean validarDatos() {
        Boolean valido = true;
        if(this.txt_nombre.getText().isEmpty() || this.txt_apellidoP.getText().isEmpty() || this.txt_apellidoM.getText().isEmpty()){
            valido=false;
        }
        return valido;
    }

    @FXML
    private void guardar(ActionEvent event) {
        if (validarDatos()) {
            try {
                String data = "";
                Usuario usuario = (Usuario) this.context.get("usuario");
                System.out.println("idUsuario:" + usuario.getIdUsuario());
                
                HashMap<String, Object> params = new LinkedHashMap<>();
                params.put("nombre", this.txt_nombre.getText());
                params.put("apellidoPaterno", this.txt_apellidoP.getText());
                params.put("apellidoMaterno", this.txt_apellidoM.getText());
                params.put("celular", this.txt_celular.getText());
                params.put("usuario", this.txt_usuario.getText());
                params.put("contrasena", this.txt_contrasena.getText());
                
                int idRolU=0;
                for(int i=0; i<this.listComboRol.size(); i++){
                    if(this.listComboRol.get(i).getNombre().equals(this.cmb_rol.getValue().toString())){
                        idRolU = this.listComboRol.get(i).getIdCatalogo();
                        
                    }
                }
                params.put("idRol", idRolU);
                
                if (this.chb_estatus.isSelected()) {
                    params.put("idEstatus", 101);
                } else {
                    params.put("idEstatus", 102);
                }
                
                int idRanchU=0;
                for(int i=0; i<this.listComboRancho.size(); i++){
                    if(this.listComboRancho.get(i).getNombre().equals(this.cmb_rancho.getValue().toString())){
                        idRanchU = this.listComboRancho.get(i).getIdRancho();
                    }
                }
                params.put("idRancho", idRanchU);
                
                if (this.isNew) {
                    params.put("idUsuarioCreador", usuario.getIdUsuario());
                    params.put("fechaCreacion", LocalDate.now());
                    data = Requests.post("/usuario/registrarUsuario/", params);
                } else {
                    params.put("idUsuarioModificador", usuario.getIdUsuario());
                    params.put("fechaModificacion", LocalDate.now());
                    data = Requests.post("/usuario/actualizarUsuario/", params);
                }
                JSONObject dataJson = new JSONObject(data);

                if ((Boolean) dataJson.get("error") == false) {
                    Window.close(event);
                    Window.showMessageInformation(dataJson.get("mensaje").toString());

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Diálogo de error...");
                    alert.setHeaderText(null);
                    alert.setContentText("Error al guardar");
                    alert.showAndWait();
                }
            } catch (JSONException ex) {
                Logger.getLogger(FormRanchoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Diálogo de error...");
                    alert.setHeaderText(null);
                    alert.setContentText("Error, intenta con otros datos");
                    alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Diálogo de error...");
            alert.setHeaderText(null);
            alert.setContentText("Campos vacíos");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Window.close(event);
    }
    
    public void cargarRanchos(){
        String respuesta = "";
        respuesta = Requests.get("/rancho/getAllRanchos/");
        Gson gson = new Gson();
        TypeToken<List<Rancho>> token = new TypeToken<List<Rancho>>(){
        };
        this.listComboRancho  = gson.fromJson(respuesta, token.getType());
        
        ObservableList<String> comboListaRanchos = FXCollections.observableArrayList();
        
        
        listComboRancho.forEach(e ->{
            comboListaRanchos.add(e.getNombre());
        });
        
        this.cmb_rancho.setItems(comboListaRanchos);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
public class UsuariosFXMLController implements Initializable {

    private Usuario usuario=null;
    
    @FXML
    private TextField txt_busqueda;
    @FXML
    private Button btn_buscar;
    @FXML
    private Button btn_limpiar;
    
    @FXML
    private TableView<Usuario> tbl_usuario;
    @FXML
    private TableColumn<Usuario, String> tcl_nombre;
    @FXML
    private TableColumn<Usuario, String> tcl_celular;
    @FXML
    private TableColumn<Usuario, String> tcl_usuario;
    @FXML
    private TableColumn<Usuario, String> tcl_rol;
    @FXML
    private TableColumn<Usuario, String> tcl_estatus;
    @FXML
    private TableColumn<Usuario, String> tcl_rancho;
    private TableColumn<Usuario, String> tcl_usuarioAlta;
    private TableColumn<Usuario, String> tcl_fechaAlta;
    private TableColumn<Usuario, String> tcl_usuarioEditor;
    private TableColumn<Usuario, String> tcl_fechaEdicion;
    @FXML
    private Button btn_desactivarUsuario;
    @FXML
    private Button btn_activarUsuario;
    @FXML
    private Button btn_editarUsuario;
    @FXML
    private Button btn_nuevoUsuario;
    
    private HashMap<String, Object> context;
    @FXML
    private TableColumn<?, ?> tcl_usuarioCreador;
    @FXML
    private TableColumn<?, ?> tcl_fechaCreacion;
    @FXML
    private TableColumn<?, ?> tcl_usuarioModi;
    @FXML
    private TableColumn<?, ?> tcl_fechaModi;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cargarUsuarios();
    }    
    
    //Para pasar datos en cada controlador
    public void setData(HashMap<String, Object> context){
        System.out.println(context);
        this.context=context;
    }
    
    public void cargarUsuarios(){
        this.usuario=null;
        String respuesta = "";
        tbl_usuario.getItems().clear();
        
        respuesta = Requests.get("/usuario/getAllUsers/");
        Gson gson = new Gson();
        
        //Definimos un TypeToken qie re´resenta una lista de objetos Usuario
        TypeToken<List<Usuario>> token = new TypeToken<List<Usuario>>(){
        };
        //Utilizamos el método fromJson{} de la clase Gson para convertir el JSON en una lista de objetos
        List<Usuario> listUsuarios = gson.fromJson(respuesta, token.getType());
        
        tcl_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcl_celular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        tcl_usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        tcl_rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        tcl_estatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tcl_rancho.setCellValueFactory(new PropertyValueFactory<>("rancho"));
        tcl_usuarioCreador.setCellValueFactory(new PropertyValueFactory<>("usuarioCreador"));
        tcl_fechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_usuarioModi.setCellValueFactory(new PropertyValueFactory<>("usuarioCreador"));
        tcl_fechaModi.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        
        listUsuarios.forEach(e ->{
            tbl_usuario.getItems().add(e);
        });
        /*for(Categoria c: listCategorias){
            tbl_categorias.getItems().add(c);
        }*/
        System.out.println(listUsuarios.size());
    }
    
    @FXML
    private void clickTable(MouseEvent event) {
        String respuesta = "";
        if (tbl_usuario.getSelectionModel().getSelectedItem() != null) {
            usuario = tbl_usuario.getSelectionModel().getSelectedItem();
        }
    }


    @FXML
    private void limpiar(ActionEvent event) {
        this.txt_busqueda.setText("");
        this.cargarUsuarios();
    }
    
    @FXML
    private void buscarUsuario(ActionEvent event) {
        String respuesta = "";
        this.tbl_usuario.getItems().clear();
        this.usuario = null;

        HashMap<String, Object> params = new LinkedHashMap<>();
        params.put("busqueda", this.txt_busqueda.getText());

        respuesta = Requests.post("/usuario/buscarUsuario", params);
        Gson gson = new Gson();

        //Definimos u  TypeToken que representa una lista de objetos Categoria
        TypeToken<List<Usuario>> token = new TypeToken<List<Usuario>>() {
        };

        //Utilizamos el método fromJson() de la clase Gson para convertir el JSON en una lista de objetos
        List<Usuario> listUsuario = gson.fromJson(respuesta, token.getType());

        if (listUsuario.size() > 0) {
            tcl_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tcl_celular.setCellValueFactory(new PropertyValueFactory<>("celular"));
            tcl_usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
            tcl_rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
            tcl_estatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
            tcl_rancho.setCellValueFactory(new PropertyValueFactory<>("rancho"));
            tcl_usuarioAlta.setCellValueFactory(new PropertyValueFactory<>("usuarioAlta"));
            tcl_fechaAlta.setCellValueFactory(new PropertyValueFactory<>("fechaAlta"));
            tcl_usuarioEditor.setCellValueFactory(new PropertyValueFactory<>("usuarioEditor"));
            tcl_fechaEdicion.setCellValueFactory(new PropertyValueFactory<>("fechaEdicion"));

            listUsuario.forEach(e -> {
                tbl_usuario.getItems().add(e);
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Los datos no coinciden con ningún registro...");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void nuevoUsuario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormUsuarioFXML.fxml"));
            Parent formUsuario = loader.load();
            FormUsuarioFXMLController ctrl = loader.getController();
            ctrl.setData(this.usuario,true, context);
            Scene scene = new Scene(formUsuario);
            Stage stageUsuarios = new Stage();
            stageUsuarios.setTitle("Usuarios");
            stageUsuarios.setResizable(false);
            stageUsuarios.setScene(scene);
            stageUsuarios.showAndWait();
            this.cargarUsuarios();

        } catch (IOException ex) {
            Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void editarUsuario(ActionEvent event) {
        if(this.usuario != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormUsuarioFXML.fxml"));
                Parent formUsuario = loader.load();
                FormUsuarioFXMLController ctrl = loader.getController();
                ctrl.setData(this.usuario, false, context);
                Scene scene = new Scene(formUsuario);
                Stage stageUsuarios = new Stage();
                stageUsuarios.setTitle("Usuarios");
                stageUsuarios.setResizable(false);
                stageUsuarios.setScene(scene);
                stageUsuarios.showAndWait();
                this.cargarUsuarios();
                
                
            } catch (IOException ex) {
                Logger.getLogger(CategoriasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar un usuario...");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void activarUsuario(ActionEvent event) {
        if (this.usuario != null) {
            if (101 != (usuario.getIdEstatus())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere activar el usuario " + this.usuario.getNombre() + "?");
                if (conf) {
                    this.actualizarEstatusUsuario("Activo");
                }
            } else {
                Window.showMessageInformation("El usuario ya esta activo...");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar un usuario...");
        }
    }

    @FXML
    private void desactivarUsuario(ActionEvent event) {
        if (this.usuario != null) {
            if (102 != (usuario.getIdEstatus())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere desactivar el usuario " + this.usuario.getNombre() + "?");
                if (conf) {
                    this.actualizarEstatusUsuario("Inactivo");
                }

            } else {
                Window.showMessageInformation("El usuario ya esta Inactivo");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar un usuario...");
        }
    }

    public void actualizarEstatusUsuario(String activo) {
        
        try {
            String data = "";
            HashMap<String, Object> params = new LinkedHashMap<>();
            params.put("idUsuario", this.usuario.getIdUsuario());
            if("Activo".equals(activo)){
                params.put("idEstatus", 101);
            
            }else{
                params.put("idEstatus", 102);
            }
            data = Requests.post("/usuario/actualizarEstatusUsuario/", params);

            JSONObject dataJson = new JSONObject(data);

            if ((Boolean) dataJson.get("error") == false) {
                Window.showMessageInformation(dataJson.get("mensaje").toString());
                this.cargarUsuarios();
            } else {
                Window.showMessageError(dataJson.get("mensaje").toString());
            }
        } catch (JSONException ex) {
            Logger.getLogger(RanchosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

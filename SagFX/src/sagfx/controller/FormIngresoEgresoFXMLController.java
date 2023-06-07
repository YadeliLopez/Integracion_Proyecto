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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Catalogo;
import sagfx.model.beans.Movimiento;
import sagfx.model.beans.Usuario;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class FormIngresoEgresoFXMLController implements Initializable {

    
    private Movimiento movimiento = null;
    Boolean isNew = null;
    private HashMap<String, Object> context;
    List<Catalogo> listCombo;
    @FXML
    private ComboBox cmb_tipo;
    @FXML
    private ComboBox cmb_concepto;
    @FXML
    private TextField txt_cantidad;
    @FXML
    private TextField txt_descripcion;
    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cancelar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Para pasar datos en cada controlador
    public void setData(Movimiento movimiento, Boolean isNew, HashMap<String, Object> context) {
        this.movimiento = movimiento;
        this.isNew = isNew;
        this.context=context;
        System.out.println(context);
        this.cargarMovimientos();
        this.cargarComboTipo();
        
    }
    
    public void cargarMovimientos() {
        if (!this.isNew) {
            this.txt_cantidad.setText(movimiento.getCantidad());
            this.txt_descripcion.setText(movimiento.getDescripcion());
        }
    }
    
    public void cargarComboTipo(){
        
        ObservableList<String> comboListaTipos = FXCollections.observableArrayList();
        comboListaTipos.add("Ingreso");
        comboListaTipos.add("Egreso");
        this.cmb_tipo.setItems(comboListaTipos);
    }
   
    public void cargarIngreso(){
        String respuesta = "";
        respuesta = Requests.get("/catalogo/getIngresos/");
        Gson gson = new Gson();
        TypeToken<List<Catalogo>> token = new TypeToken<List<Catalogo>>(){
        };
        this.listCombo  = gson.fromJson(respuesta, token.getType());
        
        ObservableList<String> comboListaIngresos = FXCollections.observableArrayList();
        
        
        listCombo.forEach(e ->{
            comboListaIngresos.add(e.getNombre());
        });
        
        this.cmb_concepto.setItems(comboListaIngresos);
    }
    
    //Hacer servicioooooooooo
    public void cargarEgreso(){
        String respuesta = "";
        respuesta = Requests.get("/catalogo/getEgresos/");
        Gson gson = new Gson();
        TypeToken<List<Catalogo>> token = new TypeToken<List<Catalogo>>(){
        };
        this.listCombo = gson.fromJson(respuesta, token.getType());
        
        ObservableList<String> comboListaIngresos = FXCollections.observableArrayList();
        
        
        listCombo.forEach(e ->{
            comboListaIngresos.add(e.getNombre());
        });
        
        this.cmb_concepto.setItems(comboListaIngresos);
    }

    @FXML
    private void guardar(ActionEvent event) {
        if(validarDatos()){
            try {
                String data = "";
                
                Usuario usuario = (Usuario) this.context.get("usuario");
                
                HashMap<String, Object> params = new LinkedHashMap<>();
                params.put("cantidad", this.txt_cantidad.getText());
                params.put("descripcion", this.txt_descripcion.getText());
                params.put("idUsuarioCreador", usuario.getIdUsuario());
                params.put("fechaCreacion", LocalDate.now());
                params.put("idEstatus", 101);
                if (this.cmb_tipo.getValue().equals("Ingreso")) {
                    params.put("idTipo", 4);
                } else {
                    params.put("idTipo", 5);
                }
                
                int idConcepto=0;
                for(int i=0; i<this.listCombo.size(); i++){
                    if(this.listCombo.get(i).getNombre().equals(this.cmb_concepto.getValue().toString())){
                        idConcepto = this.listCombo.get(i).getIdCatalogo();
                        
                    }
                }
                params.put("idConcepto", idConcepto);
                data = Requests.post("/movimiento/registrarMovimiento/", params);
               
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

    @FXML
    private void cargarConcepto(ActionEvent event) {
        if(this.cmb_tipo.getValue().equals("Ingreso")){
            this.cargarIngreso();
        }else{
            this.cargarEgreso();
        }
    }
    
    private Boolean validarDatos() {
        Boolean valido = true;
        if(this.cmb_tipo.getValue() == null || this.cmb_concepto.getValue() == null || this.txt_cantidad.getText().isEmpty() 
                || this.txt_descripcion.getText().isEmpty()){
            valido=false;
        }
        return valido;
    }
    
}

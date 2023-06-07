/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Rancho;
import sagfx.model.beans.Usuario;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class FormRanchoFXMLController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_direccion;
    @FXML
    private TextField txt_encargado;
    @FXML
    private CheckBox chb_estatus;
    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cancelar;
    
    private Rancho rancho = null;
    Boolean isNew = null;
    private HashMap<String, Object> context;
    String fechaNow;
    @FXML
    private Label lbl_fecha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    //Para pasar datos en cada controlador
    public void setData(Rancho rancho, Boolean isNew, HashMap<String, Object> context) {
        this.rancho = rancho;
        this.isNew = isNew;
        this.context=context;
        this.cargarRanchos();
    }
    
    public void cargarRanchos() {
        if (!this.isNew) {
            this.txt_nombre.setText(rancho.getNombre());
            this.txt_direccion.setText(rancho.getDireccion());
            this.txt_encargado.setText(rancho.getEncargado());
            if ("S".equals(rancho.getEstatus())) {
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

    @FXML
    private void guardar(ActionEvent event) {
        if (validarDatos()) {
            try {
                String data = "";
                Usuario usuario = (Usuario) this.context.get("usuario");
                System.out.println("idUsuario:" + usuario.getIdUsuario());
                
                HashMap<String, Object> params = new LinkedHashMap<>();
                params.put("nombre", this.txt_nombre.getText());
                params.put("direccion", this.txt_direccion.getText());
                params.put("encargado", this.txt_encargado.getText());
                
                if (this.chb_estatus.isSelected()) {
                    params.put("idEstatus", 101);
                } else {
                    params.put("idEstatus", 102);
                }
                if (this.isNew) {
                    params.put("idUsuarioAlta", usuario.getIdUsuario());
                    //fechaAlta.setValue(LocalDate.now());
                    //fechaAlta.setEditable(false);
                    params.put("fechaAlta", LocalDate.now());
                    data = Requests.post("/rancho/registrarRancho/", params);
                } else {
                    params.put("idRancho", rancho.getIdRancho());
                    params.put("idUsuarioEditor", usuario.getIdUsuario());
                    //fechaAlta.setValue(LocalDate.now());
                    //fechaAlta.setEditable(false);G
                    //fechaNow = LocalDate.now().toString();
                    //System.out.println(fechaNow);
                    //fecha.setText(fechaNow);
                    
                    params.put("fechaEdicion", LocalDate.now());
                    data = Requests.post("/rancho/actualizarRancho/", params);
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
    
    private Boolean validarDatos() {
        Boolean valido = true;
        if(this.txt_nombre.getText().isEmpty() || this.txt_direccion.getText().isEmpty() || this.txt_encargado.getText().isEmpty()){
            valido=false;
        }
        return valido;
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Window.close(event);
    }
    
}

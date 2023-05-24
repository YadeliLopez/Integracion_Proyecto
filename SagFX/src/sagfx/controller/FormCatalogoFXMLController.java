/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import java.net.URL;
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
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.json.JSONObject;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Catalogo;
import sagfx.model.beans.Categoria;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class FormCatalogoFXMLController implements Initializable {

    Catalogo catalogo = null;
    Boolean isNew = false;
    @FXML
    private TextField txt_formIdCatalogo;
    @FXML
    private TextField txt_formIdCategoriaCata;
    @FXML
    private Button btn_formGuardarCategoria;
    @FXML
    private Button btn_formCerrarCategoria;
    @FXML
    private CheckBox chb_estatus;
    @FXML
    private TextField txt_formNombreCatalogo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Catalogo catalogo, Boolean isNew) {
        this.catalogo = catalogo;
        this.isNew = isNew;
        this.cargarCatalogo();
    }
    
    public void cargarCatalogo() {
        if (!this.isNew) {
            this.txt_formIdCatalogo.setText(catalogo.getIdCatalogo().toString());
            this.txt_formIdCategoriaCata.setText(catalogo.getIdCategoria().toString());
            this.txt_formNombreCatalogo.setText(catalogo.getNombre());
            if ("S".equals(catalogo.getActivo())) {
                this.chb_estatus.setText("Activo");
                this.chb_estatus.setSelected(true);
            } else {
                this.chb_estatus.setText("Inaactivo");
                this.chb_estatus.setSelected(false);
            }
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        if (validarDatos()) {
            try {
                String data = "";
                HashMap<String, Object> params = new LinkedHashMap<>();
                params.put("idCatalogo", this.txt_formIdCatalogo.getText());
                params.put("idCategoria", this.txt_formIdCategoriaCata.getText());
                params.put("nombre", this.txt_formNombreCatalogo.getText());
                if (this.chb_estatus.isSelected()) {
                    params.put("activo", "S");
                } else {
                    params.put("activo", "N");
                }
                if (this.isNew) {
                    data = Requests.post("/catalogo/registrarCatalogo/", params);
                } else {
                    data = Requests.post("/catalogo/actualizarCatalogo/", params);
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
                Logger.getLogger(FormCategoriaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void checkEstatus(ActionEvent event) {
        if (this.chb_estatus.isSelected()) {
            this.chb_estatus.setText("Activo");
        } else {
            this.chb_estatus.setText("Inactivo");
        }
    }
    
    private Boolean validarDatos() {
        Boolean valido = true;
        if(this.txt_formIdCatalogo.getText().isEmpty() || this.txt_formIdCategoriaCata.getText().isEmpty() || this.txt_formNombreCatalogo.getText().isEmpty()){
            valido=false;
        }
        return valido;
    }

    @FXML
    private void cancelar(ActionEvent event) {
         Window.close(event);
    }
    
}

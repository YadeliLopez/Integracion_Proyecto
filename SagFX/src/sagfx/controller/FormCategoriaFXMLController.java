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
import sagfx.model.beans.Categoria;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class FormCategoriaFXMLController implements Initializable {

    @FXML
    private TextField txt_formIdCategoria;
    @FXML
    private TextField txt_formNombreCategoria;
    @FXML
    private CheckBox chb_estatus;
    @FXML
    private Button btn_formGuardarCategoria;
    @FXML
    private Button btn_formCerrarCategoria;

    Categoria categoria = null;
    Boolean isNew = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(Categoria categoria, Boolean isNew) {
        this.categoria = categoria;
        this.isNew = isNew;
        this.cargarCategoria();
    }

    public void cargarCategoria() {
        if (!this.isNew) {
            this.txt_formIdCategoria.setText(categoria.getIdCategoria().toString());
            this.txt_formNombreCategoria.setText(categoria.getNombre());
            if ("S".equals(categoria.getActivo())) {
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
                params.put("idCategoria", this.txt_formIdCategoria.getText());
                params.put("nombre", this.txt_formNombreCategoria.getText());
                if (this.chb_estatus.isSelected()) {
                    params.put("activo", "S");
                } else {
                    params.put("activo", "N");
                }
                if (this.isNew) {
                    data = Requests.post("/categoria/registrarCategoria/", params);
                } else {
                    data = Requests.post("/categoria/actualizarCategoria/", params);
                }
                JSONObject dataJson = new JSONObject(data);

                if ((Boolean) dataJson.get("error") == false) {
                    Window.close(event);
                    Window.showMessageInformation(dataJson.get("mensaje").toString());

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Diálogo de error...");
                    alert.setHeaderText(null);
                    alert.setContentText("Los campos son requeridos");
                    alert.showAndWait();
                }
            } catch (JSONException ex) {
                Logger.getLogger(FormCategoriaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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

    private Boolean validarDatos() {
        Boolean valido = true;
        if(!this.txt_formIdCategoria.getText().isEmpty() && !this.txt_formNombreCategoria.getText().isEmpty()){
            valido=true;
        }
        return valido;
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Window.close(event);
    }

}

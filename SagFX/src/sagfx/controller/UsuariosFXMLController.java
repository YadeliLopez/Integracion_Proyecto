/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class UsuariosFXMLController implements Initializable {

    @FXML
    private TextField txt_busqueda;
    @FXML
    private Button btn_buscar;
    @FXML
    private Button btn_limpiar;
    @FXML
    private Button btn_desactivarCategoria;
    @FXML
    private Button btn_activarCategoria;
    @FXML
    private Button btn_editarCategoria;
    @FXML
    private Button btn_nuevaCategoria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buscarCategoria(ActionEvent event) {
    }

    @FXML
    private void limpiar(ActionEvent event) {
    }

    @FXML
    private void desactivarCategoria(ActionEvent event) {
    }

    @FXML
    private void activarCategoria(ActionEvent event) {
    }

    @FXML
    private void editarCategoria(ActionEvent event) {
    }

    @FXML
    private void nuevaCategoria(ActionEvent event) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Rancho;
import sagfx.model.beans.Usuario;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class RanchosFXMLController implements Initializable {
    
    private Rancho rancho = null;

    @FXML
    private TextField txt_busqueda;
    @FXML
    private Button btn_buscar;
    @FXML
    private Button btn_limpiar;
    @FXML
    private Pane pnl_principal;
    @FXML
    private Button btn_desactivarRancho;
    @FXML
    private Button btn_activarRancho;
    @FXML
    private Button btn_editarRancho;
    @FXML
    private Button btn_nuevoRancho;
    @FXML
    private TableView<Rancho> tbl_ranchos;
    @FXML
    private TableColumn<Rancho, String> tcl_nombre;
    @FXML
    private TableColumn<Rancho, String> tcl_direccion;
    @FXML
    private TableColumn<Rancho, String> tcl_encargado;
    @FXML
    private TableColumn<Rancho, String> tcl_usuarioAlta;
    @FXML
    private TableColumn<Rancho, String> tcl_fechaAlta;
    @FXML
    private TableColumn<Rancho, String> tcl_usuarioEditor;
    @FXML
    private TableColumn<Rancho, String> tcl_fechaEdicion;
    @FXML
    private TableColumn<?, ?> tcl_estatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cargarRanchos();
    }

    public void cargarRanchos(){
        this.rancho=null;
        String respuesta = "";
        tbl_ranchos.getItems().clear();
        
        respuesta = Requests.get("/rancho/getAllRanchos/");
        Gson gson = new Gson();
        
        //Definimos un TypeToken qie re´resenta una lista de objetos Usuario
        TypeToken<List<Rancho>> token = new TypeToken<List<Rancho>>(){
        };
        //Utilizamos el método fromJson{} de la clase Gson para convertir el JSON en una lista de objetos
        List<Rancho> listRanchos = gson.fromJson(respuesta, token.getType());
        
        tcl_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcl_direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tcl_encargado.setCellValueFactory(new PropertyValueFactory<>("encargado"));
        tcl_estatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tcl_usuarioAlta.setCellValueFactory(new PropertyValueFactory<>("usuarioAlta"));
        tcl_fechaAlta.setCellValueFactory(new PropertyValueFactory<>("fechaAlta"));
        tcl_usuarioEditor.setCellValueFactory(new PropertyValueFactory<>("usuarioAlta"));
        tcl_fechaEdicion.setCellValueFactory(new PropertyValueFactory<>("fechaAlta"));
        
        listRanchos.forEach(e ->{
            tbl_ranchos.getItems().add(e);
        });
        /*for(Categoria c: listCategorias){
            tbl_categorias.getItems().add(c);
        }*/
        System.out.println(listRanchos.size());
    }    


    @FXML
    private void limpiar(ActionEvent event) {
    }

    @FXML
    private void buscarRancho(ActionEvent event) {
    }

    @FXML
    private void desactivarRancho(ActionEvent event) {
    }

    @FXML
    private void activarRancho(ActionEvent event) {
    }

    @FXML
    private void editarRancho(ActionEvent event) {
    }

    @FXML
    private void nuevoRancho(ActionEvent event) {
    }
    
}

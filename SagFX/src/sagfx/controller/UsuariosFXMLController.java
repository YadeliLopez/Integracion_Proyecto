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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Catalogo;
import sagfx.model.beans.Usuario;

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
    @FXML
    private TableColumn<Usuario, String> tcl_usuarioAlta;
    @FXML
    private TableColumn<Usuario, String> tcl_fechaAlta;
    @FXML
    private TableColumn<Usuario, String> tcl_usuarioEditor;
    @FXML
    private TableColumn<Usuario, String> tcl_fechaEdicion;
    @FXML
    private Button btn_desactivarUsuario;
    @FXML
    private Button btn_activarUsuario;
    @FXML
    private Button btn_editarUsuario;
    @FXML
    private Button btn_nuevoUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cargarUsuarios();
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
        tcl_usuarioAlta.setCellValueFactory(new PropertyValueFactory<>("usuarioAlta"));
        tcl_fechaAlta.setCellValueFactory(new PropertyValueFactory<>("fechaAlta"));
        tcl_usuarioEditor.setCellValueFactory(new PropertyValueFactory<>("usuarioAlta"));
        tcl_fechaEdicion.setCellValueFactory(new PropertyValueFactory<>("fechaAlta"));
        
        listUsuarios.forEach(e ->{
            tbl_usuario.getItems().add(e);
        });
        /*for(Categoria c: listCategorias){
            tbl_categorias.getItems().add(c);
        }*/
        System.out.println(listUsuarios.size());
    }


    @FXML
    private void limpiar(ActionEvent event) {
        this.txt_busqueda.setText("");
        this.cargarUsuarios();
    }
    
    @FXML
    private void buscarUsuario(ActionEvent event) {
    }
    
    @FXML
    private void nuevoUsuario(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormUsuarioFXML.fxml"));
            Parent formUsuario = loader.load();
            FormUsuarioFXMLController ctrl = loader.getController();
            ctrl.setData(this.usuario,true);
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
    }
    

    @FXML
    private void desactivarUsuario(ActionEvent event) {
    }

    @FXML
    private void activarUsuario(ActionEvent event) {
    }

    
}

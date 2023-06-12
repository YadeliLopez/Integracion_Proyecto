/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class PrincipalFXMLController implements Initializable {

    @FXML
    private BorderPane pnl_principal;
    @FXML
    private MenuItem mi_categoria;
    @FXML
    private MenuItem mi_usuario;
    @FXML
    private MenuItem mi_ingresos;
    @FXML
    private MenuItem mi_ranchos;
    
    private HashMap<String, Object> context;
    @FXML
    private MenuItem mi_cerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//Para pasar datos en cada controlador
    public void setData(HashMap<String, Object> context){
        System.out.println(context);
        this.context=context;
    }    
    
    @FXML
    private void abrirIngresoEgreso(ActionEvent event) {
        try{
            //Se carga la nueva interfaz fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/IngresoEgresoFXML.fxml"));
            
            //Se obtiene el nodo padre que contiene los nodos secuendarios de la interfaz fxml
            Parent principal = loader.load();
            IngresoEgresoFXMLController ctrl = loader.getController();
            ctrl.setData(this.context);
            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirCategoria(ActionEvent event) {
        try{
            //Se carga la nueva interfaz fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/CategoriasFXML.fxml"));
            
            //Se obtiene el nodo padre que contiene los nodos secuendarios de la interfaz fxml
            Parent principal = loader.load();
            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirUsuario(ActionEvent event) {
        try{
            //Se carga la nueva interfaz fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/UsuariosFXML.fxml"));
            
            //Se obtiene el nodo padre que contiene los nodos secuendarios de la interfaz fxml
            Parent principal = loader.load();
            UsuariosFXMLController ctrl = loader.getController();
            ctrl.setData(this.context);
            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirRanchos(ActionEvent event) {
        try{
            //Se carga la nueva interfaz fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/RanchosFXML.fxml"));
            
            //Se obtiene el nodo padre que contiene los nodos secuendarios de la interfaz fxml
            Parent principal = loader.load();
            RanchosFXMLController ctrl = loader.getController();
            ctrl.setData(this.context);
            pnl_principal.setCenter(principal);
        }catch(IOException ex){
            Logger.getLogger(PrincipalFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        Node source = (Node) this.pnl_principal;
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        
        Parent login = FXMLLoader.load(getClass().getResource("/sagfx/gui/view/LoginFXML.fxml"));
        
        //Cuando ejecute la aplicacion tomará la mac para saber quien ingreso al sistema
        
        Scene scene = new Scene(login);
        
        stage.setScene(scene);
        stage.show();
    }
    
}

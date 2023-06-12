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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Categoria;
import sagfx.model.beans.Rancho;
import sagfx.model.beans.Usuario;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class RanchosFXMLController implements Initializable {
    
    private Rancho rancho = null;
    Boolean isNew = null;

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
    private TableColumn<Rancho, String> tcl_usuarioAlta;
    private TableColumn<Rancho, String> tcl_fechaAlta;
    private TableColumn<Rancho, String> tcl_usuarioEditor;
    private TableColumn<Rancho, String> tcl_fechaEdicion;
    @FXML
    private TableColumn<Rancho, String> tcl_estatus;
    
    private HashMap<String, Object> context;
    @FXML
    private TableColumn<Rancho, String> tcl_usuarioCreador;
    @FXML
    private TableColumn<Rancho, String> tcl_fechaCreacion;
    @FXML
    private TableColumn<Rancho, String> tcl_usuarioModi;
    @FXML
    private TableColumn<Rancho, String> tcl_fechaModi;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cargarRanchos();
    }
    
    //Para pasar datos en cada controlador
    public void setData(HashMap<String, Object> context){
        System.out.println(context);
        this.context=context;
    }

    public void cargarRanchos(){
        this.rancho=null;
        String respuesta = "";
        tbl_ranchos.getItems().clear();
        
        respuesta = Requests.get("/rancho/getAllRanchos/");
        Gson gson = new Gson();
        
        //Definimos un TypeToken qie re´resenta una lista de objetos Categoría
        TypeToken<List<Rancho>> token = new TypeToken<List<Rancho>>(){
        };
        //Utilizamos el método fromJson{} de la clase Gson para convertir el JSON en una lista de objetos
        List<Rancho> listRanchos = gson.fromJson(respuesta, token.getType());
        
        tcl_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcl_direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tcl_encargado.setCellValueFactory(new PropertyValueFactory<>("encargado"));
        tcl_estatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tcl_usuarioCreador.setCellValueFactory(new PropertyValueFactory<>("usuarioCreador"));
        tcl_fechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_usuarioModi.setCellValueFactory(new PropertyValueFactory<>("usuarioModificador"));
        tcl_fechaModi.setCellValueFactory(new PropertyValueFactory<>("fechaModificacion"));
        
        listRanchos.forEach(e ->{
            tbl_ranchos.getItems().add(e);
        });
        /*for(Categoria c: listCategorias){
            tbl_categorias.getItems().add(c);
        }*/
        System.out.println(listRanchos.size());
    }    
    
    @FXML
    private void clickTable(MouseEvent event) {
        String respuesta = "";
        if (tbl_ranchos.getSelectionModel().getSelectedItem() != null) {
            rancho = tbl_ranchos.getSelectionModel().getSelectedItem();
        }
    }


    @FXML
    private void limpiar(ActionEvent event) {
        this.txt_busqueda.setText("");
        this.cargarRanchos();
    }
    
    @FXML
    private void nuevoRancho(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormRanchoFXML.fxml"));
            Parent formRancho = loader.load();
            FormRanchoFXMLController ctrl = loader.getController();
            ctrl.setData(this.rancho,true, this.context);
            Scene scene = new Scene(formRancho);
            Stage stageRanchos = new Stage();
            stageRanchos.setTitle("Ranchos");
            stageRanchos.setResizable(false);
            stageRanchos.setScene(scene);
            stageRanchos.showAndWait();
            this.cargarRanchos();

        } catch (IOException ex) {
            Logger.getLogger(UsuariosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void editarRancho(ActionEvent event) {
        if(this.rancho != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormRanchoFXML.fxml"));
                Parent formRancho = loader.load();
                FormRanchoFXMLController ctrl = loader.getController();
                ctrl.setData(this.rancho, false, context);
                Scene scene = new Scene(formRancho);
                Stage stageRanchos = new Stage();
                stageRanchos.setTitle("Rancho");
                stageRanchos.setResizable(false);
                stageRanchos.setScene(scene);
                stageRanchos.showAndWait();
                this.cargarRanchos();
                
                
            } catch (IOException ex) {
                Logger.getLogger(CategoriasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar un rancho...");
            alert.showAndWait();
        }
    }

    @FXML
    private void buscarRancho(ActionEvent event) {
        String respuesta = "";
        this.tbl_ranchos.getItems().clear();
        this.rancho = null;

        HashMap<String, Object> params = new LinkedHashMap<>();
        params.put("filtro", this.txt_busqueda.getText());

        respuesta = Requests.post("/rancho/buscarRancho", params);
        Gson gson = new Gson();

        //Definimos u  TypeToken que representa una lista de objetos Categoria
        TypeToken<List<Rancho>> token = new TypeToken<List<Rancho>>() {
        };

        //Utilizamos el método fromJson() de la clase Gson para convertir el JSON en una lista de objetos
        List<Rancho> listRancho = gson.fromJson(respuesta, token.getType());

        if (listRancho.size() > 0) {
            tcl_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tcl_direccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            tcl_encargado.setCellValueFactory(new PropertyValueFactory<>("encargado"));
            tcl_estatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
            tcl_usuarioCreador.setCellValueFactory(new PropertyValueFactory<>("usuarioCreador"));
            tcl_fechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
            tcl_usuarioModi.setCellValueFactory(new PropertyValueFactory<>("usuarioModificador"));
            tcl_fechaModi.setCellValueFactory(new PropertyValueFactory<>("fechaModificacion"));

            listRancho.forEach(e -> {
                tbl_ranchos.getItems().add(e);
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
    private void activarRancho(ActionEvent event) {
        if (this.rancho != null) {
            if (101 != (rancho.getIdEstatus())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere activar el rancho " + this.rancho.getNombre() + "?");
                if (conf) {
                    this.actualizarEstatusRancho("Activo");
                }
            } else {
                Window.showMessageInformation("El rancho ya esta activo...");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar un rancho...");
        }
    }

    @FXML
    private void desactivarRancho(ActionEvent event) {
        if (this.rancho != null) {
            if (102 != (rancho.getIdEstatus())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere desactivar el rancho " + this.rancho.getNombre() + "?");
                if (conf) {
                    this.actualizarEstatusRancho("Inactivo");
                }

            } else {
                Window.showMessageInformation("El rancho ya esta Inactivo");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar un rancho...");
        }
    }
    
    public void actualizarEstatusRancho(String activo) {
        
        try {
            String data = "";
            HashMap<String, Object> params = new LinkedHashMap<>();
            params.put("idRancho", this.rancho.getIdRancho());
            if("Activo".equals(activo)){
                params.put("idEstatus", 101);
            
            }else{
                params.put("idEstatus", 102);
            }
            data = Requests.post("/rancho/actualizarEstatusRancho/", params);

            JSONObject dataJson = new JSONObject(data);

            if ((Boolean) dataJson.get("error") == false) {
                Window.showMessageInformation(dataJson.get("mensaje").toString());
                this.cargarRanchos();
            } else {
                Window.showMessageError(dataJson.get("mensaje").toString());
            }
        } catch (JSONException ex) {
            Logger.getLogger(RanchosFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

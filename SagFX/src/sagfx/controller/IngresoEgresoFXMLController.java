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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
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
import sagfx.model.beans.Movimiento;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class IngresoEgresoFXMLController implements Initializable {
    
    private Movimiento movimiento=null;

    @FXML
    private Pane pnl_principal;
    @FXML
    private TextField txt_busqueda;
    @FXML
    private Button btn_buscar;
    @FXML
    private Button btn_limpiar;
    @FXML
    private Button btn_editarMov;
    @FXML
    private Button btn_nuevoMov;
    @FXML
    private Button btn_activarMov;
    @FXML
    private Button btn_cancelarMov;
    @FXML
    private TableView<Movimiento> tbl_ingresoEgreso;
    @FXML
    private TableColumn<Movimiento, String> tcl_tipo;
    @FXML
    private TableColumn<Movimiento, String> tcl_concepto;
    private TableColumn<Movimiento, String> tcl_fecha;
    private TableColumn<Movimiento, String> tcl_usuario;
    @FXML
    private TableColumn<Movimiento, String> tcl_descripcion;
    
    private HashMap<String, Object> context;
    
    @FXML
    private TableColumn<Movimiento, String> tcl_cantidad;
    @FXML
    private TableColumn<Movimiento, String> tcl_fechaCreacion;
    @FXML
    private TableColumn<Movimiento, String> tcl_usuarioCreador;
    @FXML
    private TableColumn<Movimiento, String> tcl_fechaCancelacion;
    @FXML
    private TableColumn<Movimiento, String> tcl_estatusMov;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cargarMovimientos();
    }    

    //Para pasar datos en cada controlador
    public void setData(HashMap<String, Object> context){
        System.out.println("iefxml: "+context);
        this.context=context;
    }
    
    public void cargarMovimientos(){
        this.movimiento=null;
        String respuesta = "";
        tbl_ingresoEgreso.getItems().clear();
        
        respuesta = Requests.get("/movimiento/getAllMovimientos/");
        Gson gson = new Gson();
        
        //Definimos un TypeToken qie re´resenta una lista de objetos Usuario
        TypeToken<List<Movimiento>> token = new TypeToken<List<Movimiento>>(){
        };
        //Utilizamos el método fromJson{} de la clase Gson para convertir el JSON en una lista de objetos
        List<Movimiento> listMovimientos = gson.fromJson(respuesta, token.getType());
        
        tcl_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tcl_concepto.setCellValueFactory(new PropertyValueFactory<>("concepto"));
        tcl_cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tcl_fechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        tcl_usuarioCreador.setCellValueFactory(new PropertyValueFactory<>("usuarioCreador"));
        tcl_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tcl_estatusMov.setCellValueFactory(new PropertyValueFactory<>("estatus"));
        tcl_fechaCancelacion.setCellValueFactory(new PropertyValueFactory<>("fechaCancelacion"));
        
        listMovimientos.forEach(e ->{
            tbl_ingresoEgreso.getItems().add(e);
        });
        /*for(Categoria c: listCategorias){
            tbl_categorias.getItems().add(c);
        }*/
        System.out.println(listMovimientos.size());
    }

    @FXML
    private void limpiar(ActionEvent event) {
        this.txt_busqueda.setText("");
        this.cargarMovimientos();
    }
    
    @FXML
    private void clickTable(MouseEvent event) {
        String respuesta = "";
        if (tbl_ingresoEgreso.getSelectionModel().getSelectedItem() != null) {
            movimiento = tbl_ingresoEgreso.getSelectionModel().getSelectedItem();
        }
    }
    
    @FXML
    private void nuevoMov(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormIngresoEgresoFXML.fxml"));
            Parent formIngresoEgreso = loader.load();
            FormIngresoEgresoFXMLController ctrl = loader.getController();
            ctrl.setData(this.movimiento,true, this.context);
            Scene scene = new Scene(formIngresoEgreso);
            Stage stageIngresoEgreso = new Stage();
            stageIngresoEgreso.setTitle("Movimientos");
            stageIngresoEgreso.setResizable(false);
            stageIngresoEgreso.setScene(scene);
            stageIngresoEgreso.showAndWait();
            this.cargarMovimientos();

        } catch (IOException ex) {
            Logger.getLogger(IngresoEgresoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void editarMov(ActionEvent event) {
        if(this.movimiento != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormIngresoEgresoFXML.fxml"));
                Parent formMovi = loader.load();
                FormIngresoEgresoFXMLController ctrl = loader.getController();
                ctrl.setData(this.movimiento, false, context);
                Scene scene = new Scene(formMovi);
                Stage stageMovi = new Stage();
                stageMovi.setTitle("Movimientos");
                stageMovi.setResizable(false);
                stageMovi.setScene(scene);
                stageMovi.showAndWait();
                this.cargarMovimientos();
                
                
            } catch (IOException ex) {
                Logger.getLogger(CategoriasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar un movimiento...");
            alert.showAndWait();
        }
    }

    @FXML
    private void buscarMov(ActionEvent event) {
        String respuesta = "";
        this.tbl_ingresoEgreso.getItems().clear();
        this.movimiento = null;

        HashMap<String, Object> params = new LinkedHashMap<>();
        params.put("filtro", this.txt_busqueda.getText());

        respuesta = Requests.post("/movimiento/buscarMovimiento", params);
        Gson gson = new Gson();

        //Definimos u  TypeToken que representa una lista de objetos Categoria
        TypeToken<List<Movimiento>> token = new TypeToken<List<Movimiento>>() {
        };

        //Utilizamos el método fromJson() de la clase Gson para convertir el JSON en una lista de objetos
        List<Movimiento> listMovi = gson.fromJson(respuesta, token.getType());

        if (listMovi.size() > 0) {
            tcl_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
            tcl_concepto.setCellValueFactory(new PropertyValueFactory<>("concepto"));
            tcl_cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
            tcl_fechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
            tcl_usuarioCreador.setCellValueFactory(new PropertyValueFactory<>("usuarioCreador"));
            tcl_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            tcl_estatusMov.setCellValueFactory(new PropertyValueFactory<>("estatus"));
            tcl_fechaCancelacion.setCellValueFactory(new PropertyValueFactory<>("fechaCancelacion"));

            listMovi.forEach(e -> {
                tbl_ingresoEgreso.getItems().add(e);
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
    private void activarMov(ActionEvent event) {
        if (this.movimiento != null) {
            if (101 != (movimiento.getIdEstatus())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere activar el movimiento " + this.movimiento.getDescripcion() + "?");
                if (conf) {
                    this.activarMovi();
                }
            } else {
                Window.showMessageInformation("El movimiento esta activo...");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar un movimiento...");
        }
    }

    @FXML
    private void cancelarMov(ActionEvent event) {
        if (this.movimiento != null) {
            if (103 != (movimiento.getIdEstatus())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere desactivar el movimiento " + this.movimiento.getDescripcion() + "?");
                if (conf) {
                    this.cancelarMovi("Cancelado");
                    
                }

            } else {
                Window.showMessageInformation("El movimiento ya esta Cancelado");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar un movimiento...");
        }
    }

    public void cancelarMovi(String activo) {
        
        try {
            String data = "";
            HashMap<String, Object> params = new LinkedHashMap<>();
            params.put("idMovimiento", this.movimiento.getIdMovimiento());
            params.put("fechaCancelacion", LocalDate.now());
            data = Requests.post("/movimiento/cancelarMovimiento/", params);

            JSONObject dataJson = new JSONObject(data);

            if ((Boolean) dataJson.get("error") == false) {
                Window.showMessageInformation(dataJson.get("mensaje").toString());
                this.cargarMovimientos();
            } else {
                Window.showMessageError(dataJson.get("mensaje").toString());
            }
        } catch (JSONException ex) {
            Logger.getLogger(IngresoEgresoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void activarMovi(){
        try {
            String data = "";
            HashMap<String, Object> params = new LinkedHashMap<>();
            params.put("idMovimiento", this.movimiento.getIdMovimiento());
            params.put("idEstatus", 101);
            params.put("fechaCancelacion", "");
         
            data = Requests.post("/movimiento/actualizarEstatusMovi/", params);

            JSONObject dataJson = new JSONObject(data);

            if ((Boolean) dataJson.get("error") == false) {
                Window.showMessageInformation(dataJson.get("mensaje").toString());
                this.cargarMovimientos();
            } else {
                Window.showMessageError(dataJson.get("mensaje").toString());
            }
        } catch (JSONException ex) {
            Logger.getLogger(IngresoEgresoFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}

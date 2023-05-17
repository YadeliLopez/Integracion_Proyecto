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
import javafx.scene.control.SplitPane;
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
import sagfx.model.beans.Catalogo;
import sagfx.model.beans.Categoria;
import sagfx.utils.Window;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class CategoriasFXMLController implements Initializable {

    Categoria categoria = null;
    
    @FXML
    private Pane pnl_principal;
    @FXML
    private Pane pnl_busqueda;
    @FXML
    private TextField txt_busqueda;
    @FXML
    private Button btn_buscar;
    @FXML
    private Button btn_limpiar;
    @FXML
    private SplitPane spl_categoriaCatalogo;
    @FXML
    private Button btn_nuevaCategoria;
    @FXML
    private Button btn_editarCategoria;
    @FXML
    private Button btn_activarCategoria;
    @FXML
    private Button btn_desactivarCategoria;
    @FXML
    private TableView<Categoria> tbl_categorias;
    @FXML
    private TableColumn<Categoria, Integer> tcl_categoriaIdCategoria;
    @FXML
    private TableColumn<Categoria, String> tcl_categoriaNombre;
    @FXML
    private TableColumn<Categoria, String> tcl_categoriaActivo;
    @FXML
    private Button btn_nuevoCatalogo;
    @FXML
    private Button btn_editarCatalogo;
    @FXML
    private Button btn_activarCatalogo;
    @FXML
    private Button btn_desactivarCatalogo;
    @FXML
    private TableView<Catalogo> tbl_catalogo;
    @FXML
    private TableColumn<Catalogo, Integer> tcl_catalogoIdCatalogo;
    @FXML
    private TableColumn<Catalogo, String> tcl_catalogoNombre;
    @FXML
    private TableColumn<Catalogo, String> tcl_catalogoActivo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.cargarCategoria();
    }    

    @FXML
    private void buscarCategoria(ActionEvent event) {
        this.cargarCategoria();
    }
    
    public void cargarCategoria(){
        String respuesta = "";
        tbl_categorias.getItems().clear();
        
        respuesta = Requests.get("/categoria/getAllCategoria/");
        Gson gson = new Gson();
        
        //Definimos un TypeToken qie re´resenta una lista de objetos Categoría
        TypeToken<List<Categoria>> token = new TypeToken<List<Categoria>>(){
        };
        //Utilizamos el método fromJson{} de la clase Gson para convertir el JSON en una lista de objetos
        List<Categoria> listCategorias = gson.fromJson(respuesta, token.getType());
        
        tcl_categoriaIdCategoria.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));
        tcl_categoriaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcl_categoriaActivo.setCellValueFactory(new PropertyValueFactory<>("activo"));
        
        listCategorias.forEach(e ->{
            tbl_categorias.getItems().add(e);
        });
        /*for(Categoria c: listCategorias){
            tbl_categorias.getItems().add(c);
        }*/
        System.out.println(listCategorias.size());
    }

    @FXML
    private void clickTable(MouseEvent event) {
        String respuesta = "";
        if (tbl_categorias.getSelectionModel().getSelectedItem() != null) {
            categoria = tbl_categorias.getSelectionModel().getSelectedItem();

            tbl_catalogo.getItems().clear();
            respuesta = Requests.get("/catalogo/getCatalogosByIdCategoria/" + categoria.getIdCategoria());
            Gson gson = new Gson();

            //Definimos un TypeToken que representa una lista de objetos Categoria
            TypeToken<List<Catalogo>> token = new TypeToken<List<Catalogo>>() {
            };
            //Utilizamos el método fromJson() de la clase Gson para convertir el JSON en una lista de objetos Categoria
            List<Catalogo> listCatalogos = gson.fromJson(respuesta, token.getType());

            tcl_catalogoIdCatalogo.setCellValueFactory(new PropertyValueFactory<>("idCatalogo"));
            tcl_catalogoNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tcl_catalogoActivo.setCellValueFactory(new PropertyValueFactory<>("activo"));

            listCatalogos.forEach(e -> {
                tbl_catalogo.getItems().add(e);
            });
        }
    }

    @FXML
    private void nuevaCategoria(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormCategoriaFXML.fxml"));
            Parent formCategoria = loader.load();
            FormCategoriaFXMLController ctrl = loader.getController();
            ctrl.setData(this.categoria,true);
            Scene scene = new Scene(formCategoria);
            Stage stageCategorias = new Stage();
            stageCategorias.setTitle("Categorías");
            stageCategorias.setResizable(false);
            stageCategorias.setScene(scene);
            stageCategorias.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(CategoriasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void editarCategoria(ActionEvent event) {
        if(this.categoria != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormCategoriaFXML.fxml"));
                Parent formCategoria = loader.load();
                FormCategoriaFXMLController ctrl = loader.getController();
                ctrl.setData(this.categoria, false);
                Scene scene = new Scene(formCategoria);
                Stage stageCategorias = new Stage();
                stageCategorias.setTitle("Categorías");
                stageCategorias.setResizable(false);
                stageCategorias.setScene(scene);
                stageCategorias.showAndWait();
                this.cargarCategoria();
                /*Stage stage2 = new Stage();
                Se carga la nueva interfaz fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/FormCategoriaFXML.fxml"));
                
                //Se obtiene el nodo padre que contienes los nodos secundarios de la interfaz fxml
                Parent formCategoria = loader.load();
                
                //Se obtiene la instancia del controlador asociado a la interfaz fxml
                FormCategoriaFXMLController ctrl = loader.getController();
                
                //setData es un metodo que esta declarado en la clase PrincipalController
                //Al metodo setData se le pasa como parametro el contexto
                ctrl.setData(this.categoria, false);
                
                //Se crea una nueva escena con la interfaz principal.fxml
                Scene scene = new Scene(formCategoria);
                
                //Insertamos la nueva escena en el escenario actual
                Se puede crear otro escenario para insertar la nueva escena (opcional)
                stage2.setScene(scene);*/
                
            } catch (IOException ex) {
                Logger.getLogger(CategoriasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Debe seleccionar una categoria...");
            alert.showAndWait();
        }
    }

    @FXML
    private void activarCategoria(ActionEvent event) {
        if (this.categoria != null) {
            if ("N".equals(categoria.getActivo())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere activar la categoría " + this.categoria.getNombre() + "?");
                if (conf) {
                    this.actualizarEstatusCategoria("S");
                }
            } else {
                Window.showMessageInformation("La categoría ya esta activa...");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar una categoría...");
        }
    }

    @FXML
    private void desactivarCategoria(ActionEvent event) {
        if (this.categoria != null) {
            if ("S".equals(categoria.getActivo())) {
                Boolean conf = Window.showMessageConfirmation("¿Quiere desactivar la categoría " + this.categoria.getNombre() + "?");
                if (conf) {
                    this.actualizarEstatusCategoria("N");
                }

            } else {
                Window.showMessageInformation("La categoría ya esta Inactiva");
            }
        } else {
            Window.showMessageWarning("Debe seleccionar una categoría...");
        }
    }
    
    public void actualizarEstatusCategoria(String activo) {
        try {
            String data = "";
            HashMap<String, Object> params = new LinkedHashMap<>();
            params.put("idCategoria", this.categoria.getIdCategoria());
            params.put("activo", activo);
            data = Requests.post("/categoria/actualizarEstatusCategoria/", params);

            JSONObject dataJson = new JSONObject(data);

            if ((Boolean) dataJson.get("error") == false) {
                Window.showMessageInformation(dataJson.get("mensaje").toString());
                this.cargarCategoria();
            } else {
                Window.showMessageError(dataJson.get("mensaje").toString());
            }
        } catch (JSONException ex) {
            Logger.getLogger(CategoriasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void limpiar(ActionEvent event) {
        this.txt_busqueda.setText("");
    }
    
}

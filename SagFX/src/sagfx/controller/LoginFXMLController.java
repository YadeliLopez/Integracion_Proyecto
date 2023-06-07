/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;
import sagfx.api.requests.Requests;
import sagfx.model.beans.Usuario;
import sagfx.utils.Window;
import sagfx.utils.JavaUtils;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private AnchorPane pnl_principal;
    @FXML
    private ImageView img_banner;
    @FXML
    private ImageView img_logo;
    @FXML
    private Pane pnl_panelLogin;
    @FXML
    private Label lbl_usuario;
    @FXML
    private Label lbl_contrasena;
    @FXML
    private TextField txt_usuario;
    @FXML
    private PasswordField txt_contrasena;
    @FXML
    private Button btn_iniciar;
    @FXML
    private Button btn_cancelar;
    @FXML
    private Label lbl_mensaje;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) {
        if(this.validar()){
            try {
                //this.lbl_mensaje.setText("");
                //Respuesta como cadena para transformarla en tipo JSON
                String data="";
                //Una ves que inicia sesion cierra la ventana
                //Window.close(event);
                //System.out.println(Window.getStageByEvent(event).getUserData());
                //Pasamos parámetros (clave:String, llave:objeto) Linked guarda el orden
                HashMap<String, Object> params = new LinkedHashMap<>();
                //Insertamos al hashmap el usuario y la contraseña extraidos de los inputs.
                params.put("usuario", this.txt_usuario.getText());
                params.put("contrasena", this.txt_contrasena.getText());
                //Mandamos a llamar la clase request. Necesita los dos parámetros y la url.
                //Post nos regresará una cadena en formato JSON y se va a guardar en la variable data.
                data = Requests.post("/sesion/login/", params);
                //Convertir la cadena de tipo JSON en un objeto tipo JSON
                JSONObject dataJson = new JSONObject(data);
                
                if((Boolean)dataJson.get("error")== false){
                    /*JSONObject respuestaJson = new JSONObject(dataJson.get("respuesta").toString());
                    //Manejo de sesiones
                    Usuario u = new Usuario();
                    u.setIdUsuario(respuestaJson.getInt("idUsuario"));
                    u.setIdRol(respuestaJson.getInt("idRol"));
                    u.setUsuario(respuestaJson.getString("usuario"));*/
                    Stage stage = Window.getStageByEvent(event);
                    //Optimización de código
                    //Se encargan de 
                    Gson gson = new Gson();
                    Usuario user = gson.fromJson(dataJson.get("respuesta").toString(), Usuario.class);
                    
                    
                    HashMap<String,Object> context = new HashMap<String, Object> ();
                    context.put("mac", JavaUtils.getMAC());
                    context.put("usuario", user);
                    
                    //Se carga la nueva interfaz fxml
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sagfx/gui/view/PrincipalFXML.fxml"));

                        //Se obtiene el nodo padre que contienes los nodos secundarios de la interfaz fxml
                        Parent principal = loader.load();

                        //Se obtiene la instancia del controlador asociado a la interfaz fxml
                        PrincipalFXMLController ctrl = loader.getController();

                        //setData es un metodo que esta declarado en la clase PrincipalController
                        //Al metodo setData se le pasa como parametro el contexto
                        ctrl.setData(context);

                        //Se crea una nueva escena con la interfaz principal.fxml
                        Scene scene = new Scene(principal);

                        //Insertamos la nueva escena en el escenario actual
                        //Se puede crear otro escenario para insertar la nueva escena (opcional)
                        stage.setScene(scene);

                        //A la nueva escena se le agrega un titulo
                        stage.setTitle("SAG (Sistema de Administración de Ganado)");
                        //Propiedad para no maximizar la escena
                        stage.setResizable(false);
                        //Se muestra la escena que previamente se creo
                        stage.show();
                    
                }else{
                    this.lbl_mensaje.setText(dataJson.getString("mensaje"));
                }
                //JSONObject respuestaJson = new JSONObject(dataJson.get("respuesta").toString());
                //System.out.println(respuestaJson.getString("nombre"));
                //System.out.println(respuestaJson.get("nombre").toString());
                //System.out.println(dataJson.get("respuesta"));
                //System.out.println(dataJson.get("error"));
            } catch (JSONException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            this.lbl_mensaje.setText("El usuario y contraseña son requeridos");
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Window.close(event);
    }
    
     //Para validar si los campos estan vacios o no
    private boolean validar(){
        boolean valido=false;
        if(!this.txt_usuario.getText().isEmpty() && !this.txt_contrasena.getText().isEmpty()){
            valido=true;
        }
        return valido;
    }
    
}

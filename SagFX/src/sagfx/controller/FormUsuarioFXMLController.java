/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sagfx.model.beans.Catalogo;
import sagfx.model.beans.Usuario;

/**
 * FXML Controller class
 *
 * @author Yadelí López
 */
public class FormUsuarioFXMLController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellidoP;
    @FXML
    private TextField txt_apellidoM;
    @FXML
    private TextField txt_celular;
    @FXML
    private TextField txt_usuario;
    @FXML
    private PasswordField txt_contrasena;
    @FXML
    private ComboBox<?> cmb_rol;
    @FXML
    private CheckBox chb_estatus;
    @FXML
    private ComboBox<?> cmb_rancho;
    @FXML
    private Button btn_guardar;
    @FXML
    private Button btn_cancelar;
    
    Usuario usuario = null;
    Boolean isNew = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void setData(Usuario usuario, Boolean isNew) {
        this.usuario = usuario;
        this.isNew = isNew;
        this.cargarUsuarios();
    }
    
    public void cargarUsuarios() {
        if (!this.isNew) {
            this.txt_nombre.setText(usuario.getNombre());
            this.txt_apellidoP.setText(usuario.getApellidoPaterno());
            this.txt_apellidoM.setText(usuario.getApellidoMaterno());
            this.txt_celular.setText(usuario.getCelular());
            this.txt_usuario.setText(usuario.getUsuario());
            this.txt_contrasena.setText(usuario.getContrasena());
            if ("S".equals(usuario.getEstatus())) {
                this.chb_estatus.setText("Activo");
                this.chb_estatus.setSelected(true);
            } else {
                this.chb_estatus.setText("Inaactivo");
                this.chb_estatus.setSelected(false);
            }
        }
    }
    
}

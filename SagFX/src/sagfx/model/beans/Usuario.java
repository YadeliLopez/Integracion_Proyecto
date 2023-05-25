/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.model.beans;

import java.util.Date;

/**
 *
 * @author Yadelí López
 */
public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String celular;
    private String usuario;
    private String contrasena;
    private int idRol;
    private String rol;
    private int idEstatus;
    private String estatus;
    private int idRancho;
    private String rancho;
    private int idUsuarioAlta;
    private String usuarioAlta;
    private Date fechaAlta;
    private int idUsuarioEditor;
    private String usuarioEditor;
    private Date fechaEdicion;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String celular, String usuario, String contrasena, int idRol, String rol, int idEstatus, String estatus, int idRancho, String rancho, int idUsuarioAlta, String usuarioAlta, Date fechaAlta, int idUsuarioEditor, String usuarioEditor, Date fechaEdicion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.celular = celular;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.idRol = idRol;
        this.rol = rol;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
        this.idRancho = idRancho;
        this.rancho = rancho;
        this.idUsuarioAlta = idUsuarioAlta;
        this.usuarioAlta = usuarioAlta;
        this.fechaAlta = fechaAlta;
        this.idUsuarioEditor = idUsuarioEditor;
        this.usuarioEditor = usuarioEditor;
        this.fechaEdicion = fechaEdicion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCelular() {
        return celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public int getIdRancho() {
        return idRancho;
    }

    public String getRancho() {
        return rancho;
    }

    public int getIdUsuarioAlta() {
        return idUsuarioAlta;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public int getIdUsuarioEditor() {
        return idUsuarioEditor;
    }

    public String getUsuarioEditor() {
        return usuarioEditor;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setRancho(String rancho) {
        this.rancho = rancho;
    }

    public void setIdUsuarioAlta(int idUsuarioAlta) {
        this.idUsuarioAlta = idUsuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setIdUsuarioEditor(int idUsuarioEditor) {
        this.idUsuarioEditor = idUsuarioEditor;
    }

    public void setUsuarioEditor(String usuarioEditor) {
        this.usuarioEditor = usuarioEditor;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }
    
    
    
}

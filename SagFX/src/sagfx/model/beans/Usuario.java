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
    private int idEstatus;
    private int idRancho;
    private int idUsuarioAlta;
    private Date fechaAlta;
    private int idUsuarioEditor;
    private Date fechaEdicion;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String celular, String usuario, String contrasena, int idRol, int idEstatus, int idRancho, int idUsuarioAlta, Date fechaAlta, int idUsuarioEditor, Date fechaEdicion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.celular = celular;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.idRol = idRol;
        this.idEstatus = idEstatus;
        this.idRancho = idRancho;
        this.idUsuarioAlta = idUsuarioAlta;
        this.fechaAlta = fechaAlta;
        this.idUsuarioEditor = idUsuarioEditor;
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

    public int getIdEstatus() {
        return idEstatus;
    }

    public int getIdRancho() {
        return idRancho;
    }

    public int getIdUsuarioAlta() {
        return idUsuarioAlta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public int getIdUsuarioEditor() {
        return idUsuarioEditor;
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

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setIdUsuarioAlta(int idUsuarioAlta) {
        this.idUsuarioAlta = idUsuarioAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setIdUsuarioEditor(int idUsuarioEditor) {
        this.idUsuarioEditor = idUsuarioEditor;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }
    
    
    
}

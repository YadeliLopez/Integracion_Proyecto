/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojos;

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
    private int idUsuarioCreador;
    private String usuarioCreador;
    private String fechaCreacion;
    private int idUsuarioModificador;
    private String usuarioModificador;
    private String fechaModificacion;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String celular, String usuario, String contrasena, int idRol, String rol, int idEstatus, String estatus, int idRancho, String rancho, int idUsuarioCreador, String usuarioCreador, String fechaCreacion, int idUsuarioModificador, String usuarioModificador, String fechaModificacion) {
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
        this.idUsuarioCreador = idUsuarioCreador;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioModificador = idUsuarioModificador;
        this.usuarioModificador = usuarioModificador;
        this.fechaModificacion = fechaModificacion;
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

    public int getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public int getIdUsuarioModificador() {
        return idUsuarioModificador;
    }

    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
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

    public void setIdUsuarioCreador(int idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setIdUsuarioModificador(int idUsuarioModificador) {
        this.idUsuarioModificador = idUsuarioModificador;
    }

    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    
}

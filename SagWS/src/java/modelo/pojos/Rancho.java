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
public class Rancho {
    private int idRancho;
    private String nombre;
    private String direccion;
    private String encargado;
    private int idEstatus;
    private String estatus;
    private int idUsuarioAlta;
    private String usuarioAlta;
    private Date fechaAlta;
    private int idUsuarioEditor;
    private String usuarioEditor;
    private Date fechaEdicion;

    public Rancho() {
    }

    public Rancho(int idRancho, String nombre, String direccion, String encargado, int idEstatus, String estatus, int idUsuarioAlta, String usuarioAlta, Date fechaAlta, int idUsuarioEditor, String usuarioEditor, Date fechaEdicion) {
        this.idRancho = idRancho;
        this.nombre = nombre;
        this.direccion = direccion;
        this.encargado = encargado;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
        this.idUsuarioAlta = idUsuarioAlta;
        this.usuarioAlta = usuarioAlta;
        this.fechaAlta = fechaAlta;
        this.idUsuarioEditor = idUsuarioEditor;
        this.usuarioEditor = usuarioEditor;
        this.fechaEdicion = fechaEdicion;
    }

    public int getIdRancho() {
        return idRancho;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
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

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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

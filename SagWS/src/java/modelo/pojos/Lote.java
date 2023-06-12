/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojos;

/**
 *
 * @author Yadelí López
 */
public class Lote {
    private int idLote;
    private String nombre;
    private String descripcion;
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

    public Lote() {
    }

    public Lote(int idLote, String nombre, String descripcion, int idEstatus, String estatus, int idRancho, String rancho, int idUsuarioCreador, String usuarioCreador, String fechaCreacion, int idUsuarioModificador, String usuarioModificador, String fechaModificacion) {
        this.idLote = idLote;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public int getIdLote() {
        return idLote;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
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

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

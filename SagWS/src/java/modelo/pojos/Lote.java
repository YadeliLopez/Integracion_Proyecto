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
    private int idRancho;
    private int idUsuarioCreador;
    private String fechaCreacion;
    private int idUsuarioModificador;
    private String fechaModificacion;

    public Lote() {
    }

    public Lote(int idLote, String nombre, String descripcion, int idEstatus, int idRancho, int idUsuarioCreador, String fechaCreacion, int idUsuarioModificador, String fechaModificacion) {
        this.idLote = idLote;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idEstatus = idEstatus;
        this.idRancho = idRancho;
        this.idUsuarioCreador = idUsuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioModificador = idUsuarioModificador;
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

    public int getIdRancho() {
        return idRancho;
    }

    public int getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public int getIdUsuarioModificador() {
        return idUsuarioModificador;
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

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setIdUsuarioCreador(int idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setIdUsuarioModificador(int idUsuarioModificador) {
        this.idUsuarioModificador = idUsuarioModificador;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    
}

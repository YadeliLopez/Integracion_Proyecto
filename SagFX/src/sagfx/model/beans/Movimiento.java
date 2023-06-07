/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sagfx.model.beans;

/**
 *
 * @author Yadelí López
 */
public class Movimiento {
    
    private Integer idMovimiento;
    private Integer idTipo;
    private String tipo;
    private String idConcepto;
    private String cantidad;
    private String concepto;
    private Integer idUsuarioCreador;
    private String usuarioCreador;
    private String fechaCreacion;
    private String fechaCancelacion;
    private String descripcion;
    private Integer idEstatus;
    private String estatus;

    public Movimiento() {
    }

    public Movimiento(Integer idMovimiento, Integer idTipo, String tipo, String idConcepto, String cantidad, String concepto, Integer idUsuarioCreador, String usuarioCreador, String fechaCreacion, String fechaCancelacion, String descripcion, Integer idEstatus, String estatus) {
        this.idMovimiento = idMovimiento;
        this.idTipo = idTipo;
        this.tipo = tipo;
        this.idConcepto = idConcepto;
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.idUsuarioCreador = idUsuarioCreador;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.fechaCancelacion = fechaCancelacion;
        this.descripcion = descripcion;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getIdConcepto() {
        return idConcepto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public Integer getIdUsuarioCreador() {
        return idUsuarioCreador;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setIdUsuarioCreador(Integer idUsuarioCreador) {
        this.idUsuarioCreador = idUsuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdEstatus(Integer idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    
    
}

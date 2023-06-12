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
public class Traspaso {
    private int idTraspaso;
    private int idLoteAnterior;
    private String loteAnterior;
    private int idLoteDestino;
    private String loteDestino;
    private String motivoTraspaso;
    private int idRancho;
    private String rancho;
    private int idEstatus;
    private String estatus;
    private int idUsuarioCreador;
    private String usuarioCreador;
    private String fechaCreacion;
    private int idUsuarioModificador;
    private String usuarioModificador;
    private String fechaModificacion;
    private String fechaCancelacion;
    private String motivoCancelacion;

    public Traspaso() {
    }

    public Traspaso(int idTraspaso, int idLoteAnterior, String loteAnterior, int idLoteDestino, String loteDestino, String motivoTraspaso, int idRancho, String rancho, int idEstatus, String estatus, int idUsuarioCreador, String usuarioCreador, String fechaCreacion, int idUsuarioModificador, String usuarioModificador, String fechaModificacion, String fechaCancelacion, String motivoCancelacion) {
        this.idTraspaso = idTraspaso;
        this.idLoteAnterior = idLoteAnterior;
        this.loteAnterior = loteAnterior;
        this.idLoteDestino = idLoteDestino;
        this.loteDestino = loteDestino;
        this.motivoTraspaso = motivoTraspaso;
        this.idRancho = idRancho;
        this.rancho = rancho;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
        this.idUsuarioCreador = idUsuarioCreador;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioModificador = idUsuarioModificador;
        this.usuarioModificador = usuarioModificador;
        this.fechaModificacion = fechaModificacion;
        this.fechaCancelacion = fechaCancelacion;
        this.motivoCancelacion = motivoCancelacion;
    }

    public int getIdTraspaso() {
        return idTraspaso;
    }

    public int getIdLoteAnterior() {
        return idLoteAnterior;
    }

    public String getLoteAnterior() {
        return loteAnterior;
    }

    public int getIdLoteDestino() {
        return idLoteDestino;
    }

    public String getLoteDestino() {
        return loteDestino;
    }

    public String getMotivoTraspaso() {
        return motivoTraspaso;
    }

    public int getIdRancho() {
        return idRancho;
    }

    public String getRancho() {
        return rancho;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
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

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }

    public void setIdTraspaso(int idTraspaso) {
        this.idTraspaso = idTraspaso;
    }

    public void setIdLoteAnterior(int idLoteAnterior) {
        this.idLoteAnterior = idLoteAnterior;
    }

    public void setLoteAnterior(String loteAnterior) {
        this.loteAnterior = loteAnterior;
    }

    public void setIdLoteDestino(int idLoteDestino) {
        this.idLoteDestino = idLoteDestino;
    }

    public void setLoteDestino(String loteDestino) {
        this.loteDestino = loteDestino;
    }

    public void setMotivoTraspaso(String motivoTraspaso) {
        this.motivoTraspaso = motivoTraspaso;
    }

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setRancho(String rancho) {
        this.rancho = rancho;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
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

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    
    
}

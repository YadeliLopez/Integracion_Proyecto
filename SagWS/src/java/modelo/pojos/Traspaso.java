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
    private int idLoteDestino;
    private String motivoTraspaso;
    private int idRancho;
    private int idEstatus;
    private int idUsuarioCreador;
    private String fechaCreacion;
    private int idUsuarioModificador;
    private String fechaModificacion;
    private String fechaCancelacion;
    private String motivoCancelacion;

    public Traspaso() {
    }

    public Traspaso(int idTraspaso, int idLoteAnterior, int idLoteDestino, String motivoTraspaso, int idRancho, int idEstatus, int idUsuarioCreador, String fechaCreacion, int idUsuarioModificador, String fechaModificacion, String fechaCancelacion, String motivoCancelacion) {
        this.idTraspaso = idTraspaso;
        this.idLoteAnterior = idLoteAnterior;
        this.idLoteDestino = idLoteDestino;
        this.motivoTraspaso = motivoTraspaso;
        this.idRancho = idRancho;
        this.idEstatus = idEstatus;
        this.idUsuarioCreador = idUsuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioModificador = idUsuarioModificador;
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

    public int getIdLoteDestino() {
        return idLoteDestino;
    }

    public String getMotivoTraspaso() {
        return motivoTraspaso;
    }

    public int getIdRancho() {
        return idRancho;
    }

    public int getIdEstatus() {
        return idEstatus;
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

    public void setIdLoteDestino(int idLoteDestino) {
        this.idLoteDestino = idLoteDestino;
    }

    public void setMotivoTraspaso(String motivoTraspaso) {
        this.motivoTraspaso = motivoTraspaso;
    }

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
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

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }
    
    
}

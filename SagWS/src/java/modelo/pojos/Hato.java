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
public class Hato {
    private int idHato;
    private String arete;
    private int idRaza;
    private int idLote;
    private int idRancho;
    private String sexo;
    private int idEstatus;
    private String descripcionHato;
    private int idUsuarioCreador;
    private String fechaCreacion;
    private int idUsuarioModificador;
    private String fechaModificacion;
    private String fechaBaja;
    private String motivoBaja;

    public Hato() {
    }

    public Hato(int idHato, String arete, int idRaza, int idLote, int idRancho, String sexo, int idEstatus, String descripcionHato, int idUsuarioCreador, String fechaCreacion, int idUsuarioModificador, String fechaModificacion, String fechaBaja, String motivoBaja) {
        this.idHato = idHato;
        this.arete = arete;
        this.idRaza = idRaza;
        this.idLote = idLote;
        this.idRancho = idRancho;
        this.sexo = sexo;
        this.idEstatus = idEstatus;
        this.descripcionHato = descripcionHato;
        this.idUsuarioCreador = idUsuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioModificador = idUsuarioModificador;
        this.fechaModificacion = fechaModificacion;
        this.fechaBaja = fechaBaja;
        this.motivoBaja = motivoBaja;
    }

    public int getIdHato() {
        return idHato;
    }

    public String getArete() {
        return arete;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public int getIdLote() {
        return idLote;
    }

    public int getIdRancho() {
        return idRancho;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getDescripcionHato() {
        return descripcionHato;
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

    public String getFechaBaja() {
        return fechaBaja;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setIdHato(int idHato) {
        this.idHato = idHato;
    }

    public void setArete(String arete) {
        this.arete = arete;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setDescripcionHato(String descripcionHato) {
        this.descripcionHato = descripcionHato;
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

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }
    
    
    
}

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
    private String raza;
    private int idLote;
    private String lote;
    private int idRancho;
    private String rancho;
    private String sexo;
    private int idEstatus;
    private String estatus;
    private String descripcion;
    private int idUsuarioCreador;
    private String usuarioCreador;
    private String fechaCreacion;
    private int idUsuarioModificador;
    private String usuarioModificador;
    private String fechaModificacion;
    private String fechaBaja;
    private String motivoBaja;

    public Hato() {
    }

    public Hato(int idHato, String arete, int idRaza, String raza, int idLote, String lote, int idRancho, String rancho, String sexo, int idEstatus, String estatus, String descripcion, int idUsuarioCreador, String usuarioCreador, String fechaCreacion, int idUsuarioModificador, String usuarioModificador, String fechaModificacion, String fechaBaja, String motivoBaja) {
        this.idHato = idHato;
        this.arete = arete;
        this.idRaza = idRaza;
        this.raza = raza;
        this.idLote = idLote;
        this.lote = lote;
        this.idRancho = idRancho;
        this.rancho = rancho;
        this.sexo = sexo;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
        this.descripcion = descripcion;
        this.idUsuarioCreador = idUsuarioCreador;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioModificador = idUsuarioModificador;
        this.usuarioModificador = usuarioModificador;
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

    public String getRaza() {
        return raza;
    }

    public int getIdLote() {
        return idLote;
    }

    public String getLote() {
        return lote;
    }

    public int getIdRancho() {
        return idRancho;
    }

    public String getRancho() {
        return rancho;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getDescripcion() {
        return descripcion;
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

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setIdRancho(int idRancho) {
        this.idRancho = idRancho;
    }

    public void setRancho(String rancho) {
        this.rancho = rancho;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }
    
    
    
}

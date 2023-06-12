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
public class Cria {
    private int idCria;
    private int idHatoMadre;
    private String sexo;
    private String fechaNacimiento;
    private int idRaza;
    private int idEstatus;
    private String observaciones;
    private int idUsuarioCreador;
    private String fechaCreacion;
    private int idUsuarioModificador;
    private String fechaModificacion;
    private String fechaBaja;

    public Cria() {
    }

    public Cria(int idCria, int idHatoMadre, String sexo, String fechaNacimiento, int idRaza, int idEstatus, String observaciones, int idUsuarioCreador, String fechaCreacion, int idUsuarioModificador, String fechaModificacion, String fechaBaja) {
        this.idCria = idCria;
        this.idHatoMadre = idHatoMadre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.idRaza = idRaza;
        this.idEstatus = idEstatus;
        this.observaciones = observaciones;
        this.idUsuarioCreador = idUsuarioCreador;
        this.fechaCreacion = fechaCreacion;
        this.idUsuarioModificador = idUsuarioModificador;
        this.fechaModificacion = fechaModificacion;
        this.fechaBaja = fechaBaja;
    }

    public int getIdCria() {
        return idCria;
    }

    public int getIdHatoMadre() {
        return idHatoMadre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getObservaciones() {
        return observaciones;
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

    public void setIdCria(int idCria) {
        this.idCria = idCria;
    }

    public void setIdHatoMadre(int idHatoMadre) {
        this.idHatoMadre = idHatoMadre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
    
    
}

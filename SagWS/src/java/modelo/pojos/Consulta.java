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
public class Consulta {
    private int idConsulta;
    private int idHato;
    private int idEstatus;
    private String estatus;
    private String veterinario;
    private String fechaAtencion;
    private String observaciones;
    private String motivoAtencion;

    public Consulta() {
    }

    public Consulta(int idConsulta, int idHato, int idEstatus, String estatus, String veterinario, String fechaAtencion, String observaciones, String motivoAtencion) {
        this.idConsulta = idConsulta;
        this.idHato = idHato;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
        this.veterinario = veterinario;
        this.fechaAtencion = fechaAtencion;
        this.observaciones = observaciones;
        this.motivoAtencion = motivoAtencion;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public int getIdHato() {
        return idHato;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getMotivoAtencion() {
        return motivoAtencion;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setIdHato(int idHato) {
        this.idHato = idHato;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setMotivoAtencion(String motivoAtencion) {
        this.motivoAtencion = motivoAtencion;
    }

    
    
}

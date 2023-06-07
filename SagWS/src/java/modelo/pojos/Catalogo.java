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
public class Catalogo {
    public int idCatalogo;
    public int idCategoria;
    public String nombre;
    public String activo;
    public Integer orden;

    public Catalogo(int idCatalogo, int idCategoria, String nombre, String activo, Integer orden) {
        this.idCatalogo = idCatalogo;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.activo = activo;
        this.orden = orden;
    }
         
    public Catalogo() {
    }

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }  
    
    @Override
    public String toString() {
        return this.nombre;
    }
}

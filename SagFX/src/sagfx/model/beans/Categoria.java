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
public class Categoria {
    public Integer idCategoria;
    public String nombre;
    public String activo;

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nombre, String activo) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getActivo() {
        return activo;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    
}

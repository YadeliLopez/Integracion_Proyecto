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
public class Catalogo {
    public int idCatalogo;
    public int idCategoria;
    public String nombre;
    public String activo;

    public Catalogo() {
    }

    public Catalogo(int idCatalogo, int idCategoria, String nombre, String activo) {
        this.idCatalogo = idCatalogo;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getIdCatalogo() {
        return idCatalogo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getActivo() {
        return activo;
    }

    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    
    
}

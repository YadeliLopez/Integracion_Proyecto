/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Catalogo;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("catalogo")
public class CatalogoWS {

    public CatalogoWS() {
    }
    
    @GET
    @Path("getAllCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo>getAllCatalogo(){
        List<Catalogo> list = new ArrayList<Catalogo>();
        SqlSession conn = null;
        try{
            conn=MyBatisUtil.getSession();
            list=conn.selectList("Catalogo.getAllCatalogo");
        }catch(Exception ex){
            ex.printStackTrace();
            
        }finally{
            conn.close();
        }
        return list;
    }
    
    @GET
    @Path("getCatalogosByIdCategoria/{idCategoria}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo>getCatalogosByIdCategoria(@PathParam("idCategoria") Integer idCategoria){
        List<Catalogo> list = new ArrayList<Catalogo>();
        SqlSession conn = null;
        try{
            conn=MyBatisUtil.getSession();
            list=conn.selectList("Catalogo.getCatalogosByIdCategoria", idCategoria);
        }catch(Exception ex){
            ex.printStackTrace();
            
        }finally{
            conn.close();
        }
        return list;
    }
    
    @POST
    @Path("registrarCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarCatalogo(
            @FormParam("idCatalogo") int idCatalogo,
            @FormParam("idCategoria") int idCategoria,
            @FormParam("nombre") String nombre,
            @FormParam("activo") String activo){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("idCategoria", idCategoria);
            param.put("nombre", nombre);
            param.put("activo", activo);
            
            conn.insert("Catalogo.registrarCatalogo", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Catalogo registrado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar el catalogo");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarCatalogo(
            @FormParam("idCatalogo") int idCatalogo,
            @FormParam("idCategoria") int idCategoria,
            @FormParam("nombre") String nombre,
            @FormParam("activo") String activo){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("idCategoria", idCategoria);
            param.put("nombre", nombre);
            param.put("activo", activo);
            
            conn.update("Catalogo.actualizarCatalogo", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Catalogo actualizar correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar el catalogo");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarEstatusCatalogo")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusCatalogo(
            @FormParam("idCatalogo") Integer idCatalogo,
            @FormParam("activo") String activo){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCatalogo", idCatalogo);
            param.put("activo", activo);
            
            conn.update("Catalogo.actualizarEstatusCatalogo", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus del catalogo ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus del catalogo...");
        }finally{
            conn.close();
        }
        return res;
    }
}

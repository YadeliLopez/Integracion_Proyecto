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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Categoria;
import modelo.pojos.Rancho;
import modelo.pojos.Respuesta;
import modelo.pojos.Usuario;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("rancho")
public class RanchoWS {
    
    @Context
    private UriInfo context;
    
    public RanchoWS(){
        
    }
    
    @GET
    @Path("getAllRanchos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rancho>getAllRanchos(){
        List<Rancho> list = new ArrayList<Rancho>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Rancho.getAllRanchos");
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return list;
    }
    
    @POST
    @Path("registrarRancho")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarRancho(
            @FormParam("nombre") String nombre,
            @FormParam("direccion") String direccion,
            @FormParam("encargado") String encargado,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("idUsuarioCreador") Integer idUsuarioCreador,
            @FormParam("fechaCreacion") String fechaCreacion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("nombre", nombre);
            param.put("direccion", direccion);
            param.put("encargado", encargado);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", fechaCreacion);
            
            conn.insert("Rancho.registrarRancho", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Rancho registrado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar el rancho");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarRancho")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarRancho(
            @FormParam("idRancho") Integer idRancho,
            @FormParam("nombre") String nombre,
            @FormParam("direccion") String direccion,
            @FormParam("encargado") String encargado,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam ("idUsuarioCreador") Integer idUsuarioCreador,
            @FormParam("fechaCreacion") String fechaCreacion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idRancho", idRancho);
            param.put("nombre", nombre);
            param.put("direccion", direccion);
            param.put("encargado", encargado);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", fechaCreacion);
            
            conn.update("Rancho.actualizarRancho", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Rancho actualizado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar el rancho");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarEstatusRancho")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusRancho(
            @FormParam("idRancho") Integer idRancho,
            @FormParam("idEstatus") Integer idEstatus){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idRancho", idRancho);
            param.put("idEstatus", idEstatus);
            
            conn.update("Rancho.actualizarEstatusRancho", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus del rancho ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus del rancho...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("buscarRancho")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rancho> buscarRancho(
            @FormParam("busqueda") String busqueda){
        List<Rancho> list = new ArrayList<Rancho>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Rancho.buscarRancho", busqueda);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
        return list;
    }
    
}

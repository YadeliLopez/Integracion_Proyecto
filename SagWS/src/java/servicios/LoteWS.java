/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Lote;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("lote")
public class LoteWS {
    @Context
    private UriInfo context;
    
    public LoteWS(){
        
    }
    
    @GET
    @Path("getAllLotes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lote>getAllHatos(){
        List<Lote> list = new ArrayList<Lote>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Lote.getAllLotes");
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
    @Path("registrarLote")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarLote(
            @FormParam("nombre") String nombre,
            @FormParam("descripcion") String descripcion,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("idRancho") Integer idRancho,
            @FormParam("idUsuarioCreador") Integer idUsuarioCreador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("nombre", nombre);
            param.put("descripcion", descripcion);
            param.put("idEstatus", idEstatus);
            param.put("idRancho", idRancho);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", LocalDate.now());
            
            conn.insert("Lote.registrarLote", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Lote registrado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar el lote");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarLote")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarLote(
        @FormParam("idLote") Integer idLote,
        @FormParam("nombre") String nombre,
        @FormParam("descripcion") String descripcion,
        @FormParam("idEstatus") Integer idEstatus,
        @FormParam("idRancho") Integer idRancho,
        @FormParam("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idLote", idLote);
            param.put("nombre", nombre);
            param.put("descripcion", descripcion);
            param.put("idEstatus", idEstatus);
            param.put("idRancho", idRancho);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.update("Lote.actualizarLote", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Lote actualizado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar el Lote");
        }finally{
            conn.close();
        }
        return res;
    }  
    
    @POST
    @Path("actualizarEstatusLote")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusLote(
            @FormParam("idLote") Integer idLote,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam ("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idLote", idLote);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.update("Lote.actualizarEstatusLote", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus del lote ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus del lote...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @GET
    @Path("getAllLotesByIdRancho/{idRancho}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lote>getAllLotesByIdRancho(@PathParam("idRancho") Integer idRancho){
        List<Lote> list = new ArrayList<Lote>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Lote.getAllLotesByIdRancho", idRancho);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return list;
    }
}

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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Hato;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("hato")
public class HatoWS {
    
    @Context
    private UriInfo context;
    
    public HatoWS(){
        
    }
    
    @GET
    @Path("getAllHatos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hato>getAllHatos(){
        List<Hato> list = new ArrayList<Hato>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Hato.getAllHatos");
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
    @Path("registrarHato")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarHato(
            @FormParam("arete") String arete,
            @FormParam("idRaza") Integer idRaza,
            @FormParam("idLote") Integer idLote,
            @FormParam("idRancho") Integer idRancho,
            @FormParam("sexo") String sexo,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("descripcion") String descripcion,
            @FormParam("idUsuarioCreador") String idUsuarioCreador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("arete", arete);
            param.put("idRaza", idRaza);
            param.put("idLote", idLote);
            param.put("idRancho", idRancho);
            param.put("sexo", sexo);
            param.put("idEstatus", idEstatus);
            param.put("descripcionHato", descripcion);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", LocalDate.now());
            
            conn.insert("Hato.registrarHato", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Hato registrado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar el Hato");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarHato")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarHato(
        @FormParam("idHato") Integer idHato,
        @FormParam("arete") String arete,
        @FormParam("idRaza") Integer idRaza,
        @FormParam("idLote") Integer idLote,
        @FormParam("idRancho") Integer idRancho,
        @FormParam ("sexo") String sexo,
        @FormParam("idEstatus") Integer idEstatus,
        @FormParam("descripcion") String descripcion,
        @FormParam("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idHato", idHato);
            param.put("arete", arete);
            param.put("idRaza", idRaza);
            param.put("idLote", idLote);
            param.put("idRancho", idRancho);
            param.put("sexo", sexo);
            param.put("idEstatus", idEstatus);
            param.put("descripcionHato", descripcion);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.update("Hato.actualizarHato", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Hato actualizado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar el Hato");
        }finally{
            conn.close();
        }
        return res;
    }  
    
    @POST
    @Path("actualizarEstatusHato")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusHato(
            @FormParam("idHato") Integer idHato,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam ("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idHato", idHato);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.update("Hato.actualizarEstatusHato", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus del Hato ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus del Hato...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("eliminarHato")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta eliminarHato(
            @FormParam("idHato") Integer idHato,
            @FormParam("motivoBaja") String motivoBaja){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idHato", idHato);
            param.put("fechaBaja", LocalDate.now());
            param.put("motivoBaja", motivoBaja);
            
            
            conn.update("Hato.eliminarHato", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El hato ha sido dado de baja");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo dar de baja al hato...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("buscarHato")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hato> buscarHato(
            @FormParam("arete") String arete,
            @FormParam("raza") String raza,
            @FormParam("lote") String lote,
            @FormParam("rancho") String rancho){
        List<Hato> list = new ArrayList<Hato>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("arete", arete);
            param.put("raza", raza);
            param.put("lote", lote);
            param.put("rancho", rancho);
            list = conn.selectList("Hato.buscarHato", param);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
        return list;
    }
    
}

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
import modelo.pojos.Respuesta;
import modelo.pojos.Traspaso;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("traspaso")
public class TraspasoWS {
    
    @Context
    private UriInfo context;
    
    public TraspasoWS(){
        
    }
    
    @GET
    @Path("getAllTraspasos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Traspaso>getAllRanchos(){
        List<Traspaso> list = new ArrayList<Traspaso>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Traspaso.getAllTraspasos");
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
    @Path("registrarTraspaso")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarTraspaso(
            @FormParam("idLoteAnterior") Integer idLoteAnterior,
            @FormParam("idLoteDestino") Integer idLoteDestino,
            @FormParam("motivoTraspaso") String motivoTraspaso,
            @FormParam("idRancho") Integer idRancho,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("idUsuarioCreador") Integer idUsuarioCreador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idLoteAnterior", idLoteAnterior);
            param.put("idLoteDestino", idLoteDestino);
            param.put("motivoTraspaso", motivoTraspaso);
            param.put("idRancho", idRancho);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", LocalDate.now());
            
            conn.insert("Traspaso.registrarTraspaso", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Traspaso registrado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar el traspaso");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarTraspaso")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarTraspaso(
            @FormParam("idTraspaso") Integer idTraspaso,
            @FormParam("idLoteAnterior") Integer idLoteAnterior,
            @FormParam("idLoteDestino") Integer idLoteDestino,
            @FormParam("motivoTraspaso") String motivoTraspaso,
            @FormParam("idRancho") Integer idRancho,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idTraspaso", idTraspaso);
            param.put("idLoteAnterior", idLoteAnterior);
            param.put("idLoteDestino", idLoteDestino);
            param.put("motivoTraspaso", motivoTraspaso);
            param.put("idRancho", idRancho);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.insert("Traspaso.actualizarTraspaso", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Traspaso actualizado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar el traspaso");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarEstatusTraspaso")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusTraspaso(
            @FormParam("idTraspaso") Integer idTraspaso,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam ("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idTraspaso", idTraspaso);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.update("Traspaso.actualizarEstatusTraspaso", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus del traspaso ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus del traspaso...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("eliminarTraspaso")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta eliminarTraspaso(
            @FormParam("idTraspaso") Integer idTraspaso,
            @FormParam("idUsuarioModificador") Integer idUsuarioModificador,
            @FormParam("motivoCancelacion") String motivoCancelacion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idTraspaso", idTraspaso);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("motivoCancelacion", motivoCancelacion);
            param.put("fechaCancelacion", LocalDate.now());
            
            
            conn.update("Traspaso.eliminarTraspaso", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El traspaso ha sido cancelado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo cancelar el traspaso...");
        }finally{
            conn.close();
        }
        return res;
    }
    
}

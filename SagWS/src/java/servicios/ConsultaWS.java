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
import modelo.pojos.Consulta;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("consulta")
public class ConsultaWS {
    @Context
    private UriInfo context;
    
    public ConsultaWS(){
        
    }
    
    @GET
    @Path("getAllConsultas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consulta>getAllConsultas(){
        List<Consulta> list = new ArrayList<Consulta>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Consulta.getAllConsultas");
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
    @Path("registrarConsulta")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarConsulta(
            @FormParam("idHato") Integer idHato,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("veterinario") String veterinario,
            @FormParam("observaciones") String observaciones,
            @FormParam("motivoAtencion") String motivoAtencion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idHato", idHato);
            param.put("idEstatus", idEstatus);
            param.put("veterinario", veterinario);
            param.put("fechaAtencion", LocalDate.now());
            param.put("observaciones", observaciones);
            param.put("motivoAtencion", motivoAtencion);
            
            conn.insert("Consulta.registrarConsulta", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Consulta registrada correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar la consulta");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarConsulta")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarConsulta(
            @FormParam("idConsulta") Integer idConsulta,
            @FormParam("idHato") Integer idHato,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("veterinario") String veterinario,
            @FormParam("observaciones") String observaciones,
            @FormParam("motivoAtencion") String motivoAtencion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idConsulta", idConsulta);
            param.put("idHato", idHato);
            param.put("idEstatus", idEstatus);
            param.put("veterinario", veterinario);
            param.put("fechaAtencion", LocalDate.now());
            param.put("observaciones", observaciones);
            param.put("motivoAtencion", motivoAtencion);
            
            conn.insert("Consulta.actualizarConsulta", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Consulta actualizada correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar la consulta");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarEstatusConsulta")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusConsulta(
            @FormParam("idConsulta") Integer idConsulta,
            @FormParam("idEstatus") Integer idEstatus){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idConsulta", idConsulta);
            param.put("idEstatus", idEstatus);
            
            conn.update("Consulta.actualizarEstatusConsulta", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus de la consulta ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus de la consulta...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("eliminarConsulta")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta eliminarConsulta(
            @FormParam("idConsulta") Integer idConsulta){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idConsulta", idConsulta);
            
            
            conn.update("Consulta.eliminarConsulta", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("La consulta ha sido cancelada");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo cancelar la consulta...");
        }finally{
            conn.close();
        }
        return res;
    }
}

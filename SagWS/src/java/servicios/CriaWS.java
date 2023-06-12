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
import modelo.pojos.Cria;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("cria")
public class CriaWS {
    
    @Context
    private UriInfo context;
    
    public CriaWS(){
        
    }
    
    @GET
    @Path("getAllCrias")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cria>getAllRanchos(){
        List<Cria> list = new ArrayList<Cria>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Cria.getAllCrias");
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
    @Path("registrarCria")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarCria(
            @FormParam("idHatoMadre") Integer idHatoMadre,
            @FormParam("sexo") String sexo,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("idRaza") Integer idRaza,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("observaciones") String observaciones,
            @FormParam("idUsuarioCreador") Integer idUsuarioCreador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idHatoMadre", idHatoMadre);
            param.put("sexo", sexo);
            param.put("fechaNacimiento", fechaNacimiento);
            param.put("idRaza", idRaza);
            param.put("idEstatus", idEstatus);
            param.put("observaciones", observaciones);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", LocalDate.now());
            
            conn.insert("Cria.registrarCria", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Cría registrada correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar la cría");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarCria")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarCria(
            @FormParam("idCria") Integer idCria,
            @FormParam("sexo") String sexo,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("idRaza") Integer idRaza,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("observaciones") String observaciones,
            @FormParam("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCria", idCria);
            param.put("sexo", sexo);
            param.put("fechaNacimiento", fechaNacimiento);
            param.put("idRaza", idRaza);
            param.put("idEstatus", idEstatus);
            param.put("observaciones", observaciones);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.insert("Cria.actualizarCria", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Cría actualizada correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar la cría");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarEstatusCria")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusCria(
            @FormParam("idCria") Integer idCria,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam ("idUsuarioModificador") Integer idUsuarioModificador){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCria", idCria);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", LocalDate.now());
            
            conn.update("Cria.actualizarEstatusCria", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus de la cría ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus de la cría...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("eliminarCria")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta eliminarCria(
            @FormParam("idCria") Integer idCria){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idCria", idCria);
            param.put("fechaBaja", LocalDate.now());
            
            
            conn.update("Cria.eliminarCria", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("La cría ha sido dado de baja");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo dar de baja a la cría...");
        }finally{
            conn.close();
        }
        return res;
    }
    
}

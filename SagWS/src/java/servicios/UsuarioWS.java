/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Rancho;
import modelo.pojos.Usuario;
import modelo.pojos.Respuesta;
import org.apache.ibatis.session.SqlSession;
import utils.JavaUtils;

/**
 * REST Web Service
 *
 * @author Yadelí López
 */
@Path("usuario")
public class UsuarioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioWS
     */
    public UsuarioWS() {
    }

    /**
     * Retrieves representation of an instance of servicios.UsuarioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario>getAllUsers(){
        List<Usuario> list = new ArrayList<Usuario>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Usuario.getAllUsers");
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
    @Path("registrarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarUsuario(
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("celular") String celular,
            @FormParam("usuario") String usuario,
            @FormParam("contrasena") String contrasena,
            @FormParam("idRol") int idRol,
            @FormParam("idEstatus") int idEstatus,
            @FormParam("idRancho") int idRancho,
            @FormParam("idUsuarioCreador") int idUsuarioCreador,
            @FormParam("fechaCreacion") String fechaCreacion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("nombre", nombre);
            param.put("apellidoPaterno", apellidoPaterno);
            param.put("apellidoMaterno", apellidoMaterno);
            param.put("celular", celular);
            param.put("usuario", usuario);
            param.put("contrasena", JavaUtils.hashString(contrasena.toUpperCase()));
            param.put("idRol", idRol);
            param.put("idEstatus", idEstatus);
            param.put("idRancho", idRancho);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", fechaCreacion);
            
            conn.insert("Usuario.registrarUsuario", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Usuario registrado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar el usuario");
        }finally{
            conn.close();
        }
        
        return res;
    }
    
    @POST
    @Path("actualizarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarUsuario(
            @FormParam("idUsuario") int idUsuario,
            @FormParam("nombre") String nombre,
            @FormParam("apellidoPaterno") String apellidoPaterno,
            @FormParam("apellidoMaterno") String apellidoMaterno,
            @FormParam("celular") String celular,
            @FormParam("usuario") String usuario,
            @FormParam("contrasena") String contrasena,
            @FormParam("idRol") int idRol,
            @FormParam("idEstatus") int idEstatus,
            @FormParam("idRancho") int idRancho,
            @FormParam("idUsuarioModificador") int idUsuarioModificador,
            @FormParam("fechaModificacion") String fechaModificacion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idUsuario", idUsuario);
            param.put("nombre", nombre);
            param.put("apellidoPaterno", apellidoPaterno);
            param.put("apellidoMaterno", apellidoMaterno);
            param.put("celular", celular);
            param.put("usuario", usuario);
            param.put("contrasena", JavaUtils.hashString(contrasena.toUpperCase()));
            param.put("idRol", idRol);
            param.put("idEstatus", idEstatus);
            param.put("idRancho", idRancho);
            param.put("idUsuarioModificador", idUsuarioModificador);
            param.put("fechaModificacion", fechaModificacion);
            
            conn.update("Usuario.actualizarUsuario", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Usuario actualizado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede actualizar el usuario");
        }finally{
            conn.close();
        }
        
        return res;
    }
    
    @PUT
    @Path("actualizarEstatusUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatus(
            @FormParam("idUsuario") Integer idUsuario,
            @FormParam("idEstatus") Integer idEstatus){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idUsuario", idUsuario);
            param.put("idEstatus", idEstatus);
            
            conn.update("Usuario.actualizarEstatusUsuario", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El usuario ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el usuario...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("buscarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> buscarUsuario(
            @FormParam("busqueda") String busqueda){
        List<Usuario> list = new ArrayList<Usuario>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Usuario.buscarUsuario", busqueda);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
        return list;
    }
}

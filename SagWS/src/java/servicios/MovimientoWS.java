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
import javax.ws.rs.core.MediaType;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Movimiento;
import modelo.pojos.Respuesta;
import modelo.pojos.Usuario;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Yadelí López
 */
@Path("movimiento")
public class MovimientoWS {
    
    public MovimientoWS(){
    }
    
    @GET
    @Path("getAllMovimientos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movimiento>getAllMovimientos(){
        List<Movimiento> list = new ArrayList<Movimiento>();
        SqlSession conn = null;
        try{
            conn = MyBatisUtil.getSession();
            list = conn.selectList("Movimiento.getAllMovimientos");
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
    @Path("registrarMovimiento")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta registrarRancho(
            @FormParam("idTipo") Integer idTipo,
            @FormParam("idConcepto") Integer idConcepto,
            @FormParam("cantidad") String cantidad,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("idUsuarioCreador") Integer idUsuarioCreador,
            @FormParam("fechaCreacion") String fechaCreacion,
            @FormParam("descripcion") String descripcion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idTipo", idTipo);
            param.put("idConcepto", idConcepto);
            param.put("cantidad", cantidad);
            param.put("idEstatus", idEstatus);
            param.put("idUsuarioCreador", idUsuarioCreador);
            param.put("fechaCreacion", fechaCreacion);
            param.put("descripcion", descripcion);
            
            conn.insert("Movimiento.registrarMovimiento", param);
            conn.commit();
            res.setError(false);
            res.setMensaje("Movimiento registrado correctamente...");
        }catch(Exception ex){
            ex.printStackTrace();
            res.setError(true);
            res.setMensaje("No se puede registrar el movimiento");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("actualizarEstatusMovi")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta actualizarEstatusRancho(
            @FormParam("idMovimiento") Integer idMovimiento,
            @FormParam("idEstatus") Integer idEstatus,
            @FormParam("fechaCancelacion") String fechaCancelacion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idMovimiento", idMovimiento);
            param.put("idEstatus", idEstatus);
            param.put("fechaCancelacion", fechaCancelacion);
            
            conn.update("Movimiento.actualizarEstatusMovi", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus del movimiento ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus del movimiento...");
        }finally{
            conn.close();
        }
        return res;
    }
    
    @POST
    @Path("cancelarMovimiento")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta cancelarMovimiento(
            @FormParam("idMovimiento") Integer idMovimiento,
            @FormParam("fechaCancelacion") String fechaCancelacion){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, Object> param = new HashMap<String, Object>();
            param.put("idMovimiento", idMovimiento);
            param.put("fechaCancelacion", fechaCancelacion);
            
            conn.update("Movimiento.cancelarMovimiento", param);
            conn.commit();
            
            res.setError(false);
            res.setMensaje("El estatus del movimiento ha sido actualizado");
        }catch(Exception e){
            e.printStackTrace();
            res.setError(true);
            res.setMensaje("No se pudo actualizar el estatus del movimiento...");
        }finally{
            conn.close();
        }
        return res;
    }
}

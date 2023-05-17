/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.HashMap;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Respuesta;
import modelo.pojos.Usuario;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import utils.JavaUtils;

/**
 *
 * @author Yadelí López
 */
@Path("sesion")
public class SesionWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SesionWS
     */
    public SesionWS() {
    }
    
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta login(
            @FormParam("usuario")String usuario, 
            @FormParam("contrasena")String contrasena){
        Respuesta res = new Respuesta();
        SqlSession conn = MyBatisUtil.getSession();
        try{
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("usuario", usuario);
            param.put("contrasena", JavaUtils.hashString(contrasena.toUpperCase()));
            Usuario u = conn.selectOne("Sesion.login", param);
            System.out.println(param);
            if(u==null){
                res.setError(true);
                res.setMensaje("No se encontró ningún usuario con esas credenciales");
            }else{
                //res.setError(false);
                //res.setMensaje(null);
                JSONObject jo = new JSONObject(u);
                //String cad = new Gson().toJson(jo);
                //System.out.println(jo);
                //System.out.println(cad);
                
                //res.setRespuesta(jo);
                //res.setRespuesta(jo.toString());
                res.setRespuesta(jo);
                res.setError(false);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            conn.close();
        }
        return res;
    }

}

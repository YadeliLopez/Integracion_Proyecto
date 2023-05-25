/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import modelo.mybatis.MyBatisUtil;
import modelo.pojos.Rancho;
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
    
}

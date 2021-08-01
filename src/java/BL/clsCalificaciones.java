/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsCalificaciones {
    
    Connection conn = null;
    
    public clsCalificaciones(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Models.clsCalificacion> getCalificacion(){
        
        List<Models.clsCalificacion> lstclsCalificacion = new ArrayList<Models.clsCalificacion>();
        
        try{
            
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarCalificacion() }");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();
                obclsCalificacion.setInCodigo(rs.getInt("caliCodigo"));
                obclsCalificacion.setStDescripion(rs.getString("caliDescripcion"));
                
                lstclsCalificacion.add(obclsCalificacion);
            }
        
        }catch(Exception ex){}
        
        return lstclsCalificacion;
    }
}

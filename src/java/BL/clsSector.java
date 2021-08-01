/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;

public class clsSector {
    Connection conn = null;
    
    public clsSector(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Models.clsSector> getSector(){
        
        List<Models.clsSector> lstclsSector = new ArrayList<Models.clsSector>();
        
        try{
            
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarSector() }");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsSector obclsSector = new Models.clsSector();
                obclsSector.setInCodigo(rs.getInt("sectCodigo"));
                obclsSector.setStDescripion(rs.getString("sectDescripcion"));
                
                lstclsSector.add(obclsSector);
            }
        
        }catch(Exception ex){}
        
        return lstclsSector;
    }
}

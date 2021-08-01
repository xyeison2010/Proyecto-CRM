/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsEstadoPosibleCliente {
    Connection conn = null;
    
    public clsEstadoPosibleCliente(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Models.clsEstadoPosibleCliente> getEstadoPosibleCliente(){
        
        List<Models.clsEstadoPosibleCliente> lstclsEstadoPosibleCliente = new ArrayList<Models.clsEstadoPosibleCliente>();
        
        try{
            
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarEstadoCliente() }");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
                obclsEstadoPosibleCliente.setInCodigo(rs.getInt("esclCodigo"));
                obclsEstadoPosibleCliente.setStDescripion(rs.getString("esclDescripcion"));
                
                lstclsEstadoPosibleCliente.add(obclsEstadoPosibleCliente);
            }
        
        }catch(Exception ex){}
        
        return lstclsEstadoPosibleCliente;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsFuentePosibleCliente {
    Connection conn = null;
    
    public clsFuentePosibleCliente(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Models.clsFuentePosibleCliente> getFuentePosibleCliente(){
        
        List<Models.clsFuentePosibleCliente> lstclsFuentePosibleCliente = new ArrayList<Models.clsFuentePosibleCliente>();
        
        try{
            
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarFuente() }");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
                obclsFuentePosibleCliente.setInCodigo(rs.getInt("fuenCodigo"));
                obclsFuentePosibleCliente.setStDescripcion(rs.getString("fuenDescripcion"));
                
                lstclsFuentePosibleCliente.add(obclsFuentePosibleCliente);
            }
        
        }catch(Exception ex){}
        
        return lstclsFuentePosibleCliente;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsPrioridad {

    Connection conn = null;

    public clsPrioridad() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsPrioridad> getPrioridad() {

        List<Models.clsPrioridad> lstclsPrioridad = new ArrayList<Models.clsPrioridad>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarPrioridad() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Models.clsPrioridad obclsPrioridad = new Models.clsPrioridad();
                obclsPrioridad.setInCodigo(rs.getInt("prioCodigo"));
                obclsPrioridad.setStDescripcion(rs.getString("prioDescripcion"));

                lstclsPrioridad.add(obclsPrioridad);
            }

        } catch (Exception ex) {

        }

        return lstclsPrioridad;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsEstadoCampana {

    Connection conn = null;

    public clsEstadoCampana() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsEstadoCampana> getEstadoCampana() {

        List<Models.clsEstadoCampana> lstclsEstadoCampana = new ArrayList<Models.clsEstadoCampana>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultaEstadoCampana() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsEstadoCampana obclsEstadoCampana = new Models.clsEstadoCampana();
                obclsEstadoCampana.setInCodigo(rs.getInt("escaCodigo"));
                obclsEstadoCampana.setStDescripcion(rs.getString("escaDescripcion"));

                lstclsEstadoCampana.add(obclsEstadoCampana);
            }

        } catch (Exception es) {
        }
        return lstclsEstadoCampana;
    }
}

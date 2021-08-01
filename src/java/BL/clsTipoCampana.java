/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsTipoCampana {

    Connection conn = null;

    public clsTipoCampana() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsTipoCampana> getTipoCampana() {

        List<Models.clsTipoCampana> lstclsTipoCampana = new ArrayList<Models.clsTipoCampana>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarTipoCampana() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsTipoCampana obclsTipoCampana = new Models.clsTipoCampana();
                obclsTipoCampana.setInCodigo(rs.getInt("ticaCodigo"));
                obclsTipoCampana.setStDescripcion(rs.getString("ticaDescripcion"));

                lstclsTipoCampana.add(obclsTipoCampana);
            }

        } catch (Exception es) {
        }
        return lstclsTipoCampana;
    }
}

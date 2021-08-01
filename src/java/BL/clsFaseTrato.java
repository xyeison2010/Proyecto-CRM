/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsFaseTrato {
    Connection conn = null;

    public clsFaseTrato() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsFaseTrato> getFaseTrato() {

        List<Models.clsFaseTrato> lstclsFaseTrato = new ArrayList<Models.clsFaseTrato>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarFaseTrato() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Models.clsFaseTrato obclsFaseTrato = new Models.clsFaseTrato();
                obclsFaseTrato.setInCodigo(rs.getInt("faseCodigo"));
                obclsFaseTrato.setStDescripcion(rs.getString("faseDescripcion"));

                lstclsFaseTrato.add(obclsFaseTrato);
            }

        } catch (Exception ex) {

        }
        return lstclsFaseTrato;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsRelacionadoCon {

    Connection conn = null;

    public clsRelacionadoCon() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsRelacionadoCon> getRelacionadoCon() {

        List<Models.clsRelacionadoCon> lstclsRelacionadoCon
                = new ArrayList<Models.clsRelacionadoCon>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarRelacionadoCon() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsRelacionadoCon obclsRelacionadoCon
                        = new Models.clsRelacionadoCon();
                obclsRelacionadoCon.setInCodigo(rs.getInt("recoCodigo"));
                obclsRelacionadoCon.setStDescripcion(rs.getString("recoDescripcion"));
                lstclsRelacionadoCon.add(obclsRelacionadoCon);
            }

        } catch (Exception ex) {

        }

        return lstclsRelacionadoCon;
    }
}

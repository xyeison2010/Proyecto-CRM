/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsTipotrato {
    Connection conn = null;

    public clsTipotrato() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsTipoTrato> getTipoTrato() {

        List<Models.clsTipoTrato> lstclsTipoTrato = new ArrayList<Models.clsTipoTrato>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarTipoTrato() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Models.clsTipoTrato obclsTipoTrato = new Models.clsTipoTrato();
                obclsTipoTrato.setInCodigo(rs.getInt("titrCodigo"));
                obclsTipoTrato.setStDescripcion(rs.getString("titrDescripcion"));

                lstclsTipoTrato.add(obclsTipoTrato);
            }

        } catch (Exception ex) {

        }
        return lstclsTipoTrato;
    }
}

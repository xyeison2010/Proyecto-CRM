/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsTipoLlamada {

    Connection conn = null;

    public clsTipoLlamada() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsTipoLlamada> getTipoLlamada() {

        List<Models.clsTipoLlamada> lstclsTipoLlamada = new ArrayList<Models.clsTipoLlamada>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarTipoLlamada() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsTipoLlamada obclsTipoLlamada = new Models.clsTipoLlamada();
                obclsTipoLlamada.setInCodigo(rs.getInt("tillCodigo"));
                obclsTipoLlamada.setStDescripcion(rs.getString("tillDescripcion"));

                lstclsTipoLlamada.add(obclsTipoLlamada);
            }

        } catch (Exception es) {
        }
        return lstclsTipoLlamada;
    }
}

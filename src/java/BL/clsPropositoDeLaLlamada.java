/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsPropositoDeLaLlamada {

    Connection conn = null;

    public clsPropositoDeLaLlamada() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsPropositoDeLaLlamada> getPropositoDeLaLlamada() {

        List<Models.clsPropositoDeLaLlamada> lstclsPropositoDeLaLlamada
                = new ArrayList<Models.clsPropositoDeLaLlamada>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarPropositoLlamada() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsPropositoDeLaLlamada obclsPropositoDeLaLlamada
                        = new Models.clsPropositoDeLaLlamada();
                obclsPropositoDeLaLlamada.setInCodigo(rs.getInt("propCodigo"));
                obclsPropositoDeLaLlamada.setStDescripcion(rs.getString("propDescripcion"));
                lstclsPropositoDeLaLlamada.add(obclsPropositoDeLaLlamada);
            }

        } catch (Exception ex) {

        }

        return lstclsPropositoDeLaLlamada;

    }
}

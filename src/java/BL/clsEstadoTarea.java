/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsEstadoTarea {

    Connection conn = null;

    public clsEstadoTarea() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Models.clsEstadoTarea> getEstadoTarea() {

        List<Models.clsEstadoTarea> ltsclsEstadoTarea = new ArrayList<Models.clsEstadoTarea>();

        try {

            PreparedStatement ps = conn.prepareStatement("{ call spConsultarEstadoTarea() }");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Models.clsEstadoTarea obclsEstadoTarea = new Models.clsEstadoTarea();
                obclsEstadoTarea.setInCodigo(rs.getInt("estarCodigo"));
                obclsEstadoTarea.setStDescripcion(rs.getString("estarDescripcion"));

                ltsclsEstadoTarea.add(obclsEstadoTarea);
            }

        } catch (Exception ex) {

        }
        return ltsclsEstadoTarea;
    }
}

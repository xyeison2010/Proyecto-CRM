/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsTareas {

    Connection conn = null;

    public clsTareas() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();

    }

    public String createTarea(Models.clsTareas obclsTareas) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarTarea(?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsTareas.getStTitular());
            ps.setString(2, obclsTareas.getStAsunto());
            ps.setString(3, obclsTareas.getStFechaVencimiento());
            ps.setString(4, obclsTareas.getStContacto());
            ps.setString(5, obclsTareas.getStCuenta());
            ps.setInt(6, obclsTareas.getObclsEstadoTarea().getInCodigo());
            ps.setInt(7, obclsTareas.getObclsPrioridad().getInCodigo());
            ps.setString(8, String.valueOf(obclsTareas.getChEnviarMensaje()));
            ps.setString(9, String.valueOf(obclsTareas.getChRepetir()));
            ps.setString(10, obclsTareas.getStDescripcion());

            ps.execute();

            return "Se realizo el proceso con exito.";

        } catch (Exception ex) {

            return ex.getMessage();
        }
    }

    public String updateTarea(Models.clsTareas obclsTareas) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spModificarTarea(?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsTareas.getInCodigo());
            ps.setString(2, obclsTareas.getStTitular());
            ps.setString(3, obclsTareas.getStAsunto());
            ps.setString(4, obclsTareas.getStFechaVencimiento());
            ps.setString(5, obclsTareas.getStContacto());
            ps.setString(6, obclsTareas.getStCuenta());
            ps.setInt(7, obclsTareas.getObclsEstadoTarea().getInCodigo());
            ps.setInt(8, obclsTareas.getObclsPrioridad().getInCodigo());
            ps.setString(9, String.valueOf(obclsTareas.getChEnviarMensaje()));
            ps.setString(10, String.valueOf(obclsTareas.getChRepetir()));
            ps.setString(11, obclsTareas.getStDescripcion());

            ps.execute();

            return "Se realizo el proceso con exito.";

        } catch (Exception ex) {

            return ex.getMessage();
        }
    }
    
    public String deleteTarea(Models.clsTareas obclsTareas) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spEliminarTarea(?)}");

            ps.setInt(1, obclsTareas.getInCodigo());

            ps.execute();

            return "Se realizo el proceso con exito.";

        } catch (Exception ex) {

            return ex.getMessage();
        }
    }

    public List<Models.clsTareas> getTareas() {

        List<Models.clsTareas> lstclsTareas = new ArrayList<Models.clsTareas>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarTareas() }");
            rs = ps.executeQuery();

            while (rs.next()) {

                Models.clsTareas obclsTareas = new Models.clsTareas();
                obclsTareas.setInCodigo(rs.getInt("tareCodigo"));
                obclsTareas.setStTitular(rs.getString("tareTitular"));
                obclsTareas.setStAsunto(rs.getString("tareAsunto"));
                obclsTareas.setStFechaVencimiento(rs.getString("tareFechaVencimiento"));
                obclsTareas.setStContacto(rs.getString("tareContacto"));
                obclsTareas.setStCuenta(rs.getString("tareCuenta"));

                Models.clsEstadoTarea obclsEstadoTarea = new Models.clsEstadoTarea();
                obclsEstadoTarea.setInCodigo(rs.getInt("etarCodigo"));
                obclsEstadoTarea.setStDescripcion(rs.getString("estarDescripcion"));
                obclsTareas.setObclsEstadoTarea(obclsEstadoTarea);

                Models.clsPrioridad obclsPrioridad = new Models.clsPrioridad();
                obclsPrioridad.setInCodigo(rs.getInt("prioCodigo"));
                obclsPrioridad.setStDescripcion(rs.getString("prioDescripcion"));
                obclsTareas.setObclsPrioridad(obclsPrioridad);

                obclsTareas.setChEnviarMensaje(rs.getString("tareEnvioCorreo").charAt(0));
                obclsTareas.setChRepetir(rs.getString("tareRepetir").charAt(0));
                obclsTareas.setStDescripcion(rs.getString("tareDescripcion"));

                lstclsTareas.add(obclsTareas);
            }

        } catch (Exception ex) {

        }

        return lstclsTareas;
    }
}

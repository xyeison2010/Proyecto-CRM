/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class clsCampanas {

    Connection conn = null;

    public clsCampanas() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String deleteCampana(Models.clsCampanas obclsCampanas) {
        try {

            PreparedStatement ps = conn.prepareStatement("{ call spEliminarCampana(?) }");

            ps.setInt(1, obclsCampanas.getInCodigo());
            ps.execute();

            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String createCampanas(Models.clsCampanas obclsCampanas) {
        try {
            PreparedStatement ps = conn.prepareStatement("{call spInsertarCampana(?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, obclsCampanas.getObclsTipoCampana().getInCodigo());
            ps.setString(2, obclsCampanas.getStNombre());
            ps.setInt(3, obclsCampanas.getObclsEstadoCampana().getInCodigo());
            ps.setString(4, obclsCampanas.getStFechaInicio());
            ps.setString(5, obclsCampanas.getStFechaFinalizacion());
            ps.setDouble(6, obclsCampanas.getDbIngresosEsperados());
            ps.setDouble(7, obclsCampanas.getDbCostePresupuestado());
            ps.setDouble(8, obclsCampanas.getDbCosteReal());
            ps.setString(9, obclsCampanas.getStRespuestaEsperada());
            ps.setInt(10, obclsCampanas.getInNumerosEnviados());
            ps.setString(11, obclsCampanas.getStDescripcion());

            ps.execute();

            return "Se realizo el proceso con exito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Models.clsCampanas> getCampanas() {
        List<Models.clsCampanas> lstclsCampanas = new ArrayList<Models.clsCampanas>();
        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarCampanas() }");
            rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsCampanas obclsCampanas = new Models.clsCampanas();
                obclsCampanas.setInCodigo(rs.getInt("campCodigo"));

                Models.clsTipoCampana obclsTipoCampana = new Models.clsTipoCampana();
                obclsTipoCampana.setInCodigo(rs.getInt("ticaCodigo"));
                obclsTipoCampana.setStDescripcion(rs.getString("ticaDescripcion"));
                obclsCampanas.setObclsTipoCampana(obclsTipoCampana);

                obclsCampanas.setStNombre(rs.getString("campNombre"));

                Models.clsEstadoCampana obclsEstadoCampana = new Models.clsEstadoCampana();
                obclsEstadoCampana.setInCodigo(rs.getInt("escaCodigo"));
                obclsEstadoCampana.setStDescripcion(rs.getString("escaDescripcion"));
                obclsCampanas.setObclsEstadoCampana(obclsEstadoCampana);

                obclsCampanas.setStFechaInicio(rs.getString("campFechaInicio"));
                obclsCampanas.setStFechaFinalizacion(rs.getString("campFechaFin"));
                obclsCampanas.setDbIngresosEsperados(rs.getDouble("campIngresosEsperados"));
                obclsCampanas.setDbCostePresupuestado(rs.getDouble("campCostePresupuestado"));
                obclsCampanas.setDbCosteReal(rs.getDouble("campCosteReal"));
                obclsCampanas.setStRespuestaEsperada(rs.getString("campRespuestaEsperada"));
                obclsCampanas.setInNumerosEnviados(rs.getInt("campNumerosEnviados"));
                obclsCampanas.setStDescripcion(rs.getString("campDescripcion"));

                lstclsCampanas.add(obclsCampanas);

            }

        } catch (Exception ex) {
        }

        return lstclsCampanas;
    }

    public String updateCampanas(Models.clsCampanas obclsCampanas) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spModificarCampana(?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, obclsCampanas.getInCodigo());
            ps.setInt(2, obclsCampanas.getObclsTipoCampana().getInCodigo());
            ps.setString(3, obclsCampanas.getStNombre());
            ps.setInt(4, obclsCampanas.getObclsEstadoCampana().getInCodigo());
            ps.setString(5, obclsCampanas.getStFechaInicio());
            ps.setString(6, obclsCampanas.getStFechaFinalizacion());
            ps.setDouble(7, obclsCampanas.getDbIngresosEsperados());
            ps.setDouble(8, obclsCampanas.getDbCostePresupuestado());
            ps.setDouble(9, obclsCampanas.getDbCosteReal());
            ps.setString(10, obclsCampanas.getStRespuestaEsperada());
            ps.setInt(11, obclsCampanas.getInNumerosEnviados());
            ps.setString(12, obclsCampanas.getStDescripcion());

            ps.execute();

            return "Se realizo el proceso con exito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}

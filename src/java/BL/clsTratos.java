/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.*;


public class clsTratos {
    Connection conn = null;

    public clsTratos() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();

    }

    public String createTrato(Models.clsTratos obclsTratos) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarTrato(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsTratos.getStImporte() );
            ps.setString(2, obclsTratos.getStNombre());
            ps.setString(3, obclsTratos.getStFechaCierre());
            ps.setString(4, obclsTratos.getStNumeroCuenta());
            ps.setInt(5, obclsTratos.getObclsFaseTrato().getInCodigo());
            ps.setInt(6, obclsTratos.getObclsTipoTrato().getInCodigo());
            ps.setDouble(7, obclsTratos.getDbProbabilidad());
            ps.setString(8, obclsTratos.getStSiguientePaso());
            ps.setDouble(9, obclsTratos.getDbIngresosEsperados());
            ps.setInt(10, obclsTratos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(11, obclsTratos.getStFuenteCampaña());
            ps.setString(12, obclsTratos.getStNombreContacto());
            ps.setString(13, obclsTratos.getStDescripcion());

            ps.execute();

            return "Se realizo el proceso con exito.";

        } catch (Exception ex) {

            return ex.getMessage();
        }
    }

    public String updateTrato(Models.clsTratos obclsTratos) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spModificarTrato(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsTratos.getInCodigo());
            ps.setString(2, obclsTratos.getStImporte() );
            ps.setString(3, obclsTratos.getStNombre());
            ps.setString(4, obclsTratos.getStFechaCierre());
            ps.setString(5, obclsTratos.getStNumeroCuenta());
            ps.setInt(6, obclsTratos.getObclsFaseTrato().getInCodigo());
            ps.setInt(7, obclsTratos.getObclsTipoTrato().getInCodigo());
            ps.setDouble(8, obclsTratos.getDbProbabilidad());
            ps.setString(9, obclsTratos.getStSiguientePaso());
            ps.setDouble(10, obclsTratos.getDbIngresosEsperados());
            ps.setInt(11, obclsTratos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(12, obclsTratos.getStFuenteCampaña());
            ps.setString(13, obclsTratos.getStNombreContacto());
            ps.setString(14, obclsTratos.getStDescripcion());

            ps.execute();

            return "Se realizo el proceso con exito.";

        } catch (Exception ex) {

            return ex.getMessage();
        }
    }
    
    public String deleteTrato(Models.clsTratos obclsTratos) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spEliminarTrato(?)}");

            ps.setInt(1, obclsTratos.getInCodigo());

            ps.execute();

            return "Se realizo el proceso con exito.";

        } catch (Exception ex) {

            return ex.getMessage();
        }
    }

    public List<Models.clsTratos> getTratos() {

        List<Models.clsTratos> lstclsTratos = new ArrayList<Models.clsTratos>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{ call spConsultarTratos() }");
            rs = ps.executeQuery();

            while (rs.next()) {

                Models.clsTratos obclsTratos = new Models.clsTratos();
                obclsTratos.setInCodigo(rs.getInt("tratCodigo"));
                obclsTratos.setStImporte(rs.getString("tratImporte"));
                obclsTratos.setStNombre(rs.getString("tratNombre"));
                obclsTratos.setStFechaCierre(rs.getString("tratFechaCierre"));
                obclsTratos.setStNumeroCuenta(rs.getString("tratNumeroCuenta"));

                Models.clsFaseTrato obclsFaseTrato = new Models.clsFaseTrato();
                obclsFaseTrato.setInCodigo(rs.getInt("faseCodigo"));
                obclsFaseTrato.setStDescripcion(rs.getString("faseDescripcion"));
                obclsTratos.setObclsFaseTrato(obclsFaseTrato);

                Models.clsTipoTrato obclsTipoTrato = new Models.clsTipoTrato();
                obclsTipoTrato.setInCodigo(rs.getInt("titrCodigo"));
                obclsTipoTrato.setStDescripcion(rs.getString("titrDescripcion"));
                obclsTratos.setObclsTipoTrato(obclsTipoTrato);

                obclsTratos.setDbProbabilidad(rs.getDouble("tratProbabilidad"));
                obclsTratos.setStSiguientePaso(rs.getString("tratSiguientePaso"));
                obclsTratos.setDbIngresosEsperados(rs.getDouble("tratIngresosEsperados"));
                
                Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
                obclsFuentePosibleCliente.setInCodigo(rs.getInt("fuenCodigo"));
                obclsFuentePosibleCliente.setStDescripcion(rs.getString("fuenDescripcion"));
                obclsTratos.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
                
                obclsTratos.setStFuenteCampaña(rs.getString("tratFuente"));
                obclsTratos.setStNombreContacto(rs.getString("tratNombreContacto"));
                obclsTratos.setStDescripcion(rs.getString("tratDescripcion"));

                lstclsTratos.add(obclsTratos);
            }

        } catch (Exception ex) {

        }

        return lstclsTratos;
    }
}

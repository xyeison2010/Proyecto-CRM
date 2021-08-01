/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class clsEventos {

    Connection conn = null;

    public clsEventos() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String createEvento(Models.clsEventos obclsEventos) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarEvento(?,?,?,?,?,?,?) }");

            ps.setString(1, obclsEventos.getStNombre());
            ps.setString(2, obclsEventos.getStUbicacion());
            ps.setString(3, obclsEventos.getStParticipantes());
            ps.setString(4, String.valueOf(obclsEventos.getChTodoDia()));
            ps.setString(5, obclsEventos.getStFecha());
            ps.setInt(6, obclsEventos.getObclsRelacionadoCon().getInCodigo());
            ps.setString(7, obclsEventos.getStDescripcion());
            
            ps.execute();

            return "Se realizo el proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateEvento(Models.clsEventos obclsEventos) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spModificarEvento(?,?,?,?,?,?,?,?) }");

            ps.setInt(1, obclsEventos.getInCodigo());
            ps.setString(2, obclsEventos.getStNombre());
            ps.setString(3, obclsEventos.getStUbicacion());
            ps.setString(4, obclsEventos.getStParticipantes());
            ps.setString(5, String.valueOf(obclsEventos.getChTodoDia()));
            ps.setString(6, obclsEventos.getStFecha());
            ps.setInt(7, obclsEventos.getObclsRelacionadoCon().getInCodigo());
            ps.setString(8, obclsEventos.getStDescripcion());
            
            ps.execute();

            return "Se realizo el proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String deleteEvento(Models.clsEventos obclsEventos) {
        try {

            PreparedStatement ps = conn.prepareStatement("{ call spEliminarEvento(?) }");

            ps.setInt(1, obclsEventos.getInCodigo());
            ps.execute();

            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List<Models.clsEventos> getEventos() {

        List<Models.clsEventos> lstclsEventos = new ArrayList<Models.clsEventos>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarEventos}");

            rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsEventos obclsEventos = new Models.clsEventos();
                obclsEventos.setInCodigo(rs.getInt("evenCodigo"));

                Models.clsRelacionadoCon obclsRelacionadoCon = new Models.clsRelacionadoCon();
                obclsRelacionadoCon.setInCodigo(rs.getInt("recoCodigo"));
                obclsRelacionadoCon.setStDescripcion(rs.getString("recoDescripcion"));
                obclsEventos.setObclsRelacionadoCon(obclsRelacionadoCon);

                obclsEventos.setStNombre(rs.getString("evenNombre"));
                obclsEventos.setStUbicacion(rs.getString("evenUbicacion"));
                obclsEventos.setStParticipantes(rs.getString("evenParticipantes"));
                obclsEventos.setChTodoDia(rs.getString("evenTodoDia").charAt(0));
                obclsEventos.setStFecha(rs.getString("evenFecha"));
                obclsEventos.setStDescripcion(rs.getString("evenDescripcion"));
             
                lstclsEventos.add(obclsEventos);
            }

        } catch (Exception ex) {

        }
        return lstclsEventos;
    }
}

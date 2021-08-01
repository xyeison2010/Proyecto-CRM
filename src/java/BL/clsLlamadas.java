/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class clsLlamadas {

    Connection conn = null;

    public clsLlamadas() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String createLlamada(Models.clsLlamadas obclsLlamadas) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarLlamada(?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsLlamadas.getStContacto());
            ps.setString(2, obclsLlamadas.getStAsunto());
            ps.setInt(3, obclsLlamadas.getObclsPropositoDeLaLlamada().getInCodigo());
            ps.setInt(4, obclsLlamadas.getObclsRelacionadoCon().getInCodigo());
            ps.setInt(5, obclsLlamadas.getObclsTipoLlamada().getInCodigo());
            ps.setString(6, obclsLlamadas.getStDetalles());
            ps.setString(7, obclsLlamadas.getStFecha());
            ps.setInt(8, obclsLlamadas.getInDuracion());
            ps.setString(9, obclsLlamadas.getStDescripcion());
            ps.setString(10, obclsLlamadas.getStResultado());

            ps.execute();

            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String updateLlamada(Models.clsLlamadas obclsLlamadas) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spModificarLlamada(?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsLlamadas.getInCodigo());
            ps.setString(2, obclsLlamadas.getStContacto());
            ps.setString(3, obclsLlamadas.getStAsunto());
            ps.setInt(4, obclsLlamadas.getObclsPropositoDeLaLlamada().getInCodigo());
            ps.setInt(5, obclsLlamadas.getObclsRelacionadoCon().getInCodigo());
            ps.setInt(6, obclsLlamadas.getObclsTipoLlamada().getInCodigo());
            ps.setString(7, obclsLlamadas.getStDetalles());
            ps.setString(8, obclsLlamadas.getStFecha());
            ps.setInt(9, obclsLlamadas.getInDuracion());
            ps.setString(10, obclsLlamadas.getStDescripcion());
            ps.setString(11, obclsLlamadas.getStResultado());

            ps.execute();

            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String deleteLlamada(Models.clsLlamadas obclsLlamadas) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spEliminarLlamada(?)}");

            ps.setInt(1, obclsLlamadas.getInCodigo());
            
            ps.execute();

            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Models.clsLlamadas> getLlamadas() {

        List<Models.clsLlamadas> lstclsLlamadas = new ArrayList<Models.clsLlamadas>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarLlamadas() }");

            rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsLlamadas obclsLlamadas = new Models.clsLlamadas();
                obclsLlamadas.setInCodigo(rs.getInt("llamCodigo"));
                obclsLlamadas.setStContacto(rs.getString("llamContacto"));
                obclsLlamadas.setStAsunto(rs.getString("llamAsunto"));
                
                Models.clsPropositoDeLaLlamada obclsPropositoDeLaLlamada = new Models.clsPropositoDeLaLlamada();
                obclsPropositoDeLaLlamada.setInCodigo(rs.getInt("propCodigo"));
                obclsPropositoDeLaLlamada.setStDescripcion(rs.getString("propDescripcion"));
                obclsLlamadas.setObclsPropositoDeLaLlamada(obclsPropositoDeLaLlamada);

                Models.clsRelacionadoCon obclsRelacionadoCon = new Models.clsRelacionadoCon();
                obclsRelacionadoCon.setInCodigo(rs.getInt("recoCodigo"));
                obclsRelacionadoCon.setStDescripcion(rs.getString("recoDescripcion"));
                obclsLlamadas.setObclsRelacionadoCon(obclsRelacionadoCon);

                Models.clsTipoLlamada obclsTipoLlamada = new Models.clsTipoLlamada();
                obclsTipoLlamada.setInCodigo(rs.getInt("tillCodigo"));
                obclsTipoLlamada.setStDescripcion(rs.getString("tillDescripcion"));
                obclsLlamadas.setObclsTipoLlamada(obclsTipoLlamada);
                
                obclsLlamadas.setStDetalles(rs.getString("llamDetalles"));
                obclsLlamadas.setStFecha(rs.getString("llamFecha"));
                obclsLlamadas.setInDuracion(rs.getInt("llamDuracion"));
                obclsLlamadas.setStDescripcion(rs.getString("llamDescripcion"));
                obclsLlamadas.setStResultado(rs.getString("llamResultado"));

                lstclsLlamadas.add(obclsLlamadas);
            }

        } catch (Exception ex) {

        }
        return lstclsLlamadas;
    }
}

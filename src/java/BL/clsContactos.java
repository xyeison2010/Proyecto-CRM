/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class clsContactos {

    Connection conn = null;

    public clsContactos() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public String deleteContacto(Models.clsContactos obclsContactos) {
        try {

            PreparedStatement ps = conn.prepareStatement("{ call spEliminarContacto(?) }");

            ps.setInt(1, obclsContactos.getInCodigo());
            ps.execute();

            return "Se realizo proceso con exito";

        } catch (Exception ex) {
            return ex.getMessage();

        }

    }

    public String createContacto(Models.clsContactos obclsContactos) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarContacto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsContactos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(2, obclsContactos.getStNombres());
            ps.setString(3, obclsContactos.getStApellidos());
            ps.setString(4, obclsContactos.getStNumeroCuenta());
            ps.setString(5, obclsContactos.getStTitulo());
            ps.setString(6, obclsContactos.getStCorreo());
            ps.setString(7, obclsContactos.getStDepartamento());
            ps.setString(8, obclsContactos.getStTelefono());
            ps.setString(9, obclsContactos.getStTelefonoParticular());
            ps.setString(10, obclsContactos.getStOtroTelefono());
            ps.setString(11, obclsContactos.getStFax());
            ps.setString(12, obclsContactos.getStMovil());
            ps.setString(13, obclsContactos.getStFechaNacimiento());
            ps.setString(14, obclsContactos.getStAsistente());
            ps.setString(15, obclsContactos.getStTelefonoAsistente());
            ps.setString(16, obclsContactos.getStRespondeA());
            ps.setString(17, String.valueOf(obclsContactos.getChNoParticipacionCorreo()));
            ps.setString(18, obclsContactos.getStIdSkype());
            ps.setString(19, obclsContactos.getStCorreoSecundario());

            ps.execute();

            return "Se Realizo El proceso Con Exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateContacto(Models.clsContactos obclsContactos) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spModificarContacto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            ps.setInt(1, obclsContactos.getInCodigo());
            ps.setInt(2, obclsContactos.getObclsFuentePosibleCliente().getInCodigo());
            ps.setString(3, obclsContactos.getStNombres());
            ps.setString(4, obclsContactos.getStApellidos());
            ps.setString(5, obclsContactos.getStNumeroCuenta());
            ps.setString(6, obclsContactos.getStTitulo());
            ps.setString(7, obclsContactos.getStCorreo());
            ps.setString(8, obclsContactos.getStDepartamento());
            ps.setString(9, obclsContactos.getStTelefono());
            ps.setString(10, obclsContactos.getStTelefonoParticular());
            ps.setString(11, obclsContactos.getStOtroTelefono());
            ps.setString(12, obclsContactos.getStFax());
            ps.setString(13, obclsContactos.getStMovil());
            ps.setString(14, obclsContactos.getStFechaNacimiento());
            ps.setString(15, obclsContactos.getStAsistente());
            ps.setString(16, obclsContactos.getStTelefonoAsistente());
            ps.setString(17, obclsContactos.getStRespondeA());
            ps.setString(18, String.valueOf(obclsContactos.getChNoParticipacionCorreo()));
            ps.setString(19, obclsContactos.getStIdSkype());
            ps.setString(20, obclsContactos.getStCorreoSecundario());

            ps.execute();

            return "Se Realizo El Proceso Con Exito";

        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public List<Models.clsContactos> getContactos() {

        List<Models.clsContactos> lstclsContactos = new ArrayList<Models.clsContactos>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarContactos}");

            rs = ps.executeQuery();

            while (rs.next()) {
                Models.clsContactos obclsContactos = new Models.clsContactos();
                obclsContactos.setInCodigo(rs.getInt("contCodigo"));

                Models.clsFuentePosibleCliente obclsFuenteDePosibleCliente = new Models.clsFuentePosibleCliente();
                obclsFuenteDePosibleCliente.setInCodigo(rs.getInt("fuenCodigo"));
                obclsFuenteDePosibleCliente.setStDescripcion(rs.getString("fuenDescripcion"));
                obclsContactos.setObclsFuentePosibleCliente(obclsFuenteDePosibleCliente);

                obclsContactos.setStNombres(rs.getString("contNombres"));
                obclsContactos.setStApellidos(rs.getString("contApellidos"));
                obclsContactos.setStNumeroCuenta(rs.getString("contNumeroCuenta"));
                obclsContactos.setStTitulo(rs.getString("contTitulo"));
                obclsContactos.setStCorreo(rs.getString("contCorreo"));
                obclsContactos.setStDepartamento(rs.getString("contDepartamento"));
                obclsContactos.setStTelefono(rs.getString("contTelefono"));
                obclsContactos.setStTelefonoParticular(rs.getString("contTelefonoParticular"));
                obclsContactos.setStOtroTelefono(rs.getString("contOtroTelefono"));
                obclsContactos.setStFax(rs.getString("contFax"));
                obclsContactos.setStMovil(rs.getString("contMovil"));
                obclsContactos.setStFechaNacimiento(rs.getString("contFechaNacimiento"));
                obclsContactos.setStAsistente(rs.getString("contAsistente"));
                obclsContactos.setStTelefonoAsistente(rs.getString("contTelefonoAsistente"));
                obclsContactos.setStRespondeA(rs.getString("contRespondeA"));
                obclsContactos.setChNoParticipacionCorreo(rs.getString("contNoParticipacionCorreo").charAt(0));
                obclsContactos.setStIdSkype(rs.getString("contIdSkype"));
                obclsContactos.setStCorreoSecundario(rs.getString("contCorreoSecundario"));
                lstclsContactos.add(obclsContactos);
            }

        } catch (Exception ex) {

        }
        return lstclsContactos;
    }
}

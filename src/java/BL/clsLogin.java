package BL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class clsLogin {

    clsConexion obclsConexion = new clsConexion();
    Connection conn = null;

    public clsLogin() {

        conn = obclsConexion.getConexion();
    }

    public String stInsertarUsuario(Models.clsLogin obclsLogin) {
        try {
            PreparedStatement ps = conn.prepareStatement("{call spInsertarUsuario(?,?)}");

            ps.setString(1, obclsLogin.getStEmail());
            ps.setString(2, obclsLogin.getStPassword());

            ps.execute();
            return "OK";
        } catch (Exception ex) {
            return ex.getMessage();
        } finally {
            obclsConexion.cerrarConexion(conn);
        }
    }

    public boolean validarLogin(Models.clsLogin obclsLogin) {
        try {

            PreparedStatement ps = conn.prepareCall("{ call spConsultarUsuario(?,?)}");

            ps.setString(1, obclsLogin.getStEmail());
            ps.setString(2, obclsLogin.getStPassword());

            ResultSet rs = ps.executeQuery();

            boolean blExiste = false;

            while (rs.next()) {
                blExiste = true;
            }

            return blExiste;

        } catch (Exception ex) {
            return false;
        }
    }
}

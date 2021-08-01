/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ContactosController", urlPatterns = {"/ContactosController"})
public class ContactosController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);

        } else if (request.getParameter("btnModificar") != null) {
            btnModificar(request, response);

        } else if (request.getParameter("stOpcion") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarModificar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                btnEliminar(request, response);
            }
        } else if (request.getParameter("btnConsultar") != null) {
            BL.clsContactos bl_obclsContactos = new BL.clsContactos();

            request.setAttribute("lstclsContactos", bl_obclsContactos.getContactos());
            
            BL.clsFuentePosibleCliente bl_clsFuenteDePosibleCliente = new BL.clsFuentePosibleCliente();
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuenteDePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Contactos.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsContactos bl_clsContactos = new BL.clsContactos();

            Models.clsContactos obclsContactos = new Models.clsContactos();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();

            if ((request.getParameter("codigoModificar") != null)) {
                obclsContactos.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }

            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                obclsContactos.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }
            
            if (request.getParameter("txtNombre") != null) {
                obclsContactos.setStNombres(request.getParameter("txtNombre"));
            }

            if (request.getParameter("txtApellidos") != null) {
                obclsContactos.setStApellidos(request.getParameter("txtApellidos"));
            }

            if (request.getParameter("txtNumeroCuenta") != null) {
                obclsContactos.setStNumeroCuenta(request.getParameter("txtNumeroCuenta"));
            }

            if (request.getParameter("txtTitulo") != null) {
                obclsContactos.setStTitulo(request.getParameter("txtTitulo"));

            }

            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsContactos.setStCorreo(request.getParameter("txtCorreoElectronico"));
            }

            if (request.getParameter("txtDepartamento") != null) {
                obclsContactos.setStDepartamento(request.getParameter("txtDepartamento"));
            }

            if (request.getParameter("txtTelefono") != null) {
                obclsContactos.setStTelefono(request.getParameter("txtTelefono"));
            }

            if (request.getParameter("txtTelefonoParticular") != null) {
                obclsContactos.setStTelefonoParticular(request.getParameter("txtTelefonoParticular"));
            }

            if (request.getParameter("txtOtroTelefono") != null) {
                obclsContactos.setStOtroTelefono(request.getParameter("txtOtroTelefono"));
            }

            if (request.getParameter("txtFax") != null) {
                obclsContactos.setStFax(request.getParameter("txtFax"));
            }

            if (request.getParameter("txtMovil") != null) {
                obclsContactos.setStMovil(request.getParameter("txtMovil"));
            }

            if (request.getParameter("txtFechaNacimiento") != null) {
                obclsContactos.setStFechaNacimiento(request.getParameter("txtFechaNacimiento"));
            }

            if (request.getParameter("txtAsistente") != null) {
                obclsContactos.setStAsistente(request.getParameter("txtAsistente"));
            }

            if (request.getParameter("txtTelefonoAsistente") != null) {
                obclsContactos.setStTelefonoAsistente(request.getParameter("txtTelefonoAsistente"));
            }

            if (request.getParameter("txtRespondeA") != null) {
                obclsContactos.setStRespondeA(request.getParameter("txtRespondeA"));
            }

            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';
                obclsContactos.setChNoParticipacionCorreo(chSeleccion);
            } else {
                obclsContactos.setChNoParticipacionCorreo('N');
            }

            if (request.getParameter("txtIDSkype") != null) {
                obclsContactos.setStIdSkype(request.getParameter("txtIDSkype"));
            }

            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                obclsContactos.setStCorreoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }

            request.setAttribute("stMensaje", bl_clsContactos.updateContacto(obclsContactos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsContactos", bl_clsContactos.getContactos());

            BL.clsFuentePosibleCliente bl_clsFuenteDePosibleCliente = new BL.clsFuentePosibleCliente();

            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuenteDePosibleCliente.getFuentePosibleCliente());
            request.getRequestDispatcher("Contactos.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Contactos.jsp").forward(request, response);
        }
    }

    public void btnEliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsContactos bl_clsContactos = new BL.clsContactos();

            Models.clsContactos obclsContactos = new Models.clsContactos();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsContactos.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }

            request.setAttribute("stMensaje", bl_clsContactos.deleteContacto(obclsContactos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsContactos", bl_clsContactos.getContactos());

            BL.clsFuentePosibleCliente bl_clsFuenteDePosibleCliente = new BL.clsFuentePosibleCliente();
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuenteDePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Contactos.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Contactos.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsContactos bl_clsContactos = new BL.clsContactos();

            List<Models.clsContactos> lstclsContactos = new ArrayList<Models.clsContactos>();
            Models.clsContactos obclsContactos = new Models.clsContactos();

            lstclsContactos = bl_clsContactos.getContactos();

            for (Models.clsContactos item : lstclsContactos) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsContactos = item;
                    break;
                }
            }

            BL.clsFuentePosibleCliente bl_clsFuenteDePosibleCliente = new BL.clsFuentePosibleCliente();
            
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuenteDePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("obclsContactos", obclsContactos);
            request.setAttribute("lstclsContactos", lstclsContactos); 

            request.getRequestDispatcher("Contactos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Contactos.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {

            BL.clsContactos bl_obclsContactos = new BL.clsContactos();

            Models.clsContactos obclsContactos = new Models.clsContactos();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();

            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                obclsContactos.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }

            if (request.getParameter("txtNombre") != null) {
                obclsContactos.setStNombres(request.getParameter("txtNombre"));
            }

            if (request.getParameter("txtApellidos") != null) {
                obclsContactos.setStApellidos(request.getParameter("txtApellidos"));
            }

            if (request.getParameter("txtNumeroCuenta") != null) {
                obclsContactos.setStNumeroCuenta(request.getParameter("txtNumeroCuenta"));
            }

            if (request.getParameter("txtTitulo") != null) {
                obclsContactos.setStTitulo(request.getParameter("txtTitulo"));
            }

            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsContactos.setStCorreo(request.getParameter("txtCorreoElectronico"));
            }

            if (request.getParameter("txtDepartamento") != null) {
                obclsContactos.setStDepartamento(request.getParameter("txtDepartamento"));
            }

            if (request.getParameter("txtTelefono") != null) {
                obclsContactos.setStTelefono(request.getParameter("txtTelefono"));
            }

            if (request.getParameter("txtTelefonoParticular") != null) {
                obclsContactos.setStTelefonoParticular(request.getParameter("txtTelefonoParticular"));
            }

            if (request.getParameter("txtOtroTelefono") != null) {
                obclsContactos.setStOtroTelefono(request.getParameter("txtOtroTelefono"));
            }

            if (request.getParameter("txtFax") != null) {
                obclsContactos.setStFax(request.getParameter("txtFax"));
            }

            if (request.getParameter("txtMovil") != null) {
                obclsContactos.setStMovil(request.getParameter("txtMovil"));
            }

            if (request.getParameter("txtFechaNacimiento") != null) {
                obclsContactos.setStFechaNacimiento(request.getParameter("txtFechaNacimiento"));
            }

            if (request.getParameter("txtAsistente") != null) {
                obclsContactos.setStAsistente(request.getParameter("txtAsistente"));
            }

            if (request.getParameter("txtTelefonoAsistente") != null) {
                obclsContactos.setStTelefonoAsistente(request.getParameter("txtTelefonoAsistente"));
            }

            if (request.getParameter("txtRespondeA") != null) {
                obclsContactos.setStRespondeA(request.getParameter("txtRespondeA"));
            }

            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';
                obclsContactos.setChNoParticipacionCorreo(chSeleccion);
            } else {
                obclsContactos.setChNoParticipacionCorreo('N');
            }

            if (request.getParameter("txtIDSkype") != null) {
                obclsContactos.setStIdSkype(request.getParameter("txtIDSkype"));
            }

            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                obclsContactos.setStCorreoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }

            request.setAttribute("stMensaje", bl_obclsContactos.createContacto(obclsContactos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsContactos", bl_obclsContactos.getContactos());

            BL.clsFuentePosibleCliente bl_clsFuenteDePosibleCliente = new BL.clsFuentePosibleCliente();
            request.setAttribute("lstclsFuenteDePosibleCliente", bl_clsFuenteDePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Contactos.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Contactos.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

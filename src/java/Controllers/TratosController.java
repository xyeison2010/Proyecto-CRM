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


@WebServlet(name = "TratosController", urlPatterns = {"/TratosController"})
public class TratosController extends HttpServlet {

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
        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarModificar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                btnEliminar(request, response);
            }
        } else if (request.getParameter("btnConsultar") != null) {

            BL.clsTratos bl_clsTratos = new BL.clsTratos();
            request.setAttribute("lstclsTratos", bl_clsTratos.getTratos());

            BL.clsFaseTrato bl_clsFaseTrato = new BL.clsFaseTrato();
            BL.clsTipotrato bl_clsTipotrato = new BL.clsTipotrato();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();

            request.setAttribute("lstclsFaseTrato", bl_clsFaseTrato.getFaseTrato());
            request.setAttribute("lstclsTipoTrato", bl_clsTipotrato.getTipoTrato());
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuentePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {

            BL.clsTratos bl_clsTratos = new BL.clsTratos();

            Models.clsTratos obclsTratos = new Models.clsTratos();
            Models.clsFaseTrato obclsFaseTrato = new Models.clsFaseTrato();
            Models.clsTipoTrato obclsTipoTrato = new Models.clsTipoTrato();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();

            if (request.getParameter("codigoModificar") != null) {
                obclsTratos.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }
            if (request.getParameter("txtImporte") != null) {
                obclsTratos.setStImporte(request.getParameter("txtImporte"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsTratos.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtFechaCierre") != null) {
                obclsTratos.setStFechaCierre(request.getParameter("txtFechaCierre"));
            }
            if (request.getParameter("txtNumeroCuenta") != null) {
                obclsTratos.setStNumeroCuenta(request.getParameter("txtNumeroCuenta"));
            }
            if (request.getParameter("ddlFase") != null) {
                obclsFaseTrato.setInCodigo(Integer.parseInt(request.getParameter("ddlFase")));
                obclsTratos.setObclsFaseTrato(obclsFaseTrato);
            }
            if (request.getParameter("ddlTipo") != null) {
                obclsTipoTrato.setInCodigo(Integer.parseInt(request.getParameter("ddlTipo")));
                obclsTratos.setObclsTipoTrato(obclsTipoTrato);
            }
            if (request.getParameter("txtProbabilidad") != null) {
                obclsTratos.setDbProbabilidad(Double.parseDouble(request.getParameter("txtProbabilidad")));
            }
            if (request.getParameter("txtSiguientePaso") != null) {
                obclsTratos.setStSiguientePaso(request.getParameter("txtSiguientePaso"));
            }
            if (request.getParameter("txtIngresosEsperados") != null) {
                obclsTratos.setDbIngresosEsperados(Double.parseDouble(request.getParameter("txtIngresosEsperados")));
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                obclsTratos.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }
            if (request.getParameter("txtFuenteCampana") != null) {
                obclsTratos.setStFuenteCampaña(request.getParameter("txtFuenteCampana"));
            }
            if (request.getParameter("txtNombreContacto") != null) {
                obclsTratos.setStNombreContacto(request.getParameter("txtNombreContacto"));
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsTratos.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            request.setAttribute("stMensaje", bl_clsTratos.updateTrato(obclsTratos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsTratos", bl_clsTratos.getTratos());

            BL.clsFaseTrato bl_clsFaseTrato = new BL.clsFaseTrato();
            BL.clsTipotrato bl_clsTipotrato = new BL.clsTipotrato();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();

            request.setAttribute("lstclsFaseTrato", bl_clsFaseTrato.getFaseTrato());
            request.setAttribute("lstclsTipoTrato", bl_clsTipotrato.getTipoTrato());
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuentePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);
        }
    }

    public void btnEliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.clsTratos bl_clsTratos = new BL.clsTratos();
            Models.clsTratos obclsTratos = new Models.clsTratos();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsTratos.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }

            request.setAttribute("stMensaje", bl_clsTratos.deleteTrato(obclsTratos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsTratos", bl_clsTratos.getTratos());

            BL.clsFaseTrato bl_clsFaseTrato = new BL.clsFaseTrato();
            BL.clsTipotrato bl_clsTipotrato = new BL.clsTipotrato();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();

            request.setAttribute("lstclsFaseTrato", bl_clsFaseTrato.getFaseTrato());
            request.setAttribute("lstclsTipoTrato", bl_clsTipotrato.getTipoTrato());
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuentePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            BL.clsTratos bl_clsTratos = new BL.clsTratos();

            List<Models.clsTratos> lstclsTratos = new ArrayList<Models.clsTratos>();
            Models.clsTratos obclsTratos = new Models.clsTratos();

            lstclsTratos = bl_clsTratos.getTratos();

            for (Models.clsTratos elem : lstclsTratos) {
                if (elem.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsTratos = elem;
                }
            }

            request.setAttribute("obclsTratos", obclsTratos);
            request.setAttribute("lstclsTratos", lstclsTratos);

            BL.clsFaseTrato bl_clsFaseTrato = new BL.clsFaseTrato();
            BL.clsTipotrato bl_clsTipotrato = new BL.clsTipotrato();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();

            request.setAttribute("lstclsFaseTrato", bl_clsFaseTrato.getFaseTrato());
            request.setAttribute("lstclsTipoTrato", bl_clsTipotrato.getTipoTrato());
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuentePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsTratos bl_clsTratos = new BL.clsTratos();

            Models.clsTratos obclsTratos = new Models.clsTratos();
            Models.clsFaseTrato obclsFaseTrato = new Models.clsFaseTrato();
            Models.clsTipoTrato obclsTipoTrato = new Models.clsTipoTrato();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();

            if (request.getParameter("txtImporte") != null) {
                obclsTratos.setStImporte(request.getParameter("txtImporte"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsTratos.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtFechaCierre") != null) {
                obclsTratos.setStFechaCierre(request.getParameter("txtFechaCierre"));
            }
            if (request.getParameter("txtNumeroCuenta") != null) {
                obclsTratos.setStNumeroCuenta(request.getParameter("txtNumeroCuenta"));
            }
            if (request.getParameter("ddlFase") != null) {
                obclsFaseTrato.setInCodigo(Integer.parseInt(request.getParameter("ddlFase")));
                obclsTratos.setObclsFaseTrato(obclsFaseTrato);
            }
            if (request.getParameter("ddlTipo") != null) {
                obclsTipoTrato.setInCodigo(Integer.parseInt(request.getParameter("ddlTipo")));
                obclsTratos.setObclsTipoTrato(obclsTipoTrato);
            }
            if (request.getParameter("txtProbabilidad") != null) {
                obclsTratos.setDbProbabilidad(Double.parseDouble(request.getParameter("txtProbabilidad")));
            }
            if (request.getParameter("txtSiguientePaso") != null) {
                obclsTratos.setStSiguientePaso(request.getParameter("txtSiguientePaso"));
            }
            if (request.getParameter("txtIngresosEsperados") != null) {
                obclsTratos.setDbIngresosEsperados(Double.parseDouble(request.getParameter("txtIngresosEsperados")));
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                obclsTratos.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }
            if (request.getParameter("txtFuenteCampana") != null) {
                obclsTratos.setStFuenteCampaña(request.getParameter("txtFuenteCampana"));
            }
            if (request.getParameter("txtNombreContacto") != null) {
                obclsTratos.setStNombreContacto(request.getParameter("txtNombreContacto"));
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsTratos.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            request.setAttribute("stMensaje", bl_clsTratos.createTrato(obclsTratos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsTratos", bl_clsTratos.getTratos());

            BL.clsFaseTrato bl_clsFaseTrato = new BL.clsFaseTrato();
            BL.clsTipotrato bl_clsTipotrato = new BL.clsTipotrato();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();

            request.setAttribute("lstclsFaseTrato", bl_clsFaseTrato.getFaseTrato());
            request.setAttribute("lstclsTipoTrato", bl_clsTipotrato.getTipoTrato());
            request.setAttribute("lstclsFuentePosibleCliente", bl_clsFuentePosibleCliente.getFuentePosibleCliente());

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tratos.jsp").forward(request, response);
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

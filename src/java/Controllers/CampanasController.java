/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.clsCampanas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//la "ñ" es un caracter especial , creo q no debo usarlo en jsp

@WebServlet(name = "CampanasController", urlPatterns = {"/CampanasController"})
public class CampanasController extends HttpServlet {

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

            BL.clsCampanas bl_obclsCampanas = new BL.clsCampanas();
            request.setAttribute("lstclsCampanas", bl_obclsCampanas.getCampanas());

            BL.clsTipoCampana bl_obclsTipoCampana = new BL.clsTipoCampana();
            BL.clsEstadoCampana bl_obclsEstadoCampana = new BL.clsEstadoCampana();

            request.setAttribute("lstclsTipoCampana", bl_obclsTipoCampana.getTipoCampana());
            request.setAttribute("lstclsEstadoCampana", bl_obclsEstadoCampana.getEstadoCampana());

            request.getRequestDispatcher("Campanas.jsp").forward(request, response);
        }

    }

    public void btnEliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            BL.clsCampanas bl_clsCampanas = new BL.clsCampanas();
            Models.clsCampanas obclsCampanas = new Models.clsCampanas();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsCampanas.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }
            request.setAttribute("stMensaje", bl_clsCampanas.deleteCampana(obclsCampanas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsCampanas", bl_clsCampanas.getCampanas());

            BL.clsTipoCampana bl_obclsTipoCampana = new BL.clsTipoCampana();
            BL.clsEstadoCampana bl_obclsEstadoCampana = new BL.clsEstadoCampana();

            request.setAttribute("lstclsTipoCampana", bl_obclsTipoCampana.getTipoCampana());
            request.setAttribute("lstclsEstadoCampana", bl_obclsEstadoCampana.getEstadoCampana());

            request.getRequestDispatcher("Campanas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Campanas.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.clsCampanas bl_clsCampanas = new BL.clsCampanas();

            List<Models.clsCampanas> lstclsCampanas = new ArrayList<clsCampanas>();
            Models.clsCampanas obclsCampanas = new Models.clsCampanas();

            lstclsCampanas = bl_clsCampanas.getCampanas();

            for (Models.clsCampanas item : lstclsCampanas) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsCampanas = item;
                    break;
                }
            }

            BL.clsTipoCampana bl_obclsTipoCampana = new BL.clsTipoCampana();
            BL.clsEstadoCampana bl_obclsEstadoCampana = new BL.clsEstadoCampana();

            request.setAttribute("lstclsTipoCampana", bl_obclsTipoCampana.getTipoCampana());
            request.setAttribute("lstclsEstadoCampana", bl_obclsEstadoCampana.getEstadoCampana());

            request.setAttribute("obclsCampanas", obclsCampanas);
            request.getRequestDispatcher("Campanas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Campanas.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsCampanas bl_obclsCampanas = new BL.clsCampanas();

            Models.clsCampanas obclsCampanas = new Models.clsCampanas();
            Models.clsTipoCampana obclsTipoCampana = new Models.clsTipoCampana();
            Models.clsEstadoCampana obclsEstadoCampana = new Models.clsEstadoCampana();

            if (request.getParameter("ddlTipo") != null) {
                obclsTipoCampana.setInCodigo(Integer.parseInt(request.getParameter("ddlTipo")));
                obclsCampanas.setObclsTipoCampana(obclsTipoCampana);
            }
            if (request.getParameter("txtNombre") != null) {
                obclsCampanas.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("ddlEstado") != null) {
                obclsEstadoCampana.setInCodigo(Integer.parseInt(request.getParameter("ddlEstado")));
                obclsCampanas.setObclsEstadoCampana(obclsEstadoCampana);
            }
            if (request.getParameter("txtFechaInicio") != null) {
                obclsCampanas.setStFechaInicio(request.getParameter("txtFechaInicio"));
            }
            if (request.getParameter("txtFechaFinalizacion") != null) {
                obclsCampanas.setStFechaFinalizacion(request.getParameter("txtFechaFinalizacion"));
            }
            if (request.getParameter("txtIngresosEsperados") != null) {
                obclsCampanas.setDbIngresosEsperados(Double.parseDouble(request.getParameter("txtIngresosEsperados")));
            }
            if (request.getParameter("txtCostePresupuestado") != null) {
                obclsCampanas.setDbCostePresupuestado(Double.parseDouble(request.getParameter("txtCostePresupuestado")));
            }
            if (request.getParameter("txtCosteReal") != null) {
                obclsCampanas.setDbCosteReal(Double.parseDouble(request.getParameter("txtCosteReal")));
            }
            if (request.getParameter("txtRespuestaEsperada") != null) {
                obclsCampanas.setStRespuestaEsperada(request.getParameter("txtRespuestaEsperada"));
            }
            if (request.getParameter("txtNumerosEnviados") != null) {
                obclsCampanas.setInNumerosEnviados(Integer.parseInt(request.getParameter("txtNumerosEnviados")));
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsCampanas.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            //ENVIO DOS PARAMETROS AL JSP
            request.setAttribute("stMensaje", bl_obclsCampanas.createCampanas(obclsCampanas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsCampanas", bl_obclsCampanas.getCampanas());

            BL.clsTipoCampana bl_obclsTipoCampana = new BL.clsTipoCampana();
            BL.clsEstadoCampana bl_obclsEstadoCampana = new BL.clsEstadoCampana();

            request.setAttribute("lstclsTipoCampana", bl_obclsTipoCampana.getTipoCampana());
            request.setAttribute("lstclsEstadoCampana", bl_obclsEstadoCampana.getEstadoCampana());

            request.getRequestDispatcher("Campanas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Campanas.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.clsCampanas bl_obclsCampanas = new BL.clsCampanas();

            Models.clsCampanas obclsCampanas = new Models.clsCampanas();
            Models.clsTipoCampana obclsTipoCampana = new Models.clsTipoCampana();
            Models.clsEstadoCampana obclsEstadoCampana = new Models.clsEstadoCampana();

            if (request.getParameter("codigoModificar") != null) {
                obclsCampanas.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }
            
            if (request.getParameter("ddlTipo") != null) {
                obclsTipoCampana.setInCodigo(Integer.parseInt(request.getParameter("ddlTipo")));
                obclsCampanas.setObclsTipoCampana(obclsTipoCampana);
            }

            if (request.getParameter("txtNombre") != null) {
                obclsCampanas.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("ddlEstado") != null) {
                obclsEstadoCampana.setInCodigo(Integer.parseInt(request.getParameter("ddlEstado")));
                obclsCampanas.setObclsEstadoCampana(obclsEstadoCampana);
            }
            if (request.getParameter("txtFechaInicio") != null) {
                obclsCampanas.setStFechaInicio(request.getParameter("txtFechaInicio"));
            }
            if (request.getParameter("txtFechaFinalizacion") != null) {
                obclsCampanas.setStFechaFinalizacion(request.getParameter("txtFechaFinalizacion"));
            }
            if (request.getParameter("txtIngresosEsperados") != null) {
                obclsCampanas.setDbIngresosEsperados(Double.parseDouble(request.getParameter("txtIngresosEsperados")));
            }
            if (request.getParameter("txtCostePresupuestado") != null) {
                obclsCampanas.setDbCostePresupuestado(Double.parseDouble(request.getParameter("txtCostePresupuestado")));
            }
            if (request.getParameter("txtCosteReal") != null) {
                obclsCampanas.setDbCosteReal(Double.parseDouble(request.getParameter("txtCosteReal")));
            }
            if (request.getParameter("txtRespuestaEsperada") != null) {
                obclsCampanas.setStRespuestaEsperada(request.getParameter("txtRespuestaEsperada"));
            }
            if (request.getParameter("txtNumerosEnviados") != null) {
                obclsCampanas.setInNumerosEnviados(Integer.parseInt(request.getParameter("txtNumerosEnviados")));
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsCampanas.setStDescripcion(request.getParameter("txtDescripcion"));
            }
            
            request.setAttribute("stMensaje", bl_obclsCampanas.updateCampanas(obclsCampanas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsCampanas", bl_obclsCampanas.getCampanas());

            BL.clsTipoCampana bl_obclsTipoCampana = new BL.clsTipoCampana();
            BL.clsEstadoCampana bl_obclsEstadoCampana = new BL.clsEstadoCampana();

            request.setAttribute("lstclsTipoCampana", bl_obclsTipoCampana.getTipoCampana());
            request.setAttribute("lstclsEstadoCampana", bl_obclsEstadoCampana.getEstadoCampana());

            request.getRequestDispatcher("Campanas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Campanas.jsp").forward(request, response);
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

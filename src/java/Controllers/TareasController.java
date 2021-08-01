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


@WebServlet(name = "TareasController", urlPatterns = {"/TareasController"})
public class TareasController extends HttpServlet {

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

            BL.clsTareas bl_clsTareas = new BL.clsTareas();
            request.setAttribute("lstclsTareas", bl_clsTareas.getTareas());

            BL.clsEstadoTarea bl_clsEstadoTarea = new BL.clsEstadoTarea();
            BL.clsPrioridad bl_clsPrioridad = new BL.clsPrioridad();

            request.setAttribute("lstclsEstadoTarea", bl_clsEstadoTarea.getEstadoTarea());
            request.setAttribute("lstclsPrioridad", bl_clsPrioridad.getPrioridad());

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);
        }
    }

    public void btnEliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.clsTareas bl_clsTareas = new BL.clsTareas();
            Models.clsTareas obclsTareas = new Models.clsTareas();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsTareas.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }

            request.setAttribute("stMensaje", bl_clsTareas.deleteTarea(obclsTareas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsTareas", bl_clsTareas.getTareas());

            BL.clsEstadoTarea bl_clsEstadoTarea = new BL.clsEstadoTarea();
            BL.clsPrioridad bl_clsPrioridad = new BL.clsPrioridad();

            request.setAttribute("lstclsEstadoTarea", bl_clsEstadoTarea.getEstadoTarea());
            request.setAttribute("lstclsPrioridad", bl_clsPrioridad.getPrioridad());

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            BL.clsTareas bl_clsTareas = new BL.clsTareas();

            List<Models.clsTareas> lstclsTareas = new ArrayList<Models.clsTareas>();
            Models.clsTareas obclsTareas = new Models.clsTareas();

            lstclsTareas = bl_clsTareas.getTareas();

            for (Models.clsTareas elem : lstclsTareas) {
                if (elem.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsTareas = elem;
                    break;
                }
            }

            request.setAttribute("obclsTareas", obclsTareas);
            request.setAttribute("lstclsTareas", lstclsTareas);

            BL.clsEstadoTarea bl_clsEstadoTarea = new BL.clsEstadoTarea();
            BL.clsPrioridad bl_clsPrioridad = new BL.clsPrioridad();

            request.setAttribute("lstclsEstadoTarea", bl_clsEstadoTarea.getEstadoTarea());
            request.setAttribute("lstclsPrioridad", bl_clsPrioridad.getPrioridad());

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsTareas bl_clsTareas = new BL.clsTareas();

            Models.clsTareas obclsTareas = new Models.clsTareas();
            Models.clsEstadoTarea obclsEstadoTarea = new Models.clsEstadoTarea();
            Models.clsPrioridad obclsPrioridad = new Models.clsPrioridad();

            if (request.getParameter("txtTitular") != null) {
                obclsTareas.setStTitular(request.getParameter("txtTitular"));
            }
            if (request.getParameter("txtAsunto") != null) {
                obclsTareas.setStAsunto(request.getParameter("txtAsunto"));
            }
            if (request.getParameter("txtFechaVencimiento") != null) {
                obclsTareas.setStFechaVencimiento(request.getParameter("txtFechaVencimiento"));
            }
            if (request.getParameter("txtContacto") != null) {
                obclsTareas.setStContacto(request.getParameter("txtContacto"));
            }
            if (request.getParameter("txtCuenta") != null) {
                obclsTareas.setStCuenta(request.getParameter("txtCuenta"));
            }
            if (request.getParameter("ddlEstado") != null) {
                obclsEstadoTarea.setInCodigo(Integer.parseInt(request.getParameter("ddlEstado")));
                obclsTareas.setObclsEstadoTarea(obclsEstadoTarea);
            }
            if (request.getParameter("ddlPrioridad") != null) {
                obclsPrioridad.setInCodigo(Integer.parseInt(request.getParameter("ddlPrioridad")));
                obclsTareas.setObclsPrioridad(obclsPrioridad);
            }
            if (request.getParameter("chkEnviarMensaje") != null) {
                obclsTareas.setChEnviarMensaje(request.getParameter("chkEnviarMensaje").equals("on") ? 'S' : 'N');
            } else {
                obclsTareas.setChEnviarMensaje('N');
            }
            if (request.getParameter("chkRepetir") != null) {
                obclsTareas.setChRepetir(request.getParameter("chkRepetir").equals("on") ? 'S' : 'N');
            } else {
                obclsTareas.setChRepetir('N');
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsTareas.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            request.setAttribute("stMensaje", bl_clsTareas.createTarea(obclsTareas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsTareas", bl_clsTareas.getTareas());

            BL.clsEstadoTarea bl_clsEstadoTarea = new BL.clsEstadoTarea();
            BL.clsPrioridad bl_clsPrioridad = new BL.clsPrioridad();

            request.setAttribute("lstclsEstadoTarea", bl_clsEstadoTarea.getEstadoTarea());
            request.setAttribute("lstclsPrioridad", bl_clsPrioridad.getPrioridad());

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsTareas bl_clsTareas = new BL.clsTareas();

            Models.clsTareas obclsTareas = new Models.clsTareas();
            Models.clsEstadoTarea obclsEstadoTarea = new Models.clsEstadoTarea();
            Models.clsPrioridad obclsPrioridad = new Models.clsPrioridad();

            if (request.getParameter("codigoModificar") != null) {
                obclsTareas.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }
            if (request.getParameter("txtTitular") != null) {
                obclsTareas.setStTitular(request.getParameter("txtTitular"));
            }
            if (request.getParameter("txtAsunto") != null) {
                obclsTareas.setStAsunto(request.getParameter("txtAsunto"));
            }
            if (request.getParameter("txtFechaVencimiento") != null) {
                obclsTareas.setStFechaVencimiento(request.getParameter("txtFechaVencimiento"));
            }
            if (request.getParameter("txtContacto") != null) {
                obclsTareas.setStContacto(request.getParameter("txtContacto"));
            }
            if (request.getParameter("txtCuenta") != null) {
                obclsTareas.setStCuenta(request.getParameter("txtCuenta"));
            }
            if (request.getParameter("ddlEstado") != null) {
                obclsEstadoTarea.setInCodigo(Integer.parseInt(request.getParameter("ddlEstado")));
                obclsTareas.setObclsEstadoTarea(obclsEstadoTarea);
            }
            if (request.getParameter("ddlPrioridad") != null) {
                obclsPrioridad.setInCodigo(Integer.parseInt(request.getParameter("ddlPrioridad")));
                obclsTareas.setObclsPrioridad(obclsPrioridad);
            }
            if (request.getParameter("chkEnviarMensaje") != null) {
                obclsTareas.setChEnviarMensaje(request.getParameter("chkEnviarMensaje").equals("on") ? 'S' : 'N');
            } else {
                obclsTareas.setChEnviarMensaje('N');
            }
            if (request.getParameter("chkRepetir") != null) {
                obclsTareas.setChRepetir(request.getParameter("chkRepetir").equals("on") ? 'S' : 'N');
            } else {
                obclsTareas.setChRepetir('N');
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsTareas.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            request.setAttribute("stMensaje", bl_clsTareas.updateTarea(obclsTareas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsTareas", bl_clsTareas.getTareas());

            BL.clsEstadoTarea bl_clsEstadoTarea = new BL.clsEstadoTarea();
            BL.clsPrioridad bl_clsPrioridad = new BL.clsPrioridad();

            request.setAttribute("lstclsEstadoTarea", bl_clsEstadoTarea.getEstadoTarea());
            request.setAttribute("lstclsPrioridad", bl_clsPrioridad.getPrioridad());

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Tareas.jsp").forward(request, response);
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

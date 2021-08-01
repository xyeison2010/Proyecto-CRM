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



@WebServlet(name = "EventosController", urlPatterns = {"/EventosController"})
public class EventosController extends HttpServlet {

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

            BL.clsEventos bl_clsEventos = new BL.clsEventos();
            request.setAttribute("lstclsEventos", bl_clsEventos.getEventos());

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());

            request.getRequestDispatcher("Eventos.jsp").forward(request, response);
        }
    }
    
    public void btnEliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {

            BL.clsEventos bl_clsEventos = new BL.clsEventos();
            Models.clsEventos obclsEventos = new Models.clsEventos();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsEventos.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }

            request.setAttribute("stMensaje", bl_clsEventos.deleteEvento(obclsEventos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEventos", bl_clsEventos.getEventos());

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());

            request.getRequestDispatcher("Eventos.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Eventos.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {

        try {

            BL.clsEventos bl_clsEventos = new BL.clsEventos();

            List<Models.clsEventos> lstclsEventos = new ArrayList<Models.clsEventos>();
            Models.clsEventos obclsEventos = new Models.clsEventos();

            lstclsEventos = bl_clsEventos.getEventos();

            for (Models.clsEventos item : lstclsEventos) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsEventos = item;
                    break;
                }
            }

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();

            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());
            request.setAttribute("obclsEventos", obclsEventos);
            request.setAttribute("lstclsEventos", lstclsEventos);

            request.getRequestDispatcher("Eventos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Eventos.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            BL.clsEventos bl_obclsEventos = new BL.clsEventos();

            Models.clsEventos obclsEventos = new Models.clsEventos();
            Models.clsRelacionadoCon obclsRelacionadoCon = new Models.clsRelacionadoCon();

            if (request.getParameter("txtNombre") != null) {
                obclsEventos.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtUbicacion") != null) {
                obclsEventos.setStUbicacion(request.getParameter("txtUbicacion"));
            }
            if (request.getParameter("txtParticipantes") != null) {
                obclsEventos.setStParticipantes(request.getParameter("txtParticipantes"));
            }
            if (request.getParameter("chkTodoDia") != null) {
                obclsEventos.setChTodoDia(request.getParameter("chkTodoDia").equals("on") ? 'S' : 'N');
            } else {
                obclsEventos.setChTodoDia('N');
            }
            if (request.getParameter("txtFecha") != null) {
                obclsEventos.setStFecha(request.getParameter("txtFecha"));
            }
            if (request.getParameter("ddlRelacionadoCon") != null) {
                obclsRelacionadoCon.setInCodigo(Integer.parseInt(request.getParameter("ddlRelacionadoCon")));
                obclsEventos.setObclsRelacionadoCon(obclsRelacionadoCon);
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsEventos.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            request.setAttribute("stMensaje", bl_obclsEventos.createEvento(obclsEventos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEventos", bl_obclsEventos.getEventos());

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());

            request.getRequestDispatcher("Eventos.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            request.getRequestDispatcher("Eventos.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            BL.clsEventos bl_obclsEventos = new BL.clsEventos();

            Models.clsEventos obclsEventos = new Models.clsEventos();
            Models.clsRelacionadoCon obclsRelacionadoCon = new Models.clsRelacionadoCon();

            if (request.getParameter("codigoModificar") != null) {
                obclsEventos.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsEventos.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtUbicacion") != null) {
                obclsEventos.setStUbicacion(request.getParameter("txtUbicacion"));
            }
            if (request.getParameter("txtParticipantes") != null) {
                obclsEventos.setStParticipantes(request.getParameter("txtParticipantes"));
            }
            if (request.getParameter("chkTodoDia") != null) {
                obclsEventos.setChTodoDia(request.getParameter("chkTodoDia").equals("on") ? 'S' : 'N');
            } else {
                obclsEventos.setChTodoDia('N');
            }
            if (request.getParameter("txtFecha") != null) {
                obclsEventos.setStFecha(request.getParameter("txtFecha"));
            }
            if (request.getParameter("ddlRelacionadoCon") != null) {
                obclsRelacionadoCon.setInCodigo(Integer.parseInt(request.getParameter("ddlRelacionadoCon")));
                obclsEventos.setObclsRelacionadoCon(obclsRelacionadoCon);
            }
            if (request.getParameter("txtDescripcion") != null) {
                obclsEventos.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            request.setAttribute("stMensaje", bl_obclsEventos.updateEvento(obclsEventos));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEventos", bl_obclsEventos.getEventos());
            
            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());

            request.getRequestDispatcher("Eventos.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Eventos.jsp").forward(request, response);
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

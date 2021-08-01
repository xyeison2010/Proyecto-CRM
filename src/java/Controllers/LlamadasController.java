package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LlamadasController", urlPatterns = {"/LlamadasController"})
public class LlamadasController extends HttpServlet {

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

            BL.clsLlamadas bl_obclsLlamadas = new BL.clsLlamadas();
            request.setAttribute("lstclsLlamadas", bl_obclsLlamadas.getLlamadas());

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            BL.clsPropositoDeLaLlamada bl_clsPropositoDeLaLlamada = new BL.clsPropositoDeLaLlamada();
            BL.clsTipoLlamada bl_clsTipoLlamada = new BL.clsTipoLlamada();

            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());
            request.setAttribute("lstclsPropositoDeLaLlamada", bl_clsPropositoDeLaLlamada.getPropositoDeLaLlamada());
            request.setAttribute("lstclsTipoLlamada", bl_clsTipoLlamada.getTipoLlamada());

            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsLlamadas bl_clsLlamadas = new BL.clsLlamadas();

            Models.clsLlamadas obclsLlamadas = new Models.clsLlamadas();
            Models.clsPropositoDeLaLlamada obclsPropositoDeLaLlamada = new Models.clsPropositoDeLaLlamada();
            Models.clsRelacionadoCon obclsRelacionadoCon = new Models.clsRelacionadoCon();
            Models.clsTipoLlamada obclsTipoLlamada = new Models.clsTipoLlamada();

            if (request.getParameter("codigoModificar") != null) {
                obclsLlamadas.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }

            if (request.getParameter("txtNombreContacto") != null) {
                obclsLlamadas.setStContacto(request.getParameter("txtNombreContacto"));
            }

            if (request.getParameter("txtAsunto") != null) {
                obclsLlamadas.setStAsunto(request.getParameter("txtAsunto"));
            }

            if (request.getParameter("ddlPropositoDeLaLlamada") != null) {
                obclsPropositoDeLaLlamada.setInCodigo(Integer.parseInt(request.getParameter("ddlPropositoDeLaLlamada")));
                obclsLlamadas.setObclsPropositoDeLaLlamada(obclsPropositoDeLaLlamada);
            }

            if (request.getParameter("ddlRelacionadoCon") != null) {
                obclsRelacionadoCon.setInCodigo(Integer.parseInt(request.getParameter("ddlRelacionadoCon")));
                obclsLlamadas.setObclsRelacionadoCon(obclsRelacionadoCon);
            }

            if (request.getParameter("rbTipoLlamada") != null) {
                obclsTipoLlamada.setInCodigo(Integer.parseInt(request.getParameter("rbTipoLlamada")));
                obclsLlamadas.setObclsTipoLlamada(obclsTipoLlamada);
            }

            if (request.getParameter("txtDetalles") != null) {
                obclsLlamadas.setStDetalles(request.getParameter("txtDetalles"));
            }

            if (request.getParameter("txtFecha") != null) {
                obclsLlamadas.setStFecha(request.getParameter("txtFecha"));
            }

            if (request.getParameter("txtDuracion") != null) {
                obclsLlamadas.setInDuracion(Integer.parseInt(request.getParameter("txtDuracion")));
            }

            if (request.getParameter("txtDescripcion") != null) {
                obclsLlamadas.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            if (request.getParameter("txtResultado") != null) {
                obclsLlamadas.setStResultado(request.getParameter("txtResultado"));
            }

            request.setAttribute("stMensaje", bl_clsLlamadas.updateLlamada(obclsLlamadas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsLlamadas", bl_clsLlamadas.getLlamadas());

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            BL.clsPropositoDeLaLlamada bl_clsPropositoDeLaLlamada = new BL.clsPropositoDeLaLlamada();
            BL.clsTipoLlamada bl_clsTipoLlamada = new BL.clsTipoLlamada();

            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());
            request.setAttribute("lstclsPropositoDeLaLlamada", bl_clsPropositoDeLaLlamada.getPropositoDeLaLlamada());
            request.setAttribute("lstclsTipoLlamada", bl_clsTipoLlamada.getTipoLlamada());

            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);
        }
    }

    public void btnEliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {

            BL.clsLlamadas bl_clsLlamadas = new BL.clsLlamadas();
            Models.clsLlamadas obclsLlamadas = new Models.clsLlamadas();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsLlamadas.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }

            request.setAttribute("stMensaje", bl_clsLlamadas.deleteLlamada(obclsLlamadas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsLlamadas", bl_clsLlamadas.getLlamadas());

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            BL.clsPropositoDeLaLlamada bl_clsPropositoDeLaLlamada = new BL.clsPropositoDeLaLlamada();
            BL.clsTipoLlamada bl_clsTipoLlamada = new BL.clsTipoLlamada();

            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());
            request.setAttribute("lstclsPropositoDeLaLlamada", bl_clsPropositoDeLaLlamada.getPropositoDeLaLlamada());
            request.setAttribute("lstclsTipoLlamada", bl_clsTipoLlamada.getTipoLlamada());

            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsLlamadas bl_clsLlamadas = new BL.clsLlamadas();
            List<Models.clsLlamadas> lstclsLlamadas = new ArrayList<Models.clsLlamadas>();
            Models.clsLlamadas obclsLlamadas = new Models.clsLlamadas();

            lstclsLlamadas = bl_clsLlamadas.getLlamadas();

            for (Models.clsLlamadas item : lstclsLlamadas) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsLlamadas = item;
                    break;
                }
            }

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            BL.clsPropositoDeLaLlamada bl_clsPropositoDeLaLlamada = new BL.clsPropositoDeLaLlamada();
            BL.clsTipoLlamada bl_clsTipoLlamada = new BL.clsTipoLlamada();

            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());
            request.setAttribute("lstclsPropositoDeLaLlamada", bl_clsPropositoDeLaLlamada.getPropositoDeLaLlamada());
            request.setAttribute("lstclsTipoLlamada", bl_clsTipoLlamada.getTipoLlamada());

            request.setAttribute("obclsLlamadas", obclsLlamadas);
            request.setAttribute("lstclsLlamadas", lstclsLlamadas);
            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);

        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {

            BL.clsLlamadas bl_obclsLlamadas = new BL.clsLlamadas();

            Models.clsLlamadas obclsLlamadas = new Models.clsLlamadas();
            Models.clsPropositoDeLaLlamada obclsPropositoDeLaLlamada = new Models.clsPropositoDeLaLlamada();
            Models.clsRelacionadoCon obclsRelacionadoCon = new Models.clsRelacionadoCon();
            Models.clsTipoLlamada obclsTipoLlamada = new Models.clsTipoLlamada();

            if (request.getParameter("txtNombreContacto") != null) {
                obclsLlamadas.setStContacto(request.getParameter("txtNombreContacto"));
            }

            if (request.getParameter("txtAsunto") != null) {
                obclsLlamadas.setStAsunto(request.getParameter("txtAsunto"));
            }

            if (request.getParameter("ddlPropositoDeLaLlamada") != null) {
                obclsPropositoDeLaLlamada.setInCodigo(Integer.parseInt(request.getParameter("ddlPropositoDeLaLlamada")));
                obclsLlamadas.setObclsPropositoDeLaLlamada(obclsPropositoDeLaLlamada);
            }

            if (request.getParameter("ddlRelacionadoCon") != null) {
                obclsRelacionadoCon.setInCodigo(Integer.parseInt(request.getParameter("ddlRelacionadoCon")));
                obclsLlamadas.setObclsRelacionadoCon(obclsRelacionadoCon);
            }

            if (request.getParameter("rbTipoLlamada") != null) {
                obclsTipoLlamada.setInCodigo(Integer.parseInt(request.getParameter("rbTipoLlamada")));
                obclsLlamadas.setObclsTipoLlamada(obclsTipoLlamada);
            }

            if (request.getParameter("txtDetalles") != null) {
                obclsLlamadas.setStDetalles(request.getParameter("txtDetalles"));
            }

            if (request.getParameter("txtFecha") != null) {
                obclsLlamadas.setStFecha(request.getParameter("txtFecha"));
            }

            if (request.getParameter("txtDuracion") != null) {
                obclsLlamadas.setInDuracion(Integer.parseInt(request.getParameter("txtDuracion")));
            }

            if (request.getParameter("txtDescripcion") != null) {
                obclsLlamadas.setStDescripcion(request.getParameter("txtDescripcion"));
            }

            if (request.getParameter("txtResultado") != null) {
                obclsLlamadas.setStResultado(request.getParameter("txtResultado"));
            }

            request.setAttribute("stMensaje", bl_obclsLlamadas.createLlamada(obclsLlamadas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsLlamadas", bl_obclsLlamadas.getLlamadas());

            BL.clsRelacionadoCon bl_clsRelacionadoCon = new BL.clsRelacionadoCon();
            BL.clsPropositoDeLaLlamada bl_clsPropositoDeLaLlamada = new BL.clsPropositoDeLaLlamada();
            BL.clsTipoLlamada bl_clsTipoLlamada = new BL.clsTipoLlamada();

            request.setAttribute("lstclsRelacionadoCon", bl_clsRelacionadoCon.getRelacionadoCon());
            request.setAttribute("lstclsPropositoDeLaLlamada", bl_clsPropositoDeLaLlamada.getPropositoDeLaLlamada());
            request.setAttribute("lstclsTipoLlamada", bl_clsTipoLlamada.getTipoLlamada());

            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Llamadas.jsp").forward(request, response);
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

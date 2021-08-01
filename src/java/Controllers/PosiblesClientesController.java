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


@WebServlet(name = "PosiblesClientesController", urlPatterns = {"/PosiblesClientesController"})
public class PosiblesClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *////por el name lo identifikamos , los submit lo tenemos q hacer aca referenciar
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //VALIDAMOS QUE SE HAYAN PRESIONADO LOS BOTONES
        if (request.getParameter("btnGuardar") != null) { //si es diferente a null es q si se ha presionado 
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

            BL.clsPosiblesClientes bl_obclsPosiblesClientes = new BL.clsPosiblesClientes();
            request.setAttribute("lstclsPosiblesClientes", bl_obclsPosiblesClientes.getPosiblesClientes());  //todos los posibles cliente

            BL.clsCalificaciones bl_clsCalificaciones = new BL.clsCalificaciones();
            BL.clsEstadoPosibleCliente bl_clsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_clsSector = new BL.clsSector();
//set attribue envia del controlador a la vista , listas desplegables
            request.setAttribute("lstclsCalificaciones", bl_clsCalificaciones.getCalificacion());
            request.setAttribute("lstclsEstadoPosiblesClientes", bl_clsEstadoPosibleCliente.getEstadoPosibleCliente());
            request.setAttribute("lstclsFuentePosiblesClientes", bl_clsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSectores", bl_clsSector.getSector());
//direccionamiento
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void btnEliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {

            BL.clsPosiblesClientes bl_clsPosiblesClientes = new BL.clsPosiblesClientes();
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            if (request.getParameter("codigoSeleccionado") != null) {
                obclsPosiblesClientes.setInCodigo(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }

            request.setAttribute("stMensaje", bl_clsPosiblesClientes.deletePosibleCliente(obclsPosiblesClientes));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsPosiblesClientes", bl_clsPosiblesClientes.getPosiblesClientes());

            BL.clsCalificaciones bl_clsCalificaciones = new BL.clsCalificaciones();
            BL.clsEstadoPosibleCliente bl_clsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_clsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificaciones", bl_clsCalificaciones.getCalificacion());
            request.setAttribute("lstclsEstadoPosiblesClientes", bl_clsEstadoPosibleCliente.getEstadoPosibleCliente());
            request.setAttribute("lstclsFuentePosiblesClientes", bl_clsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSectores", bl_clsSector.getSector());

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void btnModificar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {

            BL.clsPosiblesClientes bl_clsPosiblesClientes = new BL.clsPosiblesClientes();

            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();

            if (request.getParameter("codigoModificar") != null) {
                obclsPosiblesClientes.setInCodigo(Integer.valueOf(request.getParameter("codigoModificar")));
            }
            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesClientes.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesClientes.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesClientes.setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesClientes.setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsPosiblesClientes.setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesClientes.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                obclsPosiblesClientes.setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                obclsPosiblesClientes.setStMovil(request.getParameter("txtMovil"));
            }
            if (request.getParameter("txtWeb") != null) {
                obclsPosiblesClientes.setStSitioWeb(request.getParameter("txtWeb"));
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }
            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));
                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }
            if (request.getParameter("ddlSector") != null) {
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));
                obclsPosiblesClientes.setObclsSector(obclsSector);
            }
            if (request.getParameter("txtCantidadEmpleados") != null) {
                if (request.getParameter("txtCantidadEmpleados").equals("")) {
                    obclsPosiblesClientes.setInCantidadEmpleados(0);
                } else {
                    obclsPosiblesClientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
                }
            }

            if (request.getParameter("txtIngresosAnuales") != null) {
                if (request.getParameter("txtIngresosAnuales").equals("")) {
                    obclsPosiblesClientes.setDbIngresosAnuales(0);
                } else {
                    obclsPosiblesClientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
                }
            }

            if (request.getParameter("ddlCalificacion") != null) {
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));
                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);
            }

            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {
                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on") ? 'S' : 'N';
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico('N');
            }
            if (request.getParameter("txtIDSkype") != null) {
                obclsPosiblesClientes.setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                obclsPosiblesClientes.setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                obclsPosiblesClientes.setStCorreoElectronicoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }

            request.setAttribute("stMensaje", bl_clsPosiblesClientes.updatePosiblesCliente(obclsPosiblesClientes));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsPosiblesClientes", bl_clsPosiblesClientes.getPosiblesClientes());

            BL.clsCalificaciones bl_clsCalificaciones = new BL.clsCalificaciones();
            BL.clsEstadoPosibleCliente bl_clsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_clsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificaciones", bl_clsCalificaciones.getCalificacion());
            request.setAttribute("lstclsEstadoPosiblesClientes", bl_clsEstadoPosibleCliente.getEstadoPosibleCliente());
            request.setAttribute("lstclsFuentePosiblesClientes", bl_clsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSectores", bl_clsSector.getSector());

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //MODELO SOBRE EL QUE ESTAMOS TRABJANDO
            BL.clsPosiblesClientes bl_clsPosiblesClientes = new BL.clsPosiblesClientes();
            //LISTA DE OBJETOS DONDE ESTA LA INFORMACION GUARDADA
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();

            lstclsPosiblesClientes = bl_clsPosiblesClientes.getPosiblesClientes();

            for (Models.clsPosiblesClientes elem : lstclsPosiblesClientes) {
                if (elem.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPosiblesClientes = elem;
                    break;
                }
            }

            BL.clsCalificaciones bl_clsCalificaciones = new BL.clsCalificaciones();
            BL.clsEstadoPosibleCliente bl_clsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_clsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificaciones", bl_clsCalificaciones.getCalificacion());
            request.setAttribute("lstclsEstadoPosiblesClientes", bl_clsEstadoPosibleCliente.getEstadoPosibleCliente());
            request.setAttribute("lstclsFuentePosiblesClientes", bl_clsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSectores", bl_clsSector.getSector());

            request.setAttribute("obclsPosiblesClientes", obclsPosiblesClientes);
            request.setAttribute("lstclsPosiblesClientes", lstclsPosiblesClientes);
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            BL.clsPosiblesClientes bl_obclsPosiblesClientes = new BL.clsPosiblesClientes();
            //DEFINICION DE MODELOS
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();
//ASIGNACION DE ATRIBUTO O PROPIEDADES
            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesClientes.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesClientes.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesClientes.setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesClientes.setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsPosiblesClientes.setStCorreoElectronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesClientes.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                obclsPosiblesClientes.setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                obclsPosiblesClientes.setStMovil(request.getParameter("txtMovil"));
            }
            if (request.getParameter("txtWeb") != null) {
                obclsPosiblesClientes.setStSitioWeb(request.getParameter("txtWeb"));
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                //MODELO HIJO
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));
                //ASIGNO AL MODELO PADRE , YA NO no lo necesitmaos porq la descripcion viene de la base de datos
                obclsPosiblesClientes.setObclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }
            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));
                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }
            if (request.getParameter("ddlSector") != null) {
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));
                obclsPosiblesClientes.setObclsSector(obclsSector);
            }

            if (request.getParameter("txtCantidadEmpleados") != null) {
                if (request.getParameter("txtCantidadEmpleados").equals("")) {
                    obclsPosiblesClientes.setInCantidadEmpleados(0);
                } else {
                    obclsPosiblesClientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
                }
            }

            if (request.getParameter("txtIngresosAnuales") != null) {
                if (request.getParameter("txtIngresosAnuales").equals("")) {
                    obclsPosiblesClientes.setDbIngresosAnuales(0);
                } else {
                    obclsPosiblesClientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
                }
            }

            if (request.getParameter("ddlCalificacion") != null) {
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));
                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);
            }

            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {
                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on") ? 'S' : 'N';
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico(chSeleccion);
            } else {
                obclsPosiblesClientes.setChNoParticipacionCorreoElectronico('N');
            }
            if (request.getParameter("txtIDSkype") != null) {
                obclsPosiblesClientes.setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                obclsPosiblesClientes.setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoElectronicoSecundario") != null) {
                obclsPosiblesClientes.setStCorreoElectronicoSecundario(request.getParameter("txtCorreoElectronicoSecundario"));
            }
            //estamos retornado en st mensaje , "" esto que es el procedimiento almacenado 
            request.setAttribute("stMensaje", bl_obclsPosiblesClientes.createPosiblesCliente(obclsPosiblesClientes));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsPosiblesClientes", bl_obclsPosiblesClientes.getPosiblesClientes());

            BL.clsCalificaciones bl_clsCalificaciones = new BL.clsCalificaciones();
            BL.clsEstadoPosibleCliente bl_clsEstadoPosibleCliente = new BL.clsEstadoPosibleCliente();
            BL.clsFuentePosibleCliente bl_clsFuentePosibleCliente = new BL.clsFuentePosibleCliente();
            BL.clsSector bl_clsSector = new BL.clsSector();

            request.setAttribute("lstclsCalificaciones", bl_clsCalificaciones.getCalificacion());
            request.setAttribute("lstclsEstadoPosiblesClientes", bl_clsEstadoPosibleCliente.getEstadoPosibleCliente());
            request.setAttribute("lstclsFuentePosiblesClientes", bl_clsFuentePosibleCliente.getFuentePosibleCliente());
            request.setAttribute("lstclsSectores", bl_clsSector.getSector());

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

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

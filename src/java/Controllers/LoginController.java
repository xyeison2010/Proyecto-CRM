/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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

        if (request.getParameter("btnAutenticar") != null) {
            btnAutenticar(request, response);

        } else if (request.getParameter("btnRegistrar") != null) {
            btnRegistrar(request, response);
        }
    }

    public void btnRegistrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
                 // null = es si esta vacia si es nulo , substring nos permite leer la cadenas (en numeral )
       //.length()-1 nos permite leer cuando caracteres hay menos 1 es menos la coma q le puse ahi 
            String stMensaje = "";
            if (request.getParameter("txtEmail") == null) {
                stMensaje += "Ingrese email,"; //+=  concatenar
            }
            if (request.getParameter("txtPassword") == null) {
                stMensaje += "Ingrese password";
            }
            if (request.getParameter("txtConfirmarPassword") == null) {
                stMensaje += "Ingrese password";
            }

            if (request.getParameter("txtPassword") != null && request.getParameter("txtConfirmarPassword") == null) {
                if (!request.getParameter("txtPassword").equals(request.getParameter("txtConfirmarPassword"))) {
                    stMensaje += "El password ingresado no coincide con la confirmacion";
                }
            }

            if (!stMensaje.equals("")) {
                throw new Exception(stMensaje.substring(0, stMensaje.length() - 1));
            }

            BL.clsLogin obclsLogin = new BL.clsLogin();
            Models.clsLogin obclsLoginModel = new Models.clsLogin();

            obclsLoginModel.setStEmail(request.getParameter("txtEmail"));
            obclsLoginModel.setStPassword(request.getParameter("txtPassword"));

            if (!obclsLogin.stInsertarUsuario(obclsLoginModel).equals("OK")) {
                throw new Exception("Se produjo un error durante el procedimiento.");
            } else {
                request.setAttribute("stMensaje", "Se realizo proceso con exito.");
                request.setAttribute("stTipo", "success");
                request.getRequestDispatcher("Registrar.jsp").forward(request, response);  // request redireccionamos y forward para enviar los datos 
            }

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error"); 
            request.getRequestDispatcher("Registrar.jsp").forward(request, response);
        }

    }

    public void btnAutenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String stMensaje = "";

            if (request.getParameter("txtEmail").equals("")) {
                stMensaje += "Ingrese email,";
            }
            if (request.getParameter("txtPassword").equals("")) {
                stMensaje += " Ingrese password,";
            }

            if (!stMensaje.equals("")) { //si es diferente a nullo entonces 
                throw new Exception(stMensaje.substring(0, stMensaje.length() - 1));
            }
   //INSTACIANDO OBJETO
            Models.clsLogin obclsLogin = new Models.clsLogin();
      //asignado las propiedades
            obclsLogin.setStEmail(request.getParameter("txtEmail"));
            obclsLogin.setStPassword(request.getParameter("txtPassword"));
   //instanciando BL(bussines logic)
            BL.clsLogin obBLclsLogin = new BL.clsLogin();
      //invoco el metodo validarLOogin
            boolean blBandera = obBLclsLogin.validarLogin(obclsLogin);

            if (blBandera)
            {  //direccionamiento JSP
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            } else {
                throw new Exception("Email o password incorrecto");
            }

        } catch (Exception ex) {      
            request.setAttribute("stError", ex.getMessage());   //envio de parmetros o valores         
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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

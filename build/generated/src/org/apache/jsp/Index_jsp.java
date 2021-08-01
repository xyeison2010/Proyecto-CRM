package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <title>Index</title>\n");
      out.write("        <!-- Bootstrap core CSS-->\n");
      out.write("        <link href=\"vendor/bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom fonts for this template-->\n");
      out.write("        <link href=\"vendor/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <!-- Page level plugin CSS-->\n");
      out.write("        <link href=\"vendor/datatables/dataTables.bootstrap4.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Custom styles for this template-->\n");
      out.write("        <link href=\"css/sb-admin.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript-->\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <!-- Core plugin JavaScript-->\n");
      out.write("        <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("        <!-- Page level plugin JavaScript-->\n");
      out.write("        <script src=\"vendor/chart.js/Chart.min.js\"></script>\n");
      out.write("        <script src=\"vendor/datatables/jquery.dataTables.js\"></script>\n");
      out.write("        <script src=\"vendor/datatables/dataTables.bootstrap4.js\"></script>\n");
      out.write("        <!-- Custom scripts for all pages-->\n");
      out.write("        <script src=\"js/sb-admin.min.js\"></script>\n");
      out.write("        <!-- Custom scripts for this page-->\n");
      out.write("        <script src=\"js/sb-admin-datatables.min.js\"></script>\n");
      out.write("        <script src=\"js/sb-admin-charts.min.js\"></script>\n");
      out.write("\n");
      out.write("    <Script>\n");
      out.write("        function loadOption(option){\n");
      out.write("            document.getElementById('frame').src = option;\n");
      out.write("        }\n");
      out.write("    </Script>\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        iframe{\n");
      out.write("            width: 100%;\n");
      out.write("            height: 900px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body class=\"fixed-nav sticky-footer bg-dark\" id=\"page-top\">\n");
      out.write("    <!-- Navigation-->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\" id=\"mainNav\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"Index.jsp\">CRM</a>\n");
      out.write("        <!--esta es la rayita pa q se achike y agrande -->\n");
      out.write("        <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("            <ul class=\"navbar-nav navbar-sidenav\" id=\"exampleAccordion\">\n");
      out.write("                <li class=\"nav-item\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Posibles clientes\">\n");
      out.write("                    <a class=\"nav-link\"\n");
      out.write("                       onclick=\"loadOption('PosiblesClientesController?btnConsultar=true')\">\n");
      out.write("                        <i class=\"fa fa-fw fa-address-book\"></i>\n");
      out.write("                        <span class=\"nav-link-text\">Posibles clientes</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Tareas\">\n");
      out.write("                    <a class=\"nav-link\" \n");
      out.write("                       onclick=\"loadOption('TareasController?btnConsultar=true')\">\n");
      out.write("                        <i class=\"fa fa-fw fa-address-book\"></i>\n");
      out.write("                        <span class=\"nav-link-text\">Tareas</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Eventos\">\n");
      out.write("                    <a class=\"nav-link\"\n");
      out.write("                       onclick=\"loadOption('EventosController?btnConsultar=true')\">\n");
      out.write("                        <i class=\"fa fa-fw fa-address-book\"></i>\n");
      out.write("                        <span class=\"nav-link-text\">Eventos</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Llamadas\">\n");
      out.write("                    <a class=\"nav-link\" \n");
      out.write("                       onclick=\"loadOption('LlamadasController?btnConsultar=true')\">\n");
      out.write("                        <i class=\"fa fa-fw fa-address-book\"></i>\n");
      out.write("                        <span class=\"nav-link-text\">Llamadas</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Contactos\">\n");
      out.write("                    <a class=\"nav-link\" \n");
      out.write("                       onclick=\"loadOption('ContactosController?btnConsultar=true')\">\n");
      out.write("                        <i class=\"fa fa-fw fa-address-book\"></i>\n");
      out.write("                        <span class=\"nav-link-text\">Contactos</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Tratos\">\n");
      out.write("                    <a class=\"nav-link\" \n");
      out.write("                       onclick=\"loadOption('TratosController?btnConsultar=true')\">\n");
      out.write("                        <i class=\"fa fa-fw fa-address-book\"></i>\n");
      out.write("                        <span class=\"nav-link-text\">Tratos</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Campañas\">\n");
      out.write("                    <a class=\"nav-link\" \n");
      out.write("                       onclick=\"loadOption('CampanasController?btnConsultar=true')\">\n");
      out.write("                        <i class=\"fa fa-fw fa-address-book\"></i>\n");
      out.write("                        <span class=\"nav-link-text\">Campañas</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("            </ul>     \n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"Login.jsp\">\n");
      out.write("                        <i class=\"fa fa-fw fa-sign-out\"></i>Salir</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    <div class=\"content-wrapper\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <iframe id=\"frame\" frameborder=\"0\"></iframe>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container-fluid-->\n");
      out.write("        <!-- /.content-wrapper-->\n");
      out.write("        <footer class=\"sticky-footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <small>Copyright © CRM 2018</small>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>               \n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

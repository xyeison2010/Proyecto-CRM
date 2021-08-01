

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Posibles Clientes</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <link href="css/sweetalert.css" rel="stylesheet" type="text/css" />
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>     
        <!-- SCRIPTLETS -->
        <%
            if (request.getAttribute("stMensaje") != null) {
        %>     
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje").toString()%>"/>
        <input type="text" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo").toString()%>"/>
        <script>
            swal("Mensaje", document.getElementById("txtMensaje").value, document.getElementById("txtTipo").value);
        </script>
        <%
            }
        %>    

        <%
           
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            
            if (request.getAttribute("obclsPosiblesClientes") != null) {
                obclsPosiblesClientes = (Models.clsPosiblesClientes) request.getAttribute("obclsPosiblesClientes");
            }

            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();

            if (request.getAttribute("lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) request.getAttribute("lstclsPosiblesClientes");
            }
        %>
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Posibles Clientes
                    <p>
                        Posible cliente permite nombrar al sujeto que, de acuerdo con un análisis de mercado o estudio de
                        marketing, podría convertirse en comprador, consumidor o usuario de un producto o servicio
                        determinado.
                    </p>
                </div>
                <div class="card-body">
                          <!-- todo esta sera procesada en el controlador definido , la parte backend (action) -->
                    <form action="PosiblesClientesController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>                                    
                                    
                                    <input type="text" name="codigoModificar" id="codigoModificar" 
                                           value="<%=obclsPosiblesClientes.getInCodigo()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Informacion de Posible cliente</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblEmpresa">Empresa</label>
                                    <input type="text" placeholder="Ingrese empresa" name="txtEmpresa" class="form-control"  
                                           value="<%=obclsPosiblesClientes.getStEmpresa() != null ? obclsPosiblesClientes.getStEmpresa() : ""%>" />
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombre">Nombres</label>
                                    <input type="text" placeholder="Ingrese nombres" name="txtNombre" class="form-control"  
                                           value="<%=obclsPosiblesClientes.getStNombre() != null ? obclsPosiblesClientes.getStNombre() : ""%>" />
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblApellidos">Apellidos</label>
                                    <input type="text" placeholder="Ingrese apellidos" name="txtApellidos" class="form-control"  
                                           value="<%=obclsPosiblesClientes.getStApellidos() != null ? obclsPosiblesClientes.getStApellidos() : ""%>" />
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTitulo">Titulo</label>
                                    <input type="text" placeholder="Ingrese titulo" name="txtTitulo" class="form-control" 
                                           value="<%=obclsPosiblesClientes.getStTitulo() != null ? obclsPosiblesClientes.getStTitulo() : ""%>" />
                                </div>
                            </div>
                        </div>

                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblCorreoElectronico">Correo electronico</label>
                                    <input type="text" placeholder="Ingrese correo electronico" name="txtCorreoElectronico" class="form-control"  value="<%=obclsPosiblesClientes.getStCorreoElectronico() != null ? obclsPosiblesClientes.getStCorreoElectronico() : ""%>" />
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTelefono">Telefono</label>
                                    <input type="text" placeholder="Ingrese telefono" name="txtTelefono" class="form-control" value="<%=obclsPosiblesClientes.getStTelefono() != null ? obclsPosiblesClientes.getStTelefono() : ""%>" />
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFax">Fax</label>
                                    <input type="text" placeholder="Ingrese fax" name="txtFax" class="form-control" value="<%=obclsPosiblesClientes.getStFax() != null ? obclsPosiblesClientes.getStFax() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblMovil">Movil</label>
                                    <input type="text" placeholder="Ingrese movil" name="txtMovil" class="form-control" value="<%=obclsPosiblesClientes.getStMovil() != null ? obclsPosiblesClientes.getStMovil() : ""%>" />
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblSitioWeb">Sitio web</label>
                                    <input type="text" placeholder="Ingrese sitio web" name="txtWeb" class="form-control" value="<%= obclsPosiblesClientes.getStSitioWeb() != null ? obclsPosiblesClientes.getStSitioWeb() : ""%>" />
                                </div>
                                <div class="col-md-3">
                                    <label name="lblFuentePosibleCliente">Fuente de posible cliente</label>
                                    <select class="form-control" name="ddlFuentePosibleCliente">                                       
                                        <%
                                            List<Models.clsFuentePosibleCliente> lstclsFuentePosibleCliente = new ArrayList<Models.clsFuentePosibleCliente>();
//diferente a null , q viene de la lista del controlador 
                                            if (request.getAttribute("lstclsFuentePosiblesClientes") != null) {
                                                lstclsFuentePosibleCliente = (List<Models.clsFuentePosibleCliente>) request.getAttribute("lstclsFuentePosiblesClientes");
                                            }
//for reccorrer los valores de la lista 
                                            for (Models.clsFuentePosibleCliente elem : lstclsFuentePosibleCliente) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsPosiblesClientes.getObclsFuentePosibleCliente() != null ? obclsPosiblesClientes.getObclsFuentePosibleCliente().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                </div>       <!--columna -->
                                <div class="col-md-3">
                                    <label name="lblEstadoPosibleCliente">Estado de posible cliente</label>
                                    <select class="form-control" name="ddlEstadoPosibleCliente">    <!-- lista desplegable -->                                    
                                        <%
                                            List<Models.clsEstadoPosibleCliente> lstclsEstadoPosibleCliente = new ArrayList<Models.clsEstadoPosibleCliente>();

                                            if (request.getAttribute("lstclsEstadoPosiblesClientes") != null) {
                                                lstclsEstadoPosibleCliente = (List<Models.clsEstadoPosibleCliente>) request.getAttribute("lstclsEstadoPosiblesClientes");
                                            }

                                            for (Models.clsEstadoPosibleCliente elem : lstclsEstadoPosibleCliente) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>" 
                                                <%=obclsPosiblesClientes.getObclsEstadoPosibleCliente() != null ? obclsPosiblesClientes.getObclsEstadoPosibleCliente().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripion()%>                                        
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblSector">Sector</label>
                                    <select class="form-control" name="ddlSector">                                       
                                        <%
                                            List<Models.clsSector> lstclsSector = new ArrayList<Models.clsSector>();

                                            if (request.getAttribute("lstclsSectores") != null) {
                                                lstclsSector = (List<Models.clsSector>) request.getAttribute("lstclsSectores");
                                            }

                                            for (Models.clsSector elem : lstclsSector) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%=obclsPosiblesClientes.getObclsSector() != null ? obclsPosiblesClientes.getObclsSector().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblCantidadEmpleados">Cantidad de empleados</label>
                                    <input type="number" placeholder="Ingrese cantidad de empleados" name="txtCantidadEmpleados" class="form-control" value="<%= obclsPosiblesClientes.getInCantidadEmpleados() != 0 ? obclsPosiblesClientes.getInCantidadEmpleados() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblIngresosAnuales">Ingresos anuales</label>
                                    <input type="number" placeholder="Ingrese ingresos anuales" name="txtIngresosAnuales" class="form-control" value="<%= obclsPosiblesClientes.getDbIngresosAnuales() != 0 ? obclsPosiblesClientes.getDbIngresosAnuales() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblCalificacion">Calificacion</label>
                                    <select class="form-control" name="ddlCalificacion">                                        
                                        <%
                                            List<Models.clsCalificacion> lstclsCalificacion = new ArrayList<Models.clsCalificacion>();

                                            if (request.getAttribute("lstclsCalificaciones") != null) {
                                                lstclsCalificacion = (List<Models.clsCalificacion>) request.getAttribute("lstclsCalificaciones");
                                            }

                                            for (Models.clsCalificacion elem : lstclsCalificacion) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%=obclsPosiblesClientes.getObclsCalificacion() != null ? obclsPosiblesClientes.getObclsCalificacion().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblNoParticipacionCorreoElectronico">
                                        <input type="checkbox" name="chkNoParticipacionCorreoElectronico" <%=obclsPosiblesClientes.getChNoParticipacionCorreoElectronico() == 'S' ? "checked" : ""%>/>    
                                        No participacion correo electronico
                                    </label>                                    
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblIDSkype">ID de Skype</label>
                                    <input type="text" placeholder="Ingrese ID de Skype" name="txtIDSkype" class="form-control" value="<%=obclsPosiblesClientes.getStIDSkype() != null ? obclsPosiblesClientes.getStIDSkype() : ""%>"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblTwitter">Twitter</label>
                                    <input type="text" placeholder="Ingrese Twitter" name="txtTwitter" class="form-control" value="<%=obclsPosiblesClientes.getStTwitter() != null ? obclsPosiblesClientes.getStTwitter() : ""%>"/>
                                </div>
                                <div class="col-md-6">
                                    <label name="lblCorreoElectronicoSecundario">Correo electronico secundario</label>
                                    <input type="text" placeholder="Ingresse correo electronico secundario" name="txtCorreoElectronicoSecundario" class="form-control" value="<%=obclsPosiblesClientes.getStCorreoElectronicoSecundario() != null ? obclsPosiblesClientes.getStCorreoElectronicoSecundario() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <!--COLUMNA-->
                                <div class="col-12">
                                    <b>
                                        <i class="fa fa-clipboard"></i>
                                        Registros: <%= lstclsPosiblesClientes.size()%>
                                    </b>

                                </div>

                            </div>
                        </div>
                        <!--FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <table class="table table-bordered 
                                           table-responsive">
                                        <tr> <!--FILA-->
                                            <td>Código</td> <!--COLUMNA-->
                                            <td>Empresa</td>
                                            <td>Nombre</td>
                                            <td>Apellido</td>
                                            <td>Titulo</td>
                                            <td>Correo electronico</td>                                           
                                            <td>Telefono</td>
                                            <td>Fax</td>
                                            <td>Movil</td>
                                            <td>Sitio web</td>
                                            <td>Fuente posible cliente</td>
                                            <td>Estado posible cliente</td>
                                            <td>Sector</td>
                                            <td>Cantidad de empleados</td>
                                            <td>Ingresos anuales</td>
                                            <td>Calificacion</td>
                                            <td>No participacion de correo electronico</td>
                                            <td>ID Skype</td>
                                            <td>Twitter</td>
                                            <td>Correo electronico Secundario</td>
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsPosiblesClientes elem : lstclsPosiblesClientes) {
                                                
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStEmpresa()%></td>
                                            <td><%=elem.getStNombre()%></td>
                                            <td><%=elem.getStApellidos()%></td>
                                            <td><%=elem.getStTitulo()%></td>
                                            <td><%=elem.getStCorreoElectronico()%></td>
                                            <td><%=elem.getStTelefono()%></td>
                                            <td><%=elem.getStFax()%></td>
                                            <td><%=elem.getStMovil()%></td>
                                            <td><%=elem.getStSitioWeb()%></td>
                                            <td><%=elem.getObclsFuentePosibleCliente().getStDescripcion()%></td>
                                            <td><%=elem.getObclsEstadoPosibleCliente().getStDescripion()%></td>
                                            <td><%=elem.getObclsSector().getStDescripion()%></td>
                                            <td><%=elem.getInCantidadEmpleados()%></td>
                                            <td><%=elem.getDbIngresosAnuales()%></td>
                                            <td><%=elem.getObclsCalificacion().getStDescripion()%></td>
                                            <td><%=elem.getChNoParticipacionCorreoElectronico()%></td>
                                            <td><%=elem.getStIDSkype()%></td>
                                            <td><%=elem.getStTwitter()%></td>
                                            <td><%=elem.getStCorreoElectronicoSecundario()%></td>
                                            <td>
                                                <a class="btn btn-success btn-sm" 
                                                   href="PosiblesClientesController?stOpcion=M&codigoSeleccionado=<%=elem.getInCodigo()%>">
                                                    Modificar</a>
                                                <a class="btn btn-danger btn-sm" 
                                                   href="PosiblesClientesController?stOpcion=E&codigoSeleccionado=<%= elem.getInCodigo()%>">
                                                    Eliminar</a>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        %>

                                    </table>
                                </div>
                            </div>                                
                        </div>
                    </form>
                </div>                
            </div>
        </div>
    </body>
</html>

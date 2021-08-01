

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
        <title>Tareas</title>
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
            Models.clsTareas obclsTareas = new Models.clsTareas();

            if (request.getAttribute("obclsTareas") != null) {
                obclsTareas = (Models.clsTareas) request.getAttribute("obclsTareas");
            }

            List<Models.clsTareas> lstclsTareas = new ArrayList<Models.clsTareas>();

            if (request.getAttribute("lstclsTareas") != null) {
                lstclsTareas = (List<Models.clsTareas>) request.getAttribute("lstclsTareas");
            }
        %>

        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Tareas
                    <p>
                        Para que no se quede nada sin hacer, puedes asignar tareas a las conversaciones. Puedes asignarlas tú
                        mismo o a otro trabajador.
                    </p>
                </div>
                <div class="card-body">
                    <form action="TareasController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                    
                                    <input type="text" hidden=""
                                           name="codigoModificar"
                                           value="<%= obclsTareas.getInCodigo()%>"/>                                    
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Información sobre la tarea</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblTitular">Titular de la tarea</label>
                                    <input type="text" placeholder="Ingrese titular de la tarea" name="txtTitular" class="form-control" value="<%=obclsTareas.getStTitular() != null ? obclsTareas.getStTitular() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblAsunto">Asunto</label>
                                    <input type="text" placeholder="Ingrese asunto" name="txtAsunto" class="form-control" value="<%=obclsTareas.getStAsunto() != null ? obclsTareas.getStAsunto() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblFechaVencimiento">Fecha de vencimiento</label>
                                    <input type="date" placeholder="Ingrese fecha de vencimiento" name="txtFechaVencimiento" class="form-control" value="<%=obclsTareas.getStFechaVencimiento() != null ? obclsTareas.getStFechaVencimiento() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblContacto">Contacto</label>
                                    <input type="text" placeholder="Ingrese contacto" name="txtContacto" class="form-control" value="<%=obclsTareas.getStContacto() != null ? obclsTareas.getStContacto() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblCuenta">Cuenta</label>
                                    <input type="text" placeholder="Ingrese cuenta" name="txtCuenta" class="form-control" value="<%=obclsTareas.getStCuenta() != null ? obclsTareas.getStCuenta() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblEstado">Estado</label>
                                    <select class="form-control" name="ddlEstado">                                       
                                        <%
                                            List<Models.clsEstadoTarea> lstclsEstadoTarea = new ArrayList<Models.clsEstadoTarea>();

                                            if (request.getAttribute("lstclsEstadoTarea") != null) {
                                                lstclsEstadoTarea = (List<Models.clsEstadoTarea>) request.getAttribute("lstclsEstadoTarea");
                                            }

                                            for (Models.clsEstadoTarea elem : lstclsEstadoTarea) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsTareas.getObclsEstadoTarea()!= null ? obclsTareas.getObclsEstadoTarea().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                    
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblPrioridad">Prioridad</label>
                                      <select class="form-control" name="ddlPrioridad">                                       
                                        <%
                                            List<Models.clsPrioridad> lstclsPrioridad = new ArrayList<Models.clsPrioridad>();

                                            if (request.getAttribute("lstclsPrioridad") != null) {
                                                lstclsPrioridad = (List<Models.clsPrioridad>) request.getAttribute("lstclsPrioridad");
                                            }

                                            for (Models.clsPrioridad elem : lstclsPrioridad) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsTareas.getObclsPrioridad()!= null ? obclsTareas.getObclsPrioridad().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                    
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6"></div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <label name="lblEnviarMensaje">
                                        <input type="checkbox" name="chkEnviarMensaje" <%=obclsTareas.getChEnviarMensaje() == 'S' ? "checked" : ""%>/>Enviar mensaje de correo electronico de notificacion
                                    </label>
                                </div>
                                <div class="col-md-6">
                                    <label name="lblRepetir">
                                        <input type="checkbox" name="chkRepetir" <%=obclsTareas.getChRepetir() == 'S' ? "checked" : ""%>/>Repetir
                                    </label>
                                </div>                              
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <label name="lblDescripcion">Informacion de la descripcion</label>
                                    <input type="text" placeholder="Ingrese informacion de la descripcion" name="txtDescripcion" class="form-control" value="<%=obclsTareas.getStDescripcion() != null ? obclsTareas.getStDescripcion() : ""%>"/>
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
                                        Registros: <%= lstclsTareas.size()%>
                                    </b>

                                </div>

                            </div>
                        </div>

                        <!--FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <table class="table table-bordered table-responsive">
                                        <tr> <!--FILA-->
                                            <td>Titular</td> <!--COLUMNA-->
                                            <td>Asunto</td>
                                            <td>Fechade Vencimiento</td>
                                            <td>Contacto</td>
                                            <td>Cuenta</td>                                           
                                            <td>Estado Tarea</td>                                          
                                            <td>Prioridad</td>
                                            <td>Enviar Mensaje </td>
                                            <td>Repetir</td>
                                            <td>Descripcion</td>
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsTareas elem : lstclsTareas) {
                                        %>
                                        <tr>
                                            <td><%=elem.getStTitular()%></td>
                                            <td><%=elem.getStAsunto()%></td>
                                            <td><%=elem.getStFechaVencimiento()%></td>
                                            <td><%=elem.getStContacto()%></td>
                                            <td><%=elem.getStCuenta()%></td>
                                            <td><%=elem.getObclsEstadoTarea().getStDescripcion()%></td>
                                            <td><%=elem.getObclsPrioridad().getStDescripcion()%>
                                            <td><%=elem.getChEnviarMensaje()%></td>
                                            <td><%=elem.getChRepetir()%></td>
                                            <td><%=elem.getStDescripcion()%></td>
                                            <td>
                                                <a class="btn btn-success btn-sm" 
                                                   href="TareasController?stOpcion=M&codigoSeleccionado=<%=elem.getInCodigo()%>">
                                                    Modificar</a>
                                                <a class="btn btn-danger btn-sm" 
                                                   href="TareasController?stOpcion=E&codigoSeleccionado=<%= elem.getInCodigo()%>">
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


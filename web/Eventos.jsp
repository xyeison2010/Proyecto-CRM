

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
        <title>Eventos</title>
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
            Models.clsEventos obclsEventos = new Models.clsEventos();

            if (request.getAttribute("obclsEventos") != null) {
                obclsEventos = (Models.clsEventos) request.getAttribute("obclsEventos");
            }

            List<Models.clsEventos> lstclsEventos = new ArrayList<Models.clsEventos>();

            if (request.getAttribute("lstclsEventos") != null) {
                lstclsEventos = (List<Models.clsEventos>) request.getAttribute("lstclsEventos");
            }
        %>

        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">
                    <b>Eventos</b>
                    <p>
                        Los eventos establecen los foros para dar a conocer las tendencias influencian el futuro, 
                        reforzar habilidades en sesiones de trabajo, conocer los principales proveedores y lograr 
                        contactos con otros usuarios, compañeros del entorno y colegas estrechando lazos con sus 
                        contactos o posibles clientes a través de un evento.
                    </p>
                </div>
                <div class="card-body">
                    <form action="EventosController" method="POST">
                       
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                    
                                    <input type="text" hidden=""
                                           name="codigoModificar"
                                           value="<%= obclsEventos.getInCodigo()%>"/>                                    
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Información sobre el evento</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblNombre">Nuevo evento</label>
                                    <input type="text" 
                                           placeholder="Ingrese nuevo evento" 
                                           name="txtNombre" 
                                           class="form-control" value="<%=obclsEventos.getStNombre() != null ? obclsEventos.getStNombre() : ""%>"/> 
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblUbicacion">Ubicación</label>
                                    <input type="text" placeholder="Ingrese ubicación" name="txtUbicacion" class="form-control" value="<%=obclsEventos.getStUbicacion() != null ? obclsEventos.getStUbicacion() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-12">
                                    <label name="lblParticipantes">Participantes</label>
                                    <input type="text" placeholder="Ingrese participantes" name="txtParticipantes" class="form-control" value="<%=obclsEventos.getStParticipantes() != null ? obclsEventos.getStParticipantes() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-12">
                                    <label name="lblTodoDia">
                                        <input type="checkbox" name="chkTodoDia" <%=obclsEventos.getChTodoDia() == 'S' ? "checked" : ""%>/>Todo el dia
                                    </label>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblFecha">Fecha</label>
                                    <input type="date" name="txtFecha" placeholder="Ingrese fecha" class="form-control" value="<%=obclsEventos.getStFecha() != null ? obclsEventos.getStFecha() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblRelacionadoCon">Relacionado con</label>

                                    <select class="form-control" name="ddlRelacionadoCon">                                      
                                        <%
                                            List<Models.clsRelacionadoCon> lstclsRelacionadoCon
                                                    = new ArrayList<Models.clsRelacionadoCon>();

                                            if (request.getAttribute("lstclsRelacionadoCon") != null) {
                                                lstclsRelacionadoCon = (List<Models.clsRelacionadoCon>) request.getAttribute("lstclsRelacionadoCon");
                                            }

                                            for (Models.clsRelacionadoCon elem : lstclsRelacionadoCon) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>" <%= obclsEventos.getObclsRelacionadoCon()!= null
                                                ? obclsEventos.getObclsRelacionadoCon().getInCodigo() == elem.getInCodigo()
                                                ? "selected" : "" : ""%>> <%= elem.getStDescripcion()%>
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
                                <div class="col-md-12">
                                    <label name="lblDescripcion">Informacion de la descripción</label>
                                    <input type="text" placeholder="Ingrese informacion de la descripcion" name="txtDescripcion" class="form-control" value="<%=obclsEventos.getStDescripcion() != null ? obclsEventos.getStDescripcion() : ""%>"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <!--COLUMNA-->
                                <div class="col-12">
                                    <b>
                                        <i class="fa fa-clipboard"></i>
                                        Registros: <%= lstclsEventos.size()%>
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
                                            <td>Código</td> <!--COLUMNA-->
                                            <td>Nombre</td>
                                            <td>Ubicación</td>
                                            <td>Participantes</td>
                                            <td>Todo el día</td>
                                            <td>Fecha</td>
                                            <td>Relacionado con</td>
                                            <td>Descripción</td>
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsEventos elem : lstclsEventos) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStNombre()%></td>
                                            <td><%=elem.getStUbicacion()%></td>
                                            <td><%=elem.getStParticipantes()%></td>
                                            <td><%=elem.getChTodoDia()%></td>
                                            <td><%=elem.getStFecha()%></td>
                                            <td><%=elem.getObclsRelacionadoCon().getStDescripcion()%></td>
                                            <td><%=elem.getStDescripcion()%></td>
                                            <td>
                                                <a class="btn btn-success btn-sm" 
                                                   href="EventosController?stOpcion=M&codigoSeleccionado=<%=elem.getInCodigo()%>">
                                                    Modificar</a>
                                                <a class="btn btn-danger btn-sm" 
                                                   href="EventosController?stOpcion=E&codigoSeleccionado=<%= elem.getInCodigo()%>">
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




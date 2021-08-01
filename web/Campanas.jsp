

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
        <title>Campañas</title>
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
            Models.clsCampanas obclsCampanas = new Models.clsCampanas();

            if (request.getAttribute("obclsCampanas") != null) {
                obclsCampanas = (Models.clsCampanas) request.getAttribute("obclsCampanas");
            }

            List<Models.clsCampanas> lstclsCampanas = new ArrayList<Models.clsCampanas>();

            if (request.getAttribute("lstclsCampanas") != null) {
                lstclsCampanas = (List<Models.clsCampanas>) request.getAttribute("lstclsCampanas");
            }
        %>   
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Campañas
                    <p>
                        Conjunto de actividades o de trabajos que se realizan en un periodo de tiempo determinado y están
                        encaminados a conseguir un fin.
                    </p>
                </div>
                <div class="card-body">
                    <form action="CampanasController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>

                                    <input type="text" name="codigoModificar" id="codigoModificar" 
                                           value="<%=obclsCampanas.getInCodigo()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Información sobre la campaña</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTipo">Tipo</label>
                                    <select class="form-control" name="ddlTipo">                                       
                                        <%
                                            List<Models.clsTipoCampana> lstclsTipoCampana = new ArrayList<Models.clsTipoCampana>();

                                            if (request.getAttribute("lstclsTipoCampana") != null) {
                                                lstclsTipoCampana = (List<Models.clsTipoCampana>) request.getAttribute("lstclsTipoCampana");
                                            }

                                            for (Models.clsTipoCampana elem : lstclsTipoCampana) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsCampanas.getObclsTipoCampana()!= null ? obclsCampanas.getObclsTipoCampana().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombre">Nombre de campaña</label>
                                    <input type="text" placeholder="Ingrese nombre de campaña" name="txtNombre" class="form-control" value="<%=obclsCampanas.getStNombre() != null ? obclsCampanas.getStNombre() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblEstado">Estado</label>
                                    <select class="form-control" name="ddlEstado">                                       
                                        <%
                                            List<Models.clsEstadoCampana> lstclsEstadoCampana = new ArrayList<Models.clsEstadoCampana>();

                                            if (request.getAttribute("lstclsEstadoCampana") != null) {
                                                lstclsEstadoCampana = (List<Models.clsEstadoCampana>) request.getAttribute("lstclsEstadoCampana");
                                            }

                                            for (Models.clsEstadoCampana elem : lstclsEstadoCampana) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsCampanas.getObclsEstadoCampana()!= null ? obclsCampanas.getObclsEstadoCampana().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFechaInicio">Fecha de inicio</label>
                                    <input type="date" placeholder="Ingrese fecha de inicio" name="txtFechaInicio" class="form-control" value="<%=obclsCampanas.getStFechaInicio() != null ? obclsCampanas.getStFechaInicio() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFechaFinalizacion">Fecha de finalización</label>
                                    <input type="date" placeholder="Ingrese fecha de finalización" name="txtFechaFinalizacion" class="form-control" value="<%=obclsCampanas.getStFechaFinalizacion() != null ? obclsCampanas.getStFechaFinalizacion() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblIngresosEsperados">Ingresos esperados</label>
                                    <input type="number" placeholder="Ingrese ingresos esperados" name="txtIngresosEsperados" class="form-control" value="<%=obclsCampanas.getDbIngresosEsperados() != 0 ? obclsCampanas.getDbIngresosEsperados() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblCostePresupuestado">Coste presupuestado</label>
                                    <input type="number" placeholder="Ingrese coste presupuestado" name="txtCostePresupuestado" class="form-control" value="<%=obclsCampanas.getDbCostePresupuestado() != 0 ? obclsCampanas.getDbCostePresupuestado() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblCosteReal">Coste real</label>
                                    <input type="number" placeholder="Ingrese coste real" name="txtCosteReal" class="form-control" value="<%=obclsCampanas.getDbCosteReal() != 0 ? obclsCampanas.getDbCosteReal() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblRespuestaEsperada">Respuesta esperada</label>
                                    <input type="text" placeholder="Ingrese respuesta esperada" name="txtRespuestaEsperada" class="form-control" value="<%=obclsCampanas.getStRespuestaEsperada() != null ? obclsCampanas.getStRespuestaEsperada() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNumerosEnviados">Numeros enviados</label>
                                    <input type="number" placeholder="Ingrese numeros enviados" name="txtNumerosEnviados" class="form-control" value="<%=obclsCampanas.getInNumerosEnviados() != 0 ? obclsCampanas.getInNumerosEnviados() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <label name="lblDescripcion">Descripción</label>
                                    <input type="text" placeholder="Ingrese descripción" name="txtDescripcion" class="form-control" value="<%=obclsCampanas.getStDescripcion() != null ? obclsCampanas.getStDescripcion() : ""%>"/>
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
                                        Registros: <%= lstclsCampanas.size()%>
                                    </b>                                   
                                </div>                               
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <table class="table table-bordered table-responsive">
                                        <tr> <!--FILA-->
                                            <td>Código</td> <!--COLUMNA-->
                                            <td>Tipo</td>
                                            <td>Nombre</td>
                                            <td>Estado</td>
                                            <td>Fecha Inicio</td>
                                            <td>Fecha Final</td>
                                            <td>Ingresos Esperados</td>
                                            <td>Coste Presupuestado</td>                                           
                                            <td>Coste Real</td>
                                            <td>Respuesta esperada</td>
                                            <td>Numeros enviados</td>
                                            <td>Descripcion</td>
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsCampanas elem : lstclsCampanas) {
                                                Models.clsTipoCampana obclsTipoCampana = elem.getObclsTipoCampana();
                                                Models.clsEstadoCampana obclsEstadoCampana = elem.getObclsEstadoCampana();
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.obclsTipoCampana.getStDescripcion()%></td>
                                            <td><%=elem.getStNombre()%></td>
                                            <td><%=elem.obclsEstadoCampana.getStDescripcion()%></td>
                                            <td><%=elem.getStFechaInicio()%></td>
                                            <td><%=elem.getStFechaFinalizacion()%></td>
                                            <td><%=elem.getDbIngresosEsperados()%></td>
                                            <td><%=elem.getDbCostePresupuestado()%></td>
                                            <td><%=elem.getDbCosteReal()%></td>
                                            <td><%=elem.getStRespuestaEsperada()%></td>
                                            <td><%=elem.getInNumerosEnviados()%></td>
                                            <td><%=elem.getStDescripcion()%></td>
                                            <td>
                                                <a class="btn btn-success btn-sm" 
                                                   href="CampanasController?stOpcion=M&codigoSeleccionado=<%=elem.getInCodigo()%>">
                                                    Modificar</a>
                                                <a class="btn btn-danger btn-sm" 
                                                   href="CampanasController?stOpcion=E&codigoSeleccionado=<%= elem.getInCodigo()%>">
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





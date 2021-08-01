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
        <title>Tratos</title>
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
          
            Models.clsTratos obclsTratos = new Models.clsTratos();
           
            if (request.getAttribute("obclsTratos") != null) {
                obclsTratos = (Models.clsTratos) request.getAttribute("obclsTratos");
            }

            List<Models.clsTratos> lstclsTratos = new ArrayList<Models.clsTratos>();

            if (request.getAttribute("lstclsTratos") != null) {
                lstclsTratos = (List<Models.clsTratos>) request.getAttribute("lstclsTratos");
            }
        %>
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Tratos - Registros: (<%=lstclsTratos.size()%>)
                    <p>
                        En caso de que esas conversaciones sean ventas, puedes abrir un trato con ese
                        contacto.
                    </p>
                </div>

                <div class="card-body">
                    <form action="TratosController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                  
                                    <input type="text"
                                           name="codigoModificar"
                                           value="<%=obclsTratos.getInCodigo() != 0
                                                   ? obclsTratos.getInCodigo() : ""%>"
                                           hidden=""/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Información sobre el trato</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblImporte">Importe</label>
                                    <input type="text" placeholder="Ingrese importe" name="txtImporte" 
                                           class="form-control" 
                                           value="<%=obclsTratos.getStImporte() != null ? obclsTratos.getStImporte() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombre">Nombre de trato</label>
                                    <input type="text" placeholder="Ingrese nombre de trato" name="txtNombre" class="form-control" value="<%=obclsTratos.getStNombre() != null ? obclsTratos.getStNombre() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFechaCierre">Fecha de cierre</label>
                                    <input type="date" name="txtFechaCierre" placeholder="Ingrese fecha de cierre" class="form-control" value="<%=obclsTratos.getStFechaCierre() != null ? obclsTratos.getStFechaCierre() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNumeroCuenta">Numero de cuenta</label>
                                    <input type="text" placeholder="Ingrese numero de cuenta" name="txtNumeroCuenta" class="form-control" value="<%=obclsTratos.getStNumeroCuenta() != null ? obclsTratos.getStNumeroCuenta() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFase">Fase</label>
                                    <select class="form-control" name="ddlFase">                                       
                                        <%
                                            List<Models.clsFaseTrato> lstclsFaseTrato = new ArrayList<Models.clsFaseTrato>();

                                            if (request.getAttribute("lstclsFaseTrato") != null) {
                                                lstclsFaseTrato = (List<Models.clsFaseTrato>) request.getAttribute("lstclsFaseTrato");
                                            }

                                            for (Models.clsFaseTrato elem : lstclsFaseTrato) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsTratos.getObclsFaseTrato()!= null ? obclsTratos.getObclsFaseTrato().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTipo">Tipo</label>
                                    <select class="form-control" name="ddlTipo">                                       
                                        <%
                                            List<Models.clsTipoTrato> lstclsTipoTrato = new ArrayList<Models.clsTipoTrato>();

                                            if (request.getAttribute("lstclsTipoTrato") != null) {
                                                lstclsTipoTrato = (List<Models.clsTipoTrato>) request.getAttribute("lstclsTipoTrato");
                                            }

                                            for (Models.clsTipoTrato elem : lstclsTipoTrato) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsTratos.getObclsTipoTrato()!= null ? obclsTratos.getObclsTipoTrato().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                    
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblProbabilidad">Probabilidad</label>
                                    <input type="number" placeholder="Ingrese probabilidad" name="txtProbabilidad" class="form-control" value="<%=obclsTratos.getDbProbabilidad()%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblSiguientePaso">Siguiente paso</label>
                                    <input type="text" placeholder="Ingrese siguiente paso" name="txtSiguientePaso" class="form-control" value="<%=obclsTratos.getStSiguientePaso() != null ? obclsTratos.getStSiguientePaso() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblIngresosEsperados">Ingresos esperados</label>
                                    <input type="number" placeholder="Ingrese ingresos esperados" name="txtIngresosEsperados" class="form-control" value="<%=obclsTratos.getDbIngresosEsperados()%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFuentePosibleCliente">Fuente de posible cliente</label>
                                    <select class="form-control" name="ddlFuentePosibleCliente">                                       
                                        <%
                                            List<Models.clsFuentePosibleCliente> lstclsFuentePosibleCliente = new ArrayList<Models.clsFuentePosibleCliente>();

                                            if (request.getAttribute("lstclsFuentePosibleCliente") != null) {
                                                lstclsFuentePosibleCliente = (List<Models.clsFuentePosibleCliente>) request.getAttribute("lstclsFuentePosibleCliente");
                                            }

                                            for (Models.clsFuentePosibleCliente elem : lstclsFuentePosibleCliente) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>"
                                                <%= obclsTratos.getObclsFuentePosibleCliente()!= null ? obclsTratos.getObclsFuentePosibleCliente().getInCodigo() == elem.getInCodigo() ? "selected" : "" : ""%>>
                                            <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select> 
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFuenteCampana">Fuente de campaña</label>
                                    <input type="text" placeholder="Ingrese fuente de campaña" name="txtFuenteCampana" class="form-control" value="<%=obclsTratos.getStFuenteCampaña() != null ? obclsTratos.getStFuenteCampaña() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombreContacto">Nombre de contacto</label>
                                    <input type="text" placeholder="Ingrese nombre de contacto" name="txtNombreContacto" class="form-control" value="<%=obclsTratos.getStNombreContacto() != null ? obclsTratos.getStNombreContacto() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-12">
                                    <label name="lblDescripcion">Descripción</label>
                                    <input type="text" placeholder="Ingrese descripción" name="txtDescripcion" class="form-control" value="<%=obclsTratos.getStDescripcion() != null ? obclsTratos.getStDescripcion() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-12">
                                    <table class="table table-bordered table-responsive">
                                        <tr> <!--FILA-->
                                            <td>Codigo</td>
                                            <td>Importe</td> <!--COLUMNA-->
                                            <td>Nombre</td>
                                            <td>Fecha de Cierre</td>
                                            <td>N˙mero de Cuenta</td>
                                            <td>Fase Trato</td>
                                            <td>Tipo Trato</td>
                                            <td>Probabilidad</td>
                                            <td>Siguiente Paso</td>
                                            <td>Ingresos Esperados</td>
                                            <td>Fuente Posible Cliente</td>
                                            <td>Fuente Campaña</td>
                                            <td>Nombre de Contacto</td>
                                            <td>Descripción</td>
                                            <td>Opciones</td>
                                        </tr>

                                        <%
                                            for (Models.clsTratos elem : lstclsTratos) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getStImporte()%></td>
                                            <td><%=elem.getStNombre()%></td>
                                            <td><%=elem.getStFechaCierre()%></td>
                                            <td><%=elem.getStNumeroCuenta()%></td>
                                            <td><%=elem.obclsFaseTrato.getStDescripcion()%></td>
                                            <td><%=elem.obclsTipoTrato.getStDescripcion()%></td>
                                            <td><%=elem.getDbProbabilidad()%></td>
                                            <td><%=elem.getStSiguientePaso()%></td>
                                            <td><%=elem.getDbIngresosEsperados()%></td>
                                            <td><%=elem.obclsFuentePosibleCliente.getStDescripcion()%></td>
                                            <td><%=elem.getStFuenteCampaña()%></td>
                                            <td><%=elem.getStNombreContacto()%></td>
                                            <td><%=elem.getStDescripcion()%></td>
                                            <td>
                                                <a href="TratosController?stOpcion=M&codigoSeleccionado=<%=elem.getInCodigo()%>"
                                                   class="btn btn-success btn-sm">
                                                    Modificar</a>
                                                <a href="TratosController?stOpcion=E&codigoSeleccionado=<%=elem.getInCodigo()%>"
                                                   class="btn btn-danger btn-sm">
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
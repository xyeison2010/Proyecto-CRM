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
        <title>Contactos</title>
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
            List<Models.clsContactos> lstclsContactos = new ArrayList<Models.clsContactos>();
            Models.clsContactos obclsContactos = new Models.clsContactos();

            if (request.getAttribute("obclsContactos") != null) {
                obclsContactos = (Models.clsContactos) request.getAttribute("obclsContactos");
            }

            if (request.getAttribute("lstclsContactos") != null) {
                lstclsContactos = (List<Models.clsContactos>) request.getAttribute("lstclsContactos");
            }
        %>        
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Contacto
                    <p>
                        Todos los contactos en un listado para poder acceder a todas las conversaciones, llamadas, tareas,
                        tratos y campañas con ese cliente en un solo clic.
                    </p>
                </div>
                <div class="card-body">
                    <form action="ContactosController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>
                                  
                                    <input type="text" hidden=""
                                           name="codigoModificar"
                                           value="<%= obclsContactos.getInCodigo()%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Información sobre el contacto</h1>                                
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFuentePosibleCliente">Fuente de posible cliente</label>
                                    <select class="form-control" name="ddlFuentePosibleCliente">                                      
                                        <%
                                            List<Models.clsFuentePosibleCliente> lstclsFuenteDePosibleCliente
                                                    = new ArrayList<Models.clsFuentePosibleCliente>();

                                            if (request.getAttribute("lstclsFuentePosibleCliente") != null) {
                                                lstclsFuenteDePosibleCliente
                                                        = (List<Models.clsFuentePosibleCliente>) request.getAttribute("lstclsFuentePosibleCliente");
                                            }

                                            for (Models.clsFuentePosibleCliente elem : lstclsFuenteDePosibleCliente) {
                                        %>
                                        <option value="<%= elem.getInCodigo()%>" <%= obclsContactos.getObclsFuentePosibleCliente() != null
                                                ? obclsContactos.getObclsFuentePosibleCliente().getInCodigo() == elem.getInCodigo()
                                                ? "selected" : "" : ""%>> <%= elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombre">Nombres</label>
                                    <input type="text" placeholder="Ingrese nombres" name="txtNombre" class="form-control"
                                           value="<%= obclsContactos.getStNombres() != null ? obclsContactos.getStNombres() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblApellidos">Apellidos</label>
                                    <input type="text" placeholder="Ingrese apellidos" name="txtApellidos" class="form-control"
                                           value="<%= obclsContactos.getStApellidos() != null ? obclsContactos.getStApellidos() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNumeroCuenta">Numero de cuenta</label>
                                    <input type="text" placeholder="Ingrese numero de cuenta" name="txtNumeroCuenta" class="form-control"
                                           value="<%= obclsContactos.getStNumeroCuenta() != null ? obclsContactos.getStNumeroCuenta() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTitulo">Titulo</label>
                                    <input type="text" placeholder="Ingrese titulo" name="txtTitulo" class="form-control"
                                           value="<%= obclsContactos.getStTitulo() != null ? obclsContactos.getStTitulo() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblCorreoElectronico">Correo electronico</label>
                                    <input type="email" placeholder="Ingrese correo electronico" name="txtCorreoElectronico" class="form-control"
                                           value="<%= obclsContactos.getStCorreo() != null ? obclsContactos.getStCorreo() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblDepartamento">Departamento</label>
                                    <input type="text" placeholder="Ingrese departamento" name="txtDepartamento" class="form-control"
                                           value="<%= obclsContactos.getStDepartamento() != null ? obclsContactos.getStDepartamento() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTelefono">Telefono</label>
                                    <input type="text" placeholder="Ingrese relefono" name="txtTelefono" class="form-control"
                                           value="<%= obclsContactos.getStTelefono() != null ? obclsContactos.getStTelefono() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTelefonoParticular">Telefono particular</label>
                                    <input type="text" placeholder="Ingrese telefono particular" name="txtTelefonoParticular" class="form-control"
                                           value="<%= obclsContactos.getStTelefonoParticular() != null ? obclsContactos.getStTelefonoParticular() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblOtroTelefono">Otro telefono</label>
                                    <input type="number" placeholder="Ingrese otro telefono" name="txtOtroTelefono" class="form-control"
                                           value="<%= obclsContactos.getStOtroTelefono() != null ? obclsContactos.getStOtroTelefono() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFax">Fax</label>
                                    <input type="text" placeholder="Ingrese fax" name="txtFax" class="form-control"
                                           value="<%= obclsContactos.getStFax() != null ? obclsContactos.getStFax() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblMovil">Movil</label>
                                    <input type="text" placeholder="Ingrese movil" name="txtMovil" class="form-control"
                                           value="<%= obclsContactos.getStMovil() != null ? obclsContactos.getStMovil() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFechaNacimiento">Fecha de nacimiento</label>
                                    <input type="date" name="txtFechaNacimiento" class="form-control" placeholder="Ingrese fecha de nacimiento"
                                           value="<%= obclsContactos.getStFechaNacimiento() != null ? obclsContactos.getStFechaNacimiento() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblAsistente">Asistente</label>
                                    <input type="text" placeholder="Ingrese asistente" name="txtAsistente" class="form-control"
                                           value="<%= obclsContactos.getStAsistente() != null ? obclsContactos.getStAsistente() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTelefonoAsistente">N° de telefono del asistente</label>
                                    <input type="text" placeholder="Inhrese n° de telefono del asistente" name="txtTelefonoAsistente" class="form-control"
                                           value="<%= obclsContactos.getStTelefonoAsistente() != null ? obclsContactos.getStTelefonoAsistente() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblRespondeA">Responde a</label>
                                    <input type="text" placeholder="Ingrese responde a" name="txtRespondeA" class="form-control"
                                           value="<%= obclsContactos.getStRespondeA() != null ? obclsContactos.getStRespondeA() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNoParticipacionCorreoElectronico">
                                        <input type="checkbox" name="chkNoParticipacionCorreoElectronico"
                                               <%= obclsContactos.getChNoParticipacionCorreo() == 'S' ? "checked" : ""%>/>    
                                        No participacion correo electronico
                                    </label>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblIDSkype">ID de Skype</label>
                                    <input type="text" placeholder="Ingrese ID de Skype" name="txtIDSkype" class="form-control"
                                           value="<%= obclsContactos.getStIdSkype() != null ? obclsContactos.getStIdSkype() : ""%>"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblCorreoElectronicoSecundario">Correo electronico secundario</label>
                                    <input type="text" placeholder="Ingrese correo electronico secundario" name="txtCorreoElectronicoSecundario" class="form-control"
                                           value="<%= obclsContactos.getStCorreoSecundario() != null ? obclsContactos.getStCorreoSecundario() : ""%>"/>
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
                                        Registros: <%= lstclsContactos.size()%>
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
                                            <td>Fuente posible cliente</td>
                                            <td>Nombre</td>
                                            <td>Apellido</td>
                                            <td>Numero de Cuenta</td>
                                            <td>Titulo</td>
                                            <td>Correo Electronico</td>
                                            <td>Departamento</td>
                                            <td>Telefono</td>
                                            <td>Telefono Particular</td>
                                            <td>Otro Telefono</td>
                                            <td>Fax</td>
                                            <td>Movil</td>
                                            <td>Fecha de Nacimiento</td>
                                            <td>Asistente</td>
                                            <td>Nº de telefono de asistente</td>
                                            <td>Responde A</td>
                                            <td>No participacion de correo</td>
                                            <td>Id Skype</td>
                                            <td>Opciones</td>
                                            <td>Correo Electronico Secundario</td>
                                        </tr>

                                        <%
                                            for (Models.clsContactos elem : lstclsContactos) {
                                        %>
                                        <tr>
                                            <td><%=elem.getInCodigo()%></td>
                                            <td><%=elem.getObclsFuentePosibleCliente().getStDescripcion()%></td>
                                            <td><%=elem.getStNombres()%></td>
                                            <td><%=elem.getStApellidos()%></td>
                                            <td><%=elem.getStNumeroCuenta()%></td>
                                            <td><%=elem.getStTitulo()%></td>
                                            <td><%=elem.getStCorreo()%></td>
                                            <td><%=elem.getStDepartamento()%></td>
                                            <td><%=elem.getStTelefono()%></td>
                                            <td><%=elem.getStTelefonoParticular()%></td>
                                            <td><%=elem.getStOtroTelefono()%></td>
                                            <td><%=elem.getStFax()%></td>
                                            <td><%=elem.getStMovil()%></td>
                                            <td><%=elem.getStFechaNacimiento()%></td>
                                            <td><%=elem.getStAsistente()%></td>
                                            <td><%=elem.getStTelefonoAsistente()%></td>
                                            <td><%=elem.getStRespondeA()%></td>
                                            <td><%=elem.getChNoParticipacionCorreo()%></td>
                                            <td><%=elem.getStIdSkype()%></td>
                                            <td><%=elem.getStCorreoSecundario()%></td>
                                            <td>
                                                <a class="btn btn-success btn-sm" 
                                                   href="ContactosController?stOpcion=M&codigoSeleccionado=<%= elem.getInCodigo()%>">
                                                    Modificar</a>
                                                <a class="btn btn-danger btn-sm" 
                                                   href="ContactosController?stOpcion=E&codigoSeleccionado=<%= elem.getInCodigo()%>">
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




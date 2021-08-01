

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Index</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <!-- Page level plugin JavaScript-->
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/datatables/jquery.dataTables.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin.min.js"></script>
        <!-- Custom scripts for this page-->
        <script src="js/sb-admin-datatables.min.js"></script>
        <script src="js/sb-admin-charts.min.js"></script>

    <Script>
        function loadOption(option){
            document.getElementById('frame').src = option;
        }
    </Script>
    
    <style>
        iframe{
            width: 100%;
            height: 900px;
        }
    </style>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
        <a class="navbar-brand" href="Index.jsp">CRM</a>
        <!--esta es la rayita pa q se achike y agrande -->
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Posibles clientes">
                    <a class="nav-link"
                       onclick="loadOption('PosiblesClientesController?btnConsultar=true')">
                        <i class="fa fa-fw fa-address-book"></i>
                        <span class="nav-link-text">Posibles clientes</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tareas">
                    <a class="nav-link" 
                       onclick="loadOption('TareasController?btnConsultar=true')">
                        <i class="fa fa-fw fa-address-book"></i>
                        <span class="nav-link-text">Tareas</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Eventos">
                    <a class="nav-link"
                       onclick="loadOption('EventosController?btnConsultar=true')">
                        <i class="fa fa-fw fa-address-book"></i>
                        <span class="nav-link-text">Eventos</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Llamadas">
                    <a class="nav-link" 
                       onclick="loadOption('LlamadasController?btnConsultar=true')">
                        <i class="fa fa-fw fa-address-book"></i>
                        <span class="nav-link-text">Llamadas</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Contactos">
                    <a class="nav-link" 
                       onclick="loadOption('ContactosController?btnConsultar=true')">
                        <i class="fa fa-fw fa-address-book"></i>
                        <span class="nav-link-text">Contactos</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tratos">
                    <a class="nav-link" 
                       onclick="loadOption('TratosController?btnConsultar=true')">
                        <i class="fa fa-fw fa-address-book"></i>
                        <span class="nav-link-text">Tratos</span>
                    </a>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Campañas">
                    <a class="nav-link" 
                       onclick="loadOption('CampanasController?btnConsultar=true')">
                        <i class="fa fa-fw fa-address-book"></i>
                        <span class="nav-link-text">Campañas</span>
                    </a>
                </li>
            </ul>     
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="Login.jsp">
                        <i class="fa fa-fw fa-sign-out"></i>Salir</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="content-wrapper">
        <div class="container-fluid">
            <iframe id="frame" frameborder="0"></iframe>
        </div>
        <!-- /.container-fluid-->
        <!-- /.content-wrapper-->
        <footer class="sticky-footer">
            <div class="container">
                <div class="text-center">
                    <small>Copyright © CRM 2018</small>
                </div>
            </div>
        </footer>               
    </div>
</body>
</html>

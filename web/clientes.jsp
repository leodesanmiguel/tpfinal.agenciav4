<%-- 
    Document   : empleado
    Created on : 5 dic. 2021, 23:15:34
    Author     : Leo Martinez
--%>

<%@page import="agenciav4.logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="agenciav4.logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<!--
        Traveler by freehtml5.co
        Twitter: http://twitter.com/fh5co
        URL: http://freehtml5.co
-->
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Leo Martinez 20754731 &mdash; Trabajo Integrador 2021 - comisión 2 </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Leo Martinez 20754731 - Trabajo Integrador 2021 - comisión 2 " />
        <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
        <meta name="author" content="FreeHTML5.co" />

        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content="" />
        <meta property="og:image" content="" />
        <meta property="og:url" content="" />
        <meta property="og:site_name" content="" />
        <meta property="og:description" content="" />
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">

        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Themify Icons-->
        <link rel="stylesheet" href="css/themify-icons.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="css/bootstrap.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/bootstrap-datepicker.min.css">

        <!-- Owl Carousel  -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="css/style.css">

        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
            <script src="js/respond.min.js"></script>
            <![endif]-->
        <!-- DATA TABLE -->
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">	
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.1/css/all.min.css" integrity="sha512-9my9Mb2+0YO+I4PUCSwUYO7sEK21Y0STBAiFEYoWtd2VzLEZZ4QARDrZ30hdM1GlioHJ8o8cWQiy8IAb1hy/Hg==" crossorigin="anonymous" referrerpolicy="no-referrer" />


    </head>

    <body>
        <%
            String user = (String) request.getSession().getAttribute("user");
            String pass = (String) request.getSession().getAttribute("pass");
            if (user == null && pass == null) {
                response.sendRedirect("inicial.jsp");
            }

        %>
        <div class="gtco-loader"></div>

        <div id="page">


            <!-- <div class="page-inner"> -->
            <nav class="gtco-nav" role="navigation">
                <div class="gtco-container">

                    <div class="row">
                        <div class="col-sm-4 col-xs-12">
                            <div id="gtco-logo"><a href="index.jsp">Agencia POLO <em>.</em></a></div>
                        </div>
                        <div class="col-xs-8 text-right menu-1">
                            <ul>
                                <li class="has-dropdown">
                                    <a href="clientes.jsp">Clientes</a>
                                    <ul class="dropdown">
                                        <li><a href="crearCliente.jsp">Nuevo</a></li>
                                        <li><a href="#"></a></li>
                                    </ul>

                                </li>
                                <li class="has-dropdown">
                                    <a href="#">Ventas</a>
                                    <ul class="dropdown">
                                        <li><a href="ventasind.jsp">Individual</a></li>
                                        <li><a href="ventaspaq.jsp">Paquete</a></li>
                                    </ul>
                                </li>
                                <li><a href="pricing.jsp">Precios</a></li>
                                <li><a href="contact.jsp">Contacto</a></li>
                                <li class="has-dropdown">
                                    <a href="#">Admin</a>
                                    <ul class="dropdown">
                                        <li><a href="empleados.jsp">Empleados</a></li>
                                        <li><a href="servicios.jsp">Servicios</a></li>
                                        <li><a href="paquetes.jsp">Paquetes</a></li>
                                        <li><a href="ventas.jsp">Ventas</a></li>
                                    </ul>
                                </li>

                            </ul>
                        </div>
                    </div>


                </div>
            </nav>

            <header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" style="background-image: url(images/img_6.jpg)">
                <div class="overlay"></div>
                <div class="gtco-container">
                    <div class="row">
                        <div class="col-md-12 col-md-offset-0 text-center">
                            <div class="row row-mt-15em">

                                <div class="col-md-12 mt-text animate-box" data-animate-effect="fadeInUp">
                                    <h1>Clientes</h1>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </header>

            <div class="gtco-section">
                <div class="gtco-container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2 text-center gtco-heading">
                            <h2>Listado de Clientes</h2>
                            <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                        </div>
                    </div>

                    <!-- TABLA DE CLIENTES-->
                    <%
                        Controladora ctrl = new Controladora();
                        List<Cliente> css = ctrl.obtenerClientes();
                    %>
                    <%  %>

                    <div class="row">
                        <div class="table-responsive">
                            <table id="userList" class="table table-bordered table-hover table-striped">
                                <thead class="thead-light">
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Nombre y Apellido</th>
                                        <th scope="col">D.N.I</th>
                                        <th scope="col">telefono</th>
                                        <th scope="col">E-mail</th>
                                        <th><i class="fas fa-edit"> </i> </th>
                                        <th><i class="fas fa-user-times"> </i> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Cliente c : css) {%>

                                    <tr>
                                        <th scope="row"><%= c.getIdPersona() + ""%></th>
                                        <td><%= c.getNombreP() + " " + c.getApellidoP()%></td>
                                        <td><%= "" + c.getDni() + ""%></td>
                                        <td><%= c.getCelular()%></td>
                                        <td><%= c.getEmail()%></td>
                                        <td>
                                            <form name="modif" action="SvEditarClie" method="POST" >
                                                <input
                                                    type="hidden" name="dni" value="<%=c.getDni()%>">

                                                <input type="submit" class="btn btn-danger" value="Editar">

                                            </form>
                                        </td>
                                        <td>
                                            <form name="borra" action="SvBorrarClie" method="POST" >
                                                <input
                                                    type="hidden" name="dni" value="<%=c.getDni()%>">

                                                <input type="submit" class="btn btn-danger" value="Borrar">



                                            </form>
                                        </td>

                                    </tr>
                                    <% }%>

                                </tbody>
                            </table>
                        </div>



                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <a href="crearCliente.jsp" class="btn active btn-lg btn-info" type="button">Crear Nuevo Cliente</a>
                        </div>
                    </div>         

                </div>
            </div>



            <div id="gtco-subscribe">
                <div class="gtco-container">
                    <div class="row animate-box">
                        <div class="col-md-8 col-md-offset-2 text-center gtco-heading">
                            <h2>Subscribe</h2>
                            <p>Sea el primero en conocer los nuevos paquetes turisticos.</p>
                        </div>
                    </div>
                    <div class="row animate-box">
                        <div class="col-md-8 col-md-offset-2">
                            <form class="form-inline" action=>
                                <div class="col-md-6 col-sm-6">
                                    <div class="form-group">
                                        <label for="email" class="sr-only">Email</label>
                                        <input type="email" class="form-control" id="email" placeholder="Su correo electrónico">
                                    </div>
                                </div>
                                <div class="col-md-6 col-sm-6">
                                    <button type="submit" class="btn btn-default btn-block">Subscribe</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <footer id="gtco-footer" role="contentinfo">
                <div class="gtco-container">
                    <div class="row row-p	b-md">

                        <div class="col-md-4">
                            <div class="gtco-widget">
                                <h3>Sobre Nosotros</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore eos molestias quod sint ipsum possimus temporibus officia iste perspiciatis consectetur in fugiat repudiandae cum. Totam cupiditate nostrum ut neque ab?</p>
                            </div>
                        </div>

                        <div class="col-md-2 col-md-push-1">
                            <div class="gtco-widget">
                                <h3>Destinos</h3>
                                <ul class="gtco-footer-links">
                                    <li><a href="#">Viaje al Exterior</a></li>
                                    <li><a href="#">Viejae por Argentina</a></li>
                                    <li><a href="#">Turismo Aventura></li>
                                    <li><a href="#">Turismo Gastronomico</a></li>
                                    <li><a href="#">Viaje Directo</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-2 col-md-push-1">
                            <div class="gtco-widget">
                                <h3>Hotels</h3>
                                <ul class="gtco-footer-links">
                                    <li><a href="#">NH Mendoza Cordillera</a></li>
                                    <li><a href="#">Sheraton Mendoza</a></li>
                                    <li><a href="#">Mercure Iguazu Hotel Iru</a></li>
                                    <li><a href="#">Casita Suiza</a></li>
                                    <li><a href="#">Loi Suites Iguazú</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="col-md-3 col-md-push-1">
                            <div class="gtco-widget">
                                <h3>Contacta a nuestros Operadores</h3>
                                <ul class="gtco-quick-contact">
                                    <li><a href="#"><i class="icon-phone"></i> +54 123 456 789</a></li>
                                    <li><a href="#"><i class="icon-mail2"></i> info@agenciapolo.com.ar</a></li>
                                    <li><a href="#"><i class="icon-chat"></i> Habla por Chat!</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>

                    <div class="row copyright">
                        <div class="col-md-12">
                            <p class="pull-left">
                                <small class="block">&copy; 2021 Leo Martinez. All Rights Reserved.</small>
                                <small class="block">Diseñando por <a href="https://freehtml5.co/" target="_blank">FreeHTML5.co</a> Composición: <a href="#" target="_blank">Leo Martinez</a> Profesora: <a href="#" target="_blank">Ing. Luisina de Paula</a> </small>
                                <small class="block">Trabajo Inttegrador. Comisión Nº2.</small>
                            </p>
                            <p class="pull-right">
                            <ul class="gtco-social-icons pull-right">
                                <li><a href="#"><i class="icon-twitter"></i></a></li>
                                <li><a href="#"><i class="icon-facebook"></i></a></li>
                                <li><a href="#"><i class="icon-linkedin"></i></a></li>
                                <li><a href="#"><i class="icon-dribbble"></i></a></li>
                            </ul>
                            </p>
                        </div>
                    </div>

                </div>
            </footer>
            <!-- </div> -->

        </div>

        <div class="gototop js-top">
            <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
        </div>

        <script type="text/javascript">
            $(document).Ready(function () {
                Make sure that the ID you gave to the table is equal to the text after the symbol #
                        $(' #userList ').DataTable();
            });
        </script>


        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- jQuery Easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Waypoints -->
        <script src="js/jquery.waypoints.min.js"></script>
        <!-- Carousel -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- countTo -->
        <script src="js/jquery.countTo.js"></script>

        <!-- Stellar Parallax -->
        <script src="js/jquery.stellar.min.js"></script>

        <!-- Magnific Popup -->
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>

        <!-- Datepicker -->
        <script src="js/bootstrap-datepicker.min.js"></script>


        <!-- Main -->
        <script src="js/main.js"></script>

    </body>

</html>
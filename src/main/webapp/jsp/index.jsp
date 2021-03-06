<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Inicio</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.3/normalize.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Oswald|PT+Sans" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/css/main.css">
    <title>Inicio</title>
</head>

<body class="index">

    <header class="site-header">
        <div class="hero">
            <div class="contenido-header">
                <nav class="redes-sociales">
                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-pinterest-p" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                </nav>
                <div class="informacion-evento">
                    <div class="clearfix">
                        <p class="fecha"><i class="fa fa-calendar" aria-hidden="true"></i> 20-21 Sep</p>
                        <p class="ciudad"><i class="fa fa-map-marker" aria-hidden="true"></i> Ecuador</p>
                    </div>

                    <h1 class="nombre-sitio">PubliSubasta</h1>
                    <p class="slogan">Subastas Públicas <span>Limpias y Justas</span></p>
                    <a href="#loggin-inicio" class="button btn-loggin">LogIn</a>
                </div>
                <!--.informacion-->

            </div>
        </div>
        <!--.hero-->
    </header>
    <section  id="loggin-inicio" class="seccion contenedor">
        <h2>Ingresa en tu cuenta para encontrar los requerimientos disponibles</h2>
        <form id="registro" class="registro" action="LoginController" method="POST">
            <div id="datos_usuario" class="registro caja clearfix">
                <div class="campo">
                    
                    <input type="text" id="email" name="email" placeholder="Ingrese su Cédula">
                </div>
                <div class="campo">
                    
                    <input type="password" id="password" name="password" placeholder="Ingrese su Contraseña">
                </div>
                <input id="btnIngresar" type="submit" name="submit" class="button" value="Ingresar">
                <div id="error"></div>
            </div>
            <!--#datos_usuario-->

        </form>
    </section>
    <!--seccion-->

    <footer class="site-footer">
        <div class="contenedor clearfix">
            <div class="footer-informacion">
                <h3>Sobre <span>publisubasta</span></h3>
                <p>Praesent rutrum efficitur pharetra. Vivamus scelerisque pretium velit, id tempor turpis pulvinar et. Ut bibendum finibus massa non molestie. Curabitur urna metus, placerat gravida lacus ut, lacinia congue orci. Maecenas luctus mi at ex
                    blandit vehicula. Morbi porttitor tempus euismod.</p>
            </div>
            <div class="ultimos-tweets">
                <h3>Últimos <span>proyectos</span></h3>
                <a class="twitter-timeline" data-height="400" data-theme="light" data-link-color="#fe4918" href="#">Plataforma Gubernamental</a>
                
            </div>
            <div class="menu">
                <h3>Redes <span>sociales</span></h3>
                <nav class="redes-sociales">
                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-pinterest-p" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a>
                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                </nav>
            </div>
        </div>

        <p class="copyright">
            Todos los derechos Reservados PUBLISUBASTA 2021.
        </p>
    </footer>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lettering.js/0.7.0/jquery.lettering.min.js"></script>
    <script src="${pageContext.request.contextPath}/jsp/js/main.js"></script>
    </body>
</html>
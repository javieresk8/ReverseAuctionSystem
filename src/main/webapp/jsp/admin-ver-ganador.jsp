<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/css/bootstrap.min.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Raleway:100,400"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/css/custom.css" />
    <title>Ganador Subasta</title>
  </head>
  <body>
    <div class="container">
      <header>
        <h1 class="text-center">Ha Terminado la Subasta</h1>
      </header>
      
        <div class="contenido-principal">
          <div class="row">
            <div class="contenido primario col">
              <h2 class="text-center">El Ganador de la Subasta es</h2>
              <div class="row">
                
                  <div class="text-center col">
                    <h3 class="text-success">Razón Social</h3>
                    <p class="font-size-large">${ofertante.nombre} ${ofertante.apellido}</p>
                    <h3 class="text-success">Oferta Final Ganadora</h3>
                    <p class="font-weight-bold">${ofertante.sumaOfertas} $</p>
                  </div>
                

              </div>
              <!--requerimientos-->
              <div class="row mt-4 justify-content-center">
                <div class="col-3">
                  <a href = "LogoutController"class="btn btn-warning col">Salir</a>
                </div>
              </div>
            </div>
            <!--.contenido-->
          </div>
          <!--.row-->
        </div>
     
      
    </div>
  </body>
</html>

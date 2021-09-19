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
    <title>Administrar Requerimientos</title>
  </head>
  <body>
    <div class="container">
      <header>
        <h1 class="text-center">Bienvenido</h1>
      </header>
      
        <div class="contenido-principal">
          <div class="row">
            <div class="contenido primario col">
              <h2 class="text-center">Administra tus requerimientos</h2>
              <div class="row">
                <c:forEach var="requerimiento" items="${requerimientos}">
            		<div class="card col-4 mt-3">
	                    <h2 class="card-title font-weight-bold">${requerimiento.nombre}</h2>
	                    <p>
	                      <span class="font-weight-bold">Descripción:</span> ${requerimiento.descripcion} 
	                    </p>
                  </div>
            	</c:forEach> 
              </div>
              <!--requerimientos-->
              <div class="row mt-4 justify-content-center">
              	<div class="col-3 ">
                  <a href="LogoutController" class="btn btn-warning col">SALIR</a>
                </div>
                <div class="col-3 ">
                  <a href="VerGanadorController" class="btn btn-danger col">Terminar Subasta</a>
                </div>
                <div class="col-3">
                <a href = "AniadirRequerimientoController"class="btn btn-success col">Agregar Requerimiento</a>
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

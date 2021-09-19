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
    <title>Agregar Requerimiento</title>
  </head>
  <body>
    <div class="container">
      <header>
        <h1 class="text-center">Agregar Nuevo Requerimiento</h1>
      </header>
      <div class="m-0 row justify-content-center">
        <div class="contenido-principal w-50">
          <div class="row">
            <div class="contenido primario col">
              <h2 class="text-center">Nuevo Requerimiento</h2>
              <form id="login-admin" action="AniadirRequerimientoController" class="col" method="POST">
                <div class="form-group">
                  <label for="nombreRequerimiento">Título:</label>
                  <input
                    type="text"
                    class="form-control"
                    id="titulo_req"
                    name="nombreRequerimiento"
                    placeholder="Ingrese el Título "
                  />
                </div>
                <div class="form-group">
                  <label for="descripcionRequerimiento">Descripción:</label>
                  <textarea class="form-control"
                  id="descripcion" name ="descripcionRequerimiento"> El requerimiento consiste en
                  </textarea>
                </div>
  
                <button type="submit" class="btn btn-primary col-12">Registrar Requerimiento</button>
                <a href="ListarRequerimientosController" id="registrar_registrar"type="submit" class="btn col-12 text-danger mt-3">Cancelar</a>
              </form>
            </div>
            <!--.contenido-->
          </div>
          <!--.row-->
        </div>
      </div>
      
    </div>
  </body>
</html>

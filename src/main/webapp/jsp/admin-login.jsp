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
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Raleway:100,400"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/css/custom.css" />
    <title>Admin Login</title>
  </head>
  <body>
    <div class="container">
      <header>
        <h1 class="text-center">Administración de PubliSubasta</h1>
      </header>
      <div class="m-0 row justify-content-center">
        <div class="contenido-principal">
          <div class="row">
            <div class="contenido primario col">
              <h2 class="text-center">Login</h2>
              <form id="login-admin" action="LoginController" class="col">
                <div class="form-group">
                  <label for="email">Cédula:</label>
                  <input
                    type="text"
                    class="form-control"
                    id="email"
                    name="email"
                    placeholder="Ingrese su cédula"
                  />
                </div>
                <div class="form-group">
                  <label for="clave">Clave:</label>
                  <input
                    type="password"
                    class="form-control"
                    id="password"
                    nombre="password"
                    placeholder="Ingrese su clave"
                  />
                </div>
  
                <button type="submit" class="btn btn-primary col-12">Ingresar</button>
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

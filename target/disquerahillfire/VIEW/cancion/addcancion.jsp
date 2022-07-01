<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="assets/css/style.css">
  <link rel="stylesheet" href="assets/css/estilos.css">
  <title>Añadir Cancion</title>
</head>
<body background="">
<header class="header">
    <div class="container">
    <nav class="menu">
        <a href="cancion?accion=visualizar">Listar</a>
        <a href="index.jsp">Volver</a>
    </nav>
    </div>
</header>
<section class="form-register">
  <form action="cancion" method="post">
    <h4>Añadir Cancion</h4>
      <div>
        <input class="controls" type="text" name="nombreCancion" id="nombreCancion" required placeholder="Ingrese el Nombre de la Cancion">
        <input class="controls" type="date" name="fechaGrabacion" id="fechaGrabacion" required placeholder="Ingrese fecha de grabacion de la Cancion">
        <input class="controls" type="text" name="duracionCancion" id="duracionCancion" required placeholder="Ingrese la duracion de la Cancion">
      </div>
      <div>
        <label for="estadoCancion">Estado Cancion</label>
          <select class="form-control" name="estadoCancion" id="estadoCancion">
              <option for="chkestado" value="Activo">Activo</option>
              <option for="chkestado" value="Inactivo">Inactivo</option>
          </select>
      </div>
    <button name="accion" type="submit" value="add" class="botons">Añadir Cancion</button>
  </form>
</section>
</body>
</html>
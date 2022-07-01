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
  <title>Editar Cancion</title>
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
    <c:forEach var="cancion" items="${cancion}">
    <h4><span>Editar Cancion "${cancion.getNombreCancion()}"</span></h4>
      <div>
        <input class="controls" type="text" name="nombreCancion" id="nombreCancion" value="${cancion.getNombreCancion()}">
        <input hidden name="idCancion" id="idCancion" type="text" value="${cancion.getIdCancion()}">
        <input class="controls" type="date" name="fechaGrabacion" id="fechaGrabacion" value="${cancion.getFechaGrabacion()}">
        <input class="controls" type="text" name="duracionCancion" id="duracionCancion" value="${cancion.getDuracionCancion()}">
      </div>
      <div>
        <label for="estadoCancion">Estado Cancion</label>
          <input hidden type="checkbox" value="${cancion.getEstadoCancion()}" name="estadoCancion" id="estadoCancion" class="controls">
          <label hidden for="chkestado">Activo</label>
      </div>
    <button name="accion" type="submit" value="edit" class="botons">Editar Cancion</button>
    </c:forEach>
   </form>
</section>
</body>
</html>
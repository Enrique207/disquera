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
  <title>Editar Genero</title>
</head>
<header class="header">
    <div class="container">
    <nav class="menu">
        <a href="genero?accion=listar">Listar</a>
        <a href="genero?accion=registrar">Volver</a>
    </nav>
    </div>
</header>
<body background="">
  <section class="form-register">
    <form action="genero" method="post">
    <c:forEach var="genero" items="${genero}">
    <h4>Editar Genero "${artista.getNombreGenero()}"</h4>
    <div>
        <input class="controls" type="text" name="nombreGenero" id="nombreGenero" value="${genero.getNombreGenero()}" class="">
        <input hidden name="idGenero" id="idGenero" type="text" value="${genero.getIdGenero()}">
    </div>
    <div>
    <label>Estado Genero</label>
        <input hidden type="checkbox" name="estadoGenero" id="estadoGenero" value="${genero.getEstadoGenero()}">
        <label hidden for="chkestado">Activo</label>
    </div>
      <button name="accion" type="submit" value="edit" class="botons">Editar Genero</button>
    </c:forEach>
    </form>
  </section>
</body>
</html>

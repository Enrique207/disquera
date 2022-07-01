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
  <title>Añadir Genero</title>
</head>
<body>
  <header class="header">
    <div class="container">
    <nav class="menu">
        <a href="genero?accion=visualizar">Listar</a>
        <a href="index.jsp">Volver</a>
    </nav>
    </div>
  </header>
  <section class="form-register">
    <form action="genero" method="post">
    <h4>Añadir Genero</h4>
    <div>
        <input class="controls" type="text" name="nombreGenero" id="nombreGenero" required placeholder="Ingrese el nombre del genero">
    </div>
    <div>
    <label>Estado Genero</label>
    <select class="form-control" name="estadoGenero">
      <option value="Activo">Activo</option>
      <option value="Inactivo">Inactivo</option>
    </select>
    </div>
    <button name="accion" type="submit" class="botons" value="add">Añadir Genero</button>
      </form>
  </section>
</body>
</html>

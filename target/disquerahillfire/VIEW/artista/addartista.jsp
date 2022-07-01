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
  <title>Añadir Artista</title>
</head>
<body>
  <header class="header">
    <div class="container">
    <nav class="menu">
        <a href="artista?accion=visualizar">Listar</a>
        <a href="index.jsp">Volver</a>
    </nav>
    </div>
</header>
  <section class="form-register">
    <form action="artista" method="post">
    <h4>Añadir Artista</h4>
    <div>
      <input class="controls" type="number" name="noArtista" id="noArtisra" required placeholder="Ingrese el Numero del Artista">      
    </div>
    <div>
      <input class="controls" type="text" name="tipoDocumento" id="tipoDocumento" required placeholder="Ingrese el tipo de documento del Artista">
    </div>
    <div>
      <input class="controls" type="text" name="nombreArtista" id="nombreArtista" required placeholder="Ingerse el nombre del Artista">
    </div>
    <div>
      <input class="controls" type="text" name="apellidoArtista" id="apellidoArtista" required placeholder="Ingrese el apellido del Artista">
    </div>
    <div>
      <input class="controls " type="text" name="nombreArtistico" id="nombreArtistico" required placeholder="Ingrese el nombre Artistico del Artista">
    </div>
    <div>
      <input class="controls" type="date" name="feNacimArtista" id="feNacimArtista" required placeholder="Ingrese la fecha de nacimiento del Artista">
    </div>
    <div>
      <input class="controls" type="text" name="emailArtista" id="emailArtista" required placeholder="Ingrese el email del Artista">
    </div>
    <div>
      <label>Estado Artista</label>
      <select class="form-control" name="estadoArtista">
        <option value="Activo">Activo</option>
        <option value="Inactivo">Inactivo</option>
      </select>
      </div>
      <button name="accion" type="submit" class="botons" value="add">Añadir Artista</button>
    </form>
  </section>
</body>
</html>
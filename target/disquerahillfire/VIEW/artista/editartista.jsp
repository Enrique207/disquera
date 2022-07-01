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
  <title>Editar Artista</title>
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
    <c:forEach var="artista" items="${artista}">    
        <div>
          <h4><span>Editar Artista "${artista.getNombreArtista()}"</span></h4>
        <div>
            <input class="controls" type="number" name="noArtista" id="noArtista" value="${artista.getNoArtista()}">
            
            <input class="controls" type="text" name="tipoDocumento" id="tipoDocumento" value="${artista.getTipoDocumento()}">

            <input class="controls" type="text" name="nombreArtista" id="nombreArtista" value="${artista.getNombreArtista()}">
            
            <input class="controls" type="text" name="apellidoArtista" id="apellidoArtista" value="${artista.getApellidoArtista()}">
            
            <input class="controls" type="text" name="nombreArtistico" id="nombreArtistico" value="${artista.getNombreArtistico()}">
            
            <input class="controls" type="date" name="feNacimArtista" id="feNacimArtista" value="${artista.getFeNacimArtista()}">
            
            <input class="controls" type="text" name="emailArtista" id="emailArtista" value="${artista.getEmailArtista()}">
        </div>
        <div>
            <label for="estadoArtista">Estado Artista</label>
              <div>
                <input hidden type="checkbox" id="estadoArtista" value="${artista.getEstadoArtista()}" name="estadoArtista" class="form-control">
                <label hidden for="chkestado">Activo</label>
              </div>
        </div>
        <button type="submit" name="accion" class="botons" value="edit" >Editar Artista</button>
    </c:forEach>
  </form>
</section>
</body>
</html>
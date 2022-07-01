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
  <title>Editar Album</title>
</head>
<body>
<header class="header">
    <div class="container">
    <nav class="menu">
        <a href="album?accion=visualizar">Listar</a>
        <a href="index.jsp">Volver</a>
    </nav>
    </div>
</header>
<section class="form-register">
  <form action="album" method="post">
    <c:forEach var="album" items="${artista}">    
        <div>
          <h4><span>Editar Album "${album.getNombreAlbum()}"</span></h4>
        <div>
        

            <input class="controls" type="text" name="nombreAlbum" id="nombreAlbum" value="${album.getNombreAlbum()}">
            
            <input class="controls" type="date" name="fePubAlbum" id="fePubAlbum" value="${album.getFePubAlbum()}">

            
            
            
        </div>
        <div>
            <label for="estadoArtista">Estado Album</label>
              <div>
                <input hidden type="checkbox" id="estadoAlbum" value="${albul.getEstadoAlbum()}" name="estadoAlbum" class="form-control">
                <label hidden for="chkestado">Activo</label>
              </div>
        </div>
        <button type="submit" name="accion" class="botons" value="edit" >Editar Album</button>
    </c:forEach>
  </form>
</section>
</body>
</html>
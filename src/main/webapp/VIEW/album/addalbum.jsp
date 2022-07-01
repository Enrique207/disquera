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
  <title>Añadir Album</title>
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
    <h4>Añadir Album</h4>
    
   
    <div>
      <input class="controls" type="text" name="nombreAlbum" id="nombreAlbum" required placeholder="Ingerse el nombre del Album">
    </div>
    <div>
      <input class="controls" type="date" name="fePubAlbum" id="fePubAlbum" required placeholder="Ingrese la fecha de publicación">
    </div>
    
    
    <div>
      <label>Estado Album</label>
      <select class="form-control" name="estadoAlbum">
        <option value="Activo">Activo</option>
        <option value="Inactivo">Inactivo</option>
      </select>
      </div>
      <button name="accion" type="submit" class="botons" value="add">Añadir Album</button>
    </form>
  </section>
</body>
</html>
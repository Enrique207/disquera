<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Disquera</title>
    <link rel="icon" href="assets/img/icono.png">
	<link rel="stylesheet" href="assets/css/estilos.css">
</head>
<body>
	<header class="header">
		<div class="container">
		<div class="btn-menu">
			<label for="btn-menu"></label>
		</div>
			<div class="logo">
				<h1>HILLFIRE RECORDS</h1>
			</div>
			<nav class="menu">
				<a href="index.jsp">Inicio</a>
				<a href="artista?accion=registrar">Artista</a>
                <a href="genero?accion=registrar">Genero</a>
                <a href="cancion?accion=registrar">Cancion</a>
                <a href="album?accion=registrar">Album</a>
			</nav>
		</div>
	</header>
	
</body>
</html>
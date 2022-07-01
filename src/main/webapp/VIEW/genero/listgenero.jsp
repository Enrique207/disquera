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
  <title>Listar Genero</title>
</head>
<script type="text/javascript">
    function eliminar(){
        var respuesta = confirm("Estas seguro de eliminar el genero",'Una vez eliminada se perdera la información');
        if (respuesta ==true){
            return true;
        }else{
            return false
        }
    }
</script>
<header class="header">
    <div class="container">
    <nav class="menu">
        <a href="index.jsp">Inicio</a>
        <a href="genero?accion=registrar">Genero</a>
    </nav>
    </div>
</header>
<body>
  <br>
</br>
</br>
</br>
  <br> 
<section>
    <center>
      <form>
        <table class="table table-bordered">
            <thead>
              <tr>
                <th style="width: 15%; height: 100%;" scope="col">Id</th>
                <th style="width: 15%; height: 100%;" scope="col">Nombre</th>
                <th style="width: 15%; height: 100%;" scope="col">Estado</th>
                <th style="width: 15%; height: 100%;" scope="col">Acciones</th>
                <th style="width: 15%; height: 100%;" scope="col">Funciónes</th>
              </tr>
            </thead>
        <c:forEach var="genero" items="${genero}"> 
              <tr>
                <td><center>${genero.getIdGenero()}</center></td>
                <td><center>${genero.getNombreGenero()}</center></td>

                <c:if test="${genero.getEstadoGenero() == true}">
                    <td><span>Activo</span></td>
                </c:if>

                <c:if test="${genero.getEstadoGenero() == false}">
                    <td><span>Inactivo</span></td>
                </c:if>

            <c:if test="${genero.getEstadoGenero() == true}">
                <td>
                <a href="genero?accion=estadoGenero&idGenero=${genero.getIdGenero()}&estadoGenero=false">
                    <button type="button">
                        Inactivar
                    </button>
                </a>  
                </td>
            </c:if>

            <c:if test="${genero.getEstadoGenero() == false}">
                <td>
                <a href="genero?accion=estadoGenero&idGenero=${genero.getIdGenero()}&estadoGenero=true">
                    <button type="button">
                        Activar
                    </button>
                </a>
                </td>
            </c:if>
            <td>
                <a href="genero?accion=editar&idGenero=${genero.getIdGenero()}">
                    <button type="button">
                        Editar
                    </button> 
                </a>
                <a href="genero?accion=eliminar&idGenero=${genero.getIdGenero()}">
                    <button type="button" onclick="return eliminar()">
                        Eliminar
                    </button> 
                </a>
            </td>
        </tr>
</c:forEach>   
</table>
</form>
</center>
</section>
<script src="js/lista.js"></script>
<script src="js/lista1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/lista2.js"></script>
</body>
</html>
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
  <title>Listar Cancion</title>
</head>
<script type="text/javascript">
    function eliminar(){
        var respuesta = confirm("Estas seguro de eliminar la canción","Una vez eliminada se perdera");
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
        <a href="cancion?accion=registrar">Cancion</a>
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
                <th  style="width: 15%; height: 100%;" scope="col">Id</th>
                <th  style="width: 15%; height: 100%;" scope="col">Nombre</th>
                <th  style="width: 15%; height: 100%;" scope="col">Fecha</th>
                <th  style="width: 15%; height: 100%;" scope="col">Duracion</th>
                <th  style="width: 15%; height: 100%;" scope="col">Estado</th>
                <th  style="width: 15%; height: 100%;" scope="col">Acciones</th>
                <th  style="width: 15%; height: 100%;" scope="col">Funciones</th>
              </tr>
            </thead>
        <c:forEach var="cancion" items="${cancion}"> 
            <tr>
                <td><center>${cancion.getIdCancion()}</center></td>
                <td><center>${cancion.getNombreCancion()}</center></td>
                <td><center>${cancion.getFechaGrabacion()}</center></td>
                <td><center>${cancion.getDuracionCancion()}</center></td>

                <c:if test="${cancion.getEstadoCancion() == true}">
                    <td><span>Activo</span></td>
                </c:if>

                <c:if test="${cancion.getEstadoCancion() == false}"> 
                    <td><span>Inactivo</span></td>
                </c:if>
            <td>
                <c:if test="${cancion.getEstadoCancion() == true}">
                    <a href="cancion?accion=estadoCancion&idCancion=${cancion.getIdCancion()}&estadoCancion=false">
                        <button type="button">
                            Inactivar
                        </button>
                    </a>  
                </c:if>
                <c:if test="${cancion.getEstadoCancion() == false}">
                    <a href="cancion?accion=estadoCancion&idCancion=${cancion.getIdCancion()}&estadoCancion=true">
                        <button type="button">
                            Activar
                        </button>
                    </a>
                </c:if>
            <td>
                <a href="cancion?accion=editar&idCancion=${cancion.getIdCancion()}">
                    <button type="button">
                        Editar
                    </button> 
                </a>
                <a href="cancion?accion=eliminar&idCancion=${cancion.getIdCancion()}">
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
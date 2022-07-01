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
  <title>Listar Artista</title>
</head>
<script type="text/javascript">
    function eliminar(){
        var respuesta = confirm("Estas seguro de eliminar el artista","Una vez eliminado se perdera");
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
        <a href="artista?accion=registrar">Artista</a>
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
                    <th style="width: 15%; height: 100%;" scope="col">Numero</th>
                    <th style="width: 15%; height: 100%;" scope="col">Tipo Documento</th>
                    <th style="width: 15%; height: 100%;" scope="col">Nombre</th>
                    <th style="width: 15%; height: 100%;" scope="col">Apellido</th>
                    <th style="width: 15%; height: 100%;" scope="col">Nombre Artistico</th>
                    <th style="width: 15%; height: 100%;" scope="col">Fecha Nacimiento</th>
                    <th style="width: 15%; height: 100%;" scope="col">Email</th>
                    <th style="width: 15%; height: 100%;" scope="col">Estado</th>
                    <th style="width: 15%; height: 100%;" scope="col">Acciones</th>
                    <th style="width: 15%; height: 100%;" scope="col">Funciones</th>
                  </tr>
                </thead>
            <c:forEach var="artista" items="${artista}"> 
                  <tr>
                    <td><center>${artista.getIdArtista()}</center></td>
                    <td><center>${artista.getNoArtista()}</center></td>
                    <td><center>${artista.getTipoDocumento()}</center></td>
                    <td><center>${artista.getNombreArtista()}</center></td>
                    <td><center>${artista.getApellidoArtista()}</center></td>
                    <td><center>${artista.getNombreArtistico()}</center></td>
                    <td><center>${artista.getFeNacimArtista()}</center></td>
                    <td><center>${artista.getEmailArtista()}</center></td>

                    <c:if test="${artista.getEstadoArtista() == true}">
                        <td><span>Activo</span></td>
                    </c:if>
    
                    <c:if test="${artista.getEstadoArtista() == false}">
                        <td></span>Inactivo</span></td>
                    </c:if>
            <td>
                <c:if test="${artista.getEstadoArtista() == true}">
                    <a href="artista?accion=estadoArtista&idArtista=${artista.getIdArtista()}&estadoArtista=false">
                        <button type="button">
                            Inactivar
                        </button>
                    </a>  
                </c:if> 
                <c:if test="${artista.getEstadoArtista() == false}">
                    <a href="artista?accion=estadoArtista&idArtista=${artista.getIdArtista()}&estadoArtista=true">
                        <button type="button">
                            Activar
                        </button>
                    </a>
                </c:if>
            </td>    
                <td>
                    <a href="artista?accion=editar&idArtista=${artista.getIdArtista()}">
                        <button type="button">
                            Editar
                        </button> 
                    </a>
                    <a href="artista?accion=eliminar&idArtista=${artista.getIdArtista()}">
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
    <script src="js/lista.js"></script>
    <script src="js/lista1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/lista2.js"></script>
</body>
</html>
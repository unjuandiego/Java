<%-- 
    Document   : modificar
    Created on : 24/11/2020, 11:17:50 PM
    Author     : workj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Almacen</title>
    </head>
    <body>
        <h2>Modificar Registro</h2>
        <br/>
        <form action="ProductosController?accion=actualizar" method="POST" autocomplete="off">
            
            <input id="id" name="id" type="hidden" value="<c:out value= "${producto.id}"/>"/>
            <p>
                Codigo:
                <input id ="codigo" name="codigo" type="text"  value="<c:out value= "${producto.codigo}"/>"/>
            </p>
            
                        <p>
                Nombre:
                <input id ="nombre" name="nombre" type="text"  value="<c:out value= "${producto.nombre}"/>" />
            </p>
            
                        <p>
                Precio:
                <input id ="precio" name="precio" type="text"  value="<c:out value= "${producto.precio}"/>" />
            </p>
            
                        <p>
                Existencia:
                <input id ="existencia" name="existencia" type="text"  value="<c:out value= "${producto.existencia}"/>"/>
            </p>
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>

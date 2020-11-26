<%-- 
    Document   : index
    Created on : 24/11/2020, 11:17:10 PM
    Author     : workj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Almacen</title>
    </head>
    <body>
        <h1>Productos</h1>
        <a href ="ProductosController?accion=nuevo">Nuevo registro</a>
        <br /><br />
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Existencia</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var = "producto" items="${lista}">
                    <tr>
                        <td><c:out value="${producto.codigo}"/></td>
                        <td><c:out value="${producto.nombre}"/></td>
                        <td><c:out value="${producto.precio}"/></td>
                        <td><c:out value="${producto.existencia}"/></td>
                        <td><a href="ProductosController?accion=modificar&id=<c:out value="${producto.id}"/>">Modificar</a></td>
                        <td><a href="ProductosController?accion=eliminar&id=<c:out value="${producto.id}"/>">Eliminar</a></td>

                    </tr> 

                </c:forEach>
            </tbody>
        </table>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>

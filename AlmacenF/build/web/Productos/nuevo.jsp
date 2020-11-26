<%-- 
    Document   : nuevo
    Created on : 24/11/2020, 11:17:36 PM
    Author     : workj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Almacen</title>
    </head>
    <body>
        <h2>Nuevo Registro</h2>
        <br/>
        <form action="ProductosController?accion=insertar" method="POST" autocomplete="off">
            <p>
                Codigo:
                <input id ="codigo" name="codigo" type="text" />
            </p>
            
                        <p>
                Nombre:
                <input id ="nombre" name="nombre" type="text" />
            </p>
            
                        <p>
                Precio:
                <input id ="precio" name="precio" type="text" />
            </p>
            
                        <p>
                Existencia:
                <input id ="existencia" name="existencia" type="text" />
            </p>
            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>

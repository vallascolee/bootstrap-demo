<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Productos</h2>
        <table class="table table-striped table-hover">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>PRECIO</th>
                <th>EDITAR</th>
                <th>ELIMINAR</th>
            </tr>
            <!-- Bucle para recorrer los productos -->
            <c:forEach var="producto" items="${listProducto}">
                <tr>
                    <td>${producto.id}</td>
                    <td>${producto.nombre}</td>
                    <td>${producto.precio}</td>
                    
                    <!-- BOTÓN EDITAR -->
                    <td>
                        <a class="btn btn-warning" href="producto?accion=buscar&id=${producto.id}">Editar</a>
                    </td>
                    
                    <!-- BOTÓN ELIMINAR -->
                    <td>
                        <a class="btn btn-danger" href="producto?accion=eliminar&id=${producto.id}" onclick="return confirm('¿Eliminar producto?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <a href="index.jsp" class="btn btn-primary">Nuevo</a>
    </div>
</body>
</html>
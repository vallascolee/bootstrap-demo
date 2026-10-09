<form action="producto" method="post" onsubmit="return validarProducto();"> 
    <!-- ESTA LÍNEA ES OBLIGATORIA PARA EL SERVLET -->
    <input type="hidden" name="accion" value="guardar"> 

    <label>Nombre</label> 
    <input type="text" name="nombre" class="form-control" id="nombre"> 
    <br> 
    <label>Precio</label> 
    <input type="number" step="0.01" name="precio" class="form-control" id="precio"> 
    <br> 
    <button type="submit" class="btn btn-success">Guardar</button>
    <!-- Botón para ir a ver la tabla -->
    <a href="producto?accion=listar" class="btn btn-primary">Ver Productos</a>
</form>
package pe.edu.utp.boostrap.demo.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import pe.edu.utp.boostrap.demo.dao.ProductoDAO;
import pe.edu.utp.boostrap.demo.model.Producto;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/producto"})
public class ProductoServlet extends HttpServlet {

    ProductoDAO productoDao = new ProductoDAO();

    private void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("accion");
            switch (accion) {
                case "listar" -> {
                    List<Producto> listProducto
                            = productoDao.listar();
                    request.setAttribute("listProducto",
                            listProducto);

                    request.getRequestDispatcher("productos.jsp").forward(request,
                            response);
                }
                case "guardar" -> {
                    String nombre = request.getParameter("nombre");
                    double precio
                            = Double.parseDouble(request.getParameter("precio"));

                    productoDao.crearProducto(nombre, precio);

                    response.sendRedirect("producto?accion=listar");
                }
                case "buscar" -> {
                    int id
                            = Integer.parseInt(request.getParameter("id"));
                    Producto producto = productoDao.obtener(id);

                    request.setAttribute("producto", producto);

                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                }
                case "actualizar" -> {
                    int id
                            = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    double precio
                            = Double.parseDouble(request.getParameter("precio"));

                    productoDao.actualizar(new Producto(id, nombre,
                            precio));

                    response.sendRedirect("producto?accion=listar");
                }
                case "eliminar" -> {
                    int id
                            = Integer.parseInt(request.getParameter("id"));
                    productoDao.eliminar(id);
                    response.sendRedirect("producto?accion=listar");
                }
                case "buscarNombre" -> {
                    String nombre = request.getParameter("nombre");

                    List<Producto> listProducto
                            = productoDao.buscar(nombre);
                    request.setAttribute("listProducto",
                            listProducto);

                    request.getRequestDispatcher("productos.jsp").forward(request,
                            response);
                }
                default -> {
                    System.err.println("Petición no encontrada");
                }
            }
        } catch (Exception e) {
            response.getWriter().println("<h1>Error:</h1>"
                    + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

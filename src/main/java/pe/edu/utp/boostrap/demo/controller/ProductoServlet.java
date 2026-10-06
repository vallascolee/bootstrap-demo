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
@Override 
protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
throws ServletException, IOException { 
try { 
String nombre = request.getParameter("nombre"); 
double precio = 
Double.parseDouble(request.getParameter("precio")); 
productoDao.crearProducto(nombre, precio); 
List<Producto> listProducto = productoDao.listar(); 
request.setAttribute("listProducto", listProducto); 
request.getRequestDispatcher("productos.jsp").forward(request, 
response); 
} catch (Exception e) { 
response.getWriter().println("<h1>Error:</h1>"+ 
e.getMessage()); 
} 
} 
} 
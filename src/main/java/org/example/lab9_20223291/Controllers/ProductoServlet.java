package org.example.lab9_20223291.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab9_20223291.Beans.Usuario;
import org.example.lab9_20223291.Daos.CarritoDao;
import org.example.lab9_20223291.Daos.ProductoDao;
import org.example.lab9_20223291.Dto.CreacionyListadoDeProductosDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ProductoServlet", value = "/productos")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "list" : request.getParameter("a");

        switch (action) {
            case "new":
                cargarCategorias(request);
                request.getRequestDispatcher("/WEB-INF/views/productoForm.jsp").forward(request, response);
                break;
            default:
                ProductoDao productoDao = new ProductoDao();
                ArrayList<CreacionyListadoDeProductosDto> productos = productoDao.listarProductos();
                request.setAttribute("listaProductos", productos);
                request.getRequestDispatcher("/WEB-INF/views/productos.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("a") == null ? "" : request.getParameter("a");

        switch (action) {
            case "create":
                crearProducto(request, response);
                break;
            case "add":
                anadirAlCarrito(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/productos");
        }
    }

    private void crearProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idCatStr = request.getParameter("id_categoria");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precioStr = request.getParameter("precio");
        String stockStr = request.getParameter("stock");

        if (idCatStr == null || nombre == null || precioStr == null || stockStr == null) {
            response.sendRedirect(request.getContextPath() + "/productos?a=new");
            return;
        }

        try {
            int idCategoria = Integer.parseInt(idCatStr);
            BigDecimal precio = new BigDecimal(precioStr);
            int stock = Integer.parseInt(stockStr);

            ProductoDao productoDao = new ProductoDao();
            productoDao.crearProducto(idCategoria, nombre, descripcion, precio, stock);
        } catch (NumberFormatException ex) {

        }

        response.sendRedirect(request.getContextPath() + "/productos");
    }

    private void anadirAlCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idProdStr = request.getParameter("id_producto");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }

        try {
            int idProducto = Integer.parseInt(idProdStr);
            CarritoDao carritoDao = new CarritoDao();
            carritoDao.anadirAlCarrito(usuario.getId_usuario(), idProducto);
        } catch (NumberFormatException ignored) {
        }

        response.sendRedirect(request.getContextPath() + "/productos");
    }

    private void cargarCategorias(HttpServletRequest request) {

        String sql = "SELECT id_categoria, nombre FROM categoria ORDER BY nombre";

        ArrayList<int[]> categorias = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();

        try (Connection conn = new org.example.lab9_20223291.Daos.DaoBase().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                categorias.add(new int[]{rs.getInt(1)});
                nombres.add(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categoriasIds", categorias);
        request.setAttribute("categoriasNombres", nombres);
    }
}



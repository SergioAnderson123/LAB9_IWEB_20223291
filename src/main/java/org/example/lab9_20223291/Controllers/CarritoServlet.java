package org.example.lab9_20223291.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.lab9_20223291.Beans.Usuario;
import org.example.lab9_20223291.Daos.CarritoDao;
import org.example.lab9_20223291.Dto.AnadidoAlCarrritoyListadoDeProductosDto;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CarritoServlet", value = "/carrito")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }

        CarritoDao carritoDao = new CarritoDao();
        ArrayList<AnadidoAlCarrritoyListadoDeProductosDto> lista = carritoDao.listarCarrito(usuario.getId_usuario());
        request.setAttribute("itemsCarrito", lista);
        request.getRequestDispatcher("/WEB-INF/views/carrito.jsp").forward(request, response);
    }
}



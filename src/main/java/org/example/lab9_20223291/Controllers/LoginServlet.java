package org.example.lab9_20223291.Controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab9_20223291.Beans.Usuario;
import org.example.lab9_20223291.Daos.UsuarioDao;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("a") == null ? "login" : request.getParameter("a");

        if (action.equals("login")) {
            HttpSession httpSession = request.getSession();
            Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

            if (usuario != null && usuario.getId_usuario() > 0) {
                response.sendRedirect(request.getContextPath() + "/UsuarioServlet");
            } else {
                request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
            }
        } else { //logout
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.validarUsuario(username, password);

        if (usuario != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/productos");
        } else {
            request.setAttribute("err", "Usuario o password incorrectos");
            request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
        }
    }
}
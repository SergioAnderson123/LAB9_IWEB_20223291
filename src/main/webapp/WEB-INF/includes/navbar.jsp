<%
    org.example.lab9_20223291.Beans.Usuario u = (org.example.lab9_20223291.Beans.Usuario) session.getAttribute("usuario");
    String nombre = (u != null) ? u.getNombres() : "Invitado";
%>
<div style="padding:10px; background:#f0f0f0; margin-bottom:15px;">
    <strong>Tienda &ndash; <%= nombre %></strong>
    &nbsp;|&nbsp;
    <a href="<%= request.getContextPath() %>/productos">Productos</a>
    &nbsp;|&nbsp;
    <a href="<%= request.getContextPath() %>/carrito">Carrito</a>
    &nbsp;|&nbsp;
    <a href="<%= request.getContextPath() %>/LoginServlet?a=logout">Cerrar sesi&oacute;n</a>
    </div>



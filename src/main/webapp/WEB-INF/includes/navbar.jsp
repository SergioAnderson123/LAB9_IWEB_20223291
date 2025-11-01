<%
    org.example.lab9_20223291.Beans.Usuario u = (org.example.lab9_20223291.Beans.Usuario) session.getAttribute("usuario");
    String nombre = (u != null) ? u.getNombres() : "Invitado";
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
  <div class="container">
    <a class="navbar-brand" href="<%= request.getContextPath() %>/productos">Tienda &ndash; <%= nombre %></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/productos">Productos</a></li>
        <li class="nav-item"><a class="nav-link" href="<%= request.getContextPath() %>/carrito">Carrito</a></li>
      </ul>
      <div class="d-flex">
        <a class="btn btn-outline-light btn-sm" href="<%= request.getContextPath() %>/LoginServlet?a=logout">Cerrar sesi&oacute;n</a>
      </div>
    </div>
  </div>
</nav>



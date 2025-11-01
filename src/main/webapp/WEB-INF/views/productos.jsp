<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.example.lab9_20223291.Dto.CreacionyListadoDeProductosDto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Productos</title>
    <jsp:include page="/WEB-INF/includes/headCss.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/includes/navbar.jsp" />
<div class="container">
  <div class="d-flex justify-content-between align-items-center mb-3">
    <h2 class="m-0">Productos</h2>
    <a class="btn btn-success" href="<%= request.getContextPath() %>/productos?a=new">Crear producto</a>
  </div>

  <div class="table-responsive">
    <table class="table table-striped align-middle">
      <thead>
      <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Categoría</th>
        <th>Precio</th>
        <th>Stock</th>
        <th>Acción</th>
      </tr>
      </thead>
      <tbody>
      <%
        List<CreacionyListadoDeProductosDto> productos = (List<CreacionyListadoDeProductosDto>) request.getAttribute("listaProductos");
        if (productos != null && !productos.isEmpty()) {
            for (CreacionyListadoDeProductosDto p : productos) {
      %>
      <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getNombre() %></td>
        <td><%= p.getCategoriaNombre() %></td>
        <td><%= p.getPrecio() %></td>
        <td><%= p.getStockCalculado() %></td>
        <td>
          <form class="d-inline" method="post" action="<%= request.getContextPath() %>/productos">
            <input type="hidden" name="a" value="add" />
            <input type="hidden" name="id_producto" value="<%= p.getId() %>" />
            <button type="submit" class="btn btn-primary btn-sm">Añadir al carrito</button>
          </form>
        </td>
      </tr>
      <%
            }
        } else {
      %>
      <tr>
        <td colspan="6" class="text-center text-muted">No hay productos para mostrar.</td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
  </div>
</div>
<jsp:include page="/WEB-INF/includes/footer.jsp" />
</body>
</html>



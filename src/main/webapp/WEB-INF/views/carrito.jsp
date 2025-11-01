<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.example.lab9_20223291.Dto.AnadidoAlCarrritoyListadoDeProductosDto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Carrito</title>
    <jsp:include page="/WEB-INF/includes/headCss.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/includes/navbar.jsp" />
<div class="container">
  <h2 class="mb-3">Carrito</h2>
  <div class="table-responsive">
    <table class="table table-striped align-middle">
      <thead>
      <tr>
        <th>ID Item</th>
        <th>ID Producto</th>
        <th>Producto</th>
        <th>Usuario</th>
        <th>Precio Unitario</th>
        <th>Cantidad</th>
        <th>Subtotal</th>
      </tr>
      </thead>
      <tbody>
      <%
        List<AnadidoAlCarrritoyListadoDeProductosDto> items = (List<AnadidoAlCarrritoyListadoDeProductosDto>) request.getAttribute("itemsCarrito");
        if (items != null && !items.isEmpty()) {
            for (AnadidoAlCarrritoyListadoDeProductosDto it : items) {
      %>
      <tr>
        <td><%= it.getIdItem() %></td>
        <td><%= it.getIdProducto() %></td>
        <td><%= it.getNombreProducto() %></td>
        <td><%= it.getNombreUsuario() %></td>
        <td><%= it.getPrecioUnit() %></td>
        <td><%= it.getCantidad() %></td>
        <td><%= it.getSubtotal() %></td>
      </tr>
      <%
            }
        } else {
      %>
      <tr>
        <td colspan="7" class="text-center text-muted">Tu carrito está vacío.</td>
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



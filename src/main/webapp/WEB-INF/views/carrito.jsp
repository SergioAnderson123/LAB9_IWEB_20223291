<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.example.lab9_20223291.Dto.AnadidoAlCarrritoyListadoDeProductosDto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Carrito</title>
</head>
<body>
<jsp:include page="/WEB-INF/includes/navbar.jsp" />

<h2>Carrito</h2>

<table border="1" cellpadding="5" cellspacing="0">
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
        if (items != null) {
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
        }
    %>
    </tbody>
    </table>

</body>
</html>



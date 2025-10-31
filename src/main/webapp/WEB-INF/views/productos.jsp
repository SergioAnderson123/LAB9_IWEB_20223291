<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="org.example.lab9_20223291.Dto.CreacionyListadoDeProductosDto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Productos</title>
</head>
<body>
<jsp:include page="/WEB-INF/includes/navbar.jsp" />

<h2>Productos</h2>

<p>
    <a href="<%= request.getContextPath() %>/productos?a=new">Crear producto</a>
    </p>

<table border="1" cellpadding="5" cellspacing="0">
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
            <form method="post" action="<%= request.getContextPath() %>/productos">
                <input type="hidden" name="a" value="add" />
                <input type="hidden" name="id_producto" value="<%= p.getId() %>" />
                <button type="submit">Añadir al carrito</button>
            </form>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="6">No hay productos para mostrar.</td>
    </tr>
    <%
        }
    %>
    </tbody>
    </table>

</body>
</html>



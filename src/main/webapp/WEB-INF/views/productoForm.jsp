<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Crear producto</title>
</head>
<body>
<jsp:include page="/WEB-INF/includes/navbar.jsp" />

<h2>Crear producto</h2>

<form method="post" action="<%= request.getContextPath() %>/productos">
    <input type="hidden" name="a" value="create" />

    <label>Categoría:</label>
    <select name="id_categoria" required>
        <%
            List<int[]> ids = (List<int[]>) request.getAttribute("categoriasIds");
            List<String> nombres = (List<String>) request.getAttribute("categoriasNombres");
            if (ids != null && nombres != null) {
                for (int i = 0; i < ids.size(); i++) {
        %>
        <option value="<%= ids.get(i)[0] %>"><%= nombres.get(i) %></option>
        <%
                }
            }
        %>
    </select>
    <br/>

    <label>Nombre:</label>
    <input type="text" name="nombre" required />
    <br/>

    <label>Descripción:</label>
    <textarea name="descripcion"></textarea>
    <br/>

    <label>Precio:</label>
    <input type="number" step="0.01" min="0" name="precio" required />
    <br/>

    <label>Stock:</label>
    <input type="number" min="0" name="stock" required />
    <br/>

    <button type="submit">Guardar</button>
    </form>

</body>
</html>



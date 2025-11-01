<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Crear producto</title>
    <jsp:include page="/WEB-INF/includes/headCss.jsp" />
</head>
<body>
<jsp:include page="/WEB-INF/includes/navbar.jsp" />
<div class="container">
  <h2 class="mb-3">Crear producto</h2>
  <form method="post" action="<%= request.getContextPath() %>/productos" class="row g-3">
    <input type="hidden" name="a" value="create" />

    <div class="col-md-6">
      <label class="form-label">Categoría</label>
      <select name="id_categoria" class="form-select" required>
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
    </div>

    <div class="col-md-6">
      <label class="form-label">Nombre</label>
      <input type="text" name="nombre" class="form-control" required />
    </div>

    <div class="col-12">
      <label class="form-label">Descripción</label>
      <textarea name="descripcion" class="form-control" rows="3"></textarea>
    </div>

    <div class="col-md-6">
      <label class="form-label">Precio</label>
      <input type="number" step="0.01" min="0" name="precio" class="form-control" required />
    </div>

    <div class="col-md-6">
      <label class="form-label">Stock</label>
      <input type="number" min="0" name="stock" class="form-control" required />
    </div>

    <div class="col-12">
      <button type="submit" class="btn btn-primary">Guardar</button>
      <a href="<%= request.getContextPath() %>/productos" class="btn btn-secondary ms-2">Cancelar</a>
    </div>
  </form>
</div>
<jsp:include page="/WEB-INF/includes/footer.jsp" />
</body>
</html>



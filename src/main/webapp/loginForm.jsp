<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Login</title>
    <jsp:include page="/WEB-INF/includes/headCss.jsp" />
</head>
<body class="bg-body-tertiary">
<jsp:include page="/WEB-INF/includes/navbar.jsp" />
<div class="container">
  <div class="row justify-content-center my-5">
    <div class="col-12 col-sm-8 col-md-6 col-lg-4">
      <div class="card shadow-sm">
        <div class="card-body">
          <h1 class="h4 mb-3 text-center">Ingreso al sistema</h1>
          <% if (request.getAttribute("err") != null) { %>
          <div class="alert alert-danger" role="alert"><%= request.getAttribute("err") %></div>
          <% } %>
          <form method="post" action="<%= request.getContextPath() %>/LoginServlet" class="form-signin w-100">
            <div class="form-floating mb-2">
              <input type="text" class="form-control" id="floatingInput" placeholder="name@example.com" name="username" required>
              <label for="floatingInput">Correo</label>
            </div>
            <div class="form-floating mb-3">
              <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>
              <label for="floatingPassword">Contraseña</label>
            </div>
            <button class="btn btn-primary w-100 py-2" type="submit">Ingresar</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="/WEB-INF/includes/footer.jsp" />
</body>
</html>



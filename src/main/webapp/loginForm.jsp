<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Iniciar sesión</title>
</head>
<body>
<jsp:include page="/WEB-INF/includes/navbar.jsp" />
<h2>Iniciar sesi&oacute;n</h2>

<% String err = (String) request.getAttribute("err"); if (err != null) { %>
<p style="color:red;"><%= err %></p>
<% } %>

<form method="post" action="<%= request.getContextPath() %>/LoginServlet">
    <label>Email:</label>
    <input type="email" name="username" required />
    <br/>
    <label>Contrase&ntilde;a:</label>
    <input type="password" name="password" required />
    <br/>
    <button type="submit">Ingresar</button>
    </form>

</body>
</html>



<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>

<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.html");
        return;
    }
%>

<h1>Welcome, <%= user %>!</h1>
<p>Login successful</p>

</body>
</html>

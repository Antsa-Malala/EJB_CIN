<% String erreur=(String) request.getAttribute("error");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style1.css" type="text/css">
    </head>
    <body>
        <h1><%out.print(erreur);%></h1>
        <a href="Formulaire"><button>Revenir au transfert</button></a>
    </body>
</html>

<%-- 
    Document   : Formulaire
    Created on : 16 oct. 2023, 14:14:02
    Author     : Antsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dto.DeviseDTO"%>
<%@page import="java.util.ArrayList"%>
<%
     ArrayList<DeviseDTO> devise = (ArrayList<DeviseDTO>)request.getAttribute("devise");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfert d'argent</title>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>
    <body>
        <h1>Transferer de l'argent</h1>
        <form method="post" action="Transfert">
            <label for="numCompte1">Numero de compte de l'envoyeur</label>
            <input type="text" name="numCompte1">
            <label for="numCompte2">Numero de compte du recepteur</label>
            <input type="text" name="numCompte2">
            <label for="somme">Somme à envoyer</label>
            <input type="text" name="somme">
            <label for="devise">Devise</label>
            <select name="iddevise">
                <%for(int i=0;i<devise.size();i++){ %>
                    <option value=<%out.print(devise.get(i).getiddevise());%>><%out.print(devise.get(i).getnom());%></option>
                <%}%>
            </select>
            <label>Date d'envoie</label>
            <input type="datetime-local" name="dateEnvoie">
            <input type="submit" value="Transferer">
        </form>
    </body>
</html>

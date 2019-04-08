<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtr HTML 4.01 tdansitional//EN" "http://www.w3.org/td/html4/loose.dtr">
<html>
<head>
<%
String nomArticle = request.getAttribute("nomArticle").toString();
String descArticle  = request.getAttribute("descArticle").toString();
String categorie = request.getAttribute("categorie").toString();
String prixInit = request.getAttribute("prixInit").toString();
String prixVente = request.getAttribute("prixVente").toString();
String finEnchere = request.getAttribute("finEnchere").toString();
String lieuRetrait = request.getAttribute("lieuRetrait").toString();
String vendeur = request.getAttribute("vendeur").toString();
String lastNameEnchere = request.getAttribute("lastNameEnchere").toString();
String lastPriceEnchere = request.getAttribute("lastPriceEnchere").toString();

String button = "<form><input type=\"number\" name=\"creditProp\"/><button type=\"submit\" >Encherir</button></form>";
if(session.getAttribute("actualUser") == null){
	button = "";
}
%>
</head>
<body>
<h1 style="text-align:center;">Detail vente</h1>
<table>
	<tr>
		<td><%=nomArticle %></td>
	</tr>
	<tr>
		<td>Description : </td>
		<td><%=descArticle %></td>
	</tr>
	<tr>
		<td>Catégorie : </td>
		<td><%=categorie %></td>
	</tr>
	<tr>
		<td>Meilleure offre : </td>
		<td><%=lastPriceEnchere %> par <%=lastNameEnchere %></td>
	</tr>
	<tr>
		<td>Mise à prix : </td>
		<td><%=prixInit %></td>
	</tr>
	<tr>
		<td>Fin de l'enchère : </td>
		<td><%=finEnchere %></td>
	</tr>
	<tr>
		<td>Retrait : </td>
		<td><%=lieuRetrait %></td>
	</tr>
	<tr>
		<td>Vendeur : </td>
		<td><%=vendeur %></td>
	</tr>
	<tr>
		<td>Ma proposition : </td>
		<td><%=button %></td>
	</tr>
	
</table>
</body>
</html>
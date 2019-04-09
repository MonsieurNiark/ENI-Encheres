<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtr HTML 4.01 tdansitional//EN" "http://www.w3.org/td/html4/loose.dtr">
<html>
<head>
<%
int idArticle = Integer.parseInt(request.getParameter("id"));
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
String credit = "0";
int creditInt = 0;
String button = "";
if(session.getAttribute("actualUser") == null){
	button = "";
} else {
	String actualUser = session.getAttribute("actualUser").toString();
	credit = session.getAttribute("credit").toString();
	creditInt = Integer.parseInt(credit);
	button = "<form  method=\"post\" onSubmit=\"return verify(this.creditProp)\" action=\"./enchere?id="+idArticle+"\">"
			+"<input type=\"number\" name=\"creditProp\"/><button type=\"submit\" >Encherir</button>"
			+ "</form><h3>Crédit disponible : "+creditInt+"</h3>";
	
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
 <script type="text/javascript">
function verify(element1)
// La fonction reçois en paramètre les 2 éléments
 {
	var creditInt = <%=creditInt%>
  	var passed=false

   if (element1.value > creditInt)
   {
    alert("Vous n'avez pas assez de crédit")
    element1.select()
   }  else if (element1.value <= <%=lastPriceEnchere%>){
	   alert("Vous devez mettre une enchère plus élevé")
	   element1.select()
   } else {
   passed=true
   }
  return passed
 }
</script></body>
</html>
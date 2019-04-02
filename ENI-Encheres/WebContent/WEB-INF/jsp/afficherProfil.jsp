<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String pseudo_user = request.getAttribute("pseudo_user").toString();
String nom = request.getAttribute("nom").toString();
String prenom = request.getAttribute("prenom").toString();
String email = request.getAttribute("email").toString();
String telephone = request.getAttribute("telephone").toString();
String rue = request.getAttribute("rue").toString();
String code_postal = request.getAttribute("code_postal").toString();
String ville = request.getAttribute("ville").toString();%>
Pseudo : <%=pseudo_user%> <br/>
Nom : <%=nom %><br/>
Prenom : <%=prenom %><br/>
Email : <%=email %><br/>
Telephone : <%=telephone %><br/>
Rue : <%=rue %><br/>
Code Postal : <%=code_postal %><br/>
Ville : <%=ville %><br/>

</body>
</html>
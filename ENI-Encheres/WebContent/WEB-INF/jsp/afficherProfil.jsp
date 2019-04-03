<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="./style.css" rel="stylesheet">
    <link href="./pure-min.css" rel="stylesheet">

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
<br/><br/><br/><br/><br/><br/>
<table class="pure-table">		  
    <thead>			
      <tr>			  			  
        <th  colspan=2 style="text-align:center;"><h2><%=pseudo_user%></h2></th>
      </tr>
    </thead>
    <tbody>
      <tr>			  
        <th scope="row">Nom</th>
        <td><%=nom %></td>
      </tr>
      <tr>			  
      <th scope="row">Prénom</th>			  
      <td><%=prenom %></td>			  			  			
      </tr>			
      <tr>			  
      <th scope="row">Email</th>
      	<td><%=email %></td>
      </tr>
      <th scope="row">Téléphone</th>
      	<td><%=telephone %></td>
      </tr>
      <th scope="row">Rue</th>
      	<td><%=rue %></td>
      </tr>
      <th scope="row">Code postal</th>
      	<td><%=code_postal %></td>
      </tr>
      <th scope="row">Ville</th>
      	<td><%=ville %></td>
      </tr>		  
      </tbody>		
      </table>
</body>
</html>
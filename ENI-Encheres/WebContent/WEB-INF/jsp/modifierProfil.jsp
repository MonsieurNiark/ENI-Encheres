<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="/ENI-Encheres/style.css" rel="stylesheet">
    <link href="/ENI-Encheres/pure-min.css" rel="stylesheet">
    <style>
/* Popup container - can be anything you want */
.popup {
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* The actual popup */
.popup .popuptext {
  visibility: hidden;
  width: 160px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 8px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
  visibility: visible;
  -webkit-animation: fadeIn 1s;
  animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
  from {opacity: 0;} 
  to {opacity: 1;}
}

@keyframes fadeIn {
  from {opacity: 0;}
  to {opacity:1 ;}
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String pseudo_user = session.getAttribute("pseudo_user").toString();
String nom = session.getAttribute("nom").toString();
String prenom = session.getAttribute("prenom").toString();
String email = session.getAttribute("email").toString();
String telephone = session.getAttribute("telephone").toString();
String rue = session.getAttribute("rue").toString();
String code_postal = session.getAttribute("code_postal").toString();
String ville = session.getAttribute("ville").toString();
String actualUser = session.getAttribute("actualUser").toString();
%>
<h1><%=actualUser %></h1>
<br/><br/><br/><br/><br/><br/>
<table class="pure-table">		  
    <thead>			
      <tr>			  			  
        <th  colspan=2 style="text-align:center;"><h2><%=pseudo_user%></h2></th>
      </tr>
    </thead>
    <tbody>
    <form action="modifierProfile" method="post">
      <tr>			  
        <th scope="row">Nom</th>
        <td><input type="text" value="<%=nom %>" name="nom"></td>
      </tr>
      <tr>			  
      <th scope="row">Prénom</th>			  
      <td><input type="text" value="<%=prenom %>" name="prenom"></td>			  			  			
      </tr>			
      <tr>			  
      <th scope="row">Email</th>
      	<td><input type="text" value="<%=email %>" name="email"></td>
      </tr>
      <th scope="row">Téléphone</th>
      	<td><input type="text" value="<%=telephone %>" name="telephone"></td>
      </tr>
      <th scope="row">Rue</th>
      	<td><input type="text" value="<%=rue %>" name="rue"></td>
      </tr>
      <th scope="row">Code postal</th>
      	<td><input type="text" value="<%=code_postal %>" name="code_postal"></td>
      </tr>
      <th scope="row">Ville</th>
      	<td><input type="text" value="<%=ville %>" name="ville"></td>
      </tr>
      <th scope="row">Mot de passe</th>
      	<td><input type="text" value="" name="motDePasse"></td>
      </tr>
      <tr>			  			  
        <th  style="text-align:center;"><button type="submit">Confirmer</button></th></form>
        <th>
        <div class="popup" onclick="popup()">SUPPRIMER MON COMPTE
		  <span class="popuptext" id="myPopup"><a href="/ENI-Encheres/modifierProfile?suppression=1" onClick="popup()">Confirmer</a></span>
		</div>
        </th>
        </th>
      </tr>	 
       
      
      </tbody>		
      </table>
      <script>
// When the user clicks on div, open the popup
function popup() {
  var popup = document.getElementById("myPopup");
  popup.classList.toggle("show");
}
</script>
</body>

</html>
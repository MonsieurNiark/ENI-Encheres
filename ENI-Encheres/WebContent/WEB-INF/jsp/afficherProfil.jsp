<%@include file="header.jsp" %>
<style>    <style>
    <%@ include file="../../style.css"%>
     <%@ include file="../../pure-min.css"%></style>
<% 
String pseudoUser = request.getAttribute("pseudoUser").toString();
String nom = request.getAttribute("nom").toString();
String prenom = request.getAttribute("prenom").toString();
String email = request.getAttribute("email").toString();
String telephone = request.getAttribute("telephone").toString();
String rue = request.getAttribute("rue").toString();
String code_postal = request.getAttribute("code_postal").toString();
String ville = request.getAttribute("ville").toString();
String actualUser = session.getAttribute("actualUser").toString();
String display = "none";
String credit = "";
if(pseudoUser.equals(actualUser)){
	display="inline";
credit = request.getAttribute("credit").toString();
}
%>
<br/><br/><br/><br/><br/><br/>
<table class="pure-table">		  
    <thead>			
      <tr>			  			  
        <th  colspan=2 style="text-align:center;"><h2><%=pseudoUser%></h2></th>
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
      <th scope="row">T�l�phone</th>
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
      <th colspan=2 scope="row"><%=credit %></th>
      <tr>			  			  
        <th  colspan=2 style="text-align:center;display:<%=display%>;"><a href="modifierProfile"><button>Modifier le profile</button></a></th>
      </tr>	  
      </tbody>		
      </table>
</body>
</html>
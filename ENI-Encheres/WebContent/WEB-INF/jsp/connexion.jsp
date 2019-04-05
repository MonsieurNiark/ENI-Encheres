<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Enchères</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<%String identifiant = (String)session.getAttribute("actualUser"); %>
<div class="container">
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/connexion">
<fieldset class="justify-content-center">

<!-- Form Name -->
<legend>Eni-Enchères</legend>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-5 control-label" for="user">Identifiant :</label>  
  <div class="col-md-2">
  <c:if test="${identifiant != null }">
  <input id="user" name="user" type="text" placeholder="Identifiant" value="<%= identifiant %>" class="form-control input-md">
  </c:if>  
  <c:if test="${identifiant == null }">
  <input id="user" name="user" type="text" placeholder="Identifiant" class="form-control input-md">
  </c:if> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="mdp">Mot de passe :</label>  
  <div class="col-md-2">
  <input id="mdp" name="mdp" type="password" placeholder="Mot de passe" class="form-control input-md"/>
  </div>
</div>

<!-- Multiple Checkboxes -->
<div class="form-group">
  
  <div class="col-md-7 control-label">
  <input type="submit" name="submit" value="Connexion" class="btn btn-default">
    <label for="checkCo">
      <input type="checkbox" name="checkCo" id="seSouvenirDeMoi" value=1>
      Se souvenir de moi
    </label>
	</div>
  </div>

</form>
<!-- Button -->
<div class="form-group">
  <div class="col-md-7 control-label ">
    <a id="creer" class="btn btn-inverse" href="${pageContext.request.contextPath}/inscription">Créer un compte</a>
  </div>
</div>
</fieldset>
</div>
</body>
</html>
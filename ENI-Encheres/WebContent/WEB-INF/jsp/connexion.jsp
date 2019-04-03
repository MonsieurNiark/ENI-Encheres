<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Enchères</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<div class="container">
<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/connexion">
<fieldset class="justify-content-center">

<!-- Form Name -->
<legend>Eni-Enchères</legend>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-5 control-label" for="user">Identifiant :</label>  
  <div class="col-md-2">
  <input id="user" name="user" type="text" placeholder="Identifiant" class="form-control input-md" required="">
    
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
    <button id="creerCompte" name="creerCompte" class="btn btn-inverse">Créer un compte</button>
  </div>
</div>
</fieldset>
</div>
</body>
</html>
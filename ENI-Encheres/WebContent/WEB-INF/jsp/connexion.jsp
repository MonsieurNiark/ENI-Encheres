<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Eni-Enchères</title>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
	<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Eni-Enchères</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="user">Identifiant :</label>  
  <div class="col-md-4">
  <input id="user" name="user" type="text" placeholder="Identifiant" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="mdp">Mot de passe</label>  
  <div class="col-md-4">
  <input id="mdp" name="mdp" type="text" placeholder="Mot de passe" class="form-control input-md">
    
  </div>
</div>

<!-- Multiple Checkboxes -->
<div class="form-group">
  <label class="col-md-4 control-label" for="checkCo"></label>
  <div class="col-md-4">
  <button id="submit" name="submit" class="btn btn-default">Connexion</button>
  <div class="checkbox">
    <label for="checkCo">
      <input type="checkbox" name="checkCo" id="checkCo" value=1>
      Rester connecter
    </label>
	</div>
  </div>
</div>
</form>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="creerCompte"></label>
  <div class="col-md-4">
    <button id="creerCompte" name="creerCompte" class="btn btn-inverse">Créer un compte</button>
  </div>
</div>

</fieldset>

</body>
</html>
<%@include file="header.jsp" %>
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
  <c:if test="${identifiant }">

  <input id="user" name="user" type="text" placeholder="Identifiant" value="<%= identifiant %>" class="form-control input-md">
  </c:if>  
  <c:if test="${!identifiant }">

  <input id="user" name="user" type="text" placeholder="Identifiant" class="form-control input-md">
  </c:if> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-5 control-label" for="mdp">Mot de passe :</label>  
  <div class="col-md-2">
  <input id="mdp" name="mdp" type="password" placeholder="Mot de passe" class="form-control input-md">
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
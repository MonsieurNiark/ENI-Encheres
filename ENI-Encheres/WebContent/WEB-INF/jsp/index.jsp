<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>ENI-Enchères</title>

</head>
<body>
	<!--NAVBAR -->
	<div id="custom-bootstrap-menu" class="navbar navbar-default "
		role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">ENI-Enchères</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-menubuilder">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse navbar-menubuilder">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="">Se connecter</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<form action="${pageContext.request.contextPath}/" method="post"
			class="form-horizontal">

			<div class="form-group row">
				<div class="col-sm-3">
					<label class="col-lg-9 col-form-label" for="champRecherche">Filtres
						:</label> <input id="champRecherche" type="search" name="recherche"
						class="form-control" placeholder="Nom de l'article...">
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-3">
					<label class="col-lg-9 col-form-label" for="champRecherche">Catégorie :</label>
					<select id="categorie" class="form-control" name ="categorie">
						<option value="Toutes">Toutes</option>
						<c:forEach items="${sessionScope.categories }" var="categorie">
							<option value=${categorie.noCategorie}>${categorie.libelle }</option>
						</c:forEach>
					</select>
				</div>
				<input type="submit" name="submit" value="Connexion" class="btn btn-default align-bottom">
			</div>
		</form>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-5">
				<div class="container ">
				</div>
			</div>
			<div class="col-lg-2">
			</div>
			<div class="col-lg-5">
			</div>
		</div>
	</div>
</body>
</html>
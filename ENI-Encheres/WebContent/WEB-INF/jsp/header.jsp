<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ENI - Enchères</title>
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
       
		<link rel="stylesheet" href="css/index.css">
		
	</head>

	<body>
		<header class="bg-info">
			<h1 class="p-3"><a class="text-white" href="${pageContext.request.contextPath}/index">ENI - Enchères</a></h1>
			<input type="button" onclick="refresh()" value="Rafraichir"/>
			<script type="text/javascript"> function refresh() { window.location.reload(false); } </script>

            <!-- MENU -->
			<nav class="navbar navbar-expand justify-content-end bg-dark navbar-dark">
				<ul class="navbar-nav">
					<c:if test="${sessionScope.isConnecte == null}">
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/connexion">S'inscrire - Se connecter</a>
						</li>
					</c:if>
					<c:if test="${sessionScope.isConnecte != null}">
                        <li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/membre/ajouterEnchere">Vendre un article</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/AjoutArticle">Ajouter une Enchere</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/profile?user=${sessionScope.actualUser}">${sessionScope.actualUser }</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}/deconnexion">Déconnecter</a>
						</li>
					</c:if>
				</ul>
			</nav>

		</header>
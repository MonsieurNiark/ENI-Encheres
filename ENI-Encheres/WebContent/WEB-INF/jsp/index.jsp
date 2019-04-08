<%@include file="header.jsp" %>
<%@ page import="fr.eni.encheres.bo.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

        <!-- RECHERCHE -->
		<section id="recherche" class="mb-2 p-4">
			<h2 class="text-center mb-3">Liste des ench�res</h2>
			<form action="${pageContext.request.contextPath}/index" method="post">
				<section class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="champRecherche">Filtres : </label>
                    </div>
					<input id="champRecherche" class="form-control" type="search" name="recherche" placeholder="Nom de l'article..." >
				</section>

                <section class="input-group mb-3">
                    <section class="input-group-prepend">
                        <label class="input-group-text" for="categorie">Cat�gorie: </label>
                    </section>
                    <select id="categorie" class="form-control" name="categorie">
                        <option value="Toutes">Toutes</option>
                        <c:forEach items="${categories }" var="categorie">
                            <option value="${categorie.noCategorie}">${categorie.libelle }</option>
                        </c:forEach>
                    </select>
                    
                </section>

                <c:if test="${sessionScope.isConnecte == true }">
                    <div class="d-flex flex-row mb-3">

						<%-- achats --%>
                        <section>
                            <section>
                                <input type="radio" value="achats" id="achats" name="radioMenu" checked>
                                <label for="achats">Achats</label>
                            </section>
                            <section class="ml-4">
                                <div>
                                    <input type="checkbox" value="encheresOuvertes" name="encheresOuvertes" id="encheresOuvertes">
                                    <label for="encheresOuvertes">ench�res ouvertes</label>
                                </div>

                                <div>
                                    <input type="checkbox" value="encheresEnCours" name="encheresEnCours" id="encheresEnCours">
                                    <label for="encheresEnCours">mes ench�res en cours</label>
                                </div>
                                <div>
                                    <input type="checkbox" value="encheresRemportees" name="encheresRemportees" id="encheresRemportees">
                                    <label for="encheresRemportees">mes ench�res remport�es</label>
                                </div>
                            </section>
                        </section>

						<%-- ventes --%>
                        <section class="ml-4">
                            <section>
                                <input type="radio" value="ventes" id="ventes" name="radioMenu">
                                <label for="ventes">Mes ventes</label>
                            </section>
                            <section class="ml-4">
                                <div>
                                    <input type="checkbox" value="ventesEnCours" name="ventesEnCours" id="ventesEnCours">
                                    <label for="ventesEnCours">mes ventes en cours</label>
                                </div>

                                <div>
                                    <input type="checkbox" value="ventesNonDebutees" name="ventesNonDebutees" id="ventesNonDebutees">
                                    <label for="ventesNonDebutees">ventes non d�but�es</label>
                                </div>

                                <div>
                                    <input type="checkbox" value="ventesTerminees" name="ventesTerminees" id="ventesTerminees" >
                                    <label for="ventesTerminees">ventes termin�es</label>
                                </div>
                            </section>
                        </section>
                    </div>
                </c:if>

                <section class="input-group">
                    <button class="btn btn-success btn-large" type="submit" name="valideRecherche">Rechercher</button>
                </section>
            </form>
		</section>

		<!-- VUE SUR LES ENCHERES OUVERTES -->
		<section class="mb-2 p-4">
			<c:if test="${not empty listeArticles }">
			<h3>Ench�res ouvertes : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${listeArticles }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/afficherEnchere?article=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'ench�re: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == false }">
	                                    <p>Vendeur: ${article.utilisateur.pseudo }</p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

        	<!-- VUE SUR LES ENCHERES EN COURS  -->
	        <c:if test="${not empty requestScope.mesEncheresEC }">
	        <h3>Ench�res en cours : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${requestScope.mesEncheresEC }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/afficherEnchere?article=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'ench�re: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == false }">
	                                    <p>Vendeur: ${article.utilisateur.pseudo }</p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

       		<!-- VUE SUR LES ENCHERES REMPORTEES  -->
	        <c:if test="${not empty requestScope.mesEncheresR }">
	        <h3>Ench�res remport�es : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${requestScope.mesEncheresR }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/afficherEnchere?article=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'ench�re: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == false }">
	                                    <p>Vendeur: ${article.utilisateur.pseudo }</p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

	        <!--  VUE SUR TOUTES LES VENTES DE L'UTILISATEUR -->
	        <c:if test="${not empty requestScope.mesVentes }">
	        <h3>Mes ventes : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${requestScope.mesVentes }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/afficherEnchere?article=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'ench�re: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == false }">
	                                    <p>Vendeur: ${article.utilisateur.pseudo }</p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

        	<!-- VUE SUR LES VENTES EN COURS  -->
	        <c:if test="${not empty requestScope.mesVentesEC }">
	        <h3>Ventes en cours : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${requestScope.mesVentesEC }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/afficherEnchere?article=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'ench�re: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == false }">
	                                    <p>Vendeur: ${article.utilisateur.pseudo }</p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

        	<!-- VUE SUR LES VENTES NON DEBUTEES  -->
	        <c:if test="${not empty requestScope.mesVentesND }">
	        <h3>Ventes non d�but�es : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${requestScope.mesVentesND }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/afficherEnchere?article=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'ench�re: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == false }">
	                                    <p>Vendeur: ${article.utilisateur.pseudo }</p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

        	<!-- VUE SUR LES VENTES TERMINEES  -->
	        <c:if test="${not empty requestScope.mesVentesT }">
	        <h3>Ventes termin�es : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${requestScope.mesVentesT }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/afficherEnchere?article=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'ench�re: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == false }">
	                                    <p>Vendeur: ${article.utilisateur.pseudo }</p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

			<c:if test="${empty requestScope.mesEncheresEC && empty requestScope.mesEncheresR && empty requestScope.mesVentes &&
			empty requestScope.encheresO && empty requestScope.mesVentesEC && empty requestScope.mesVentesND &&
			empty requestScope.mesVentesT}">
				<h3 class="text-muted text-center">Aucun r�sultat � afficher</h3>
			</c:if>
        </section>
	</body>
</html>
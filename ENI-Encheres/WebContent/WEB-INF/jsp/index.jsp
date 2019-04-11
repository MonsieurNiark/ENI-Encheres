<%@include file="header.jsp" %>
<%@ page import="fr.eni.encheres.bo.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

        <!-- RECHERCHE -->
		<section id="recherche" class="mb-2 p-4">
			<h2 class="text-center mb-3">Liste des enchères</h2>
			<form action="${pageContext.request.contextPath}/index" method="post">
				<section class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="champRecherche">Filtres : </label>
                    </div>
					<input id="champRecherche" class="form-control" type="search" name="recherche" placeholder="Nom de l'article..." >
				</section>

                <section class="input-group mb-3">
                    <section class="input-group-prepend">
                        <label class="input-group-text" for="categorie">Catégorie: </label>
                    </section>
                    <select id="categorie" class="form-control" name="categorie">
                        <option value="-1">Toutes</option>
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
                                    <label for="encheresOuvertes">enchères ouvertes</label>
                                </div>

                                <div>
                                    <input type="checkbox" value="encheresEnCours" name="encheresEnCours" id="encheresEnCours">
                                    <label for="encheresEnCours">mes enchères en cours</label>
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
                                    <input type="checkbox" value="ventesTerminees" name="ventesTerminees" id="ventesTerminees" >
                                    <label for="ventesTerminees">ventes terminées</label>
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
			<c:if test="${not empty articles && empty enchereO && empty enchereEC && empty venteEC && empty venteT}">
			<h3>Enchères ouvertes : </h3>
			
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${articles }" var="article">
	                    <section class="sectionEncheres">
	               
	                        <div class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="img/img.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/enchere?id=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.miseAPrix }</p>
	                                <p>Fin de l'enchère: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte != null }">
	                                    <p>Vendeur : <a href="profile?pseudo=${article.utilisateur.getPseudo() }">${article.utilisateur.getPseudo() }</a></p>
	                     
	                                </c:if>
	                                <c:if test="${sessionScope.isConnecte == null }">
	                                    <p>Vendeur: ${article.utilisateur.getPseudo() }</p>
	                                 
	                                </c:if>
	                                
	                            </div>
	                        </div>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

        	<!-- VUE SUR LES ENCHERES OUVERTE -->
	        <c:if test="${not empty enchereO }">

	        <h3>Enchères ouverte : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${ articles }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="img/img.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/enchere?id=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'enchère: ${article.dateFinEncheres }</p>
	                                <c:if test="${sessionScope.isConnecte == true }">
	                                    <p>Vendeur : <a href="affichageProfil?pseudo=${article.utilisateur.pseudo }">${article.utilisateur.pseudo }</a></p>
	                                </c:if>
	                            </div>
	                        </article>
	                    </section>
	                </c:forEach>
	            </section>
	        </div>
	        </c:if>

       		<!-- VUE SUR LES ENCHERES EN COURS  -->
	        <c:if test="${not empty enchereEC }">
	        <h3>Enchères en cours : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${articlesEC }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/enchere?id=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'enchère: ${article.dateFinEncheres }</p>
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
	        <c:if test="${not empty venteEC }">
	        <h3>Ventes en cours : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${articles }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/enchere?id=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'enchère: ${article.dateFinEncheres }</p>
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
	        <c:if test="${not empty venteT }">
	        <h3>Ventes terminées : </h3>
	        <div class="d-flex flex-row">
	            <section class="d-flex flex-wrap justify-content-center">
	                <c:forEach items="${articles }" var="article">
	                    <section class="sectionEncheres">
	                        <article class="encheres row">
	                            <section class="col-5">
	                                <img class="img-fluid" alt="enchere" src="images/encheres/gris.jpg">
	                            </section>
	                            <div class="col-7">
	                                <h3 class="text-left"><a href="${pageContext.request.contextPath }/enchere?id=${article.noArticle }">${article.nomArticle }</a></h3>
	                                <p>Prix : ${article.prixVente }</p>
	                                <p>Fin de l'enchère: ${article.dateFinEncheres }</p>
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
			empty requestScope.articles && empty requestScope.mesVentesEC && empty requestScope.mesVentesND &&
			empty requestScope.mesVentesT}">
				<h3 class="text-muted text-center">Aucun résultat à afficher</h3>
			</c:if>
        </section>
	</body>
</html>
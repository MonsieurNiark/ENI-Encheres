<%@include file="header.jsp" %>


<form method="post" action="${pageContext.request.contextPath}/AjoutArticle">
	<div class="row">
		<div class="col-lg-4">
			IMG
		</div>
		<div class="col-lg-6">
			<div class="form-group">
  				<label class="col-form-label" for="inputDefault">Article</label>
	  			<input type="text" class="form-control" placeholder="Article" id="Article" name="Article">
			</div>
			<div class="form-group">
      			<label for="exampleTextarea">Description</label>
      			<textarea class="form-control" id="Desc" name="Desc" rows="3"></textarea>
    		</div>
 			<div class="form-group">
      			<label for="exampleSelect1">Catégorie</label>
      			<select class="form-control" id="Catégorie">
        			<option value="info">Informatique</option>
        			<option value="Meuble">Ameublement</option>
        			<option value="Vêtement">Vêtement</option>
        			<option value="Loisirs">Sports & Loisirs</option>
     			</select>
    		</div>
    		<div class="form-group">
      			<label for="exampleInputFile">File input</label>
      			<input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
	    	</div>
    		<div class="form-group">
  				<label class="col-form-label" for="inputDefault">Mise à prix</label>
  				<input type="text" class="form-control" placeholder="en euro" id="Prix" name="Prix">
			</div>
			<div class="form-group">
  				<label class="col-form-label" for="inputDefault">Début de l'enchère</label>
  				<input type="date" class="form-control" placeholder="aaaa-mm-jj" id="DateDebut" name="DateDebut">
			</div>
			<div class="form-group">
  				<label class="col-form-label" for="inputDefault">Fin de l'enchère</label>
  				<input type="date" class="form-control" placeholder="aaaa-mm-jj" id="DateFin" name="DateFin">
			</div>
	    	<fieldset class="trsp">
				<legend> Retrait  </legend>
				<div class="form-group">
	  				<label class="col-form-label" for="inputDefault">Rue</label>
	  				<input type="text" class="form-control" placeholder="Rue" id="Rue" name="Rue">
				</div>
				<div class="form-group">
	  				<label class="col-form-label" for="inputDefault">Ville</label>
	  				<input type="text" class="form-control" placeholder="Ville"  id="Ville" name="Ville">
				</div>
				<div class="form-group">
	  				<label class="col-form-label" for="inputDefault">Code Postal</label>
	  				<input type="text" class="form-control" placeholder="Code Postal" id="CodePostal" name="CodePostal">
				</div>		
			</fieldset>	
			<div class="row">
	    	 	<div class="col-lg-2">
	    	 		 <button type="submit" value="Enregistrer" class="btn btn-primary">Enregistrer</button>
	   			 </div>
	   		<div class="col-lg-2">
	    		<button type="submit" class="btn btn-primary">Annuler</button>
	    	</div>
			</div>
		</div>
	<div class="col-lg-2">
	</div>
	</div>
</form>

</body>
</html>
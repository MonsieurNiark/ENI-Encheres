<%@include file="header.jsp" %>



<div class="row">
	<div class="col-lg-4">
		IMG
	</div>
	<div class="col-lg-6">
		<div class="form-group">
  			<label class="col-form-label" for="inputDefault">Article</label>
  			<input type="text" class="form-control" placeholder="Article" id="inputDefault">
		</div>
		<div class="form-group">
      		<label for="exampleTextarea">Description</label>
      		<textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
    	</div>
 		<div class="form-group">
      		<label for="exampleSelect1">Catégorie</label>
      		<select class="form-control" id="exampleSelect1">
        		<option>1</option>
        		<option>2</option>
        		<option>3</option>
        		<option>4</option>
        		<option>5</option>
     		</select>
    	</div>
    	<div class="form-group">
      		<label for="exampleInputFile">File input</label>
      		<input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
    	</div>
    	<div class="form-group">
  			<label class="col-form-label" for="inputDefault">Mise à prix</label>
  			<input type="text" class="form-control" placeholder="en euro" id="inputDefault">
		</div>
		<div class="form-group">
  			<label class="col-form-label" for="inputDefault">Début de l'enchère</label>
  			<input type="text" class="form-control" placeholder="jj/mm/aa" id="inputDefault">
		</div>
		<div class="form-group">
  			<label class="col-form-label" for="inputDefault">Fin de l'enchère</label>
  			<input type="text" class="form-control" placeholder="jj/mm/aa" id="inputDefault">
		</div>
    	<fieldset class="trsp">
			<legend> Retrait  </legend>
			<div class="form-group">
  				<label class="col-form-label" for="inputDefault">Rue</label>
  				<input type="text" class="form-control" placeholder="Rue" id="inputDefault">
			</div>
			<div class="form-group">
  				<label class="col-form-label" for="inputDefault">Ville</label>
  				<input type="text" class="form-control" placeholder="Ville" id="inputDefault">
			</div>
			<div class="form-group">
  				<label class="col-form-label" for="inputDefault">Code Postal</label>
  				<input type="text" class="form-control" placeholder="Code Postal" id="inputDefault">
			</div>		
		</fieldset>	
		<div class="row">
    	 	<div class="col-lg-2">
    	 		 <button type="submit" class="btn btn-primary">Enregistrer</button>
   			 </div>
   			 <div class="col-lg-2">
    			 <button type="submit" class="btn btn-primary">Annuler</button>
    	 	</div>
		</div>
	</div>
	<div class="col-lg-2">
	</div>
</div>

</body>
</html>
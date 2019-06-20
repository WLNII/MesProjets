<?php
  require_once("action/inscriptionAction.php");
    $action = new inscriptionAction();
	  $action->execute();
  require_once("partial/headerNoMenu.php");
  
?>


<div class = "bgPageInscription"></div>


<div id="topTitle"> <h1> INSCRIPTION </h1> </div>


<section id="formInscription">
<form action="inscription.php"  method="post">

<label for="lname">Nom</label>
  <input type="text" id="nom" name="nom" required>

  <label for="fname">Prenom</label>
  <input type="text" id="prenom" name="prenom" required>

  <label for="lname">Courriel</label>
  <input type="text" id="courriel" name="courriel" >

  <label for="lname">Pseudonyme</label>
  <input type="text" id="pseudo" name="username" required>

  <label for="lname">mot de passe</label>
  <input type="password" id="mdp" name="mdp" required>

  <label for="lname">Confirmer mot de passe</label>
  <input type="password" type = "password" id="mdp2" name="mdp2"required>

  <label for="lname">Membre++</label>
  <input type="text" id="membre" name="privilege" placeholder="optionnelle">

<br>
  <input type="file" id="real-file" hidden="hidden" name="foto" />
  <button type="button" id="custom-button">Choisir une photo de profile</button>
  <span id="custom-text">pas d'image choisi,encore.</span>
  <hr>

  <button type="submit" id="connexion" value="create">Connexion</button>
</form>
<a href="login.php"><button id="cancel" value="cancel">Annuler</button></a>
</section>


<?php

	require_once("partial/footer.php");
?>

<script src="js/fileUpload.js"></script>
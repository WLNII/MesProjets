<?php
require_once("action/loginAction.php");

	$action = new loginAction();
	$action->execute();

  require_once("partial/header.php"); 
?>

<div class="bgIndexS"></div>

<div id="id01" class="modal">
  <section class="modal-content animate">


  <form  action="login.php" method="post">
  <?php
				if ($action->wrongLogin) {
					?>
					<div id="error-div"><strong>Erreur : </strong>Connexion erronée</div>
					<?php
        }
      ?>
      
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <img src="images/loginAvatar.png" alt="Avatar" class="avatar" id="loginImage">
    </div>

    <div class="container">

      <label for="username"><b>Nom d'Utilisateur</b></label>
      <input type="text" placeholder="Entrer nom utilisateur" name="username" required>
      

      <label for="pwd"><b>Mot De Passe</b></label>
      <input type="password" placeholder="Entrer mot de passe" name="pwd" required>

      <label for="membre"><b>Membre++</b></label>
      <input type="password" placeholder="Optionnelle" name="privilege">

        
      <button id="loginButton" type="submit">S'identifier</button>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Se souvenir de moi
      </label>
    </div>
    </form>
    <div class="container" style="background-color:#f1f1f1">
    <a href="inscription.php"><button id="enregistrer">S'enregistrer</button></a>

      <div class="psw">oublier <a href="recupMDP.php">mot de passe?</a></div>
    </div>
  
</div>
</section>
<script src="js/login_Javascript.js"></script>



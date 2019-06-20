<?php
require_once("partial/headerNoMenu.php");
require_once("action/actionRecupMDP.php");
?>
<script src="js/recupMDPJs.js"> </script>

<div class = "bgPageCompte">

<form action="recupMDP.php" method="post">
<div id="divRecupMDP">
<h3 style="color:goldenRod">recuperation de mot de passe</h3>
<br>
<p>Entrer votre email: <input type="text" name="emailReset"></p>

<button type="submit">reinitialiser</button>
</div>
</form>
</div>


<?php
require_once("partial/footer.php"); 
?>
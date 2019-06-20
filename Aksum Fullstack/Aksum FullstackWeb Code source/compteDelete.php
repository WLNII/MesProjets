<?php

require_once("action/compteAction.php");
    $action = new compteAction();
    $action->execute();

require_once("partial/header.php");

?>

<div class=bgIndexS></div>

<form action="compteDelete.php" method="post">


//entrer le nom usager a effacer
<div class="divDelete"><p>confirmez nom utilisateur du compte a fermer</p> Nom Utilisateur
<input name="inputDelete"></>  
</div>


<button type="submit" id="sendDelete">effacer compte</button>
</form>
<?php
require_once("partial/footer.php")

?>
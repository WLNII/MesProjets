<?php

require_once("action/compteAction.php");
require_once("action/DAO/compteDAO.php");

    $action = new compteAction();
    $action->execute();


require_once("partial/header.php");


$_SESSION["compte"]=true;

?>
<div class=bgIndexS></div>


<form action="compte.php" method="post">
<section id = "compteInfo">
<img src="<?=  $action->mesInfo['photo'];?>" alt="picture" style="width:100%">
<h1> <?=  $action->mesInfo['username'];?> </h1> 
<p class="email"> <?=  $action->mesInfo['courriel'];?></p> 
<p> <?=  $action->mesInfo['nom'];?>     </p> 
<p> <?=  $action->mesInfo['prenom'];?>  </p> 
</section>

<!-- <button id="buttonEditCompte" type="submit" >Modif. info</button> -->

<button> <a href="compteDelete.php" id="fermerCompte" type="submit"> Fermer le compte</a></button>

</div>
</form>

<script src="js/compte.js"></script>
<?php
require_once("partial/footer.php");

?>
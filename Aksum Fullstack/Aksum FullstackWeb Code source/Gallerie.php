<?php

require_once("action/gallerieAction.php");

$action = new gallerieAction();
$action->execute();



require_once("partial/header.php");

?>

<div id="bgGallerie"></div>

<section class="body">
  <div class="container">
    
    <div class="produits">

    </div>
    <!-- products -->

    <div class="panier">
      <div class="panier-Entete">
        <span class="produit-quantite">0</span> Produit(s) dans panier
      </div>
      <ul class="panier-list">
      </ul>
      <div class="panier-buttons">
        <a href="#0" class="galButton viderPanier">Vider panier</a>
        <a href="panier.php" class="galButton caisse">Passer a la Caisse - <span class="prix-total">$0</span></a>
      </div>
    </div>
  </div>
  <!-- container -->

</section>


</div>
<script src="js/gallScript.js"></script>

<?php

require_once("partial/footer.php"); 


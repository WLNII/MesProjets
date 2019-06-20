
<?php
    require_once("action/artistesMainAction.php");
    $action = new artistesMainAction();
    $action->execute();
    require_once("partial/header.php");
    
    ?>

  
<div id="bgArtistesMain">
  <div id="artistesContainer">
    <a href="artiste1.php" ><div id="top"> <div class="artistNames">Lina Viktor</div></div></a>
    <a href="artiste2.php" ><div id="middle"><div class="artistNames">James Jean</div></div></a>
    <a href="artiste3.php" ><div id="bottom"><div class="artistNames">BANKSY</div></div></a>
  </div>
</div>
<script src="js/artistesMain.js"></script>
<?php
require_once("partial/footer.php"); 
?>

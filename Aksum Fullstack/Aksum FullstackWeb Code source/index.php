<?php
require_once("action/indexAction.php");

$action = new indexAction();
$action->execute();

require_once("partial/header.php");
$_SESSION["compte"]=false;
?>
<div class=bgIndexS></div>

<section id="titreSite">
<div id="ts1">Bazaar D'Aksum</div>
</section>


<?php
require_once("partial/footer.php"); 
?>
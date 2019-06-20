<?php
require_once("action/panierAction.php");

$action = new panierAction();
$action->execute();

require_once("partial/header.php");

?>
<div class=bgIndexS></div>

<div id="prixTotal">LE PRIX TOTAL EST: "En cours de preparation" </div>

<script src="js/gallScript.js"></script>
<?php
require_once("partial/footer.php"); 
?>


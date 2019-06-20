<?php
	require_once("action/artistesMainAction.php");
    $action = new artistesMainAction();
    $action->execute();
	require_once("partial/header.php");

?>


<div class = "bgArtist2"></div>

<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100"  src="images/JamesJean/art3.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
    <img class="d-block w-100"  src="images/JamesJean/art1.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
    <img class="d-block w-100"  src="images/JamesJean/art2.jpg" alt="First slide">
    </div>
  </div>
  <section class="boutons">
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  </section>
</div>


<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">James Jean</h5>
    <p class="card-text">James Jean fusionne des sujets contemporains avec des techniques 
    esthétiques inspirées des peintures sur rouleaux traditionnelles chinoises, des estampes 
    japonaises et des portraits de la Renaissance. En expérimentant différents styles et genres 
    de l'histoire de l'art, Jean décrit des mondes cosmologiques détaillés axés sur des expériences 
    individuelles et universelles. Ses pièces à petite échelle mettent en scène des personnages 
    célibataires engagés dans des tâches quotidiennes et se concentrent sur des récits et des émotions 
    spécifiques. Les œuvres de Jean à grande échelle rappellent des peintures complexes de Hiéronymus 
    Bosch et des paysages majestueux de la dynastie Tang. Couché avec des images tirées à la fois de la 
    culture contemporaine et d'allégories séculaires, l'artiste imagine un royaume collectif aux proportions mythologiques.</p>
    <a href="http://www.jamesjean.com/2018" class="btn btn-primary">Oeuvres</a>
  </div>
<?php

	require_once("partial/footer.php");
?>
<?php
	require_once("action/artistesMainAction.php");
    $action = new artistesMainAction();
    $action->execute();
	require_once("partial/header.php");

?>


<div class = "bgArtist3"></div>


<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100"  src="images/Banksy/art1.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100"  src="images/Banksy/art2.jpg" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100"  src="images/Banksy/art3.jpg" alt="First slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Banksy</h5>
    <p class="card-text">Sans doute le street artiste le plus controversé au monde, Banksy a développé toute une sous-culture artistique consacrée à ses œuvres. 
    L’art de Banksy peut avoir un impact sur n’importe quel lieu et à tout moment. 
    Son identité reste inconnue, même après plus de 20 ans d’intervention dans le graffiti. 
    Il a travaillé avec différents types de médias et de types d'art de rue. 
    Son travail comprend non seulement de nombreuses images puissantes, souvent controversées, 
    mais on peut également les trouver sur Internet sous forme d'images virales.

On sait très peu de choses sur Banksy lui-même, car il refuse d'être interrogé et maintient son identité avec soin. 
Mystérieux de renommée mondiale, Banksy a gravi les échelons pour devenir l'un des plus grands artistes de rue du monde, 
en partie en créant l'urgence de comprendre son personnage. 
Les fanatiques du street art sont toujours satisfaits de chaque œuvre qu’il livre, 
bien qu’il leur laisse souvent le désir de continuer. 
Cette tactique porte la curiosité d'explorer une perspective ou une idée totalement nouvelle, 
laissant ses créations artistiques pour inspirer les artistes débutants et avancés. 
Cette inspiration est également connue sous le nom de «l'effet Banksy».</p>
    <a href="http://walledoffhotel.com/index.html" class="btn btn-primary">Oeuvres</a>
  </div>

<?php

	require_once("partial/footer.php");
?>
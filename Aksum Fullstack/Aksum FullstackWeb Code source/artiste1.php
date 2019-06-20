<?php
	require_once("action/artistesMainAction.php");
    $action = new artistesMainAction();
    $action->execute();
	require_once("partial/header.php");

?>


<div class = "bgArtist1"></div>



<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100"  src="images/LinaViktor/tableau5.jpeg" alt="First slide">
    </div>
    <div class="carousel-item">
    <img class="d-block w-100"  src="images/LinaViktor/tableau6.jpeg" alt="First slide">
    </div>
    <div class="carousel-item">
    <img class="d-block w-100"  src="images/LinaViktor/tableau4.jpeg" alt="First slide">
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
    <h5 class="card-title">Lina Iris Viktor</h5>
    <p class="card-text">Élevée à Londres de parents libériens, elle a beaucoup voyagé dans sa jeunesse et a également vécu à Johannesburg, 
    en Afrique du Sud, pendant de nombreuses années. 
    L'approche multidisciplinaire de son travail, qui tisse des matériaux et des méthodes disparates appartenant à la fois aux formes d'art contemporaines et anciennes, 
    remet en question la nature du temps et de l'être. Ses œuvres sont un mélange de photographie, de performance, 
    de peinture abstraite et de la pratique ancienne de la dorure à l'or 24 carats pour créer des toiles de plus en plus sombres 
    incrustées de «couches de lumière» sous forme de symboles et de motifs complexes. Viktor considère ces toiles sombres 
    comme des «œuvres de lumière». Chacune provoque un commentaire philosophique par le biais de documents qui abordent à 
    la fois l’infini et le fini, l’immortalité et la mortalité, le microcosme et le macrocosme, en plus des préconceptions 
    socio-politiques et historiques entourant la «noirceur» et ses implications universelles.</p>
    <a href="http://www.linaviktor.com/painting" class="btn btn-primary">Oeuvres</a>
  </div>
</div>

<?php
	require_once("partial/footer.php");
?>
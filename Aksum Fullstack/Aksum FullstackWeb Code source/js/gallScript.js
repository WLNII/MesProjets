let monPanierMain = (function($) {
  
    let lesProduits = document.querySelector(".produits"),
        panier =     document.querySelector(".panier-list"),
        quantiteProduit = document.querySelector(".produit-quantite"),
        viderPanier = document.querySelector(".viderPanier"),
        passerCaisse = document.querySelector(".caisse"),
        prixTotal = document.querySelector(".prix-total");
        let produitsJson;

        
      //vas chercher un json de ma base de donnee
      jQuery.ajax({                                      
          url: 'ajaxGallerie.php',                 
          dataType: 'json',                      
          success: function(data)
            {
              produitsJson = data;
              console.log(produitsJson);
            },
          error:function(){
            alert('erreur')
            }
        });

        produitDansPanier = [];
    
    // template pour creer nos cartes d'items
    let genereListProduit = function() {
      produitsJson.forEach(function(item) {
        let produitElement = document.createElement("div");
        produitElement.className = "produit";
        produitElement.innerHTML = `<div class="produit-image ">
                                  <img src="${item.photo}" alt="${item.nom}">
                               </div>
                               <div class="titre-produit"><span>Titre:</span> ${item.nom}</div>
                               <div class="artist-produit"><span>Artiste: </span> ${item.auteur}</div>
                               <div class="description-produit"><span>Description:</span> ${item.description}</div>
                               <div class="prix-produit"><span>Prix:</span> ${item.prix} $</div>
                               <div class="produit-add-to-cart">
                                 <a href="#0" class="galButton add-to-cart" data-iditem=${item.iditem-1}>Ajout panier</a>
                               </div>
                            </div>`;
                               
  lesProduits.appendChild(produitElement);
      });
    }
    
    let genererListPanier = function() {
      
      panier.innerHTML = "";

      produitDansPanier.forEach(function(item) {
        let li = document.createElement("li");
        li.innerHTML = `${item.quantity} ${item.produit.nom} - ${item.produit.prix * item.quantity}`;
        panier.appendChild(li);
      });
      
      quantiteProduit.innerHTML = produitDansPanier.length;
      
      genereBoutonPanier()
    }
    
    
    // boutons ajout dans panier et vider panier
    let genereBoutonPanier = function() {
      if(produitDansPanier.length > 0) {
        viderPanier.style.display = "block";
        passerCaisse.style.display = "block"
        prixTotal.innerHTML = "$ " + calculPrixTotal();
      } else {
        viderPanier.style.display = "none";
        passerCaisse.style.display = "none";
      }
    }
    
    //creer listeners si bouton est clicker
    let creerListeners = function() {
      lesProduits.addEventListener("click", function(event) {
        let el = event.target;
        if(el.classList.contains("add-to-cart")) {
         let elId = el.dataset.iditem;
         ajoutPanier(elId);
        }
      });
      
      //enleve les items du tableau afin de vider panier
      viderPanier.addEventListener("click", function(event) {
        if(confirm("Etes-vous sur?")) {
          produitDansPanier = [];
        }
        genererListPanier();
      });
    }
    
    //Ajout de produit dans panier et verif si doublé
    let ajoutPanier = function(id) {
      let obj = produitsJson[id];
      if(produitDansPanier.length === 0 || produitTrouver(obj.iditem) === undefined) {
        produitDansPanier.push({produit: obj, quantity: 1});
      } else {
        produitDansPanier.forEach(function(item) {
          if(item.produit.id === obj.id) {
            item.quantity++;
          }
        });
      }
      genererListPanier();
    }
    
    
    // This function checks if project is already in produitDansPanier array
    let produitTrouver = function(produitiditem) {
      return produitDansPanier.find(function(item) {
        return item.produit.iditem === produitiditem;
      });
    }
    let calculPrixTotal = function() {
      return produitDansPanier.reduce(function(total, item) {
        prixTotalPanier=total + (item.produit.prix *  item.quantity);
        return prixTotalPanier;
      }, 0);
    }
    
    //fonction qui lance le tout
    let init = function() {
      genereListProduit();
      creerListeners();
    }
    
    return {
      init: init
    };
    
  })();
  
  window.onload=function() {
    monPanierMain.init();
  }
  

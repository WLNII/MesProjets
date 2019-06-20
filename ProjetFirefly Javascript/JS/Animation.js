let spriteListStars=[];
let spriteListNMEs=[];
let spriteListPlasma=[];
let spriteListPlasma2=[];

let game = false;

let points=0;

let parent = document.getElementById("frameTwo");
var audio = new Audio('sound/warp.mp3');

// document.onkeypress = e =>{
//     if(e.which == 13) {
//         document.getElementById("frameOne").style.display="none";
//         document.getElementById("frameTwo").style.display="block";
//         game = true;
//     }
// }
   
let rightPushed = false;
let leftPushed = false;
let spacePushed = false;

document.onkeydown = function (e) {
    if (e.which == 65){ console.log("left")
        leftPushed = true;} 
    else if (e.which == 68){ console.log("right") 
        rightPushed = true;}
    else if(e.which == 13) {
        document.getElementById("frameOne").style.display="none";
        document.getElementById("frameTwo").style.display="block";
        game = true;
    }              
}

document.onkeyup = function (e) {
    if (e.which == 65)         leftPushed = false;                
    else if (e.which == 68) rightPushed = false;   
    else if (e.which == 32) spacePushed = false;                
    }

    document.onkeypress = function (e){
        if(e.which==32)
        spacePushed = true;
    }



let monHero = null;  //create global variable to be used in diff. funtions

window.onload=()=>{
    monHero = new Hero(); 

    tick();

}




const tick = () =>{


    monHero.tick();

    console.log(monHero.tick());

    console.log(monHero.tick())

    if(game==true){     //permet de lancer la creation de nouveau vaiseau seulement quand le
                        //deuxieme frame s'affiche
        if(Math.random() < 0.01){
            spriteListNMEs.push(new NMEs());
        }
    }



    

    for (let i = 0; i < spriteListNMEs.length; i++) {
        const sprite = spriteListNMEs[i];
        const alive = sprite.tick();

        if(!alive[0]){
            spriteListNMEs.splice(i,1);
            i--;
        }        
    }

    if(spacePushed){
    if(Math.random() < .4){
        spriteListPlasma.push(new Plasma());
        spriteListPlasma2.push(new Plasma2());
    }
}
    for (let i = 0; i < spriteListPlasma.length; i++) {
        const sprite = spriteListPlasma[i];
        const shooting = sprite.tick();
        const sprite2 = spriteListPlasma2[i];
        const shooting2 = sprite2.tick();

        if(!shooting || !shooting2){
            spriteListPlasma.splice(i,1);
            spriteListPlasma2.splice(i,1);
            i--;
        }
}



    window.requestAnimationFrame(tick);
}


class NMEs {

    constructor(){

        var min=30; 
        var max=600;  
        this.node = document.createElement("div");
        this.node.setAttribute("class","NMEs");
        document.getElementById("frameTwo").appendChild(this.node);
        this.X= 200 + Math.random() * 800;
        this.node.style.left = this.X + "px";
        this.node.style.top = 0 + "px";
        this.speedY =1.5;
        this.velocity = 0.5;
        audio.play();
        this.currentY = this.node.style.top;

    }

    tick(){

        this.speedY += this.velocity;
        this.currentY =this.speedY ;
        this.node.style.top = this.currentY + "px";

        if(this.currentY > 500){
            this.node.remove();

            return [false,this.currentX,this.currentY]
        }
        else{

            return [true,this.currentX,this.currentY]
        }

    }
}
  


class Hero{

    constructor(){
        
        this.currentX = 500;
        var min=340; 
        var max=1180;
        this.node = document.createElement("div");
        this.node.setAttribute("class","Hero");
        document.getElementById("frameTwo").appendChild(this.node);
        this.node.style.left = this.currentX + "px";
        this.node.style.top = 500 + "px";
        this.speedY =2;
  
    }

       

    tick(){

        this.speedX =4;

        if(rightPushed && this.currentX<1000)
        {    
            this.currentX +=this.speedX;
        }
        else if(leftPushed && this.currentX>200 )
        {
             this.currentX -=this.speedX;
        }

        this.node.style.left = this.currentX + "px";

        return this.currentX;  // will be used for projectile (plasma)


    }


}

class Plasma{

    constructor(x){
        this.currentposY;
        this.currentposX;
        this.speed = 1.5;
        this.balle = document.createElement("div");
        this.balle.setAttribute("class","Plasma");
        document.getElementById("frameTwo").appendChild(this.balle);
        this.balle.style.top = this.currentY;
        this.balle.style.left = monHero.tick() + "px";
        this.balle.style.left = this.x + "px";
        this.currentY = 500;
    }

    tick(){
        
        this.currentY -=this.speed;
        this.balle.style.top = this.currentY + "px";
        this.currentY -= this.speed;
        this.balle.style.top = this.currentY + "px";
        this.actif = false;

        if(this.currentY < 0){
            this.balle.remove();
            return [false,this.balle.style.top,this.currentY]
        }
        else{
            return [true,this.balle.style.top,this.currentY]
        }
    }
}




class Plasma2{

    constructor(x){
        this.currentposY;
        this.currentposX;
        this.speed = 1.5;
        this.balle = document.createElement("div");
        this.balle.setAttribute("class","Plasma");
        document.getElementById("frameTwo").appendChild(this.balle);
        this.balle.style.top = this.currentY;
        this.balle.style.left = (monHero.tick() + 60) + "px";
        this.balle.style.left = this.x + "px";
        this.currentY = 500;
    }

    tick(){
        
        this.currentY -=this.speed;
        this.balle.style.top = this.currentY + "px";
        this.currentY -= this.speed;
        this.balle.style.top = this.currentY + "px";
        this.actif = false;

        if(this.currentY < 0){
            this.balle.remove();
            return [false,this.balle.style.top,this.currentY]
        }
        else{
            return [true,this.balle.style.top,this.currentY]
        }
    }
}
// Get the modal
var modal = document.getElementById('id01');

// quand on click en dehors du modal, le fermer
window.onclick = function(event) {
    if (event.target == container) {
        modal.style.display = "none";
        
    }
    window.location.href = "index.php";
}

window.onload=()=>{
    document.getElementById('id01').style.display='block';
    document.getElementById('id01').style.width='100%';
    
}



console.log("dans le javascript")








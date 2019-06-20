$("#top").fadeIn(500);
$("#middle").fadeIn(1000);
$("#bottom").fadeIn(1500);




$(document).ready( function() {
    $('#test').hover(
        function() {
            $(this).animate({ 'zoom': 1.2 }, 400);
        },
        function() {
            $(this).animate({ 'zoom': 1 }, 400);
        });
    });
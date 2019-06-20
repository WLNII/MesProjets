<?php


    if(isset($_POST["emailReset"])){

    $emailTo = $_POST["emailReset"];

    $subject = "recuperation mot de passe ";

    $body = "Voici votre mot de passe temporaire:"." ".randomPwd();

    $headers = "From: wlnii@outlook.com";

        if (filter_var($emailTo, FILTER_VALIDATE_EMAIL))
        {
            mail($emailTo, $subject, $body, $headers);
            echo "Le email a ete envoyer avec success";
            
        } else {
            
            echo "le email n'a pas pu etre envoyer";
            
        }
    
    }
    else{
        echo " nothing";  
    }

   function randonPwd(){
    $bytes = openssl_random_pseudo_bytes(4);

    $pwd = bin2hex($bytes);

    return $pwd;
   }

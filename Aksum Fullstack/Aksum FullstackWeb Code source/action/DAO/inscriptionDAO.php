<?php
    require_once("Connection.php");

class inscriptionDAO{
      
    public static function addUser($nom, $prenom, $username, $courriel, $password,$privilege,$foto){
        echo("");
        $maConn2 = Connection::getConnection();

        $sql = "INSERT INTO user (nom, prenom, username,courriel,mdp, privilege,photo)
                VALUES
                (?,?,?,?,?,?,?)";
        $statement = $maConn2->prepare($sql);
        $hash = password_hash($password, PASSWORD_DEFAULT);
        return $statement->execute([$nom, $prenom, $username, $courriel, $hash,$privilege,$foto]);
        echo("reussi");
      }
    }
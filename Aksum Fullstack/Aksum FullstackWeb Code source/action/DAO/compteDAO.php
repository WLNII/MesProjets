<?php
require_once("action/DAO/Connection.php");

class compteDAO{


    public static function userInfo($username){
        
        $connection = Connection::getConnection();
        $sql = "SELECT * FROM user WHERE username = ? ";

        if ($connection !=null) {
        $statement = $connection->prepare($sql);
        $statement->bindParam(1, $username);
        $statement->setFetchMode(PDO::FETCH_ASSOC);
        $statement->execute();

        while($row = $statement->fetch()) {
			return $row;
		    }
        }
    }  

    //ferme le compte de l'usager en allant chercher celui ci par le username passer en parametre
    public static function deleteUser($username){
        $connection = Connection::getConnection();

        if ($connection !=null) {
        $statement = $connection->prepare("DELETE FROM user WHERE username = ?");
        $statement->bindParam(1, $username);
        $statement->setFetchMode(PDO::FETCH_ASSOC);
        $statement->execute();    
                session_unset();
				session_destroy();
				session_start();
                header("location:index.php");
                exit;
			}
        }
    }


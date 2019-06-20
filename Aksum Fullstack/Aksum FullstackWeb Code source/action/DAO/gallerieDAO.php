
<?php
require_once("action/DAO/Connection.php");

class gallerieDAO{

    public static function loadGallerie(){
        
        $connection = Connection::getConnection();
        $sql = "SELECT * FROM item ";

        if ($connection !=null) {
        $statement = $connection->prepare($sql);
        $statement->setFetchMode(PDO::FETCH_ASSOC);
        $statement->execute();

        while($row = $statement->fetchAll()) {
			return $row;
		    }
        }
    }  
}
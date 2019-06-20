<?php
      
class Connection {

        //mac
        // private static $conn;
        // private static $host = "localhost";
        // private static $username = "root";
        // private static $db = "aksum";
        // private static $password = "root";


        //windows
        private static $conn;
        private static $host = "localhost:3306";
        private static $username = "root";
        private static $db = "aksum";
        private static $password = "password";


        public static function getConnection() {
                try{
                 // create a PDO connection with the configuration data
                 Connection::$conn = new PDO("mysql:host=".Connection::$host.";dbname=" . Connection::$db, Connection::$username, Connection::$password);
                 Connection::$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
                 Connection::$conn->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
                 // display a message if connected to database successfully
                 if(Connection::$conn){
                 //echo "Connected to the <strong>".Connection::$db."</strong> database successfully!";
                 //echo "<br>";
                        }
                }catch (PDOException $e){
                 // report error message
                 echo $e->getMessage();
                }
        
                return Connection::$conn;
        }




        
              
}
                // public static function getInstance() {
                //         if(!isset(self::$instance)) {
                //          self::$instance = new Connection();
                //         }
                //  return self::$instance->pdo;
                // }
                // $data = [
                //         'name' => $name,
                //         'surname' => $surname,
                //         'sex' => $sex,
                //     ];
               
        //        try {
        //         $sql = " INSERT INTO user (nom, prenom, username,courriel,addresse,mdp)
        //         VALUES
        //         ('lam','will','wlnii','wlnii@outlook.com','123 cloud street', 'yoda')";
                
        //         $sql2 = "SELECT * FROM item";


        // $maConn = new Connection();
        // $maConnexion = $maConn->getConnection();
        // $statement = $maConnexion->prepare($sql);
        // $statement->execute();
        //        }catch (Exception $e){
        //                var_dump($e);
        //        }
        //echo $stmt->rowCount();

       // $retval = "mysql_query( $sql, $stmt )";

       //fetchRows($stmt);

        function fetchRows($e){

                while ($row = $e->fetch(PDO::FETCH_ASSOC)){     
                        print_r($row);
                        echo "<br>";
                        echo "<br>";
                        echo "printed";
                }        
       }

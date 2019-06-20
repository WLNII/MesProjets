<?php
require_once("action/DAO/Connection.php");
	class UserDAO {

		public static function authenticate($username, $password, $privilege) {
			$connection = Connection::getConnection();

			$statement = $connection->prepare("SELECT * FROM USER WHERE USERNAME = ?");
			$statement->bindParam(1, $username);
			$statement->setFetchMode(PDO::FETCH_ASSOC);
			$statement->execute();

			$userInfo = null;
			$privi=null;

			$visibility = 0;
			$_SESSION['member']=false;
			

			if ($row = $statement->fetch()) {
				if (password_verify($password, $row["mdp"])) {
					$userInfo = $row;
				}

				if($row['privilege'] == $privilege && $row['privilege'] !=0 ){
					$_SESSION['member']=true;
					$privi = $row;
				}

			return $userInfo;
			}
		}
	}


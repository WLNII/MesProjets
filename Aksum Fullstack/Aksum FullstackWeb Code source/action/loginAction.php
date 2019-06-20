<?php
	require_once("action/CommonAction.php");
	require_once("action/DAO/userDAO.php");

	class LoginAction extends CommonAction {
		public $wrongLogin;

		public function __construct() {
			parent::__construct(CommonAction::$VISIBILITY_PUBLIC);
		}

		protected function executeAction() {
			$this->wrongLogin = false;
//fonction permettant de verifier si utilisateur a les bonnes informations
			if(isset($_POST["username"])) {
				$visibility = UserDAO::authenticate($_POST["username"], $_POST["pwd"],$_POST["privilege"]);
				if ($visibility > CommonAction::$VISIBILITY_PUBLIC) {
					$_SESSION["username"] = $_POST["username"];
					$_SESSION["visibility"] = $visibility;
					header("location:index.php");
					exit;
				} else {
					$this->wrongLogin = true;
				}
			}	
		}
	}
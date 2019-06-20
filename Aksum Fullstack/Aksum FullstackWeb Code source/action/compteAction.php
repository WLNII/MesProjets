<?php
	require_once("action/CommonAction.php");
	require_once("action/DAO/compteDAO.php");

	class compteAction extends CommonAction {

		public $mesInfo;

		public function __construct() {
			parent::__construct(CommonAction::$VISIBILITY_PUBLIC);
		}

		protected function executeAction() {

			$this->mesInfo = compteDAO::userInfo($_SESSION["myName"]);
			

//permet d'efacer un utilisateur en utilisant son id
			if (isset($_POST['inputDelete'])) 
			{
				 compteDAO::deleteUser($_POST["inputDelete"]);
					header("location:login.php");
					exit;
				} 

		}
	}
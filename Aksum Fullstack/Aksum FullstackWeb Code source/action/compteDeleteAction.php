<?php
	require_once("action/CommonAction.php");
	require_once("action/DAO/compteDeleteDAO.php");

	class compteAction extends CommonAction {
		public function __construct() {
			parent::__construct(CommonAction::$VISIBILITY_PUBLIC);
		}

		protected function executeAction() {			

			if (isset($_POST['inputDelete'])) 
			{
				 compteDAO::deleteUser($_POST["inputDelete"]);
					header("location:login.php");
					exit;
			} 
		}
	}
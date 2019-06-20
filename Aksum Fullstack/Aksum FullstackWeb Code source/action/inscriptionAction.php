<?php
	require_once("action/CommonAction.php");
	require_once("action/DAO/inscriptionDAO.php");

	class inscriptionAction extends CommonAction {

		public function __construct() {
			parent::__construct(CommonAction::$VISIBILITY_PUBLIC);
		}

		//validation mot de passe ainsi que niveau de privilege
		protected function executeAction() {

			if(isset($_POST["foto"])){

			}

			if ($_POST["mdp"] != $_POST["mdp2"]) {
				echo '<script language="javascript">';
				echo 'alert("mot de passe non-identiques")';
				echo '</script>';

			}
			else{

			if (isset($_POST['nom'])) 
			{ 
				if ($_POST["privilege"]=="") {
					$_POST["privilege"]=0;
				 
				}
			
				inscriptionDAO::addUser($_POST["nom"], $_POST["prenom"],$_POST["username"],$_POST["courriel"],$_POST["mdp"],$_POST["privilege"], "images/profilPics/".$_POST["foto"]);
					header("location:login.php");
					exit;		
				} 
			}
		}	            
	}
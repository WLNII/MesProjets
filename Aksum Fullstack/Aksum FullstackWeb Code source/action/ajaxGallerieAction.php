<?php
	require_once("action/CommonAction.php");
	require_once("action/DAO/gallerieDAO.php");

	class ajaxGallerieAction extends CommonAction {
		public function __construct() {
			parent::__construct(CommonAction::$VISIBILITY_PUBLIC);
		}

		protected function executeAction() {
        $this->ajaxGallerieInfo = gallerieDAO::loadGallerie();
		}
	}
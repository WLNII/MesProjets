<?php
    require_once("action/ajaxGallerieAction.php");

    $action = new ajaxGallerieAction();
    $action->execute();


    echo json_encode($action->ajaxGallerieInfo);
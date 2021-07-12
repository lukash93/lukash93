<?php

    if($_POST)
    {
        require('core/core.php');
        
        switch(isset($_GET['mode']) ? $_GET['mode'] : null)
        {
            default:
                header('location: index.php');
                break;
        }
    }
    else
    {
        header('location: index.php');
    }

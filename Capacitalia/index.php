<?php
    
    require('core/core.php');

    //Condicional de definición de vistas
    if(isset($_GET['view']))
    {
        //El metodo 'strtolower' se utiliza para no tener problemas de escritura
        if(file_exists('core/controllers/'. strtolower($_GET['view'] . 'Controller.php')))
        {
            include('core/controllers/'. strtolower($_GET['view'] . 'Controller.php'));
        }
        else
        {
            include('core/controllers/errorController.php');
        }
    }
    else
    {
        //Incluye el controlador
        include('core/controllers/indexController.php');
    }
?>
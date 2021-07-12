<?php

    //Este es el Nucleo de la Aplicación
    
    date_default_timezone_set('Chile/Continental');
    
    //Constantes de Conexión
    define('DB_HOST','localhost');
    define('DB_USER','root');
    define('DB_PASS','');
    define('DB_NAME','capacitaliadb');

    //Constantes de la Aplicación
    define('HTML_DIR','html/');
    define('APP_TITLE','Capacitalia');
    define('APP_COPY','© '.date('Y',time()).' Capacitalia, Todos los derechos reservados.');
    define('APP_URL','http://localhost/Capacitalia/');
    
    //Estructuras de Conexión que Cargan todas las librerias
    require('core/models/class.Conexion.php');
    
?>
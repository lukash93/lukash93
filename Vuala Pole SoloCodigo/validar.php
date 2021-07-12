<?php
    $user=$_POST['user'];
    $pass=$_POST['pass'];
//Conexion BD
    $conexion=mysqli_connect("localhost","vualapol","U0nt7voK45","vualapol_vualapol");
    
    $consulta="SELECT * FROM usuarios WHERE user='$user' and pass='$pass'";
    $resultado=mysqli_query($conexion, $consulta);
//Validador    
    $filas=mysqli_num_rows($resultado);
    if($filas>0){
        header("location:cpanel.html");
    }else{
        echo "Error de autentificaci&oacuten";
    }
    mysqli_free_result($resultado);
    mysqli_close($conexion);
?>
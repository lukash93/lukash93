<?php
    $conexion=mysqli_connect("localhost","vualapol","U0nt7voK45","vualapol_vualapol");
    
    $imag = basename($_FILES["imagen"]["name"]);
    $pathupload = 'imagenes/' . $imag;
    echo '<pre>';
    if (move_uploaded_file($_FILES['imagen']['tmp_name'],$pathupload)){
        echo 'exito';
    }else{
            echo 'error';
        }
    
    print_r($_FILES); 
    print "</pre>";

    $titulo_ = $_POST["titulo"];
    $subtitulo_ = $_POST["subtitulo"];
    $text_ = $_POST["text"];
 
    $_grabar = "insert into slider2 (titulo,subtitulo,text,imagen) values ('$titulo_','$subtitulo_','$text_','$imag');";
    mysqli_query($conexion, $_grabar);
                        
?>

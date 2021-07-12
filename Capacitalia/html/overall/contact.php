<!--------Start-Contact-----------> 
 <div class="contact" id="contact">
	<div class="wrap">
		<h2>Contáctanos</h2>
			<div class="contact-form">
				<div class="para-contact">
					<h4>Mantente en contácto con nosotros</h4>
					<p>Si deseas mas información sobre nuestros cursos no dudes en contactárnos.</p>
				
				 	<div class="social_2 social_3">	
			           <ul>	
						    <li class="facebook"><a href="https://www.facebook.com/CapacitaliaLtda/"><span> </span></a></li>
						    <li class="twitter"><a href="https://twitter.com/oteccapacitalia"><span> </span></a></li>
					  </ul>
		 		  </div>
		 		  <div class="get-intouch-left-address">
						<p>Calle Moneda #812, Oficina 708</p>
						<p>Santiago Centro, Chile.</p>
						<p>+56 (02) 4813997</p>
                        <p><a href="mailto:contacto@capacitalia.cl"> contacto@capacitalia.cl</a></p>
                        <br/>
                        <p>Ruben Castagneto #1495</p>
						<p>La Serena, Chile.</p>
						<p>+56 (9) 63685682</p>
						<p><a href="mailto:contacto@capacitalia.cl"> amaureir67@gmail.com</a></p>
					</div>
					<div class="clear"></div>
                    
				</div>	
						<div class="form">
                                <form id="contact-form" action="mail.php">
                                    <div class="control-group">
                                        <div class="controls">
                                            <input class="span12" type="text" id="name" name="name" placeholder="Nombre: " />
                                            <div class="error left-align" id="err-name">Por favor ingrese su nombre.</div>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <input class="span12" type="email" name="email" id="email" placeholder="E-Mail: " />
                                            <div class="error left-align" id="err-email">Por favor ingrese una dirección de correo valida.</div>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <textarea class="span12" name="comment" id="comment" placeholder="Escriba aquí su comentario..."></textarea>
                                            <div class="error left-align" id="err-comment">Por favor ingrese su comentario.</div>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="button send_button">
                                            <input id="send-mail" type="submit" value="Enviar">
                                        </div>
                                    </div>
                                </form>
                                <div id="successSend" class="alert alert-success invisible">
                                    <strong>¡Bien Hecho!</strong>Su mensaje ha sido enviado.
                                </div>
                                <div id="errorSend" class="alert alert-error invisible">Hubo un problema.</div>
								<div class="clear"> </div>
						</div>
						<a class="mov-top" href="#home1"> <span> </span></a>
					 <div class="clear"> </div>
				</div>
  			</div>
     </div>
     <!-- contact_form -->
        <script type="text/javascript" src="views/app/js/contact.js"></script>
     <!-- scroll_top_btn -->
		<script type="text/javascript" src="views/app/js/move-top.js"></script>
		<script type="text/javascript" src="views/app/js/easing.js"></script>
	    <script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
		<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>

		 <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
<!--------//end-contact----------->
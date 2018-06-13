<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html >
<head>
  <meta charset="UTF-8">
  <title>Iniciar Sesión</title>
  
  
  
      <link rel="stylesheet" href="css/login.css">
      <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet" type="text/css"/>
  
</head>

<body>
  <body>
<div class="container">
	<section id="content">
		<form action="">
			<h1>Iniciar Sesión</h1>
			<div>
                            <input type="text" placeholder="Usuario" id="username" />
			</div>
			<div>
				<input type="password" placeholder="Clave" id="password" />
			</div>
			<div>
                            <a><input type="button"e value="Inicio sesion" id="ingresar"/></a>
			</div>
		</form><!-- form -->

	</section><!-- content -->
</div><!-- container -->
</body>
  
    <script src="js/index.js"></script>
      <script src="js/jquery-2.1.1.js"></script>
      <script src="js/plugins/toastr/toastr.min.js" type="text/javascript"></script>
    <script>
        $("#ingresar").click(function(){
            var login = $("#username").val();
            var pass = $("#password").val();

            if (login === "" && pass === "") {
                toastr.warning('Debe ingresar usuario y contraseña');
                return false;
            }else if(login === ""){
                toastr.warning('Debe ingresar el usuario');
                return false;
            }else if(pass === ""){
                toastr.warning('Debe ingresar la contraseña');
                return false;                
            }else{
                if(login === "Admin" && pass === "123"){
                  window.location.assign("Fincas.jsp"); 
                }else{              
                    toastr.warning('Usuario no se encuentra registrado');
                }
            }            
        });
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Formulario</h1>
	<form id="form">
		<div>
			<label for="email">Email</label> <input type="text" id="email"
				name="email" class="span-6" value="emailteste@gmail.com" onkeyup="updateForm()" />
		</div>
		<div>
			<label for="senha">Senha</label> <input type="text" id="senha"
				name="senha" class="span-6" value="" onkeyup="updateForm()" />
		</div>
		<div>
			<input type="checkbox" id="lembrar" checked="true">Lembrar
			senha?</input>
		</div>
		<div>
			<input type="submit" id="submit" name="send" value="Login"
				disabled="true" /> 
			<input type="reset" id="limpar" value="Limpar">
			<input type="hidden" id="senhaSegura">
		</div>
	</form>
	<script>
	   function updateForm () {
		    var email = document.getElementById("email").value;
		    var senha = document.getElementById("senha").value;
		    var btnSubmit = document.getElementById("submit");
		    if(email.length > 0 && senha.length > 0){
		    	btnSubmit.disabled = false;	
		    }else{
		    	btnSubmit.disabled = true;
		    }
	   }
	
	</script>
</body>
</html>
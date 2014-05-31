<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Assincrono</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js" /></script>
</head>
<body>
	<h1>Login</h1>
	
	<div id="messageArea">
	
	</div>
	
	<form id="form" method="post">
		<div>
			<label for="email">Email</label> <input type="text" id="email"
				name="email" class="span-6" value="" />
		</div>
		<div>
			<label for="senha">Senha</label> <input type="password" id="senha"
				name="senha" class="span-6" value="" />
		</div>
		<div>
			<input type="submit" id="submit" name="send" value="Login" onclick="return enviarForm()" /> 
			<input type="reset" id="limpar" value="Limpar">
		</div>
	</form>
	<script>
	   function enviarForm( e ){
		   $("#messageArea").empty();
		   $.ajax({
			   url: "${pageContext.request.contextPath}/login",
			   type: "post",
			   data: {
				   email: $("#email").val(),
				   senha: $("#senha").val()
			   },
			   success: function(data , textStatus, jqXHR){
				   var json = JSON.parse( data );
				   var classe = json.status;
				   $("#messageArea").append("<span id='" + classe + "'>" + json.message + "</span>");
			   },
			   error: function(jqXHR , textStatus, errorThrown){
                   alert("Error: " , errorThrown );
               }
		   });
		   return false;
	   }
	</script>
</body>
</html>
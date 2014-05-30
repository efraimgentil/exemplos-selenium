<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.border {
	border: 1px solid;
	border-style: gray;
}

.divpai {
	background-color: #888888;
}

.divfilho {
	padding-left: 22px;
	background-color: #D0D0D0;
}

.divneto {
	padding-left: 44px;
	background-color: #F0F0F0;
}

.direita {
	float: right;
	width: 200px;
}

.esquerda {
	float: left;
	margin-right: 200px;
}
</style>
</head>
<body>
	<h1>PAGINA COMPLEXA 2</h1>

	<form method="post" name="form1" action="resultado.php">
		<b>Dados basicos</b><br>
		<table>
			<tr>
				<td width="100px" style="text-align: right">E-mail:</td>
				<td><input id=name-920 name=name-920 size="50" maxlength="70"
					type="text"></td>
			</tr>
			<tr>
				<td width="100px" style="text-align: right">Senha:</td>
				<td><input id=632-password name=632-password size="30"
					maxlength="50" type="password"></td>
			</tr>
			<tr>
				<td width="100px" style="text-align: right">Repetir Senha:</td>
				<td><input id=162-password-162 name=162-password-162 size="30"
					maxlength="50" type="password"></td>
			</tr>
		</table>
		<input type="submit" id="send" value="Cadastrar">
	</form>
</body>
</html>
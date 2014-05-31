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
	<form method="post" name="form1" action="resultado.php">
		<b>Dados basicos</b>
		<br>
		<table>
			<tr>
				<td width="10px">Nome</td>
				<td><input id="name1" name="fname" size="50" maxlength="70"
					type="text"></td>
			</tr>
			<tr>
				<td width="10px">Sobrebome</td>
				<td><input id="name2" name="lname" size="50" maxlength="50"
					type="text"></td>
			</tr>
		</table>

		<b>Sexo</b><br>
		<table>
			<tr>
				<td><input value="Homem" name="gender" type="radio">Homem</td>
			</tr>
			<tr>
				<td><input value="Mulher" name="gender" type="radio">Mulher</td>
			</tr>
		</table>

		<b>Qual sua comida favorita?</b><br>
		<table>
			<tr>
				<td align="center"><input id="value1" value="Carne"
					name="food[]" type="checkbox"> Carne</td>
			</tr>
			<tr>
				<td align="center"><input id="value2" value="Frango"
					name="food[]" type="checkbox"> Frango</td>
			</tr>
			<tr>
				<td align="center"><input id="value3" value="Pizza"
					name="food[]" type="checkbox"> Pizza</td>
			</tr>
		</table>
		Outra comida: <br>
		<textarea id='txtarea' name="area" rows="3" cols="10" wrap="physical"
			onfocus="limpaTxtArea();">Insira aqui outra(s) comida(s) favorita(s)</textarea>
		<br> <br> <b>Selecione o seu nível de instrução</b><br>
		<select name="education">
			<option value="1grauincomp">1° grau incompleto</option>
			<option value="1graucomp">1° grau completo</option>
			<option value="2grauincomp">2° grau incompleto</option>
			<option value="2graucomp">2° grau completo</option>
			<option value="graduado">Graduado</option>
			<option value="pos">Pós-Graduação / MBA</option>
			<option value="mestrado">Mestrado</option>
			<option value="doutorado">Doutorado</option>
		</select><br> <br> <b>Selecione a melhor parte do seu dia</b><br>
		<select multiple="multiple" id="dia" name="melhorpartedia[]" size="3">
			<option value="Manhã">Manhã</option>
			<option value="Tarde">Tarde</option>
			<option value="Noite">Noite</option>
		</select>
		<p>
			<input type="submit" name="send" value="Enviar dados">
	</form>
</body>
</html>
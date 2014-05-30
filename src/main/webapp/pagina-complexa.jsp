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
	<h1>PAGINA COMPLEXA</h1>

	<div class="divpai border">
		Div Pai
		<div class="divfilho border">
			Div Filho
			<div class="divneto border">Div Neto 1</div>
			<div class="divneto border">Div Neto 2</div>
		</div>
	</div>
	
	<br />
	
	<b>Lista de Relatorios</b>
	<ul>
		<li><a href="#">Relatorio Diario</a></li>
		<li><a href="#">Relatorio Semanal</a></li>
		<li><a href="#">Relatorio Mensal</a></li>
		<li><a href="#">Relatorio Trimestral</a></li>
		<li><a href="#">Relatorio Semanal</a></li>
		<li><a href="#">Relatorio Anual</a></li>
	</ul>

	Data Inicio Relatorio:
	<input type="text" id="dataInicio" />
	<br/> Data Fim Relatorio:
	<input type="text" name="dataFimRelatorio" />


</body>
</html>
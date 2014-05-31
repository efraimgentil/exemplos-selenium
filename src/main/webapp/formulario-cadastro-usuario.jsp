<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	<h1>Cadastro de Usuário</h1>
	
	<c:if test="${message != null}">
	   <span id="message"><c:out value="${message}" /></span>
	</c:if>
	
	<form id="form" method="post"  >
		<div>
			<label for="nomeUsuario">Nome Usuário</label> <input type="text"
				id="nomeUsuario" name="nomeUsuario" class="span-6" value=""
				onkeyup="updateForm()" />
            <c:if test="${errorNomeUsuario != null}">
		       <span id="errorNomeUsuario"><c:out value="${errorNomeUsuario}" /></span>
		    </c:if>				
		</div>
		<div>
			<label for="login">Login</label> <input type="text" id="login"
				name="login" class="span-6" value="" onkeyup="updateForm()" />
			 <c:if test="${errorLogin != null}">
               <span id="errorLogin"><c:out value="${errorLogin}" /></span>
            </c:if>         
		</div>
		<div>
			<label for="email">Email</label> <input type="text" id="email"
				name="email" class="span-6" value="" onkeyup="updateForm()" />
			 <c:if test="${errorEmail != null}">
               <span id="errorEmail"><c:out value="${errorEmail}" /></span>
            </c:if>
		</div>
		<div>
			<label for="senha">Senha</label> <input type="text" id="senha"
				name="senha" class="span-6" value="" onkeyup="updateForm()" />
			<c:if test="${errorSenha != null}">
               <span id="errorSenha"><c:out value="${errorSenha}" /></span>
            </c:if>
		</div>
		<div>
			<input type="submit" id="submit" value="Cadastrar" />
			<input type="reset" id="limpar"  value="Limpar">
		</div>
	</form>
</body>
</html>
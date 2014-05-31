package br.com.efraimgentil.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.efraimgentil.model.Usuario;

@WebServlet("/cadastro-usuario")
public class CadastroUsuario extends HttpServlet {

	private static final long serialVersionUID = -5422724464308818530L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/formulario-cadastro-usuario.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario(  req.getParameter("nomeUsuario") );
		usuario.setLogin( req.getParameter("login") );
		usuario.setEmail( req.getParameter("email") );
		usuario.setSenha( req.getParameter("senha") );
		
		if( isValid( usuario  , req ) ){
			req.setAttribute("message", "Cadastro realizado com sucesso");
		}else{
			req.setAttribute("message", "Não foi possivel cadastrar, verifique os dados informados");
		}
		req.getRequestDispatcher("/formulario-cadastro-usuario.jsp").forward(req, resp);
	}

	private boolean isValid(Usuario usuario, HttpServletRequest req) {
		boolean valido = true;
		if(usuario.getLogin() == null || usuario.getLogin().isEmpty() ){
			req.setAttribute("errorLogin", "Login deve ser preenchido");
			valido = false;
		}
		if(usuario.getSenha() == null || usuario.getSenha().isEmpty() ){
			req.setAttribute("errorSenha", "Senha deve ser preenchido");
			valido = false;
		}else if ( usuario.getSenha().length() < 6 ){
			req.setAttribute("errorSenha", "Senha deve ter no minimo 6 caracteres");
			valido = false;
		}
		if(usuario.getEmail() == null || usuario.getEmail().isEmpty() ){
			req.setAttribute("errorEmail", "Email deve ser preenchido");
			valido = false;
		}
		if(usuario.getNomeUsuario() == null || usuario.getNomeUsuario().isEmpty()){
			req.setAttribute("errorNomeUsuario", "Nome Usuário deve ser preenchido");
			valido = false;
		}
		return valido;
	}
	
}

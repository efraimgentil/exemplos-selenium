package br.com.efraimgentil.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginAssincrono extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		resp.setCharacterEncoding( "utf-8" );
		PrintWriter writer = resp.getWriter();
		if("email@email.com".equals(email) && "senha".equals(senha) ){
			writer.write("{ \"message\": \"Usuário logado com sucesso\" , \"status\" : \"sucesso\" }");
		}else{
			writer.write("{ \"message\": \"Login e/ou senha invalidos\" , \"status\"  : \"falha\" }");
		}
	}
	
}

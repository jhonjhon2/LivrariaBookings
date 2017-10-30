package br.com.lovefood.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lovefood.entity.Funcionario;
import br.com.lovefood.entity.Funcionario.Nivel;
import br.com.lovefood.service.FuncionarioService;

@WebServlet({ "/sistema/func/buscar", "/sistema/func/excluir", "/sistema/func/salvar" })
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PREFIX = "/sistema/func/";

	public ServletFuncionario() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Dentro dessa estrutura encadeada (if-else if), teremos o buscar, listar e
		// excluir
		if (request.getServletPath().equals(PREFIX + "buscar")) {
			buscar(request, response);

		} else if (request.getServletPath().equals(PREFIX + "excluir")) {
			response.getWriter().append("excluir");

		} else {
			response.getWriter().append("URL N�o encontrada!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals(PREFIX + "salvar")) {
			salvar(request, response);
		}
	}
	private void salvar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Funcionario f = new Funcionario();
		f.setNome(request.getParameter("nome"));
		f.setLogin(request.getParameter("login"));
		f.setSenha(request.getParameter("senha"));
		f.setNivel(Nivel.valueOf(request.getParameter("nivel")));
		
		String resposta = "";
		
		if(new FuncionarioService().salvar(f)) {
			resposta = "Funcion�rio salvo com sucesso";
		}
		
		response.getWriter().append(resposta);
		
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		if (request.getParameter("nome") != null) {
			response.getWriter().append("buscar pelo nome: " + request.getParameter("nome"));
		
		} else if (request.getParameter("id") != null) {
			response.getWriter().append("buscar pelo id: " + request.getParameter("id"));
		
		} else {
			response.getWriter().append("buscar todos");
		}
	}
}

package br.com.lovefood.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lovefood.entity.Cliente;
import br.com.lovefood.service.ClienteService;

@WebServlet({ "/sistema/cliente/buscar", "/sistema/cliente/excluir", "/sistema/cliente/salvar",
		"/sistema/cliente/atualizar" })
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PREFIX = "/sistema/cliente/";

	public ServletCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getServletPath().equals(PREFIX + "buscar")) {
			buscar(request, response);

		} else if (request.getServletPath().equals(PREFIX + "excluir")) {
			excluir(request, response);

		} else {
			response.getWriter().append("URL Não encontrada!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getServletPath().equals(PREFIX + "salvar")) {
			salvar(request, response);
		} else if (request.getServletPath().equals(PREFIX + "excluir")) {
			atualizar(request, response);
		}
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("nome") != null) {
			response.getWriter().append("buscar pelo nome: " + request.getParameter("nome"));

		} else if (request.getParameter("id") != null) {
			response.getWriter().append("buscar pelo id: " + request.getParameter("id"));

		} else {

			for (Cliente c : new ClienteService().buscar()) {
				response.getWriter().append(c.toString() + "<br>");

			}
		}
	}

	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente c = new Cliente();

		c.setId(Long.parseLong(request.getParameter("id")));
		c.setNome(request.getParameter("nome"));
		c.setLogin(request.getParameter("login"));
		c.setCpf(request.getParameter("cpf"));
		c.setEndereco(request.getParameter("endereco"));
		c.setTelefone(request.getParameter("telefone"));
		c.setSenha(request.getParameter("senha"));

		String resposta = "";

		if (new ClienteService().salvar(c)) {
			resposta = "Cliente salvo com sucesso";
		}

		response.getWriter().append(resposta);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		String resposta = "";

		if (new ClienteService().excluir(id)) {
			resposta = "Cliente excluído com sucesso";
		}

		response.getWriter().append(resposta);
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente c = new Cliente();
		c.setId(Long.parseLong(request.getParameter("id")));
		c.setSenha(request.getParameter("senha"));

		String resposta = "";

		if (new ClienteService().trocaSenha(c)) {
			resposta = "Senha do cliente atualizada com sucesso";
		}

		response.getWriter().append(resposta);
	}
}

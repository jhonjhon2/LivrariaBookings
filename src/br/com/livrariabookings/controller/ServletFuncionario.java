package br.com.livrariabookings.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livrariabookings.entity.Funcionario;
import br.com.livrariabookings.entity.Funcionario.Nivel;
import br.com.livrariabookings.service.FuncionarioService;

@WebServlet({ "/sistema/fun/buscar", "/sistema/fun/excluir", "/sistema/fun/salvar", "/sistema/fun/atualizar" })
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PREFIX = "/sistema/fun/";

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
			excluir(request, response);

		} else {
			response.getWriter().append("URL Não encontrada!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals(PREFIX + "salvar")) {
			salvar(request, response);
		} else if (request.getServletPath().equals(PREFIX + "atualizar")) {
			atualizar(request, response);
		}
	}

	private void salvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Funcionario f = new Funcionario();
		f.setNome(request.getParameter("nome"));
		f.setLogin(request.getParameter("login"));
		f.setSenha(request.getParameter("senha"));
		f.setNivel(Nivel.valueOf(request.getParameter("nivel")));

		String resposta = "";

		if (new FuncionarioService().salvar(f)) {
			resposta = "Funcionário salvo com sucesso";
		}

		response.getWriter().append(resposta);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("nome") != null) {
			for (Funcionario f : new FuncionarioService().buscarPorNome(request.getParameter("nome"))) {
				response.getWriter().append(f.toString() + "<br>");
			}

		} else if (request.getParameter("id") != null) {
			Long id = Long.parseLong(request.getParameter("id"));
			response.getWriter().append(new FuncionarioService().buscarPorId(id).toString());

		} else {

			for (Funcionario f : new FuncionarioService().buscar()) {
				response.getWriter().append(f.toString() + "<br>");
			}
		}
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));

		String resposta = "";

		if (new FuncionarioService().excluir(id)) {
			resposta = "Funcionário excluído com sucesso";
		}

		response.getWriter().append(resposta);
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Funcionario f = new Funcionario();
		String resposta = "";

		f.setId(Long.parseLong(request.getParameter("id")));

		if (request.getParameter("nivel") != null) {
			f.setNivel(Nivel.valueOf(request.getParameter("nivel")));

			if (new FuncionarioService().atualizaNivel(f)) {
				resposta = "Nível do funcionário atualizado com sucesso";
			}
		} else if (request.getParameter("senha") != null) {
			f.setSenha(request.getParameter("senha"));

			if (new FuncionarioService().atualizaNivel(f)) {
				resposta = "Senha do funcionário atualizado com sucesso";
			}
		}
		response.getWriter().append(resposta);
	}
}

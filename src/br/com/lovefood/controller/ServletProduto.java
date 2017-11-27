package br.com.lovefood.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lovefood.entity.Produto;
import br.com.lovefood.util.Upload;

@WebServlet({ "/sistema/admin/prd/save", "/sistema/admin/prd/remove", "/sistema/prd/buscar" })
@MultipartConfig
public class ServletProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/sistema/admin/prd/";

	public ServletProduto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	private void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getServletPath().equals(PREFIX + "save"))
			save(request, response);
		else if (request.getServletPath().equals(PREFIX + "remove"))
			delete(request, response);
		else
			find(request, response);

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Produto produto = new Produto();

		produto.setNmProduto(request.getParameter("nome"));
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		produto.setPreco(Double.parseDouble(request.getParameter("preco")));

		if (request.getPart("foto").getSize() == 0) {
			produto.setImagem(request.getParameter("imagem"));
		} else if (request.getParameter("imagem") != null) {
			produto.setImagem(Upload.Imagem(request, response));
		} else {
			produto.setImagem("default.jpg");
		}

		// new ProdutoService.save(produto);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

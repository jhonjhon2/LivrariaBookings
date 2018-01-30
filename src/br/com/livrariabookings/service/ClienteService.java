package br.com.livrariabookings.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livrariabookings.entity.Cliente;
import br.com.livrariabookings.entity.Usuario;
import br.com.livrariabookings.persistence.ClienteDAO;

public class ClienteService {
	private ClienteDAO dao;

	public ClienteService() {
		dao = new ClienteDAO();
	}

	public Boolean salvar(Cliente c) {
		try {
			dao.save(c);
			return Boolean.TRUE;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Boolean.FALSE;
	}

	public Boolean excluir(Long id) {
		try {
			dao.delete(id);
			return Boolean.TRUE;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Boolean.FALSE;
	}

	public List<Cliente> buscar() {
		try {
			return dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Cliente>();
	}

	public Boolean trocaSenha(Cliente c) {
		try {
			dao.changePassword(c);
			return Boolean.TRUE;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}
	
	public Cliente efetuaLogin(Usuario usuario) {
		try {
			return dao.efetuarLogin(usuario);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

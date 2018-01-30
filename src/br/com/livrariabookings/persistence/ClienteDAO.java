package br.com.livrariabookings.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.livrariabookings.entity.Cliente;
import br.com.livrariabookings.entity.Usuario;

public class ClienteDAO extends ConnectionDAO {

	private Connection conn = null;

	public ClienteDAO() {
		try {
			conn = getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(Cliente c) throws SQLException {
		PreparedStatement stmt = null;
		try {
			if (c.getId() == null) {
				stmt = conn.prepareStatement("insert into cliente values (null, ?, ?, ?, ?, ?, md5(?))");

			} else {
				stmt = conn.prepareStatement(
						"update cliente set nome = ?, login = ?, cpf = ?, endereco = ?, telefone = ? where id = ?");
			}

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getLogin());
			stmt.setString(3, c.getCpf());
			stmt.setString(4, c.getEndereco());
			stmt.setString(5, c.getTelefone());

			if (c.getId() != null) {
				stmt.setLong(6, c.getId());
			} else {
				stmt.setString(6, c.getSenha());
			}

			int count = stmt.executeUpdate();

			if (count == 0)
				throw new SQLException("Erro ao salvar o cliente");
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public void delete(Long id) throws SQLException {

		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("delete from cliente where id = ?");
			stmt.setLong(1, id);

			int count = stmt.executeUpdate();

			if (count == 0)
				throw new SQLException("Erro ao excluir o cliente");

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public List<Cliente> findAll() throws SQLException {

		List<Cliente> clientes = new ArrayList<Cliente>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement("select id, nome, login, cpf, endereco, telefone from cliente");

			rs = stmt.executeQuery();

			while (rs.next()) {
				clientes.add(createCliente(rs));
			}

		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

		return clientes;
	}

	public void changePassword(Cliente c) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update cliente set senha = md5(?) where id = ?");

			stmt.setString(1, c.getSenha());
			stmt.setLong(2, c.getId());

			int count = stmt.executeUpdate();

			if (count == 0)
				throw new SQLException("Erro ao trocar a senha do cliente");
			
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}
	
	public Cliente efetuarLogin(Usuario u) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente c = null;
		
		try {
			stmt = conn.prepareStatement("select id, nome, login, cpf, endereco, telefone from cliente where login like ? and senha = md5(?)");
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				c = createCliente(rs);
			}
			
		}finally {
			if(conn != null)
				conn.close();
			
			if(stmt != null)
				stmt.close();
			
			if(rs != null)
				rs.close();
		}
		
		return c;
	}

	private Cliente createCliente(ResultSet rs) throws SQLException {
		Cliente c = new Cliente();

		c.setId(rs.getLong(1));
		c.setNome(rs.getString(2));
		c.setLogin(rs.getString(3));
		c.setCpf(rs.getString(4));
		c.setEndereco(rs.getString(5));
		c.setTelefone(rs.getString(6));

		return c;
	}
}
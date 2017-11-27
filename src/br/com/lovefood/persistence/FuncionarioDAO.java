package br.com.lovefood.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lovefood.entity.Funcionario;
import br.com.lovefood.entity.Funcionario.Nivel;
import br.com.lovefood.entity.Usuario;

public class FuncionarioDAO extends ConnectionDAO {

	private Connection conn = null;

	public FuncionarioDAO() {
		try {
			conn = getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// método responsável por gravar ou editar o funcionário
	public void save(Funcionario f) throws SQLException {
		PreparedStatement stmt = null;
		try {
			// se o ID estiver vazio(null), será gravado um novo funcionário
			if (f.getId() == null) {
				stmt = conn.prepareStatement("insert into funcionario values (null, ?, ?, md5(?), ?)");

				// se o ID já estiver definido(setado), será editado o funcionário
			} else {
				stmt = conn.prepareStatement("update funcionario set nome = ?, login = ? where id = ?");
			}

			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getLogin());

			if (f.getId() != null) {
				// atualizar
				stmt.setLong(3, f.getId());
			} else {
				// gravar
				stmt.setString(3, f.getSenha());
				stmt.setString(4, f.getNivel().toString());
			}

			int count = stmt.executeUpdate();

			if (count == 0)
				throw new SQLException("Erro ao gravar o funcionario");
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public void updateNivel(Funcionario f) throws SQLException {

		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("update funcionario set nivel = ? where id = ?");
			stmt.setString(1, f.getNivel().toString());
			stmt.setLong(2, f.getId());

			int count = stmt.executeUpdate();

			if (count == 0)
				throw new SQLException("Erro ao atualizar o funcionario");

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}
	
	public void updateSenha(Funcionario f) throws SQLException {

		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("update funcionario set senha = ? where id = ?");
			stmt.setString(1, f.getSenha());
			stmt.setLong(2, f.getId());

			int count = stmt.executeUpdate();

			if (count == 0)
				throw new SQLException("Erro ao atualizar o funcionario");

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
			stmt = conn.prepareStatement("delete from funcionario where id = ?");
			stmt.setLong(1, id);

			int count = stmt.executeUpdate();

			if (count == 0)
				throw new SQLException("Erro ao salvar o funcionario");

		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public List<Funcionario> findAll() throws SQLException {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement("select id, nome, login, nivel from funcionario");

			rs = stmt.executeQuery();

			while (rs.next()) {
				funcionarios.add(createFuncionario(rs));
			}
			
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		
		return funcionarios;
	}
	
	public List<Funcionario> findByName(String nome) throws SQLException {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement("select id, nome, login, nivel from funcionario where nome = ?");
			stmt.setString(1, nome);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				funcionarios.add(createFuncionario(rs));
			}
			
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		
		return funcionarios;
	}
	
	public Funcionario findById(Long id) throws SQLException {

		Funcionario funcionario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement("select id, nome, login, nivel from funcionario where id = ?");
			stmt.setLong(1, id);

			rs = stmt.executeQuery();

			while (rs.next()) {
				funcionario = createFuncionario(rs);
			}
			
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		
		return funcionario;
	}
	
	public Funcionario efetuarLogin(Usuario u) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Funcionario f = null;
		
		try {
			stmt = conn.prepareStatement("select id, nome, login, nivel from lovefood.funcionario where login like ? and senha = md5(?)");
			stmt.setString(1, u.getLogin());
			stmt.setString(2, u.getSenha());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				f = createFuncionario(rs);
			}
			
		}finally {
			if(conn != null)
				conn.close();
			
			if(stmt != null)
				stmt.close();
			
			if(rs != null)
				rs.close();
		}
		
		return f;
	}
	
	private Funcionario createFuncionario(ResultSet rs) throws SQLException {
		Funcionario f = new Funcionario();

		f.setId(rs.getLong(1));
		f.setNome(rs.getString(2));
		f.setLogin(rs.getString(3));
		f.setNivel(Nivel.valueOf(rs.getString(4)));

		return f;
	}
}

package br.com.lovefood.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lovefood.entity.Funcionario;

public class FuncionarioDAO extends ConnectionDAO {

	private Connection conn = null;

	public FuncionarioDAO() {
		try {
			conn = getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// m�todo respons�vel por gravar ou editar o funcion�rio
	public void save(Funcionario f) throws SQLException {
		PreparedStatement stmt = null;
		try {
			// se o ID estiver vazio(null), ser� gravado um novo funcion�rio
			if (f.getId() == null) {
				stmt = conn.prepareStatement("insert into funcionario values (null, ?, ?, md5(?), ?)");

				// se o ID j� estiver definido(setado), ser� editado o funcion�rio
			} else {
				stmt = conn.prepareStatement("update funcionario set nome = ?, login = ? where id = ?");
			}
			
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getLogin());
			
			if(f.getId() != null) {
				//atualizar
				stmt.setLong(3, f.getId());
			} else {
				// gravar
				stmt.setString(3, f.getSenha());
				stmt.setString(4, f.getNivel().toString());
			}
			
			int count = stmt.executeUpdate();
			
			if(count == 0)
					throw new SQLException("Erro ao gravar o funcionario");
		} finally {
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}
	}
}

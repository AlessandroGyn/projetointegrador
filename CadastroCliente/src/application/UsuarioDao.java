package application;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UsuarioDao {
	// Método para listar através de chave primária
	public Boolean verificaUsuario(String login, String senha) {
		Boolean statusUsuario = false;
		try {
			Connection con = Conexao.getConexao();
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from tb_usuario where login='"+login+"' and senha='"+senha+"'");
				if (rs.next() ) {
					statusUsuario = true;
				}
			} finally {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusUsuario;
	}
}

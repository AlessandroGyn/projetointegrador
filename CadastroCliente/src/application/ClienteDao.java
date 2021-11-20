package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {
	// Método para inserir
		public void inserir(Cliente cliente) {
			try {
				Connection con = Conexao.getConexao();
				try {
					PreparedStatement pstmt = con.prepareStatement("insert into tb_cadastro_clientes(nome,cpf_clientes,email,data_nascimento,data_cadastro,celular) values (?,?,?,?,?,?)");
					pstmt.setString(1, cliente.getNome());
					pstmt.executeUpdate();
				} finally {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}

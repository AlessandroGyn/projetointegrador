package application;

import java.sql.Connection;
import java.sql.Date;
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
				pstmt.setLong(2, cliente.getCpf());
				pstmt.setString(3, cliente.getEmail());
				pstmt.setDate(4, (Date) cliente.getDatanascimento());
				pstmt.setDate(5, (Date) cliente.getDatacadastro());
				pstmt.setString(6, cliente.getCelular());
				pstmt.executeUpdate();
			} finally {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

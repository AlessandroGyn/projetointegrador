package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
	public static Connection getConexao() throws SQLException{
		try { 
			return DriverManager.getConnection("jdbc:postgresql:ProjetoIntegradorADS2","postgres","@su.23Per");
		}catch (SQLException e) {
			e.printStackTrace();
		    throw e;
		}
	}
}

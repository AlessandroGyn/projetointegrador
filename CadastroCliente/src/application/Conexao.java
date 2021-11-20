package application;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
	public static Connection getConexao(){
		try { 
			return DriverManager.getConnection("jdbc:postgresql:ProjetoIntegradorADS2","postgres","@su.23Per");
		}catch (Exception e) {
			e.printStackTrace();
		    return null;
		}
	}
}

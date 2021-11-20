package application;
	
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("CadastroCliente.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Cadastro de Clientes");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		launch(args);
		Cliente cliente = new Cliente();
		cliente.setNome("joão silva");
		cliente.setCpf(Long.valueOf("52456826952"));
		cliente.setCelular("62 9983-5245");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataCadastro = (Date) formato.parse("23/11/2015");
		cliente.setDatacadastro(dataCadastro);
		Date dataNascimento = (Date) formato.parse("01/01/2000");
		cliente.setDatanascimento(dataNascimento);
		cliente.setEmail("amanha@hoje.com");
		ClienteDao clientedao = new ClienteDao();
		clientedao.inserir(cliente);
		/*
		Long cpf;
		String nome;
		Date datacadastro;
		String celular;
		Date datanascimento;
		String email;
		*/
		
		
	}
}



	




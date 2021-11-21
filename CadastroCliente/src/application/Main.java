package application;
	
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

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
		/*
		Cliente cliente = new Cliente();
		cliente.setNome("Sebastiana das oreias");
		System.out.println(cliente.getNome());
		cliente.setCpf(Long.valueOf("524568262"));
		System.out.println(cliente.getCpf());
		cliente.setCelular("62 9983-5245");
		System.out.println(cliente.getCelular());
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//System.out.println(formatter.format(calendar.getTime()));
		//formatter.format(calendar.("23/11/2015"))
		//pst.setDate(2, java.sql.Date.valueOf(ordem_Producao.getData_abertura()));
		
		//ps.setDate(2, java.sql.Date.valueOf("2013-09-04"));
		
		//DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // define padrão das datas BR 
		////Date outradata = java.sql.Date.valueOf(formato.format(dataCadastro)); // forma de usar o padrão
		
		//LocalDate dataCadastroLocal = LocalDate.parse("23/11/2015", formato);
		//System.out.println(dataCadastroLocal);  // formato de data do sql
		//java.util.Date dataCadastroDate = Date.from(dataCadastroLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
		//System.out.println(dataCadastroDate);  // formato de data para mostrar na tela
		// =================================== PEGAR DATA CADASTRO ==============================
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // define padrão das datas BR
		LocalDate dataCadastroLocal = LocalDate.parse("23/11/2015", formato);  // aqui pega a data do fieldText
		Date dataCadastroDate = java.sql.Date.valueOf(dataCadastroLocal);  // converte a data para tipo Date
		cliente.setDatacadastro(dataCadastroDate);  // altera o atributo
		
		// =================================== PEGAR DATA CADASTRO - FIM ==============================
		LocalDate dataNascimentoLocal = LocalDate.parse("23/11/2015", formato);  // aqui pega a data do fieldText
		Date dataNascimentoDate = java.sql.Date.valueOf(dataNascimentoLocal);  // converte a data para tipo Date
		cliente.setDatanascimento(dataNascimentoDate);  // altera o atributo
		// ===========================================================================================
		cliente.setEmail("amanha@hoje.com");
		ClienteDao clientedao = new ClienteDao();
		clientedao.inserir(cliente);
		
		*/
		
		/*
		 * LocalDate datetime = LocalDate.parse(txt_Data_Abertura.getText(), DateTimeFormatter.ofPattern(“dd/MM/yyyy”));
String newstring = datetime.format(DateTimeFormatter.ofPattern(“dd/MM/yyyy”));
System.out.println(newstring); 
		 * 
		 * 
		 */
		
	}
}



	




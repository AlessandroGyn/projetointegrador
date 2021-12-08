package application;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import util.LoadFXMLGeral;
public class Main extends Application {
	@FXML Stage janela;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage arg0) throws Exception {
		try {
			janela = LoadFXMLGeral.criarJanela("CadastroCliente/src/view/Login.fxml", "LOGIN", "/estilo.css", 600, 400);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

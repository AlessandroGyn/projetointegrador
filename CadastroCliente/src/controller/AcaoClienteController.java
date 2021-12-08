package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import util.LoadFXMLGeral;

public class AcaoClienteController {
	@FXML Stage janela;
    @FXML
    void handlerCadastrarCliente(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
		try {
			janela = LoadFXMLGeral.criarJanela("CadastroCliente/src/view/CadastroCliente.fxml", "CADASTRO DE CLIENTES", "/estilo.css", 600, 400);
	    	janela.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void handlerVoltar(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    	try {
			janela = LoadFXMLGeral.criarJanela("CadastroCliente/src/view/Principal.fxml", "PRINCIPAL", "/estilo.css", 1200, 800);
	    	janela.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.LoadFXMLGeral;

public class PrincipalController {
	@FXML Stage janela;
	@FXML private Button btnCadastrarCliente;
    @FXML private Button btnSair;
    
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
    void handlerSair(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    }
}

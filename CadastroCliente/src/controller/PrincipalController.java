package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import util.LoadFXMLGeral;

public class PrincipalController {
	@FXML Stage janela;
    @FXML
    void handlerAcaoCliente(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
		try {
			janela = LoadFXMLGeral.criarJanela("CadastroCliente/src/view/AcaoCliente.fxml", "CLIENTE", "/estilo.css", 600, 400);
	    	//janela.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void handlerSair(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    }
}

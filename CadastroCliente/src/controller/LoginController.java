package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.LoadFXMLGeral;



public class LoginController {
	
	@FXML Stage janela;
	@FXML private Button btncancelar;
    @FXML private Button btnentrar;
    @FXML private PasswordField textFieldSenha;
    @FXML private TextField textFieldUser;
    
    @FXML 
    public void handlerEntrar(ActionEvent event) throws IOException {
		
    	//System.out.println(textFieldUser.getText());   comparar com BD
    	//System.out.println(textFieldSenha.getText());
    	if (textFieldUser.getText().equals("teste") && textFieldSenha.getText().equals("123")    ) {
    		// se a senha e usuario ok ---> então fecha esta classe e instancia a principal
    		fecha(event);
    		try {
    			janela = LoadFXMLGeral.criarJanela("CadastroCliente/src/view/Principal.fxml", "PRINCIPAL", "/estilo.css", 600, 400);
		    	janela.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	} else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Erro");
    		alert.setHeaderText("Login Inválido");
    		alert.setContentText("Usuário inválido");
    		alert.show();
    	}
    }

    @FXML
    void handlercancelar(ActionEvent event) {
    	fecha(event);
    }
    public void fecha(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    }
}


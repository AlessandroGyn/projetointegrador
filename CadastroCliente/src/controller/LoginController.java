package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class LoginController {
	@FXML private Button btncancelar;
    @FXML private Button btnentrar;
    @FXML private PasswordField textFieldSenha;
    @FXML private TextField textFieldUser;
    
    @FXML 
    void handlerEntrar(ActionEvent event) {
    	if (textFieldUser.getText().equals("teste") && textFieldSenha.getText().equals("123")    ) {
    		// se a senha e usuario ok ---> então fecha esta classe e instancia a principal
    		fecha(event);
    		Stage janelaMain = new Stage();
    		try {
    			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/Main.fxml"));
    			Scene scene = new Scene(root,600,400);
    			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
    			janelaMain.setScene(scene);
    			janelaMain.setTitle("PRINCIPAL");
    			janelaMain.setResizable(false);
    			janelaMain.show();
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
    void handlerSenha(ActionEvent event) {

    }

    @FXML
    void handlerUser(ActionEvent event) {

    }

    @FXML
    void handlercancelar(ActionEvent event) {
    	fecha(event);
    	//((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    }
    public void fecha(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    	//janelaLogin.getStage().close();
    }
}


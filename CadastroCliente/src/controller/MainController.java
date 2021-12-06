package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button btnCadastrarCliente;

    @FXML
    private Button btnSair;

    @FXML
    void handlerCadastrarCliente(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
		Stage janelaCadastrarCliente = new Stage();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/CadastroCliente.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			janelaCadastrarCliente.setScene(scene);
			janelaCadastrarCliente.setTitle("CADASTRO DE CLIENTES");
			janelaCadastrarCliente.setResizable(false);
			janelaCadastrarCliente.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void handlerSair(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    }

}


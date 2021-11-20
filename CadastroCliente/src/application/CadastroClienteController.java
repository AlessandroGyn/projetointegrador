package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroClienteController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGravar;

    @FXML
    private TextField textFieldCelular;

    @FXML
    private TextField textFieldCpf;

    @FXML
    private DatePicker textFieldDateNascimento;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldNome;

    @FXML
    void handlerCancelar(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    }

    //private ClienteDAO livroDAO;
    
    
    
    @FXML
    void handlerGravar(ActionEvent event) {
    	String textfield = textFieldCpf.getAccessibleText();
    	
    	
    	
    	//Button botaoClicado = (Button)event.getSource();
    	//c.digit( Integer.parseInt( botaoClicado.getText() ) );
    	// fecha janela
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }
    // cancelar --> fechar a tela; --- ok
    // gravar --> salva os dados no banco e fecha a tela e dá mensagem de gravado com sucesso.
    // tratar erros - campo obrigatórios
    
    
    
    
}

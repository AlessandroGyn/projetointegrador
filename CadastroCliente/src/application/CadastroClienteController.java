package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
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
    
    LocalDate dataHoje = LocalDate.now(); 

    Cliente cliente = new Cliente();
    ClienteDao clienteDAO = new ClienteDao();
    
    @FXML
    void handlerGravar(ActionEvent event) {
    	// pode cliar um metodo para preecher o cliente  tipo: this.preencherCliente
    	// 1-pega os valores dos textfields  // verifica se campos estão vazios, e campos obrigatórios
    	// 2-grava os valores no objeto cliente
    	// 3-grava o objeto cliente no BD
    	try {
    		
    		// fase captura de dados
	    	String campoNome = textFieldNome.getText();
	    	String campoCPF = textFieldCpf.getText();
	    	String campoCelular = textFieldCelular.getText();
	    	// pega no sistema data atual que será a data do cadastro
	    	Date dataCadastro = java.sql.Date.valueOf(dataHoje);  // converte LocalDate para Date
	    	LocalDate campoDataNascimento = textFieldDateNascimento.getValue();
	    	Date dataNascimento = java.sql.Date.valueOf(campoDataNascimento);  // converte LocalDate para Date
	    	String campoEMail = textFieldEmail.getText();
    		
	    	// fase instanciar objeto
	    	cliente.setNome(campoNome);
	    	cliente.setCpf(Long.valueOf(campoCPF));
	    	cliente.setCelular(campoCelular);
	    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // define padrão das datas BR
	    	cliente.setDatacadastro(dataCadastro);
	    	cliente.setDatanascimento(dataNascimento);  // altera o atributo
			cliente.setEmail(campoEMail);
    	}catch(Exception ex){
    		JOptionPane.showMessageDialog(null, "Verifique a fase instanciar objeto.", "Problemas com o objeto", JOptionPane.ERROR_MESSAGE);  
            throw ex;
    	}
		
    	
		try{
			// fase gravar no BD
			clienteDAO.inserir(cliente);  // gravar no BD
			
			//limpar campos textField
			textFieldNome.setText("");
			textFieldCpf.setText("");
			textFieldCelular.setText("");
			textFieldDateNascimento.setPromptText("");
			textFieldEmail.setText("");
			
			
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
		}catch(Exception ex){
            JOptionPane.showMessageDialog(null, null, "Problemas com Banco de Dados.", JOptionPane.ERROR_MESSAGE);  
            throw ex;
		}
		
		
    	
    	((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
    }
    // cancelar --> fechar a tela; --- ok
    // gravar --> salva os dados no banco e fecha a tela e dï¿½ mensagem de gravado com sucesso.
    // tratar erros - campo obrigatórios
    
}

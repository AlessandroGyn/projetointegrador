package application;

import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
    LocalDate dataHoje = LocalDate.now(); // Instancia objeto com a data de hoje
    Cliente cliente = new Cliente();  // Instancia objeto cliente
    ClienteDao clienteDAO = new ClienteDao(); // Instancia objeto clienteDao
    
    @FXML
    void handlerGravar(ActionEvent event) {
    	Object[] options = { "SIM", "CANCELAR" };
		int opcao = JOptionPane.showOptionDialog(null, "Confirma a gravação dos dados?", "CONFIRMAÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    	if (opcao==0) {
    		if (this.validarCliente()) {
    			this.construirCliente();
		    	try {
					clienteDAO.inserir(cliente);  // gravar no BD
					limparCampos(); //limpar campos textField
					((Node)(event.getSource())).getScene().getWindow().hide();  // fecha janela
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
				}catch(Exception ex){
		            JOptionPane.showMessageDialog(null, "Verifique o ClienteDAO.", "Problemas com Banco de Dados.", JOptionPane.ERROR_MESSAGE);  
		            throw ex;
				}
			}
		} else {
			System.exit(0);
		}
    }
    private Boolean validarCliente() {
    	StringBuilder listaErrosList = new StringBuilder();
    	Boolean isValid = true;
    	if (textFieldNome.getText().isEmpty() || textFieldCpf.getText().isEmpty() ) { // não pode ser campo vazio
    		listaErrosList.append("O campo Nome e/ou o campo CPF não podem ser vazio.");
    		listaErrosList.append("\n");
    		isValid = false;
		}
    	if (!textFieldCpf.getText().matches("^[0-9]+$")) { // somente números
    		listaErrosList.append("O campo CPF deve conter somente números.");
    		listaErrosList.append("\n");
    		isValid = false;
    	}
    	if (isValid == false) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Dados Incorretos!");
	    	alert.setHeaderText("Campos Inválidos:");
	    	alert.setContentText(listaErrosList.toString());
	    	alert.showAndWait();
    	}
    	return isValid;
    }
    private void construirCliente() {
    	try {
	    	// fase instanciar objeto
	    	cliente.setNome(textFieldNome.getText());
	    	cliente.setCpf(Long.valueOf(textFieldCpf.getText()));
	    	cliente.setCelular(textFieldCelular.getText());
	    	Date dataCadastro = java.sql.Date.valueOf(dataHoje);  // converte LocalDate para Date
	    	cliente.setDatacadastro(dataCadastro);
	    	LocalDate campoDataNascimento = textFieldDateNascimento.getValue();
	    	Date dataNascimento = java.sql.Date.valueOf(campoDataNascimento);  // converte LocalDate para Date
	    	cliente.setDatanascimento(dataNascimento);
			cliente.setEmail(textFieldEmail.getText());
    	}catch(Exception ex){
    		JOptionPane.showMessageDialog(null, "Verifique a fase instanciar objeto.", "Problemas com o objeto", JOptionPane.ERROR_MESSAGE);  
            throw ex;
    	}
    }
    private void limparCampos() {
    	textFieldNome.clear();
    	textFieldNome.clear();
		textFieldCpf.clear();
		textFieldCelular.clear();
		textFieldDateNascimento.setValue(null);
		textFieldEmail.clear();
    }

}

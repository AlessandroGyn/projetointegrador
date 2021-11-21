package application;

import java.sql.SQLException;
import java.time.LocalDate;
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

   
   Cliente cliente = new Cliente();
   ClienteDao clienteDAO = new ClienteDao();
    
    @FXML
    void handlerGravar(ActionEvent event) {
    	
    	// fase pegar textos
    	String textfield = textFieldCpf.getAccessibleText();
    	String textFieldN = textFieldNome.getText();
    	// pode cliar um metodo para preecher o cliente  tipo: this.preencherCliente
    	// 1-pega os valores dos textfields
    	// 2-grava os valores no objeto cliente
    	// 3-grava o objeto cliente no BD
    	
    	
    	
    	
    	
    	
    	// fase instanciar objeto
    	cliente.setNome(textFieldN);
    	System.out.println(textFieldN);
    	cliente.setCpf(Long.valueOf("524568262"));
    	cliente.setCelular("62 9983-5245");
    	// =================================== PEGAR DATA CADASTRO ==============================
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // define padrão das datas BR
		LocalDate dataCadastroLocal = LocalDate.parse("23/11/2015", formato);  // aqui pega a data do fieldText
		Date dataCadastroDate = java.sql.Date.valueOf(dataCadastroLocal);  // converte a data para tipo Date
		cliente.setDatacadastro(dataCadastroDate);  // altera o atributo
		// =================================== PEGAR DATA CADASTRO - FIM ==============================
		LocalDate dataNascimentoLocal = LocalDate.parse("23/11/2015", formato);  // aqui pega a data do fieldText
		Date dataNascimentoDate = java.sql.Date.valueOf(dataNascimentoLocal);  // converte a data para tipo Date
		cliente.setDatanascimento(dataNascimentoDate);  // altera o atributo
		// ===========================================================================================
		cliente.setEmail("amanha@hoje.com");
    	
		try{
			// fase gravar no BD
			clienteDAO.inserir(cliente);  // gravar no BD
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
		}catch(Exception ex){
            JOptionPane.showMessageDialog(null, null, "Problemas com o cadastro", JOptionPane.ERROR_MESSAGE);  
            throw ex;
		}
		
		
    	//Button botaoClicado = (Button)event.getSource();
    	//c.digit( Integer.parseInt( botaoClicado.getText() ) );
    	// fecha janela
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }
    // cancelar --> fechar a tela; --- ok
    // gravar --> salva os dados no banco e fecha a tela e dï¿½ mensagem de gravado com sucesso.
    // tratar erros - campo obrigatï¿½rios
    
    
    
    
}

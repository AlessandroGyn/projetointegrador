package controller;
import java.io.IOException;
import javax.swing.JOptionPane;
import application.Usuario;
import application.UsuarioDao;
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
    Usuario usuario = new Usuario();
    UsuarioDao usuariodao = new UsuarioDao();
    @FXML 
    public void handlerEntrar(ActionEvent event) throws IOException {
		this.construirUsuario(); // instancia o objeto usuario
		if (this.validarUsuario()) {
    		fecha(event);
    		try {
    			janela = LoadFXMLGeral.criarJanela("CadastroCliente/src/view/Principal.fxml", "PRINCIPAL", "/estilo.css", 1200, 800);
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
    
    private void construirUsuario() {
    	try {
	    	// fase instanciar objeto Usuario
	    	usuario.setLogin(textFieldUser.getText());
	    	usuario.setSenha(textFieldSenha.getText());
    	}catch(Exception ex){
    		JOptionPane.showMessageDialog(null, "Verifique a fase instanciar objeto Usuario.", "Problemas com o objeto", JOptionPane.ERROR_MESSAGE);  
            throw ex;
    	}
    }
    private Boolean validarUsuario() {
    	return usuariodao.verificaUsuario(usuario.getLogin(), usuario.getSenha());
    }
}


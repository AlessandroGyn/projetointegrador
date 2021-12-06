package util;
import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class LoadFXMLGeral {
	public static Stage criarJanela(String caminhoFXML, String titulo, String caminhoCSS, Integer largura, Integer altura) throws IOException {
		java.net.URL uriFXML = new File(caminhoFXML).toURI().toURL();
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(uriFXML);
			Scene scene = new Scene(root,largura,altura);
			scene.getStylesheets().add( caminhoCSS );
			stage.setScene(scene);
			stage.setTitle(titulo);
			stage.setResizable(false);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stage;
	}
}

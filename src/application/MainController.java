package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private void switchToTop20(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Top20.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void switchToAllWords(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AllWords.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

package application;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Top20Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private ListView<String> top20ListView;
	
	@FXML
	private void switchToAllWords(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("AllWords.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private void switchToMain(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void runTop20() throws IOException {

		// Read each line of the file
		BufferedReader reader = new BufferedReader(new FileReader("src/textFile.txt"));
		String line;
		Map<String, Integer> wordFreq = new HashMap<>();

		while ((line = reader.readLine()) != null) {

			// Split the line into words and eliminate all characters except letters, then
			// count the frequency of each word
			String[] words = line.replaceAll("[^A-Za-z— ]", "").toLowerCase().split("\\s+|—");

			for (String word : words) {
				if (word.length() > 0) {
					wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
				}
			}
		}

		reader.close();
		
		LinkedHashMap<String, Integer> sortedMap = wordFreq.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(20)
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e1, LinkedHashMap::new));

		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			
			top20ListView.getItems().add(entry.getKey() + ": " + entry.getValue());
			
		}
	}

}

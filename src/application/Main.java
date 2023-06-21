package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
		String html = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";

		Document doc = Jsoup.connect(html).get();

		Elements content = doc.getElementsByClass("chapter");
		Elements title = doc.getElementsByTag("h1");
		Elements author = doc.getElementsByTag("h2");

		String contentText = content.text();
		String titleText = title.text();
		String authorText = author.text();

		BufferedWriter writer = new BufferedWriter(new FileWriter("src/textFile.txt"));

		writer.write(titleText + " ");
		writer.write(authorText + " ");
		writer.write(contentText);

		writer.close();
		
		launch(args);
	}
}
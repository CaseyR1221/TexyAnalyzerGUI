module TextAnalyzerGUI {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires org.jsoup;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;
}

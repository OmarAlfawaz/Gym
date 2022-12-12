package home.example;

import home.ui.RingProgressIndicator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RingProgressIndicatorExample extends Application {

	@Override
	public void start(Stage primaryStage) {
		RingProgressIndicator indicator = new RingProgressIndicator();
		Slider slider = new Slider(0, 100, 50);

		slider.valueProperty().addListener((o, oldVal, newVal) -> indicator.setProgress(newVal.intValue()));
		VBox main = new VBox(1, indicator, slider);
		indicator.setProgress(Double.valueOf(slider.getValue()).intValue());
		Scene scene = new Scene(main);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test ring progress");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauchABCorpCalculateBonusApp_update extends Application {
	@Override
	
	public void start (Stage primaryStage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource ("CalculateBonusScreen.fxml"));
		primaryStage.setTitle("AB Corporation Bonus Incentive Calculation Application");
		primaryStage.setScene(new Scene (root, 800, 500)); //first horizontal, then vertical
		primaryStage.show();
		
	}

	public static void main (String[] args) {
		launch (args);
				
	}

}
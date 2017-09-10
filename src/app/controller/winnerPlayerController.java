package app.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class winnerPlayerController {

    @FXML
    private Label wonLbl;
    @FXML
    private Button againBtn;
    @FXML
    private Button resultBtn;
    @FXML
    private Button quitBtn;
    @FXML
    void playAgain(ActionEvent event) throws IOException {
    	Stage stageInfo = new Stage();
		Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/tableView.fxml"));
		Scene scene = new Scene (parent);
		stageInfo.setScene(scene);
		stageInfo.setTitle("21");
		stageInfo.show();
    }
    /*@FXML
	void cleanup() {
	    // stop animations reset model ect.
	}

	void startGame(Stage stage) {
	    // initialisation from start method goes here

		againBtn.setOnAction(e -> {
	       restart(stage);
	    });

	    stage.show();
	}

	void restart(Stage stage) {
	    cleanup();
	    startGame(stage);
	}

	@Override
	public void start(Stage primaryStage) {
	    startGame(primaryStage);
	}*/
    @FXML
    void resultButtonAction(ActionEvent event) {
    	Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void quitButtonAction(ActionEvent event) {
    	//zamkniêcie programu
    	Platform.exit();
        System.exit(0);
        
        //zamkniêcie okna 
        /*Stage stage = (Stage) quitBtn.getScene().getWindow();
        stage.close();*/
    }
    
}

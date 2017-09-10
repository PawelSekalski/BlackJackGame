package app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class tableController {

    @FXML
    private Label dealerScore;
    @FXML
    private Rectangle dCard1b;
    @FXML
    private Rectangle dCard1f;
    @FXML
    private Rectangle dCard2;
    @FXML
    private Label cd0;
    @FXML
    private Label cd1;
    @FXML
    private Label cd2;
    @FXML
    private Label cd3;
    @FXML
    private Label cd4;
    @FXML
    private Label vd0;
    @FXML
    private Label playerScore;
    @FXML
    private Label result;
    @FXML
    private Rectangle pCard1;
    @FXML
    private Rectangle pCard2;
    @FXML
    private Rectangle pCard3;
    @FXML
    private Rectangle pCard4;
    @FXML
    private Rectangle pCard5;
    @FXML
    private Label cp0;
    @FXML
    private Label cp1;
    @FXML
    private Label cp2;
    @FXML
    private Label cp3;
    @FXML
    private Label cp4;
    @FXML
    private Button btn_hit;
    @FXML
    private Button btn_stay;
    
    int hit_count = 1;
	ArrayList <Integer> wylosowane = new ArrayList<Integer>();
	// to je to co mi teraz losuje i dzia³a. stackoverflower pomog³o w koñcu. co s¹dzisz o takim zapisie?
	public int generateRandom(int start, int end, ArrayList<Integer> excludeRows) {
	    Random rand = new Random();
	    int range = end - start + 1;
	    
	    int random = rand.nextInt(range) + 1;
	    while(excludeRows.contains(random)) {
	        random = rand.nextInt(range) + 1;
	    }
	    return random;
	}
	
    public int losuj(){
		
		int los = 0;
		los = generateRandom(1, 51, wylosowane);
		wylosowane.add(los);
		System.out.println("nr karty: " + los);
		return los;
    }
    
    //////////////////////////////////////////////////////////////////// LOSOWANIE
    static int resP,resD = 0;
    public static Cards c = new Cards();
    
    @FXML
    void hitAction(MouseEvent event) throws IOException {    	
    	
    	int los=0;
    	//pierwsze losowanie, akcja po "hit"
    	if(hit_count == 1) {
    		
    		btn_stay.setDisable(false);
    		dCard1b.setVisible(true);
    		dCard2.setVisible(true);
    		pCard1.setVisible(true);
    		pCard2.setVisible(true);
    		
    		// player 1 karta
    		los = losuj();
    		cp0.setText(c.CardsName.get(los));
    		resP += c.CardsValue.get(los);
    		System.out.println("SumaP1: "+resP);
    		playerScore.setText(String.valueOf(resP));
    		
    		// dealer 1 karta
    		los = losuj();
    		cd0.setText(c.CardsName.get(los));
    		resD += c.CardsValue.get(los);
    		System.out.println("SumaD1: "+resD);
    		dealerScore.setText(String.valueOf(resD));
    		
    		// player 2 karta
    		los = losuj();
   			cp1.setText(c.CardsName.get(los));
    		resP += c.CardsValue.get(los);
    		System.out.println("SumaP2: "+resP);
    		playerScore.setText(String.valueOf(resP));
    		
    		// dealer 2 karta
    		los = losuj();
    		cd1.setText(c.CardsName.get(los));
	    	resD += c.CardsValue.get(los);
	    	System.out.println("SumaD2: "+resD);
	    	dealerScore.setText(String.valueOf(resD));
	    	hit_count ++;
	    	
	    // drugie losowanie
    	}else if (hit_count == 2) {
    		
    		// player 3 karta
    		System.out.println("---hit---");
    		pCard3.setVisible(true);
    		los = losuj();
    		cp2.setText(c.CardsName.get(los));
    		resP += c.CardsValue.get(los);
    		System.out.println("SumaP3: "+resP);
    		playerScore.setText(String.valueOf(resP));
    		hit_count ++;
    		
    	}else if(hit_count == 3) {
    		
    		// player 4 karta
    		System.out.println("---hit---");
    		pCard4.setVisible(true);
    		los = losuj();
    		cp3.setText(c.CardsName.get(los));
    		resP += c.CardsValue.get(los);
    		System.out.println("SumaP4: "+resP);
    		playerScore.setText(String.valueOf(resP));
    		hit_count ++;

    	}else if(hit_count == 4) {
    		
    		// player 5 karta
    		System.out.println("---hit---");
    		pCard5.setVisible(true);
    		los = losuj();
    		cp4.setText(c.CardsName.get(los));
    		resP += c.CardsValue.get(los);
    		System.out.println("SumaP5: "+resP);
    		playerScore.setText(String.valueOf(resP));
    		hit_count ++;
    	}
		
    ///////////////////////////////////////////////////////////// WYGRANA NATURALNA

		int dealerScore = resD;
		int playerScore = resP;
		
		if (dealerScore == 21 || 
				playerScore > 21) {
			
			System.out.println("Dealer won!");
			
			Stage stageInfo = new Stage();
			
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/tableDealerWinner.fxml"));
			Scene scene = new Scene (parent);
			stageInfo.setScene(scene);
			stageInfo.setTitle("Winner - dealer!");
			stageInfo.show();
		
		} else if(playerScore == 21 || 
				dealerScore > 21) {
			System.out.println("Player won!");
			
			Stage stageInfo = new Stage();
			
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/tablePlayerWinner.fxml"));
			Scene scene = new Scene (parent);
			stageInfo.setScene(scene);
			stageInfo.setTitle("Winner - player!");
			stageInfo.show();
			
			}
	    }
    
    ///////////////////////////////////////////////////////////// ZATRZYMANIE
    
    @FXML
    	void stayAction(MouseEvent event) throws IOException {
    		// akcja po "stay"
    		System.out.println("---stay---");
    		dealerScore.setVisible(true);
    		dCard1b.setVisible(false);
    		dCard1f.setVisible(true);
    		cd0.setVisible(true);
    		btn_hit.setDisable(true);
    		btn_stay.setDisable(true);
    
    ///////////////////////////////////////////////////////////// WYGRANA
    		
    	System.out.println("WHO WON?");
		
		int dealerScore = resD;
		int playerScore = resP;
		
		if ((dealerScore < 21 && dealerScore > playerScore) ||
				dealerScore == playerScore) {
			
			System.out.println("Dealer won!");
			
			Stage stageInfo = new Stage();
			
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/tableDealerWinner.fxml"));
			Scene scene = new Scene (parent);
			stageInfo.setScene(scene);
			stageInfo.setTitle("Winner - dealer!");
			stageInfo.show();
		
		} else if(playerScore < 21 && playerScore > dealerScore) {
			
			System.out.println("Player won!");
			
			Stage stageInfo = new Stage();
			
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/tablePlayerWinner.fxml"));
			Scene scene = new Scene (parent);
			stageInfo.setScene(scene);
			stageInfo.setTitle("Winner - player!");
			stageInfo.show();
			
			}
    	}

}

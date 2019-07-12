package launcher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fourplayersgame.GameBoardFourPlayersController;
import game.Dice;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sixplayersgame.GameBoardSixPlayersController;

public class BeginController {
	@FXML
	public Button btnRollTheDice;
	public Button btnStartGame;
	public Button btnEndGame;
	public ImageView imgDice1;
	public ImageView imgDice6;
	public ImageView imgDice5;
	public ImageView imgDice4;
	public ImageView imgDice3;
	public ImageView imgDice2;
	public TextField txtPlayer1;
	public TextField txtPlayer2;
	public TextField txtPlayer3;
	public TextField txtPlayer4;
	public TextField txtPlayer5;
	public TextField txtPlayer6;
	
	
	private ArrayList<Integer> cubeNumber = new ArrayList<Integer>();
	private int clickCounter = 0;

	public ArrayList<String> playerName = new ArrayList<String>();
	public ArrayList<String> color = new ArrayList<String>();
	public ArrayList<String> rival = new ArrayList<String>();
	public int numberOfPlayers = 0;
	
	public void initialize(ArrayList<String> playerName, ArrayList<String> color, ArrayList<String> rival, int numberOfPlayers) {
		this.playerName = playerName;
		this.color = color;
		this.rival = rival;
		this.numberOfPlayers = numberOfPlayers;

		/*
		 * Anzeigen der Spielernamen mit ihrer jeweiligen Farbe
		 */
		txtPlayer1.setText(playerName.get(0) + " - " + color.get(0));
		txtPlayer2.setText(playerName.get(1) + " - " + color.get(1));
		
		if(numberOfPlayers == 3) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
		
		} else if(numberOfPlayers == 4) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
		
		}else if(numberOfPlayers == 5) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
		
		}else if(numberOfPlayers == 6) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
			txtPlayer6.setText(playerName.get(5) + " - " + color.get(5));
		}
		
		btnRollTheDice.setOnMouseClicked(mouseEvent -> btnOnActionRollTheDice(mouseEvent, numberOfPlayers));
		
	}

	public void beginningRollTheDice(int numberOfPlayers) {
		if(clickCounter > numberOfPlayers){
			btnRollTheDice.setDisable(true);
			btnStartGame.setDisable(false);
			return;
		}

		Dice rtd = new Dice();
		int value = rtd.rollTheDice();

		cubeNumber.add(value);

		/*
		 * Bilder der sechs Wuerfel
		 */
		Image dice1 = new Image("/pictures/Dice1.png", false);
		Image dice2 = new Image("/pictures/Dice2.png", false);
		Image dice3 = new Image("/pictures/Dice3.png", false);
		Image dice4 = new Image("/pictures/Dice4.png", false);
		Image dice5 = new Image("/pictures/Dice5.png", false);
		Image dice6 = new Image("/pictures/Dice6.png", false);

		ImageView imgDice = getDiceView();

		/*
		 * Aendern des Wuerfel bildes zu der gewuerfelten Zahl
		 */
		switch (value) {
		case 1:
			imgDice.setImage(dice1);
			break;
		case 2:
			imgDice.setImage(dice2);
			break;
		case 3:
			imgDice.setImage(dice3);
			break;
		case 4:
			imgDice.setImage(dice4);
			break;
		case 5:
			imgDice.setImage(dice5);
			break;
		case 6:
			imgDice.setImage(dice6);
			break;
		default: imgDice.setImage(dice1);
			break;
		}
	}

	private ImageView getDiceView() {
		ImageView imgDice = new ImageView();
		switch (clickCounter) {
			case 1:
				imgDice = imgDice1;
				break;
			case 2:
				imgDice = imgDice2;
				break;
			case 3:
				imgDice = imgDice3;
				break;
			case 4:
				imgDice = imgDice4;
				break;
			case 5:
				imgDice = imgDice5;
				break;
			case 6:
				imgDice = imgDice6;
				break;
		}
		return imgDice;
	}

	private int determinedStartingPlayer() {
		int max = cubeNumber.stream().max((o1, o2) -> o1.compareTo(o2)).get();

		List<Integer> maxList = new ArrayList<>();
		for (Integer value : cubeNumber) {
			if (value == max){
				maxList.add(cubeNumber.indexOf(value));
			}
		}
		if (maxList.size() > 1){
			return maxList.get(new Random().nextInt(maxList.size()));
		} else {
			return cubeNumber.indexOf(max);
		}
	}
	
	/*
	 *  Event Listener fuer den ersten Wuerfel Button.
	 *  Dieser ruft die Methode beginningRollTheDice() auf und setzt den Button auf Disable, da jeder nur einmal Wuerfeln darf.
	 */
	//@FXML
	public void btnOnActionRollTheDice(MouseEvent event, int numberOfPlayers) {
		clickCounter++;
		beginningRollTheDice(numberOfPlayers);
	}
	
	/*
	 *  Event Listener fuer den Spiel starten Button.
	 *  Dieser ruft das Spielfeld auf.
	 */
	@FXML
	public void btnOnActionStartGame(ActionEvent event) {
		/*
		 * SchlieÃŸen des Launcher Fensters
		 */
		Stage currentStage = (Stage)btnRollTheDice.getScene().getWindow();
		currentStage.close();

		Integer startPlayer = determinedStartingPlayer();
		/*
		 * Bei 3, 5 oder 6 Spielern wird das 6er Brett aufgerufen
		 */
		if((LauncherController.numberOfPlayers == 3) || (LauncherController.numberOfPlayers == 5) || (LauncherController.numberOfPlayers == 6)) {
			
			
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sixplayersgame/GameBoardSixPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardSixPlayersController gbsp = fxmlloader.getController(); 
				gbsp.initialize(playerName, color, rival, numberOfPlayers, startPlayer);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Sechser Spielbrett");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
						
			/*
			 * Bei 2 oder 4 Spielern wird das 4er Brett aufgerufen
			 */			
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fourplayersgame/GameBoardFourPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardFourPlayersController gbfp = fxmlloader.getController(); 
				gbfp.initialize(playerName, color, rival, numberOfPlayers, startPlayer);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Vierer Spielbrett");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
	
	/*
	 *  Event Listener fuer den Beenden Button.
	 *  Dieser beendet das Programm.
	 */
	@FXML
	public void btnOnActionEndGame(ActionEvent event) {
		System.exit(0);
	}
	
}

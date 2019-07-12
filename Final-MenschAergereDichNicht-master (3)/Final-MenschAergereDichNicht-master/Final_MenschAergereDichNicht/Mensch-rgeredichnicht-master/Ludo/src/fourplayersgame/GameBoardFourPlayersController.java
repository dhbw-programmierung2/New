package fourplayersgame;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.SplitPane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.JOptionPane;

import game.Dice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;
import launcher.LauncherController;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 * Dieser Controller ist für das Steuern und initialisieren des Spielfeld zuständig.
 * Dieser synergiert mit dem GameBoardFourPlayers.fxml
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 *
 */
public class GameBoardFourPlayersController {
	
	/*
	 * FXML Komponenten, die auf dem Spielfeld sichtbar sein werden
	 */
	
	@FXML
	public SplitPane splitPane;
	public GridPane gridPaneLeft;
	public GridPane gridPaneRigth;
	
	//Startfelder der verschiedenen Farben
	public Circle crcBeginYellow001;
	public Circle crcBeginYellow002;
	public Circle crcBeginYellow003;
	public Circle crcBeginYellow004;
	public Circle crcBeginBlack003;
	public Circle crcBeginBlack001;
	public Circle crcBeginBlack004;
	public Circle crcBeginBlack002;
	public Circle crcBeginRed004;
	public Circle crcBeginRed003;
	public Circle crcBeginRed001;
	public Circle crcBeginRed002;
	public Circle crcBeginGreen001;
	public Circle crcBeginGreen002;
	public Circle crcBeginGreen003;
	public Circle crcBeginGreen004;
	
	//Endfelder der verschiedenen Farben
	public Circle crcAimBlack001;
	public Circle crcAimBlack002;
	public Circle crcAimBlack003;
	public Circle crcAimBlack004;
	public Circle crcAimYellow001;
	public Circle crcAimYellow002;
	public Circle crcAimYellow003;
	public Circle crcAimYellow004;
	public Circle crcAimGreen001;
	public Circle crcAimGreen002;
	public Circle crcAimGreen003;
	public Circle crcAimGreen004;
	public Circle crcAimRed001;
	public Circle crcAimRed002;
	public Circle crcAimRed003;
	public Circle crcAimRed004;
	
	//Felder
	public Circle crcField031;
	public Circle crcField030;
	public Circle crcField029;
	public Circle crcField032;
	public Circle crcField028;
	public Circle crcField033;
	public Circle crcField027;
	public Circle crcField034;
	public Circle crcField026;
	public Circle crcField035;
	public Circle crcField025;
	public Circle crcField036;
	public Circle crcField037;
	public Circle crcField038;
	public Circle crcField039;
	public Circle crcField040;
	public Circle crcField001;
	public Circle crcField002;
	public Circle crcField003;
	public Circle crcField004;
	public Circle crcField005;
	public Circle crcField015;
	public Circle crcField006;
	public Circle crcField014;
	public Circle crcField007;
	public Circle crcField013;
	public Circle crcField008;
	public Circle crcField012;
	public Circle crcField009;
	public Circle crcField010;
	public Circle crcField011;
	public Circle crcField024;
	public Circle crcField023;
	public Circle crcField022;
	public Circle crcField021;
	public Circle crcField020;
	public Circle crcField016;
	public Circle crcField017;
	public Circle crcField018;
	public Circle crcField019;
	
	//Button zum Wuerfeln und zum Beenden des Spiels
	public Button btnRollTheDice;
	public Button btnExitGame;
	
	//Wuerfelbild, welches die gewuerfelte Augenzahl anzeigt
	public ImageView imgDice;
	
	//Textfelder fuer Spielernamen
	public TextField txtPlayer1;
	public TextField txtPlayer2;
	public TextField txtPlayer3;
	public TextField txtPlayer4;
	
	//Zaehlt mit, wie oft der Wuerfel Button gedrueckt wurde.
	public int numberButtonPressed = 0;
	
	/*
	 * Diese ArrayLists enthalten die Felder, der Kategorien Lauffelder, Hausfeldern/Beginfeldern und Zielfeldern.
	 * Der HashMap wird die ID der Circles sowie ein interner Name als Wert uebergeben.
	 */
	public ArrayList<Circle> fieldsGui = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsBlackGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsBlackGui = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsRedGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsRedGui = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsYellowGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsYellowGui = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsGreenGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsGreenGui = new ArrayList<Circle>();

	public HashMap<String, String> tokenID = new HashMap<String, String>();
	
	/**
	 * Methode die das Spielfeld initialisiert
	 *  @param playerName Enthaelt die Namen der Spieler
	 * @param color Enthaelt die Farben der jeweiligen Spieler
	 * @param rival Enthaelt ob es sich um einen Computer oder Mensch handelt
	 * @param numberOfPlayers Enthaelt die Anzahl der Spieler
	 * @param startPlayer
	 */
	public void initialize(ArrayList<String> playerName, ArrayList<String> color, ArrayList<String> rival, int numberOfPlayers, Integer startPlayer) {
		
		ObservableList<Node> l_circleList = gridPaneLeft.getChildren();
		for (Node l_node : l_circleList) {
			Circle l_circle = (Circle) l_node;
			if (l_circle.getId().startsWith("crcField")) {
				fieldsGui.add(l_circle);
			} else if (l_circle.getId().startsWith("crcAimBlack")) {
				aimFieldsBlackGui.add(l_circle);
			} else if (l_circle.getId().startsWith("crcBeginBlack")) {
				beginFieldsBlackGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcAimRed")) {
				aimFieldsRedGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginRed")) {
				beginFieldsRedGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcAimYellow")) {
				aimFieldsYellowGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginYellow")) {
				beginFieldsYellowGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcAimGreen")) {
				aimFieldsGreenGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginGreen")) {
				beginFieldsGreenGui.add(l_circle);
			}
		}

		fieldsGui.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsBlackGui.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsBlackGui.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsRedGui.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsRedGui.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsYellowGui.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsYellowGui.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsGreenGui.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsGreenGui.sort(Comparator.comparing(circle -> circle.getId()));

		
		// Zur Ueberpruefung
		System.out.println(fieldsGui);
		System.out.println(playerName);
		System.out.println(color);
		System.out.println(rival);
		System.out.println(numberOfPlayers);
		
		/*
		 * Anzeigen der Spielernamen und ihrer jeweiligen Farbe auf dem Spielfeld
		 */
		txtPlayer1.setText(playerName.get(0) + " - " + color.get(0));
		txtPlayer2.setText(playerName.get(1) + " - " + color.get(1));
		if(numberOfPlayers == 4) {
			txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
		}		
		
		/*
		 * Check ob Farbe Gruen ausgewaehlt wurde.
		 * Definiert Basis fuer gruen
		 */
		if(color.contains("Gruen")) {
			
			crcBeginGreen001.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen002.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen003.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcField011.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			
			populateGreen();
			
			tokenID.put("crcBeginGreen1", "green1");
			tokenID.put("crcBeginGreen2", "green2");
			tokenID.put("crcBeginGreen3", "green3");
			tokenID.put("crcField11", "green4");
		}
		
		/*
		 * check ob Farbe Gelb ausgewaehlt wurde.
		 * Definiert Basis fuer Gelb
		 */
		if(color.contains("Gelb")) {
			
			crcBeginYellow001.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow002.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcBeginYellow003.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			crcField001.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
			
			populateYellow();
			
			tokenID.put("crcBeginYellow1", "yellow1");
			tokenID.put("crcBeginYellow2", "yellow2");
			tokenID.put("crcBeginYellow3", "yellow3");
			tokenID.put("crcField1", "yellow4");
		}
		
		/*
		 * check ob Farbe Schwarz ausgewaehlt wurde.
		 * Definiert Basis fuer Schwarz
		 */
		if(color.contains("Schwarz")) {
			
			crcBeginBlack001.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcBeginBlack002.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcBeginBlack003.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcField031.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			
			populateBlack();
			
			tokenID.put("crcBeginBlack1", "black1");
			tokenID.put("crcBeginBlack2", "black2");
			tokenID.put("crcBeginBlack3", "black3");
			tokenID.put("crcField31", "black4");
		}
		
		/*
		 * Check ob Farbe Rot ausgewaehlt wurde.
		 * Definiert Basis fuer Rot
		 */
		if(color.contains("Rot")) {
			
			crcBeginRed001.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed002.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed003.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcField021.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			
			populateRed();
			
			tokenID.put("crcBeginRed1", "red1");
			tokenID.put("crcBeginRed2", "red2");
			tokenID.put("crcBeginRed3", "red3");
			tokenID.put("crcField21", "red4");
		}
	}
	
	/*
	 * Setzt die roten Spielfiguren in die rote Basis
	 */
	public void populateRed() {
		Image im4 = new Image("/pictures/Red.jpg", false);
		crcBeginRed001.setFill(new ImagePattern(im4));
		crcBeginRed002.setFill(new ImagePattern(im4));
		crcBeginRed003.setFill(new ImagePattern(im4));
		
		//Zu Beginn mit einer Spielfigur auf dem Feld starten
		crcField021.setFill(new ImagePattern(im4));
	}
	
	/*
	 * Setzt die schwarzen Spielfiguren in die schwarze Basis
	 */
	public void populateBlack() {
		Image im3 = new Image("/pictures/Black.jpg", false);
		crcBeginBlack001.setFill(new ImagePattern(im3));
		crcBeginBlack002.setFill(new ImagePattern(im3));
		crcBeginBlack003.setFill(new ImagePattern(im3));
		
		//Zu Beginn mit einer Spielfigur auf dem Feld starten
		crcField031.setFill(new ImagePattern(im3));
	}
	
	/*
	 * Setzt die gelben Spielfiguren in die gelbe Basis
	 */
	public void populateYellow() {
		Image im2 = new Image("/pictures/Yellow.jpg", false);
		crcBeginYellow001.setFill(new ImagePattern(im2));
		crcBeginYellow002.setFill(new ImagePattern(im2));
		crcBeginYellow003.setFill(new ImagePattern(im2));
		
		//Zu Beginn mit einer Spielfigur auf dem Feld starten
		crcField001.setFill(new ImagePattern(im2));
	}
	
	/*
	 * Setzt die gruenen Spielfiguren in die gruene Basis
	 */
	public void populateGreen() {
		Image im1 = new Image("/pictures/Green.jpg", false);
		crcBeginGreen001.setFill(new ImagePattern(im1));
		crcBeginGreen002.setFill(new ImagePattern(im1));
		crcBeginGreen003.setFill(new ImagePattern(im1));
		
		//Zu Beginn mit einer Spielfigur auf dem Feld starten
		crcField011.setFill(new ImagePattern(im1));
	}
	
	/*
	 *  Event Listener fuer 
	 */
	@FXML
	public void circleOnActionM(MouseEvent event) {
		String tempCircle = event.getPickResult().getIntersectedNode().getId();
		
		if(tokenID.containsKey(tempCircle)) {
			System.out.println("Ja");
		} else {
			JOptionPane.showMessageDialog(null, "Auf diesem Feld steht keine Spielfigur.","Achtung", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	/*
	 *  Event Listener fuer den Button Wuerfeln
	 *  Dieser ruft die Methode rollTheDice auf
	 */
	@FXML
	public void buttonRollTheDiceOnAction(ActionEvent event) {
		//Nach jedem mal Wuerfeln die Anzahl der runden/gewuerfelten male um 1 erhoehen
		numberButtonPressed++;
		
		if(numberButtonPressed == 1) {
			for(int i = 0; i <= LauncherController.numberOfPlayers; i++) {
				Dice rtd = new Dice();
				//rtd.anfangsRunde();
			}
		}
		
		
		
		Dice rtd = new Dice();
		int value = rtd.rollTheDice();

		/*
		 * Bilder der sechs Wuerfel
		 */
		Image dice1 = new Image("/pictures/Dice1.png", false);
		Image dice2 = new Image("/pictures/Dice2.png", false);
		Image dice3 = new Image("/pictures/Dice3.png", false);
		Image dice4 = new Image("/pictures/Dice4.png", false);
		Image dice5 = new Image("/pictures/Dice5.png", false);
		Image dice6 = new Image("/pictures/Dice6.png", false);
		
		/*
		 * aendern des Wuerfel bildes zu der gewuerfelten Zahl
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
		
		
		
		
		/*
		 * Man darf nur einmal Wuerfeln und muss danach ziehen
		 */
		if (event.getSource()==btnRollTheDice) {
			
				btnRollTheDice.setDisable(true);
				if (/*spieler hat gezogen*/ 
						//circleOnActionM(event);
						true) {
					
					btnRollTheDice.setDisable(false);
			}
		}
	}
	
	/*
	 *  Event Listener fuer den Beenden Button.
	 *  Dieser Beendet das Programm
	 */
	@FXML
	public void buttonExitGameOnAction(ActionEvent event) {

		System.exit(0);
	}
}


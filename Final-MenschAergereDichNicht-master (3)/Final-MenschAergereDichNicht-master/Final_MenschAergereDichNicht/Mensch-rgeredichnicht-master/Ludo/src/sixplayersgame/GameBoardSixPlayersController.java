package sixplayersgame;

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

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;

import javafx.scene.shape.Circle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 * Diese Klasse enthaelt das Spielfeld fuer sechs Spieler
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 */
public class GameBoardSixPlayersController {
	/*
	 * FXML Komponenten, die später auf dem Feld zu sehen sind 
	 */
	@FXML
	public SplitPane splitPane;
	public GridPane gridPaneLeft;
	public GridPane gridPaneRigth;
	
	//Startfelder der jeweiligen Farbe
	public Circle crcBeginYellow001;
	public Circle crcBeginYellow002;
	public Circle crcBeginYellow003;
	public Circle crcBeginYellow004;
	public Circle crcBeginBlack001;
	public Circle crcBeginBlack002;
	public Circle crcBeginBlack003;
	public Circle crcBeginBlack004;
	public Circle crcBeginRed001;
	public Circle crcBeginRed002;
	public Circle crcBeginRed003;
	public Circle crcBeginRed004;
	public Circle crcBeginBlue001;
	public Circle crcBeginBlue002;
	public Circle crcBeginBlue003;
	public Circle crcBeginBlue004;
	public Circle crcBeginGreen001;
	public Circle crcBeginGreen002;
	public Circle crcBeginGreen003;
	public Circle crcBeginGreen004;
	public Circle crcBeginPurple001;
	public Circle crcBeginPurple002;
	public Circle crcBeginPurple003;
	public Circle crcBeginPurple004;
	
	//Zielfelder der jeweiligen Farbe
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
	public Circle crcAimBlack001;
	public Circle crcAimBlack002;
	public Circle crcAimBlack003;
	public Circle crcAimBlack004;
	public Circle crcAimPurple001;
	public Circle crcAimPurple002;
	public Circle crcAimPurple003;
	public Circle crcAimBlue001;
	public Circle crcAimBlue002;
	public Circle crcAimBlue003;
	public Circle crcAimBlue004;
		
	//Lauffelder des Bretts
	public Circle crcField048;
	public Circle crcField045;
	public Circle crcField002;
	public Circle crcField046;
	public Circle crcField028;
	public Circle crcField047;
	public Circle crcField029;
	public Circle crcField043;
	public Circle crcField003;
	public Circle crcField044;
	public Circle crcField020;
	public Circle crcField001;
	public Circle crcField021;
	public Circle crcField022;
	public Circle crcField030;
	public Circle crcField027;
	public Circle crcField035;
	public Circle crcField026;
	public Circle crcField033;
	public Circle crcField024;
	public Circle crcField032;
	public Circle crcField023;
	public Circle crcField031;
	public Circle crcField042;
	public Circle crcField041;
	public Circle crcField038;
	public Circle crcField025;
	public Circle crcField040;
	public Circle crcField036;
	public Circle crcField037;
	public Circle crcField034;
	public Circle crcField039;
	public Circle crcField004;
	public Circle crcField005;
	public Circle crcField006;
	public Circle crcField007;
	public Circle crcField008;
	public Circle crcField009;
	public Circle crcField010;
	public Circle crcField011;
	public Circle crcField012;
	public Circle crcField013;
	public Circle crcField014;
	public Circle crcField015;
	public Circle crcField016;
	public Circle crcField017;
	public Circle crcField018;
	public Circle crcField019;
	
	//Button zum Wuerfeln, zum Beenden des Spiels
	public Button btnRollTheDice;
	public Button btnExitGame;
	
	//ImageView, welche das Wuerfelbild zeigt
	public ImageView imgDice;
	public Label lblPlayer;
	
	//Namen der Spieler eins bis sechs
	public TextField txtPlayer1;
	public TextField txtPlayer2;
	public TextField txtPlayer3;
	public TextField txtPlayer4;
	public TextField txtPlayer5;
	public TextField txtPlayer6;
	
	//Zaehlt wie oft der Button Wuerfeln geklickt wurde.
	public int round = 0;
	
	/*
	 * Diese ArrayLists halten die Felder, diese werden entweder in drei Kategorien eingeteilt den Lauffelder, Hausfeldern/Beginfeldern und Zielfeldern.
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
	public ArrayList<Circle> beginFieldsBlueGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsBlueGui = new ArrayList<Circle>();
	public ArrayList<Circle> beginFieldsPurpleGui = new ArrayList<Circle>();
	public ArrayList<Circle> aimFieldsPurpleGui = new ArrayList<Circle>();
	public HashMap<String, String> tokenID = new HashMap<String, String>();
	
	/**
	 * Methode die das Spielbrett initialisiert
	 *  @param playerName Name der Spieler
	 * @param color Farbe der jeweiligen Spieler
     * @param rival Eigenschaft der Spieler
     * @param numberOfPlayers Anzahl der Spieler
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
			}else if (l_circle.getId().startsWith("crcAimBlue")) {
				aimFieldsBlueGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginBlue")) {
				beginFieldsBlueGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcAimPurple")) {
				aimFieldsPurpleGui.add(l_circle);
			}else if (l_circle.getId().startsWith("crcBeginPurple")) {
				beginFieldsPurpleGui.add(l_circle);
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
		aimFieldsBlueGui.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsBlueGui.sort(Comparator.comparing(circle -> circle.getId()));
		aimFieldsPurpleGui.sort(Comparator.comparing(circle -> circle.getId()));
		beginFieldsPurpleGui.sort(Comparator.comparing(circle -> circle.getId()));

		/*
		 * Anzeigen der Spielernamen mit ihrer jeweiligen Farbe
		 */
		txtPlayer1.setText(playerName.get(0) + " - " + color.get(0));
		txtPlayer2.setText(playerName.get(1) + " - " + color.get(1));
		txtPlayer3.setText(playerName.get(2) + " - " + color.get(2));
		
		if(numberOfPlayers == 5) {
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
		}else if(numberOfPlayers == 6) {
			txtPlayer4.setText(playerName.get(3) + " - " + color.get(3));
			txtPlayer5.setText(playerName.get(4) + " - " + color.get(4));
			txtPlayer6.setText(playerName.get(5) + " - " + color.get(5));
		}
		/*
		 * Check ob die Farbe Gruen ausgewaehlt wurde.
		 * Definiert Basis fuer Gruen
		 */
		if(color.contains("Gruen")) {
			
			crcBeginGreen001.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen002.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcBeginGreen003.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			crcField033.setEffect(new DropShadow(+25d, 0d, +2d, Color.GREEN));
			
			populateGreen();
			
			tokenID.put("crcBeginGreen1", "green1");
			tokenID.put("crcBeginGreen2", "green2");
			tokenID.put("crcBeginGreen3", "green3");
			tokenID.put("crcField33", "green4");
		}
		
		/*
		 * Check ob die Farbe Gelb ausgewaehlt wurde
		 * Definiert die Basis fuer Gelb
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
		 * Check ob die Farbe Schwarz ausgewaehlt wurde
		 * Definiert die Basis fuer schwarz
		 */
		if(color.contains("Schwarz")) {
			
			crcBeginBlack001.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcBeginBlack002.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcBeginBlack003.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			crcField009.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLACK));
			
			populateBlack();
			
			tokenID.put("crcBeginBlack1", "black1");
			tokenID.put("crcBeginBlack2", "black2");
			tokenID.put("crcBeginBlack3", "black3");
			tokenID.put("crcField9", "black4");
		}
		
		/*
		 * Check ob die Farbe Rot ausgewaehlt wurde.
		 * Definiert die Basis fuer Rot
		 */
		if(color.contains("Rot")) {
			
			crcBeginRed001.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed002.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcBeginRed003.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			crcField025.setEffect(new DropShadow(+25d, 0d, +2d, Color.RED));
			
			populateRed();
			
			tokenID.put("crcBeginRed1", "red1");
			tokenID.put("crcBeginRed2", "red2");
			tokenID.put("crcBeginRed3", "red3");
			tokenID.put("crcField25", "red4");
		}
		
		/*
		 * Check ob die Farbe Blau ausgewaehlt wurde.
		 * Definiert die Basis fuer Blau
		 */
		if(color.contains("Blau")) {
			
			crcBeginBlue001.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
			crcBeginBlue002.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
			crcBeginBlue003.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
			crcField017.setEffect(new DropShadow(+25d, 0d, +2d, Color.BLUE));
			
			populateBlue(); 
			
			tokenID.put("crcBeginBlue1", "blue1");
			tokenID.put("crcBeginBlue2", "blue2");
			tokenID.put("crcBeginBlue3", "blue3");
			tokenID.put("crcField17", "blue4");
		}
		
		/*
		 * Check ob die Farbe Lila ausgewaehlt wurde.
		 * Definiert die Basis fuer Lila.
		 */
		if(color.contains("Lila")) {
			
			crcBeginPurple001.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE));
			crcBeginPurple002.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE));
			crcBeginPurple003.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE));
			crcField041.setEffect(new DropShadow(+25d, 0d, +2d, Color.PURPLE));
			
			populatePurple();
			
			tokenID.put("crcBeginPurple1", "purple1");
			tokenID.put("crcBeginPurple2", "purple2");
			tokenID.put("crcBeginPurple3", "purple3");
			tokenID.put("crcField41", "purple4");
		}
	}	

	
	/*
	 * Setzt die Lila Spielfiguren in die lila Basis
	 */
	public void populatePurple() {
		Image im6 = new Image("/pictures/Purple.jpg", false);
		crcBeginPurple001.setFill(new ImagePattern(im6));
		crcBeginPurple002.setFill(new ImagePattern(im6));
		crcBeginPurple003.setFill(new ImagePattern(im6));
		
		//Zu Beginn mit einer Spielfigur auf dem Feld starten
		crcField041.setFill(new ImagePattern(im6));
	}
	
	/*
	 * Setzt die blauen Spielfiguren in die blaue Basis
	 */
	public void populateBlue() {
		Image im5 = new Image("/pictures/Blue.jpg", false);
		crcBeginBlue001.setFill(new ImagePattern(im5));
		crcBeginBlue002.setFill(new ImagePattern(im5));
		crcBeginBlue003.setFill(new ImagePattern(im5));
		
		//Zu Beginn mit einer Spielfigur auf dem Feld starten
		crcField017.setFill(new ImagePattern(im5));
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
		crcField025.setFill(new ImagePattern(im4));
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
		crcField009.setFill(new ImagePattern(im3));
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
		crcField033.setFill(new ImagePattern(im1));
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
	 *  Event Listener fuer den Wuerfeln Button
	 *  Dieser ruft die Methode rollTheDice auf
	 */
	@FXML
	public void buttonRollTheDiceOnAction(ActionEvent event) {
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
		
		//nach jedem mal wuerfeln werden dies rounds um eins hochgezaehlt
		round++;
		
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
	 *  Dieser beendet das Programm
	 */
	@FXML
	public void buttonExitGameOnAction(ActionEvent event) {
		System.exit(0);
	}
	
}

package launcher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sixplayersgame.GameBoardSixPlayersController;
import fourplayersgame.GameBoardFourPlayersController;

/**
 * Der Launcher Controller ist für die Funktionalität des Launchers verantwortlich.
 * Hier kann der Spieler die Voreinstellungen für das Spiel tätigen.
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 *
 */
public class LauncherController {
	
	/*
	 * FXML Komponenten,aus welchen das Board aufgebaut ist 
	 */
	
	@FXML
	//RadioButtons zur Anzahl der Spielerauswahl
	public GridPane gridPane;
	public RadioButton rbPlayer2;
	public RadioButton rbPlayer3;
	public RadioButton rbPlayer4;
	public RadioButton rbPlayer5;
	public RadioButton rbPlayer6;
		
	//Textfelder in welcher die Namen der Spieler eingetragen werden koennen.
	public TextField txtName1;
	public TextField txtName2;
	public TextField txtName3;
	public TextField txtName4;
	public TextField txtName5;
	public TextField txtName6;
	
	//ComboBoxen zur Farbauswahl der Spieler
	public ComboBox<String> cbColor1;
	public ComboBox<String> cbColor2;
	public ComboBox<String> cbColor3;
	public ComboBox<String> cbColor4;
	public ComboBox<String> cbColor5;
	public ComboBox<String> cbColor6;
	
	//ComboBoxen zur Gegneraswahl
	public ComboBox<String> cbRival1;
	public ComboBox<String> cbRival2;
	public ComboBox<String> cbRival3;
	public ComboBox<String> cbRival4;
	public ComboBox<String> cbRival5;
	public ComboBox<String> cbRival6;
	
	//Buttons zum Starten, Beenden und Auswahlueberpruefen
	public Button btnStartGame;
	public Button btnExitGame;
	public Button btnCheckSelection;
	
	//Variable enthaelt die Anzahl der Spieler
	public static int numberOfPlayers;
	
	/*
	 * ArrayLists welche die Farbe und Eigenschaften der Spieler enthaelt, diese sind zum leichteren Befuellen der ComboBoxen gedacht.
	 */
	private ArrayList <ComboBox> cbColor = new ArrayList<ComboBox>();
	private ArrayList <ComboBox> cbRival = new ArrayList<ComboBox>();
	
	/*
	 * ArrayLists zur Uebergabe der vom Spieler ausgewaehlten Eigenschaften an die Spiellogik 
	 */
	public ArrayList <String> playerName = new ArrayList<String>();
	public ArrayList <String> color = new ArrayList<String>();
	public ArrayList <String> rival = new ArrayList<String>();
	
	/*
	 * Methode zum Hinzufuegen der einzelnen ComboBoxen zu den ArrayLists sowie das Befuellen der ComboBoxen.
	 */
	public void initialize() {
		cbColor.add(cbColor1);
		cbColor.add(cbColor2);
		cbColor.add(cbColor3);
		cbColor.add(cbColor4);
		cbColor.add(cbColor5);
		cbColor.add(cbColor6);
		
		cbRival.add(cbRival1);
		cbRival.add(cbRival2);
		cbRival.add(cbRival3);
		cbRival.add(cbRival4);
		cbRival.add(cbRival5);
		cbRival.add(cbRival6);
		
		/*
		 * Die ComboBoxen Farbe wird zunaechst mit den 4 Farben des 4er Spielbrettes gefuellt und die Farbe Gelb als Vorauswahl getroffen
		 */
		int i = 0,j = 0;
		while (i < cbColor.size()) {
			cbColor.get(i).getItems().add("Gelb");
			cbColor.get(i).getItems().add("Rot");
			cbColor.get(i).getItems().add("Gruen");
			cbColor.get(i).getItems().add("Schwarz");
			cbColor.get(i).setValue("Gelb");
			i++;
		}
		
		/*
		 * Die ComboBoxen fuer die Auswahl der Eigenschaften der Gegner wird befuellt und die Eigenschaft Mensch als Vorauswahl getroffen
		 */
		while (j < cbRival.size()) {
			cbRival.get(j).getItems().add("Mensch");
			cbRival.get(j).getItems().add("Computer");
			cbRival.get(j).setValue("Mensch");
			j++;
		}				
	}
	
	@FXML
	/*
	 * Event Listener fuer den RadioButton, wenn die Anzahl der Spieler 2 ausgewaehlt wird.
	 */
	public void rbOnActionPlayer2(ActionEvent event) {
		if(rbPlayer2.isSelected()) {
			
			numberOfPlayers = 2;
		}
		
		/*
		 * Die Textfelder und ComboBoxen fuer den Spieler 1 und Spieler 2 werden aktiviert, auÃŸer die ComboBox Farben fuer Spieler 2 da der Spieler 2 immer gegenueber der Farbe des Spielers 1 sein muss
		 */
		txtName1.setDisable(false);
		cbColor1.setDisable(false);
		cbRival1.setDisable(false);
		
		txtName2.setDisable(false);
		cbRival2.setDisable(false);
		
		/*
		 * Die Auswahl fuer die Anzahl an Spielern die nicht ausgewaehlt wurde, wird deaktiviert
		 */
		rbPlayer3.setDisable(true);
		rbPlayer4.setDisable(true);
		rbPlayer5.setDisable(true);
		rbPlayer6.setDisable(true);
		
		/*
		 * Da die Vorauswahl der ComboBox Farben des Spieler 1 auf Gelb gesetzt wird, wird die Farbe Rot fuer den Spieler 2 ausgewaehlt
		 */
		cbColor2.setValue("Rot");
	}
	
	@FXML
	/*
	 * Event Listener fuer den RadioButton, wenn fuer die Anzahl der Spieler 3 ausgewaehlt wird.
	 */
	public void rbOnActionPlayer3(ActionEvent event) {
		if(rbPlayer3.isSelected()) {
			numberOfPlayers = 3;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben des Spielers 1 hinzugefuegt, da hier auf dem 6er Spielfeld gespielt wird.
			 * Da die Auswahl fuer Spieler 1 anfangs auf Gelb gesetzt wird und die direkte Nachbarfarbe bei 3 Spieler nicht ausgewaehlt werden darf, wird die Auswahl Farbe bei Spieler 2 auf Blau und Gruen beschraenkt
			 * Die Farbauswahl bei Spieler 3 wird erweitert mit Blau und Lila und die Vorauswahl auf Gruen gesetzt
			 */
			cbColor1.getItems().add("Blau");
			cbColor1.getItems().add("Lila");
			cbColor1.setValue("Gelb");
			
			cbColor2.getItems().removeAll();
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Gruen");
			cbColor2.setValue("Blau");
			
			cbColor3.getItems().add("Blau");
			cbColor3.getItems().add("Lila");
			cbColor3.setValue("Gruen");
			
			/*
			 * Das Textfeld fuer den Namen und die ComboBox fuer die Gegnerauswahl wird fuer Spieler 1, Spieler 2 und Spieler 3 aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbRival3.setDisable(false);
			
			/*
			 * Die Auswahl fuer die Anzahl an Spielern die nicht ausgewaehlt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer5.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/*
	 * Event Listener fuer den RadioButton, wenn fuer die Anzahl der Spieler 4 ausgewaehlt wird.
	 */
	public void rbOnActionPlayer4(ActionEvent event) {
		if(rbPlayer4.isSelected()) {
			numberOfPlayers = 4;
			
			/*
			 * Das Textfeld fuer den Namen und die ComboBox fuer die Gegnerauswahl wird fuer Spieler 1, Spieler 2, Spieler 3 und Spieler 4 aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false); 
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
			
			/*
			 * Die Auswahl fuer die Anzahl an Spielern die nicht ausgewaehlt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer5.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/*
	 * Event Listener fuer den RadioButton, wenn fuer die Anzahl der Spieler 5 ausgewaehlt wird.
	 */
	public void rbOnActionPlayer5(ActionEvent event) {
		if(rbPlayer5.isSelected()) {
			numberOfPlayers = 5;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben aller Spieler hinzugefuegt, da hier auf dem 6er Spielfeld gespielt wird
			 * Und jeweils eine Vorauswahl der Farben getroffen
			 */
			int i = 0,j = 0;
			while (i < cbColor.size()) {
				cbColor.get(i).getItems().add("Blau");
				cbColor.get(i).getItems().add("Lila");
				cbColor.get(i).setValue("Gelb");
				i++;
			}
			
			/*
			 * Das Textfeld fuer den Namen und die ComboBox fuer die Gegnerauswahl wird fuer Spieler 1, Spieler 2, Spieler 3, Spieler 4 und Spieler 5 aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
			
			txtName5.setDisable(false);
			cbColor5.setDisable(false);
			cbRival5.setDisable(false);
			
			/*
			 * Die Auswahl fuer die Anzahl an Spielern die nicht ausgewaehlt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/*
	 * Event Listener fuer den RadioButton, wenn fuer die Anzahl der Spieler 6 ausgewaehlt wird.
	 */
	public void rbOnActionPlayer6(ActionEvent event) {
		if(rbPlayer6.isSelected()) {
			numberOfPlayers = 6;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben aller Spieler hinzugefuegt, da hier auf dem 6er Spielfeld gespielt wird
			 * Und jeweils eine Vorauswahl der Farben getroffen
			 */
			int i = 0,j = 0;
			while (i < cbColor.size()) {
				cbColor.get(i).getItems().add("Blau");
				cbColor.get(i).getItems().add("Lila");
				cbColor.get(i).setValue("Gelb");
				i++;
			}
			
			/*
			 * Das Textfeld fuer den Namen und die ComboBox fuer die Gegnerauswahl wird fuer alle Spieler aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
				
			txtName5.setDisable(false);
			cbColor5.setDisable(false);
			cbRival5.setDisable(false);
			
			txtName6.setDisable(false);
			cbColor6.setDisable(false);
			cbRival6.setDisable(false);
			
			/*
			 * Die Auswahl fuer die Anzahl an Spielern die nicht ausgewaehlt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer5.setDisable(true);
		}
	}
	
	@FXML
	/*
	 *  Event Listener fuer die ComboBox Farben1.
	 */
	public void cbOnActionColor1(ActionEvent event) {
	
		/*
		 * Wenn die Anzahl der Spieler = 2 ist, wird die Methode setcbColor2Player2() ausgefuehrt.
		 */
		if(rbPlayer2.isSelected()){
			setcbColor2Player2();
		}
		
		/*
		 * Da man nur Werte die Items der jeweiligen ComboBox sind als Wert setzen kann werden hier nochmal alle zur ComboBox der Farben des Spielers 2 hinzugefuegt,
		 * da es ansonsten zu Fehlern bei der Farbauswahl von 3 Spielern kommen wuerde.
		 * Wenn die Anzahl der Spieler = 3 ist, wird die Methode setcbColor2Player3() ausgefuehrt.
		 */
		else if(rbPlayer3.isSelected()) {
			
			cbColor2.getItems().removeAll();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Gruen");
			cbColor2.getItems().add("Schwarz");
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Lila");
			
			setcbColor2Player3();
		}
	}
	
	/*
	 * Wenn die Anzahl der Spieler = 2 ist, duerfen nur die gegenueberliegenden Farben verwendet werden. 
	 * Es wird zunaechst die Auswahl fuer die erste Farbe ueberprueft und die Farbe fuer die zweite Farbe, also den Spieler 2 automatisch ausgewaehlt.
	 * Die zweite Farbe kann nicht veraendert werden.
	 */
	private void setcbColor2Player2() {		
		if(cbColor1.getValue().equals("Gelb")) {
			cbColor2.setValue("Rot");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Gruen")) {
			cbColor2.setValue("Schwarz");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Rot")) {
			cbColor2.setValue("Gelb");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Schwarz")) {
			cbColor2.setValue("Gruen");
			cbColor2.setDisable(true);
		}
	}
	
	/*
	 * Wenn die Anzahl der Spieler = 3 ist, duerfen nur die Farben verwendet werden, die nicht direkte Nachbarn sind. 
	 * Es wird zunaechst die Auswahl fuer die erste Farbe ueberprueft und die Farbauswahl fuer die zweite Farbe neu festgelegt, also die ComboBox der Farbe des Spielers 2 jeweils neue Items gesetzt.
	 */
	private void setcbColor2Player3() {
		if(cbColor1.getValue().equals("Gelb")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Gruen");
			cbColor2.setValue("Blau");
			cbColor3.setValue("Gruen");
				
		} else if(cbColor1.getValue().equals("Gruen")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Blau");
			cbColor2.setValue("Gelb");
			cbColor3.setValue("Blau");
				
		} else if(cbColor1.getValue().equals("Blau")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Gruen");
			cbColor2.setValue("Gelb");
			cbColor3.setValue("Gruen");
		
		} else if(cbColor1.getValue().equals("Lila")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Schwarz");
			cbColor2.setValue("Rot");
			cbColor3.setValue("Schwarz");
				
		} else if(cbColor1.getValue().equals("Rot")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Lila");
			cbColor2.getItems().add("Schwarz");
			cbColor2.setValue("Lila");
			cbColor3.setValue("Schwarz");
				
		} else if(cbColor1.getValue().equals("Schwarz")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Lila");
			cbColor2.setValue("Rot");
			cbColor3.setValue("Lila");
		}
	}

	@FXML
	/*
	 *  Event Listener fuer die ComboBox Farben2.
	 */
	public void cbOnActionColor2(ActionEvent event) {
		
		/*
		 * Wenn die Anzahl der Spieler = 3 ist, wird die Methode setcbColor3() ausgefuehrt.
		 */
		if(rbPlayer3.isSelected()){
			setcbColor3();
		}
	}

	/*
	 * Es wird anschlieÃŸend die Auswahl fuer die erste und zweite Farbe ueberprueft und die Farbe fuer die dritte Farbe, also fuer den Spieler 3 automatisch ausgewaehlt.
	 * Die dritte Farbe kann nicht veraendert werden.
	 */
	public void setcbColor3() {
		if(cbColor1.getValue().equals("Gelb")) {
			if(cbColor2.getValue().equals("Gruen")) {
				cbColor3.setValue("Blau");
			} else if (cbColor2.getValue().equals("Blau")){
				cbColor3.setValue("Gruen");
			}	
		} else if(cbColor1.getValue().equals("Gruen")) {
			if(cbColor2.getValue().equals("Blau")) {
				cbColor3.setValue("Gelb");
			} else if(cbColor2.getValue().equals("Gelb")){
				cbColor3.setValue("Blau");
			}	
		} else if(cbColor1.getValue().equals("Blau")) {
			if(cbColor2.getValue().equals("Gruen")) {
				cbColor3.setValue("Gelb");
			} else if(cbColor2.getValue().equals("Gelb")){
				cbColor3.setValue("Gruen");
			}		
		} else if(cbColor1.getValue().equals("Lila")) {
			if(cbColor2.getValue().equals("Rot")) {
				cbColor3.setValue("Schwarz");
			} else if (cbColor2.getValue().equals("Schwarz")){
				cbColor3.setValue("Rot");
			}				
		} else if(cbColor1.getValue().equals("Rot")) {
			if(cbColor2.getValue().equals("Lila")) {
				cbColor3.setValue("Schwarz");
			} else if (cbColor2.getValue().equals("Schwarz")){
				cbColor3.setValue("Lila");
			}	
				
		} else if(cbColor1.getValue().equals("Schwarz")) {
			if(cbColor2.getValue().equals("Rot")) {
				cbColor3.setValue("Lila");
			} else if (cbColor2.getValue().equals("Lila")){
				cbColor3.setValue("Rot");
			}	
		}
	}

	
	@FXML
	/*
	 *  Event Listener fuer den Button Auswahl ueberpruefen.
	 */
	public void buttonOnActionCheckSelection(ActionEvent event) {
		/*
		 * Zunaechst muss ein RadioButton fuer die Anzahl an Spielern ausgewaehlt sein, damit es keinen Fehler bei der Ueberpruefung gibt
		 */
		if((!rbPlayer2.isSelected()) && (!rbPlayer3.isSelected()) && (!rbPlayer4.isSelected()) && (!rbPlayer5.isSelected()) && (!rbPlayer6.isSelected())) {
			JOptionPane.showMessageDialog(null, "Bitte waehlen Sie eine Anzahl an Spielern aus.","Achtung", JOptionPane.ERROR_MESSAGE);
		}
		else {
			/*
			 * Wenn die Anzahl der Spieler = 2 ausgewaehlt wurde
			 */
			if(numberOfPlayers == 2) {
				/*
				 * Es wird die Methode checkSelection1and2() ausgefuehrt, wenn diese false zurueckggibt wird eine Fehlermeldung gesendet
				 */
				if(checkSelection1and2() == true) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
				
			/*
			 * Wenn die Anzahl der Spieler = 3 ausgewaehlt wurde
			 */
			}else if(numberOfPlayers == 3) {
				/*
				 * Es werden die Methoden checkSelection1and2() und checkSelection3() ausgefuehrt, wenn diese false zurueckggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true)) {
						btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Wenn die Anzahl der Spieler = 4 ausgewaehlt wurde
			 */
			} else if (numberOfPlayers == 4) {
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3() und checkSelection4() ausgefuehrt, wenn diese false zurueckggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true)) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Wenn die Anzahl der Spieler = 5 ausgewaehlt wurde
			 */
			} else if (numberOfPlayers == 5) {
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3(), checkSelection4() und checkSelection5() ausgefuehrt, wenn diese false zurueckggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true) && (checkSelection5()) == true) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Wenn die Anzahl der Spieler = 6 ausgewaehlt wurde
			 */
			} else if (numberOfPlayers == 6) {
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3(), checkSelection4(), checkSelection5() und checkSelection6() ausgefuehrt, wenn diese false zurueckggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true) && (checkSelection5() == true) && (checkSelection6() == true)) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Ueberpruefen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		//nur fuer Testzwecke
		System.out.println(playerName);
		System.out.println(color);
		System.out.println(rival);
	}
	
	
	/*
	 * Die Eingaben beim Spieler 1 und Spieler 2 werden auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * @return Es wird false zurueckgegeben, wenn nicht alles richtig und vollstaendig ist, also die TextFelder nicht oder falsch ausgefuellt wurden, hierzu zaehlt auch die Eingabe von Sonderzeichen oder eine zu GroÃŸe oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewaehlt haben
	 * @return Es wird true zurueckgegeben, wenn alles richtig und vollstaendig ist und die Eingaben werden den ArrayList hinzugefuegt
	 */
	public boolean checkSelection1and2 () {
		
		if((txtName1.getText().isEmpty()) || (txtName2.getText().isEmpty()) || (txtName2.getText().equals(txtName1.getText())) || (!txtName1.getText().matches("\\w+")) || (!txtName2.getText().matches("\\w+")) || (txtName1.getText().length() > 40) || (txtName1.getText().length() <= 1) || (txtName2.getText().length() > 40) || (txtName2.getText().length() <= 1)){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		if((cbColor1.getValue().isEmpty()) || (cbColor2.getValue().isEmpty()) || (cbColor2.getValue().equals(cbColor1.getValue()))) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}
		
		else {	
			playerName.add(txtName1.getText());
			color.add(cbColor1.getValue());
			rival.add(cbRival1.getValue());	
		
			playerName.add(txtName2.getText());
			color.add(cbColor2.getValue());
			rival.add(cbRival2.getValue());	
			return true;	
		}
	}
	
	/*
	 * Die Eingaben beim Spieler 3 werden auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * @return Es wird false zurueckgegeben wenn nicht alles richtig und vollstaendig ist, also die TextFelder nicht oder falsch ausgefuellt wurden, hierzu zaehlt auch die Eingabe von Sonderzeichen oder eine zu GroÃŸe oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewaehlt haben
	 * @return Es wird true zurueckgegeben wenn alles richtig und vollstaendig ist und die Eingaben werden den ArrayList hinzugefuegt
	 */
	public boolean checkSelection3 () {
		
		if((playerName.contains(txtName3.getText())) || (txtName3.getText().isEmpty()) || (!txtName3.getText().matches("\\w+")) || (txtName3.getText().length() > 40) || (txtName3.getText().length() <= 1)){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		// oder die Farbe3 bereits vergeben ist gibt es einen Fehler und die bisherigen Arraylist werden geleert
		if((cbColor3.getValue().isEmpty()) || (cbColor3.getValue().equals(cbColor1.getValue())) || (cbColor3.getValue().equals(cbColor2.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}
		else { 
			playerName.add(txtName3.getText());
			color.add(cbColor3.getValue());
			rival.add(cbRival3.getValue());	
			
			return true;
		} 	
	}
	
	/*
	 * Die Eingaben beim Spieler 4 werden auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * @return Es wird false zurueckgegeben wenn nicht alles richtig und vollstaendig ist, also die TextFelder nicht oder falsch ausgefuellt wurden, hierzu zaehlt auch die Eingabe von Sonderzeichen oder eine zu GroÃŸe oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewaehlt haben
	 * @return Es wird true zurueckgegeben wenn alles richtig und vollstaendig ist und die Eingaben werden den ArrayList hinzugefuegt
	 */
	public boolean checkSelection4 () {
		
		if((playerName.contains(txtName4.getText())) || (txtName4.getText().isEmpty()) || (!txtName4.getText().matches("\\w+")) || (txtName4.getText().length() > 40) || (txtName4.getText().length() <= 1)) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		
		if((cbColor4.getValue().isEmpty()) || (cbColor4.getValue().equals(cbColor1.getValue())) || (cbColor4.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor3.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;			
		} 
		
		else { 
			playerName.add(txtName4.getText());
			color.add(cbColor4.getValue());	
			rival.add(cbRival4.getValue());
			
			return true;
		}	
	}
		
	/*
	 * Die Eingaben beim Spieler 5 werden auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * @return Es wird false zurueckgegeben wenn nicht alles richtig und vollstaendig ist, also die TextFelder nicht oder falsch ausgefuellt wurden, hierzu zaehlt auch die Eingabe von Sonderzeichen oder eine zu GroÃŸe oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewaehlt haben
	 * @return Es wird true zurueckgegeben wenn alles richtig und vollstaendig ist und die Eingaben werden den ArrayList hinzugefuegt
	 */
	public boolean checkSelection5 () {
		
		if((playerName.contains(txtName5.getText())) || (txtName5.getText().isEmpty()) || (!txtName5.getText().matches("\\w+")) || (txtName5.getText().length() > 40) || (txtName5.getText().length() <= 1)) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		
		if((cbColor5.getValue().isEmpty()) || (cbColor5.getValue().equals(cbColor1.getValue())) || (cbColor5.getValue().equals(cbColor2.getValue())) || (cbColor5.getValue().equals(cbColor3.getValue())) || (cbColor5.getValue().equals(cbColor4.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		
		else { 
			playerName.add(txtName5.getText());
			color.add(cbColor5.getValue());	
			rival.add(cbRival5.getValue());
			
			return true;
		}
	}
		
	/*
	 * Die Eingaben beim Spieler 6 werden auf Vollstaendigkeit und Richtigkeit ueberprueft.
	 * @return Es wird false zurueckgegeben wenn nicht alles richtig und vollstaendig ist, also die TextFelder nicht oder falsch ausgefuellt wurden, hierzu zaehlt auch die Eingabe von Sonderzeichen oder eine zu GroÃŸe oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewaehlt haben
	 * @return Es wird true zurueckgegeben wenn alles richtig und vollstaendig ist und die Eingaben werden den ArrayList hinzugefuegt
	 */
	public boolean checkSelection6 () {
		if((playerName.contains(txtName6.getText())) || (txtName6.getText().isEmpty()) || (!txtName6.getText().matches("\\w+")) || (txtName6.getText().length() > 40) || (txtName6.getText().length() <= 1)) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		} 
		
		if((cbColor6.getValue().isEmpty()) || (cbColor6.getValue().equals(cbColor1.getValue())) || (cbColor6.getValue().equals(cbColor2.getValue())) || (cbColor6.getValue().equals(cbColor3.getValue())) || (cbColor6.getValue().equals(cbColor4.getValue())) || (cbColor6.getValue().equals(cbColor5.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}
		
		else { 
			playerName.add(txtName6.getText());
			color.add(cbColor6.getValue());
			rival.add(cbRival6.getValue());	
			
			return true;
		} 
	}
	
	@FXML
	/*
	 *  Event Listener fuer den Button Auswahl aufheben.
	 */
	public void buttonOnActionRepeatSelection(ActionEvent event) {
		/*
		 * Das Fenster des Launchers wird geschlossen.
		 */
		Stage currentStage = (Stage)btnStartGame.getScene().getWindow();
		currentStage.close();
		
		/*
		 * Es wird ein neues Fenster des Launchers geoeffnet.
		 */
		try {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/launcher/Launcher.fxml"));
			Parent root = fxmlloader.load();
			Stage secondaryStage = new Stage();
			secondaryStage.setTitle("Game Selection");
			secondaryStage.setScene(new Scene(root, 750, 450)); 
			secondaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML		
	/*
	 *  Event Listener fuer den Start Button.
	 */
	public void buttonOnActionStart(ActionEvent event) {
		/*
		 * SchlieÃŸen des Launcher Fensters
		 */
		Stage currentStage = (Stage)btnStartGame.getScene().getWindow();
		currentStage.close();
		
		try {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Begin.fxml"));
			Parent root = fxmlloader.load();
			BeginController bc = fxmlloader.getController(); 
			bc.initialize(playerName, color, rival, numberOfPlayers);
			Stage secondaryStage = new Stage();
			secondaryStage.setTitle("Wer darf anfangen?");
			secondaryStage.setScene(new Scene(root, 600, 450)); 
			secondaryStage.show();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	/*
	 *  Event Listener fuer den Button Spiel beenden.
	 *  Dieser schlieÃŸt das Programm
	 */
	public void buttonOnActionExit(ActionEvent event) {
		
		System.exit(0);
	}
}


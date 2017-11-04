package uppgift4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Innehåller main-metoden
 * Controller-klassen håller reda på allt och tar besluten i programmet.
 * Den säTter/håller reda på array7x7-objekten och skickar de till displayen 
 * med hjälp av objekten själva och Array7-objekt för flyttandet av textremsorna.
 * Den skapar arrayer för att hålla objekten och timers för att initera rinnande text.
 * @author Max Frennessen, Amin Harirchian, Ley Tufva Qlibt, Lykke Levin
 *
 */

public class Controller {
	private Timer timerR = new Timer(200, new ATimer());
	private Timer timerL = new Timer(200, new ATimer());
	private Viewer view;
	protected Char letter = new Char();

	// Förberedda arrayer och sträng-objekt för flyttande av texten
	private Array7x7[] letterBox;
	private Array7[] columnBox,rowBox;
	private Array7 copy;

	private int[][] aLetter = new int[7][7];
	protected int[] backUp;
	private int lenChars;
	protected int count =0;


	public Controller(Viewer view){
		this.view = view;
		view.setController(this);
	}

	protected void showLetter(int[][] boxes,int high, int move) {
		view.updateDisplay(boxes,high,move);
	}

	// Skapar och visar innehållet i textarrayerna.
	public void stitchArray(String chars){
		char one;
		int chr=0;
		if ( chars != null){
			lenChars = chars.length();	
			if ( lenChars < 5){
				do{
					chars += " ";
					lenChars++;
				}while(lenChars < 5);
			}
			chars += " ";
			lenChars++;
			letterBox = new Array7x7[lenChars];
			columnBox = new Array7[lenChars];
			rowBox = new Array7[lenChars];

			do{
				one = chars.charAt(chr);	
				letterBox[chr]= letter.getChar(one);
				backUp = letterBox[chr].getColumn(6);
				copy = new Array7(backUp); 
				columnBox[chr] = copy;
				backUp = letterBox[chr].getRow(6);
				copy = new Array7(backUp);
				rowBox[chr]= copy;
				chr++;
			}while(chr < lenChars);
			for (int move = 0; move < lenChars;move++){			
				aLetter = letterBox[move].getSign();
				showLetter(aLetter,0,move);
			}
		}else{
			count = 4;
			chars="ERROR: INPUT TEXT";
			view.btnAmin.setEnabled(false);
			view.btnLykke.setEnabled(false);
			view.btnLey.setEnabled(false);
			view.btnMax.setEnabled(false);
			view.btnEnter.setEnabled(false);
			view.tfInput.setEnabled(false);

			stitchArray(chars);
			updateLeftArray();
		}
	}

	// Flyttar texten åt höger
	public void goArray(){
		if ( letterBox != null && backUp !=null){			
			for ( int b = 0; b < letterBox.length; b++){
				backUp = letterBox[b].getColumn(6);
				copy = new Array7(backUp); 
				columnBox[b] = copy;
			}
			copy = columnBox[lenChars-1];
			for (int n = lenChars - 1; n > 0; n--){
				columnBox[n] = columnBox[n-1];
			}
			columnBox[0] = copy;		
			for (int box = 0; box < letterBox.length; box ++){
				letterBox[box].setColumn(columnBox[box], 0);
				letterBox[box].moveSignR();		
			}
			for (int move = 0; move < lenChars; move++){
				aLetter= letterBox[move].getSign();
				showLetter(aLetter,0,move);
			}		
			view.updateDisplay();
		}else{
			String chars="ERROR: INPUT TEXT";
			view.btnAmin.setEnabled(false);
			view.btnLykke.setEnabled(false);
			view.btnLey.setEnabled(false);
			view.btnMax.setEnabled(false);
			view.btnEnter.setEnabled(false);
			view.tfInput.setEnabled(false);
			stitchArray(chars);
			updateLeftArray();
			}

	}
	// Flytta texten år vänster
	public void goLeftArray(){	
		if (letterBox !=null && backUp != null) {
			for (int n = 0; n < letterBox.length; n++){
				backUp = letterBox[n].getColumn(0);
				copy = new Array7(backUp); 
				columnBox[n] = copy;
			}
			copy = columnBox[0];
			for (int n = 1; n < lenChars; n++){
				columnBox[n-1] = columnBox[n];
			}
			columnBox[lenChars - 1] = copy;		
			for (int box = 0; box < letterBox.length; box++){
				letterBox[box].setColumn(columnBox[box], 6);
				letterBox[box].moveSignL();		
			}
			for (int move = 0; move < lenChars; move++){
				aLetter= letterBox[move].getSign();
				showLetter(aLetter,0,move);
			}		
			view.updateDisplay();
		}else{
			String chars="ERROR: INPUT TEXT";
			view.btnAmin.setEnabled(false);
			view.btnLykke.setEnabled(false);
			view.btnLey.setEnabled(false);
			view.btnMax.setEnabled(false);
			view.btnEnter.setEnabled(false);
			view.tfInput.setEnabled(false);
			stitchArray(chars);
			updateLeftArray();
			}

	}
	// Stopp och uppdatering för timrarna
	public void stopArray() {
		timerR.stop();
	}
	public void stopLeftArray() {
		timerL.stop();
	}
	public void updateArray() {
		timerL.stop();
		timerR.restart();
	}
	public void updateLeftArray() {
		timerR.stop();
		timerL.restart();
	}

	private class ATimer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == timerR){
				goArray();	
			}
			if (e.getSource() == timerL){
				goLeftArray();			
			}
		}			
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Viewer view = new Viewer(1, 5, Color.BLACK, Color.MAGENTA);
				Controller controller = new Controller(view);
				JFrame frame = new JFrame();
				frame.setPreferredSize(new Dimension(800,620));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(view);
				frame.pack();
				frame.setVisible(true);

			}
		});
	}

}

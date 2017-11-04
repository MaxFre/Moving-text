package uppgift4;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Max Frennessen, Amin Harirchian, Ley Tufva Qlibt, Lykke Levin
 *
 */

public class RorandeDel extends JPanel {

	private static Char array7x7;
	private String[] LeftSide = new String[7];
	private String[] RightSide = new String[7];

	private int[][] hiddenArray = new int[7][9];
	private int[][] tempCopyOfHiddenArray = new int[7][9];
	private int[] tempArray = new int[7];
	private int[][] CopyOfHiddenArray = new int[7][9];

	private JTextField[] LeftSideTF = new JTextField[7];
	private JTextField[] RightSideTF = new JTextField[7];

	private int[][] fromArray7x7INT = new int[7][7];

	private JTextField[] fields = new JTextField[49];

	private JButton btnRight = new JButton(">>");
	private JButton btnLeft = new JButton("<<");
	private JButton btnMiddle = new JButton("[  ]");
	private int x = 0;
	private int y = 0;

	public RorandeDel(Array7x7 prog) {
		int[][] fromArray7x7 = prog.getTest();

		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 9; y++) {
				hiddenArray[i][y] = 123;

			}
		}

		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 7; y++) {
				hiddenArray[i][y + 1] = fromArray7x7[i][y];
				fromArray7x7INT[i][y] = fromArray7x7[i][y];
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 9; y++) {
				CopyOfHiddenArray[i][y] = hiddenArray[i][y];

			}
		}

		int[] testar = new int[49];
		int n = 0;
		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 7; y++) {

				testar[n] = hiddenArray[i][y + 1];
				n++;
			}
		}

		setLayout(null);
		setPreferredSize(new Dimension(800, 520));

		int a = 0;
		int b = 0;
		int v = 0;
		int p = 0;
		int q = 0;
		int k = 0;
		int u = 0;

		for (int i = 0; i < fields.length; i++) {

			fields[i] = new JTextField("   " + String.valueOf(testar[i]));

			if (i <= 6) {
				fields[i].setBounds(220 + a, 55, 50, 50);
				a += 60;

			} else if ((i > 6) && (i <= 13)) {
				fields[i].setBounds(220 + b, 110, 50, 50);
				b += 60;

			} else if ((i > 13) && (i <= 20)) {
				fields[i].setBounds(220 + v, 170, 50, 50);
				v += 60;

			}

			else if ((i > 20) && (i <= 27)) {
				fields[i].setBounds(220 + p, 230, 50, 50);
				p += 60;
			}

			else if ((i > 27) && (i <= 34)) {
				fields[i].setBounds(220 + q, 290, 50, 50);
				q += 60;
			} else if ((i > 34) && (i <= 41)) {
				fields[i].setBounds(220 + k, 350, 50, 50);
				k += 60;
			} else if ((i > 41) && (i <= 48)) {
				fields[i].setBounds(220 + u, 410, 50, 50);
				u += 60;
			}
			add(fields[i]);

		}

		for (int i = 0; i < RightSide.length; i++) {

			LeftSideTF[i] = new JTextField("");

			LeftSideTF[i].setBounds(70, 55 + x, 50, 50);
			x += 60;

			add(LeftSideTF[i]);
		}

		for (int i = 0; i < RightSide.length; i++) {

			RightSideTF[i] = new JTextField("");

			RightSideTF[i].setBounds(700, 55 + y, 50, 50);
			y += 60;

			add(RightSideTF[i]);
		}

		btnRight.setBounds(475, 475, 50, 50);
		btnMiddle.setBounds(400, 475, 50, 50);
		btnLeft.setBounds(325, 475, 50, 50);

		add(btnRight);
		add(btnMiddle);
		add(btnLeft);

		btnLeft.addActionListener(new gameListener());
		btnMiddle.addActionListener(new gameListener());
		btnRight.addActionListener(new gameListener());

	}

	public void addListeners() {
		gameListener listener = new gameListener();
		btnRight.addActionListener(listener);
		btnMiddle.addActionListener(listener);
		btnLeft.addActionListener(listener);
	}

	private class gameListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnRight) {
				toRight();
			}

			if (e.getSource() == btnLeft) {
				toLeft();
			}

			if (e.getSource() == btnMiddle) {
				Middle();
			}
		}
	}

	// OM TRYCK P� V�NSTER S� K�RS HIDDEN LEFT,
	// SEN CHANBE OCH SEN S�TTS TEXT IN
	public void toLeft() {

		HiddenToLeft();
		Change();

		for (int i = 0; i < 7; i++) {

			if (hiddenArray[i][0] == 123) {
				LeftSideTF[i].setText("   ");
			} else {
				LeftSideTF[i].setText("   " + LeftSide[i]);
			}
		}

		for (int i = 0; i < 7; i++) {
			if (hiddenArray[i][8] == 123) {
				RightSideTF[i].setText("   ");
			} else
				RightSideTF[i].setText("   " + tempArray[i]);
		}
	}

	// CENTRERAR
	public void Middle() {

		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 9; y++) {
				hiddenArray[i][y] = CopyOfHiddenArray[i][y];
			}
		}

		for (int i = 0; i < 7; i++) {

			RightSideTF[i].setText("   ");
			LeftSideTF[i].setText("   ");
		}

		reset();
	}

	public void toRight() {

		HiddenToRight();
		Change();

		for (int i = 0; i < 7; i++) {

			if (RightSide[i].equals("123")) {
				RightSideTF[i].setText("   ");

			} else {
				RightSideTF[i].setText("   " + RightSide[i]);

			}
		}

		for (int i = 0; i < 7; i++) {
			if (tempArray[i] == 123) {
				LeftSideTF[i].setText("  ");
			}

			else {
				LeftSideTF[i].setText(String.valueOf(tempArray[i]));
			}
		}

	}

	// �NDRAR P� DEN "HIDDEN" ARRAYEN SOM �R GRUNDEN I ALLT
	// TEMPARRAY �R DEN SOM �R YTTERST TILL V�NSTER OCH DEN GER V�RDEN TILL
	// LEFTSIDE
	public void HiddenToLeft() {
		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 9; y++) {

				if (y == 0) {
					tempArray[i] = hiddenArray[i][0];
				}

				if (y == 8) {

					hiddenArray[i][8] = tempArray[i];
				}

				if (y < 8) {
					hiddenArray[i][y] = hiddenArray[i][y + 1];
				}

			}
		}

		for (int i = 0; i < 7; i++) {
			LeftSide[i] = String.valueOf(hiddenArray[i][0]);
		}

	}

	// TEMPCOPYOF �R EN KOPIA AV HELA HIDDEN SOM D�R �R JUST NU.
	// TEMPARRAY F�R V�RDENA AV HIDDENSARRAYS SISTA OCH SEN F�R VID 8
	// FLYTTAS DESSA V�RDEN IN I HIDDENS F�RSTA

	public void HiddenToRight() {

		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 9; y++) {

				tempCopyOfHiddenArray[i][y] = hiddenArray[i][y];

				if (y == 0) {
					tempArray[i] = hiddenArray[i][8];
				}

				if ((y > 0) & (y < 9)) {
					hiddenArray[i][y] = tempCopyOfHiddenArray[i][y - 1];
				}
				if (y == 8) {
					hiddenArray[i][0] = tempArray[i];
				}
			}
		}

		for (int i = 0; i < 7; i++) {

			RightSide[i] = String.valueOf(hiddenArray[i][8]);

		}
	}

	// �TERST�LLER HIDDENS HARRAY TILL VAD DESS URSPRUNGLIGA V�RDEN �R VIA
	// COPYOFHIDDENARRAY,
	// SEN FIELDS BLIR �TERST�LLDA OCKS� MED TEXT AV URSPRUNGLIGA,
	public void reset() {
		int plus = 0;
		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 7; y++) {
				fields[plus].setText("   " + hiddenArray[i][y + 1]);

				plus++;
			}
		}
		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 7; y++) {
				hiddenArray[i][y] = CopyOfHiddenArray[i][y];
			}
		}

	}

	// CHANGE F�R IN NYA V�RDEN P� HIDDENARRAY OCH FIELDS
	// FIELDS SKRIVER UT DE NYA V�RDENA

	public void Change() {
		int plus = 0;

		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 7; y++) {

				if (hiddenArray[i][y + 1] == 123) {
					fields[plus].setText("   ");
				} else {
					fields[plus].setText("   " + hiddenArray[i][y + 1]);
				}
				plus++;
			}
		}

	}

	public static void main(String[] args) {
		Array7x7 prog = new Array7x7(array7x7);
		prog.test(0);
		JFrame frame = new JFrame("Display");
		frame.setSize(800, 620);
		frame.add(new RorandeDel(prog));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(280, 123);
	}

}

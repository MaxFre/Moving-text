package uppgift4;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ritar upp panel, lägger till knappar och lyssnare, uppdaterar och rensar
 * panel.
 * @author Max Frennessen, Amin Harirchian, Ley Tufva Qlibt, Lykke Levin
 */

public class Viewer extends JPanel {
	private JButton btnClear = new JButton("Rensa");
	protected JButton btnEnter = new JButton("Enter");
	protected JButton btnAmin = new JButton("Amin");
	protected JButton btnLykke = new JButton("Lykke");
	protected JButton btnLey = new JButton("Ley");
	protected JButton btnRandom = new JButton("Random");
	protected JButton btnMax = new JButton("Max");
	protected JButton btnLeftFf = new JButton("<<");
	protected JButton btnLeft = new JButton("<");
	protected JButton btnRight = new JButton(">");
	protected JButton btnRightFf = new JButton(">>");
	protected JTextField tfInput = new JTextField("");

	private ColorDisplay colordisplay;
	private Controller controller;

	/**
	 * Konstruerar och initialiserar ny colordisplay. Lägger till display på
	 * panel.
	 * 
	 * @param verticalPages
	 *            1x7
	 * @param horizontalpages
	 *            5x7
	 * @param background
	 *            färg bakgrund rutor
	 * @param grid
	 *            färg bakgrund panel
	 */
	public Viewer(int verticalPages, int horizontalpages, int background, int grid) {

		ButtonListener btnListener = new ButtonListener();
		colordisplay = new ColorDisplay(1, 5, Color.BLACK, Color.MAGENTA);
		setLayout(new BorderLayout());
		add(colordisplay, BorderLayout.CENTER);
		add(pnlSub(), BorderLayout.SOUTH);
		btnLeft.addActionListener(btnListener);
		btnLeftFf.addActionListener(btnListener);
		btnRight.addActionListener(btnListener);
		btnRightFf.addActionListener(btnListener);
		btnClear.addActionListener(btnListener);
		btnAmin.addActionListener(btnListener);
		btnLykke.addActionListener(btnListener);
		btnLey.addActionListener(btnListener);
		btnMax.addActionListener(btnListener);
		btnEnter.addActionListener(btnListener);

	}

	/**
	 * Skapar en panel och lägger till knappar och textfält.
	 * 
	 * @return panel
	 */
	public JPanel pnlSub() {
		JPanel pnlInputs = new JPanel(new GridLayout(1, 6));
		pnlInputs.add(btnLeftFf);
		pnlInputs.add(btnLeft);
		pnlInputs.add(btnRight);
		pnlInputs.add(btnRightFf);
		pnlInputs.add(btnClear);
		pnlInputs.add(btnAmin);
		pnlInputs.add(btnLykke);
		pnlInputs.add(btnLey);
		pnlInputs.add(btnMax);
		pnlInputs.add(tfInput);
		pnlInputs.add(btnEnter);
		return pnlInputs;
	}

	/**
	 * Upprättar kontakt mellan Viewer och Controller
	 * 
	 * @param controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Uppdaterar displayen i ColorDisplay
	 * 
	 * @param colors
	 */
	public void updateDisplay(int[][] colors, int high, int move) {
		colordisplay.setDisplay(colors, high, move);
		colordisplay.updateDisplay();
	}

	public void updateDisplay() {
		colordisplay.updateDisplay();
	}

	public void clearDisplay() {
		colordisplay.clearDisplay();
	}

	/**
	 * Lyssnar på knappar.
	 *
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String res = tfInput.getText();

			if (e.getSource() == btnAmin) {
				controller.stitchArray("Amin");
			}
			if (e.getSource() == btnLykke) {
				controller.stitchArray("Lykke");
			}
			if (e.getSource() == btnLey) {
				controller.stitchArray("Ley");
			}
			if (e.getSource() == btnMax) {
				controller.stitchArray("Max");
			}
			if (e.getSource() == btnClear) {
				controller.stopArray();
				controller.stopLeftArray();
				clearDisplay();
				controller.backUp = null;
				btnAmin.setEnabled(true);
				btnLykke.setEnabled(true);
				btnLey.setEnabled(true);
				btnMax.setEnabled(true);
				btnEnter.setEnabled(true);
				tfInput.setEnabled(true);
			}
			if (e.getSource() == btnLeftFf) {
				controller.updateLeftArray();
			}
			if (e.getSource() == btnLeft) {
				controller.stopArray();
				controller.stopLeftArray();
				controller.goLeftArray();
			}
			if (e.getSource() == btnRight) {
				controller.stopArray();
				controller.stopLeftArray();
				controller.goArray();
			}
			if (e.getSource() == btnRightFf) {
				controller.updateArray();
			}

			if (e.getSource() == btnEnter) {
				controller.stopArray();
				controller.stopLeftArray();
				controller.stitchArray(res);
				
			}

		}
	}

}

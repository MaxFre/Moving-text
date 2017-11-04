package uppgift4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Max Frennessen, Amin Harirchian, Ley Tufva Qlibt, Lykke Levin
 *
 */
public class ForstaDelen extends JPanel {

	
	private static Char array7x7;
	
	private JLabel rad = new JLabel("Rad");
	private JLabel kolum = new JLabel("Kolum");
	private JLabel[] fields = new JLabel[49];
	private JTextField[] LeftSide = new JTextField[7];
	private JTextField[] Below = new JTextField[7];

	private JButton btnLasRad = new JButton("Läs rad");
	private JButton btnSkrivRad = new JButton("Skriv rad");
	private JButton btnLasKol = new JButton("Läs kol");
	private JButton btnSkrivKol = new JButton("Skriv kol");

	private JTextField RadTextField = new JTextField();
	private JTextField KolTextField = new JTextField();
    private String[] fromArray7x7String = new String[49];
    
    
	public ForstaDelen(Array7x7 prog) {
		int[][] fromArray7x7 = prog.getTest();
		
		
		int n = 0;
		for(int i = 0; i <7; i++){
			for(int y = 0; y <7; y++){
				fromArray7x7String[n] = String.valueOf(fromArray7x7[i][y]);
			n++;
			 }
			}
		setLayout(null);
		setPreferredSize(new Dimension(800, 620));

		int x = 0;
		int y = 0;
		int v = 0;
		int p = 0;
		int q = 0;
		int k = 0;
		int u = 0;

		for (int i = 0; i < fields.length; i++) {

			fields[i] = new JLabel(fromArray7x7String[i]);

			if (i <= 6) {
				fields[i].setBounds(160 + x, 55, 50, 50);
				x += 60;

			} else if ((i > 6) && (i <= 13)) {
				fields[i].setBounds(160 + y, 110, 50, 50);
				y += 60;

			} else if ((i > 13) && (i <= 20)) {
				fields[i].setBounds(160 + v, 170, 50, 50);
				v += 60;

			}

			else if ((i > 20) && (i <= 27)) {
				fields[i].setBounds(160 + p, 230, 50, 50);
				p += 60;
			}

			else if ((i > 27) && (i <= 34)) {
				fields[i].setBounds(160 + q, 290, 50, 50);
				q += 60;
			} else if ((i > 34) && (i <= 41)) {
				fields[i].setBounds(160 + k, 350, 50, 50);
				k += 60;
			} else if ((i > 41) && (i <= 48)) {
				fields[i].setBounds(160 + u, 410, 50, 50);
				u += 60;
			}
			add(fields[i]);

		}

		for (int i = 0; i < Below.length; i++) {

			Below[i] = new JTextField("");

			if (i <= 7) {
				Below[i].setBounds(-260 + x, 500, 50, 50);
				x += 60;

				add(Below[i]);

			}
		}

		for (int i = 0; i < LeftSide.length; i++) {

			LeftSide[i] = new JTextField("");

			if (i <= 7) {
				LeftSide[i].setBounds(25, -782 + x, 50, 50);
				x += 60;

				add(LeftSide[i]);

			}
		}

		kolum.setBounds(30, 20, 150, 50);
		rad.setBounds(580, 500, 150, 50);

		btnLasRad.setBounds(650, 50, 150, 50);
		btnSkrivRad.setBounds(650, 110, 150, 50);
		RadTextField.setBounds(650, 170, 150, 50);

		btnLasKol.setBounds(650, 230, 150, 50);
		btnSkrivKol.setBounds(650, 290, 150, 50);
		KolTextField.setBounds(650, 350, 150, 50);

		add(kolum);
		add(rad);
		add(btnLasRad);
		add(btnSkrivRad);
		add(btnLasKol);
		add(btnSkrivKol);
		add(KolTextField);
		add(RadTextField);

		btnLasRad.addActionListener(new gameListener());
		btnSkrivRad.addActionListener(new gameListener());
		btnLasKol.addActionListener(new gameListener());
		btnSkrivKol.addActionListener(new gameListener());

	}

	public void addListeners() {
		gameListener listener = new gameListener();
		btnLasRad.addActionListener(listener);
		btnSkrivRad.addActionListener(listener);
		btnLasKol.addActionListener(listener);
		btnSkrivKol.addActionListener(listener);
	}

	private class gameListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnLasRad) {
				String res = RadTextField.getText();

				if (res.equals("1")) {

					for (int i = 0; i < Below.length; i++) {
						String temp = fields[i].getText();
						Below[i].setText(temp);
					}
				}

				if (res.equals("2")) {

					for (int i = 0; i < Below.length; i++) {
						String temp = fields[i + 7].getText();
						Below[i].setText(temp);
					}
				}

				if (res.equals("3")) {

					for (int i = 0; i < Below.length; i++) {
						String temp = fields[i + 14].getText();
						Below[i].setText(temp);
					}
				}

				if (res.equals("4")) {

					for (int i = 0; i < Below.length; i++) {
						String temp = fields[i + 21].getText();
						Below[i].setText(temp);
					}
				}

				if (res.equals("5")) {

					for (int i = 0; i < Below.length; i++) {
						String temp = fields[i + 28].getText();
						Below[i].setText(temp);
					}
				}

				if (res.equals("6")) {

					for (int i = 0; i < Below.length; i++) {
						String temp = fields[i + 35].getText();
						Below[i].setText(temp);
					}
				}

				if (res.equals("7")) {

					for (int i = 0; i < Below.length; i++) {
						String temp = fields[i + 42].getText();
						Below[i].setText(temp);
					}
				}

			}

			if (e.getSource() == btnSkrivRad) {

				String res = RadTextField.getText();

				if (res.equals("1")) {

					for (int i = 0; i < 7; i++) {
						String temp = Below[i].getText();
						fields[i].setText(temp);
					}

				}

				if (res.equals("2")) {

					for (int i = 0; i < 7; i++) {
						String temp = Below[i].getText();
						fields[i + 7].setText(temp);
					}

				}

				if (res.equals("3")) {

					for (int i = 0; i < 7; i++) {
						String temp = Below[i].getText();
						fields[i + 14].setText(temp);
					}

				}

				if (res.equals("4")) {

					for (int i = 0; i < 7; i++) {
						String temp = Below[i].getText();
						fields[i + 21].setText(temp);
					}

				}

				if (res.equals("5")) {

					for (int i = 0; i < 7; i++) {
						String temp = Below[i].getText();
						fields[i + 28].setText(temp);
					}

				}

				if (res.equals("6")) {

					for (int i = 0; i < 7; i++) {
						String temp = Below[i].getText();
						fields[i + 35].setText(temp);
					}

				}

				if (res.equals("7")) {

					for (int i = 0; i < 7; i++) {
						String temp = Below[i].getText();
						fields[i + 42].setText(temp);
					}

				}

			}

			if (e.getSource() == btnLasKol) {

				String res = KolTextField.getText();

				if (res.equals("1")) {
					for (int i = 0; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = fields[i].getText();
							LeftSide[y].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("2")) {
					for (int i = 1; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = fields[i].getText();
							LeftSide[y].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("3")) {
					for (int i = 2; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = fields[i].getText();
							LeftSide[y].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("4")) {
					for (int i = 3; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = fields[i].getText();
							LeftSide[y].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("5")) {
					for (int i = 4; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = fields[i].getText();
							LeftSide[y].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("6")) {
					for (int i = 5; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = fields[i].getText();
							LeftSide[y].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("7")) {
					for (int i = 6; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = fields[i].getText();
							LeftSide[y].setText(temp);
							i = i + 7;
						}
					}
				}
			}

			if (e.getSource() == btnSkrivKol) {
				String res = KolTextField.getText();

				if (res.equals("1")) {
					for (int i = 0; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = LeftSide[y].getText();
							fields[i].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("2")) {
					for (int i = 1; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = LeftSide[y].getText();
							fields[i].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("3")) {
					for (int i = 2; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = LeftSide[y].getText();
							fields[i].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("4")) {
					for (int i = 3; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = LeftSide[y].getText();
							fields[i].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("5")) {
					for (int i = 4; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = LeftSide[y].getText();
							fields[i].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("6")) {
					for (int i = 5; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = LeftSide[y].getText();
							fields[i].setText(temp);
							i = i + 7;
						}
					}
				}

				if (res.equals("7")) {
					for (int i = 6; i < 49; i++) {
						for (int y = 0; y < 7; y++) {
							String temp = LeftSide[y].getText();
							fields[i].setText(temp);
							i = i + 7;
						}
					}
				}

			}

		}
	}

	public static void main(String[] args) {
		Array7x7 prog = new Array7x7(array7x7);
        prog.test(0);
		JFrame frame = new JFrame("Display");
		frame.setSize(800, 620);
		frame.add(new ForstaDelen(prog));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(280, 123);

	}
}

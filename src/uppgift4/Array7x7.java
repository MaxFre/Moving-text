package uppgift4;

/**
 * 
 * @author Max Frennessen, Amin Harirchian, Ley Tufva Qlibt, Lykke Levin
 *
 */
public class Array7x7 {

	private Char tecken;

	private Array7 oneLiner;

	private int[] kolumn = new int[7], rad = new int[7];
	private int[][] aCopy = new int[7][7];
	private int row, col;
	private int[][] text = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 5, 5, 5, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 3, 4, 5, 6, 7 } };

	// Tar emot bokstavsarrayen och kopiera, mäter och skapar arrayer av
	// lämpligt format
	public Array7x7(int[][] res) {
		setSign(res);

	}

	public Array7x7(Char array7x7) {
		this.tecken = array7x7;
	}

	public void setSign(int[][] res) {
		for (int a = 0; a < 7; a++) {
			for (int m = 0; m < 7; m++) {
				text[a][m] = res[a][m];
			}
		}
	}

	public int[][] getSign() {
		for (int a = 0; a < 7; a++) {
			for (int m = 0; m < 7; m++) {
				aCopy[a][m] = text[a][m];
			}
		}
		return aCopy;
	}

	public void setColumn(int col) {
		this.col = col;
	}

	public void setColumn(Array7 oneLiner, int col) {
		this.oneLiner = oneLiner;
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setRow(Array7 oneLiner, int row) {
		this.oneLiner = oneLiner;
		this.row = row;
	}

	public void changeColumn() {
		kolumn = oneLiner.getColumn();
		for (int n = 0; n < 7; n++) {
			text[n][col] = kolumn[n];
		}
	}

	public void changeRow() {
		kolumn = oneLiner.getRow();
		for (int n = 0; n < 7; n++) {
			text[row][n] = rad[n];
		}
	}

	public int[] getColumn(int col) {
		for (int n = 0; n < 7; n++) {
			kolumn[n] = text[n][col];
		}
		return kolumn;
	}

	public int[] getRow(int row) {
		for (int n = 0; n < 7; n++) {
			rad[n] = text[row][n];
		}
		return rad;
	}

	public void moveColR() {
		getSign();
		for (int a = 0; a < 7; a++) {
			for (int m = 0; m < 6; m++) {
				text[a][m + 1] = aCopy[a][m];
			}
		}
	}

	public void moveRowU() {
		getSign();
		for (int a = 1; a < 7; a++) {
			for (int m = 0; m < 7; m++) {
				text[a][m - 1] = aCopy[a][m];
			}
		}

	}

	public void moveRowD() {
		getSign();
		for (int a = 0; a < 6; a++) {
			for (int m = 0; m < 7; m++) {
				text[a][m + 1] = aCopy[a][m];
			}
		}
	}

	public void moveColL() {
		getSign();
		for (int a = 0; a < 7; a++) {
			for (int m = 1; m < 7; m++) {
				text[a][m - 1] = aCopy[a][m];
			}
		}
	}
	
	// Skiftar arrayen en kolumn åt höger
	public void moveSignR() {
		moveColR();
		changeColumn();
	}

	public void moveSignL() {
		moveColL();
		changeColumn();

	}

	// Skiftar arrayen en kolumn åt höger
	public void moveSignU() {
		moveRowU();
		changeRow();
	}

	public void moveSignD() {
		moveRowD();
		changeRow();
	}

	public void setElement(int row, int col, int value) {

		text[row][col] = value;
	}

	public int getElement(int row, int pos) {

		System.out.println("Den du ville se var: " + text[row][pos]);
		System.out.println("arrayn ser i helhet s�h�r: ");
		for (int i = 0; i < 7; i++) {
			for (int y = 0; y < 7; y++) {
				System.out.print(text[i][y] + "  ");
				if (y == 6) {
					System.out.println("");
				}
			}
		}
		return row;
	}

	public void test(int value) {

	}

	public void setTest(int[][] test) {
		this.text = test;
	}

	public int[][] getTest() {
		return this.text;
	}

	public static void main(String[] args) {
		Char tecken = new Char();
		Array7x7 prog = new Array7x7(tecken);
		prog.test(1);

	}

}

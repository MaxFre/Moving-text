package uppgift4;

/**
 * 
 * @author Max Frennessen, Amin Harirchian, Ley Tufva Qlibt, Lykke Levin
 *
 */

public class Array7 {

	private int[] aCol = new int[7];
	private int[] storedArray = new int[7];

	public Array7(int[] storedArray){
		this.storedArray = storedArray;
		
	}
	public void setColumn(int[] setting){
		for (int n = 0; n < 7; n++){
			storedArray[n] = setting[n];
		}
	}
	public void setRow(int[] setting){
		for (int n = 0; n < 7; n++){
			storedArray[n] = setting[n];
		}
	}
	
	public int[] getColumn(){
		for (int n = 0; n < 7; n++){
			aCol[n] = storedArray[n];
		}
		return aCol;
	}
	public int[] getRow(){
		for (int n = 0; n < 7; n++){
			aCol[n] = storedArray[n];
		}
		return aCol;
	}
	public void setElement(int col, int value){

		storedArray[col] = value;		
	}


	public void getElement(int pos){

		System.out.println("Den du ville se var: " + storedArray[pos]);

		System.out.print("arrayn ser i helhet s�h�r: "); 
		for(int i = 0; i < 7; i++){
			System.out.print(storedArray[i] + "  ");
		}
	}


}

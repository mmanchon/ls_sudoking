import Gui.SudokuGUI;

public class Visualitzacio {
	public void visualitzacio(){}
	
	public void visualitza(int op,String path, Object obj, SudokuGUI interficie){
		switch(op){
		case 0:
			System.out.println("[System] Solucionat");
			break;
		case 1:
			System.out.println("[System] Solucions per linia de comandes\n");
			int[][] matrix = (int[][]) obj;
			for(int f = 0; f<matrix[0].length;f++){
				for(int c = 0;c<matrix[0].length;c++)System.out.print(matrix[f][c]);
				System.out.println();
			}
			System.out.println();
			break;
		case 2: 
			System.out.println("[System] Mostrar solucions per Gui");
			int[][] matrix1 = (int[][]) obj;
			interficie.updateBoard(matrix1);
			break;
		case 3:
			System.out.println("[System] Solucions en fitxer de sortida");
			Fitxers f = new Fitxers();
			int[][] matrix2 = (int[][]) obj;
			int tipus =matrix2[0].length;
			switch (tipus){
			case 9:
				f.write9x9(path, matrix2);
				break;
			case 16:
				f.write16x16(path,matrix2);
				break;
			case 21: 
				break;
				
			}
		}
		
	}
}

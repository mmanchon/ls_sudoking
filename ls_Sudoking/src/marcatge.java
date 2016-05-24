
public class marcatge {
	public marcatge(){}
	//Definim una matriu de boleans per cada  sudoku.

	boolean[][] marcatgef = new boolean[9][9];
	boolean[][] marcatgec = new boolean[9][9];
	boolean[][] marcatgeq = new boolean[9][9];


	public boolean[][] getMarcatgef() {
		return marcatgef;
	}

	public void setMarcatgef(boolean[][] marcatgef) {
		this.marcatgef = marcatgef;
	}

	public boolean[][] getMarcatgec() {
		return marcatgec;
	}

	public void setMarcatgec(boolean[][] marcatgec) {
		this.marcatgec = marcatgec;
	}

	public boolean[][] getMarcatgeq() {
		return marcatgeq;
	}

	public void setMarcatgeq(boolean[][] marcatgeq) {
		this.marcatgeq = marcatgeq;
	}

	// Metode encarregat de  marcar el sudoku de 9x9
	public boolean[][]  marcar9x9(int f, int c,boolean[][] marc){
		marc[f][c] = true;
		return marc;
	}
	
	public int Index(int f, int c){
		int i=0;
		if(f<3){
			if(c<3){i=0;}
			if(c>=3 && c<6){ i=1;}
			if(c>5){i=2;}
		}
		
		if(f>=3&&f<6){
			if(c<3){i=3;}
			if(c>=3 && c<6){i=4;}
			if(c>5){i=5;}
		}
		if(f>5){
			if(c<3){i=6;}
			if(c>=3 && c<6){i=7;}
			if(c>5){i=8;}
		}
		return i;
	}
	
	//Marquem el quadrant
	public boolean[][] marcar9x9q(int num, int f,int c, boolean[][] marc){
		int i=0;
		i=Index(f,c);
		marc[i][num]=true;
		return marc;
	}
	
	public boolean[][] desmarcar9x9q(int num, int f,int c, boolean[][] marc){
		int i=0;
		i=Index(f,c);
		marc[i][num]=false;
		return marc;
	}
	
	
	//Metode encarregat de desmarcar el sudoku de 9x9.
	public boolean[][]  desmarcar9x9(int f, int c,boolean[][] marc){
		marc[f][c] = false;
		return marc;
	}
	// Metode encarregat de  marcar el sudoku de 16x16
	public boolean[][]  marcar16x16(int f, int c,boolean[][] marc){
		marc[f][c]=true;
		return marc;
	}
	
	public int Index16x16(int f, int c){
		int i=0;
		if(f<4){
			if(c<4){i=0;}
			if(c>3&&c<8){i=1;}
			if(c>7&&c<12){i=2;}
			if(c>11){i=3;}
		}
		
		if(f>3&&f<8){
			if(c<4){i=4;}
			if(c>3&&c<8){i=5;}
			if(c>7&&c<12){i=6;}
			if(c>11){i=7;}
		}
		
		if(f>7&&f<12){
			if(c<4){i=8;}
			if(c>3&&c<8){i=9;}
			if(c>7&&c<12){i=10;}
			if(c>11){i=11;}
		}
		
		if(f>11){
			if(c<4){i=12;}
			if(c>3&&c<8){i=13;}
			if(c>7&&c<12){i=14;}
			if(c>11){i=15;}
		}
		return i;
	}
	
	public boolean[][] marcar16x16q(int num, int f,int c, boolean[][] marc){
		int i=0;
		i=Index16x16(f,c);
		marc[i][num]=true;
		return marc;
	}
	//Metode encarregat de desmarcar el sudoku de 16x16.
	public boolean[][]  desmarcar16x16(int f, int c,boolean[][] marc){
		marc[f][c]=false;
		return marc;
	}
	
	public boolean[][] desmarcar16x16q(int num, int f, int c, boolean[][] marc){
		int i=0;
		i=Index16x16(f,c);
		marc[i][num]=false;
		return marc;
	}
	
	public boolean getBoolean(int f, int c, boolean[][] marc){
		return marc[f][c];
	}
}

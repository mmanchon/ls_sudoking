
public class marcatgeSamu {
	
	private int[][] marcatgef = new int[9][9];
	private int[][] marcatgec = new int[9][9];
	private int[][] marcatgeq = new int[9][9];
	
	public marcatgeSamu(){}
	
	public void setMarcatge(int[][] marcatgef, int[][] marcatgec, int[][] marcatgeq){
		this.marcatgec = marcatgec;
		this.marcatgef = marcatgef;
		this.marcatgeq = marcatgeq;
	}
	
	public int[][] getMarcatgef() {
		return marcatgef;
	}
	
	public void setMarcatgef(int[][] marcatgef) {
		this.marcatgef = marcatgef;
	}
	
	public int[][] getMarcatgec() {
		return marcatgec;
	}
	
	public void setMarcatgec(int[][] marcatgec) {
		this.marcatgec = marcatgec;
	}
	
	public int[][] getMarcatgeq() {
		return marcatgeq;
	}
	
	public void setMarcatgeq(int[][] marcatgeq) {
		this.marcatgeq = marcatgeq;
	}
	
	public int[][] marcarSamu(int f, int c, int[][] marc){
		marc[f][c]++;
		return marc;
	}
	
	public int[][] desmarcarSamu(int f, int c, int[][] marc){
		marc[f][c]--;
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
	
	public int[][] marcarQuadrantSamu(int num, int f, int c, int[][] marc){
		int i = 0;
		i=Index(f,c);
		marc[i][num]++;
		return marc;
	}
	
	public int[][] desmarcarQuadrantSamu(int num, int f, int c, int[][] marc){
		int i =0;
		i=Index(f,c);
		marc[i][num]--;
		return marc;
	}

}

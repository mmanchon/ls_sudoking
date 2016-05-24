
public class matrius {
	private int[][] matriu =  new int[9][9];
	private boolean[][] esc = new boolean[9][9];
	
	public matrius(){}
	
	public int[][] getMatriu() {
		return matriu;
	}
	public void setMatriu(int[][] matriu) {
		//this.matriu = matriu;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				this.matriu[i][j] = matriu[i][j];
			//	System.out.print(matriu[i][j]);
			}
		//	System.out.println();
		}
	//	System.out.println();
	}
	
	public boolean[][] getEsc() {
		return esc;
	}
	
	public void setEsc(boolean[][] esc) {
		this.esc = esc;
	}
	
	public void omple(int[][] x){
		for(int i=0; i<9; i++){
			for(int j=0; j<9;  j++){
				if(x[i][j]== 0){
					this.esc[i][j]=false;
				}else{
					this.esc[i][j]=true;
				}
				//System.out.println(esc[i][j]);
			}
			//System.out.println();
		}
		//System.out.println();
	}
	
	public int getNum(int f, int c, int[][] x){
		//System.out.println(x[f][c]);
		return x[f][c];
	}
	
}

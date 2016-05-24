import java.io.IOException;
import java.util.Scanner;

public class main {
	int[][] aux = new int[9][9];
	boolean[][] cTaulell = new boolean [9][9];
	long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución

	public long getTInicio() {
		return TInicio;
	}

	public void setTInicio(long tInicio) {
		TInicio = tInicio;
	}

	public long getTFin() {
		return TFin;
	}

	public void setTFin(long tFin) {
		TFin = tFin;
	}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public main(){}

	public int[][] getAux() {
		return aux;
	}
	public void setAux(int[][] aux) {
		this.aux = aux;
	}

	public boolean[][] getcTaulell() {
		return cTaulell;
	}

	public void setcTaulell(boolean[][] cTaulell) {
		this.cTaulell = cTaulell;
	}


	public static void main(String[] args) throws IOException{
	
		Fitxers f = new Fitxers();
		System.out.println("[System]-->Args: "+args[0]+ " "+args[1]+" "+args[2]);
		int op = f.comprovacioFitxerUser(args[0]);
		
		Execucio exec = new Execucio();
		exec.operation(op, args[0], args[2]);
	}	

}

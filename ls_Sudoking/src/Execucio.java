import java.io.IOException;
import java.util.Scanner;

public class Execucio {
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

	public Execucio(){}

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


	public void operation(int opcio, String pathInput,int mode, String pathOutput) throws IOException{

		int f;
		int c;
		int indexc = 0, indexf = 0;
		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		String s_file = null;
		Execucio m= new Execucio();
		marcatge marc=new marcatge();

		Fitxers fi= new Fitxers();

		//Iniciamos el tiempo
		m.setTInicio(System.currentTimeMillis());

		switch(opcio){
		case 1:
			boolean[][] cT = new boolean [9][9];
			int[][] aux_a=new int[9][9];
			int[][] x = new int[9][9];
			int[][] solucio = new int[9][9];

			boolean[][] marcatgef = new boolean[9][9];
			boolean[][] marcatgec = new boolean[9][9];
			boolean[][] marcatgeq = new boolean[9][9];

			s_file = fi.read9x9(pathInput);
			char[] file = s_file.toCharArray();
			//comprovem que el mapa del sudoku s'hagi introduit correctament

			Func_Auxiliar fa=new Func_Auxiliar();
			m.setAux(fa.conversio9x9(file));
			aux_a = m.getAux();
			indexf=0;
			while(indexf<9){
				indexc=0;
				while(indexc<9){
					if(aux_a[indexf][indexc]==0){
						cT[indexf][indexc]= true;
					}else{
						marcatgef=marc.marcar9x9(indexf,aux_a[indexf][indexc]-1,marcatgef);
						marcatgec=marc.marcar9x9(aux_a[indexf][indexc]-1, indexc, marcatgec);
						marcatgeq=marc.marcar9x9q(aux_a[indexf][indexc]-1,indexf,indexc,marcatgeq);
						cT[indexf][indexc]= false;
					}
					indexc++;
				}
				indexf++;
			}
			m.setcTaulell(cT);
			sudoku9x9 s=new sudoku9x9(m.getcTaulell(),mode);

			aux_a=m.getAux();
			indexf = 0;
			indexc = 0;
			while(indexf<9){
				indexc=0;
				while(indexc<9){
					x[indexf][indexc] = aux_a[indexf][indexc];
					indexc++;
				}
				indexf++;
			}


			solucio = s.sudoku9x9(0,0,x,m.getAux(),marcatgef,marcatgec,marcatgeq,mode,pathOutput);

			break;
		case 2:
			boolean[][] c_t2 = new boolean [16][16];
			int[][] aux_a2=new int[16][16];
			int[][] x2 = new int[16][16];
			int[][] solucio2 = new int[16][16];
			boolean[][] marcf = new boolean[16][16];
			boolean[][] marcc = new boolean[16][16];
			boolean[][] marcq = new boolean[16][16];

			Execucio m2 = new Execucio();
			Fitxers fi2= new Fitxers();
			String resposta = null;
			int[] file2=new int[256];
			int c2=0, f2=0;
			resposta = fi2.read16x16(pathInput);
			int j=0;
			String[] cadena = resposta.split(" ");

			while(j<cadena.length-1){
				cadena[j]=cadena[j+1];
				j++;
			}

			for(int i=0; i<256; i++){
				if("-".equals(cadena[i])){
					file2[i]=0;
				}else{
					file2[i]=Integer.parseInt(cadena[i]);
				}

			}
			Func_Auxiliar fa2=new Func_Auxiliar();
			m2.setAux(fa2.conversio16x16(file2));

			aux_a2=m2.getAux();
			indexf = 0;
			while(indexf<16){
				indexc=0;
				while(indexc<16){
					x2[indexf][indexc] = aux_a2[indexf][indexc];
					indexc++;
				}
				indexf++;
			}
			indexf=0;
			while(indexf<16){
				indexc=0;
				while(indexc<16){
					if(aux_a2[indexf][indexc]==0){
						c_t2[indexf][indexc]= true;
					}else{
						marcatgef=marc.marcar16x16(indexf,aux_a2[indexf][indexc]-1,marcf);
						marcatgec=marc.marcar16x16(aux_a2[indexf][indexc]-1, indexc, marcc);
						marcatgeq=marc.marcar16x16q(aux_a2[indexf][indexc]-1,indexf,indexc,marcq);
						c_t2[indexf][indexc]= false;
					}

					indexc++;
				}
				indexf++;
			}
			m2.setcTaulell(c_t2);
			sudoku16x16 s2=new sudoku16x16(m2.getcTaulell(), mode);
			solucio2 = s2.sudoku16x16(0,0,x2,m2.getAux(),marcf,marcc,marcq,mode,pathOutput);
			break;

		case 3:
			boolean[][] c_t3 = new boolean [21][21];
			int[][] aux_a3=new int[21][21];
			int[][] x3 = new int[21][21];
			int[][] solucio3 = new int[21][21];
			Execucio m3 = new Execucio();
			Fitxers fi3= new Fitxers();
			String resposta3 = null;
			int[] file3=new int[441];
			int c3=0, f3=0;
			resposta = fi3.readsamurai(pathInput);
			int k=0;
			String[] cadenas = resposta.split(" ");

			while(k<cadenas.length-1){
				cadenas[k]=cadenas[k+1];
				k++;
			}

			for(int i=0;i<441;i++){
				if("-".equals(cadenas[i])){
					file3[i]=0;
				}else{
					if("*".equals(cadenas[i])){
						file3[i]=10;
					}else{
						file3[i]=Integer.parseInt(cadenas[i]);
					}
				}
			}

			Func_Auxiliar fa3=new Func_Auxiliar();
			m3.setAux(fa3.conversiosam(file3));
			aux_a3=m3.getAux();
			indexf=0;

			while(indexf<21){
				indexc=0;
				while(indexc<21){
					if(aux_a3[indexf][indexc]==0){
						c_t3[indexf][indexc]= true;
					}else{
						c_t3[indexf][indexc]= false;
					}
					indexc++;
				}
				indexf++;
			}
			m3.setcTaulell(c_t3);


			Samurai sam = new Samurai(m3.getcTaulell());
			indexf=0;
			while(indexf<21){
				indexc=0;
				while(indexc<21){
					x3[indexf][indexc] = aux_a3[indexf][indexc];
					indexc++;
				}
				indexf++;
			}

			solucio3 = sam.resoldre(x3);
		}

	}	

}

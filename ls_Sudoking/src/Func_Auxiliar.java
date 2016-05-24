import java.nio.channels.CancelledKeyException;

public class Func_Auxiliar {

	public Func_Auxiliar(){}

	public int[][] conversio9x9(char[] cad){
		int[][] x = new int [9][9];
		int c = 0;
		int f = 0;
		int i_c = 0;
		int i_cf=0;
		char[] cad_f = new char[89];
		while(i_c<cad.length){
			if(cad[i_c]==' '){
				i_c++;
			}else{
				cad_f[i_cf]=cad[i_c];
				i_cf++;
				i_c++;
			}
		}
		i_c = 0;
		while(i_c<=88){	
			c= 0;
			while(i_c<=88){
				if(!(cad_f[i_c]=='\n')){
					if(cad_f[i_c]=='-'){
						x[f][c]=0;
						i_c++;
						c++;
					}else{
						x[f][c]=Character.getNumericValue(cad_f[i_c]);
						i_c++;
						c++;
					}
				}else{
					break;
				}
			}
			f++;
			i_c++;
		}

		return x;
	}

	public int[][] conversio16x16(int[] cad){
		int[][] x = new int [16][16];
		int c = 0;
		int f = 0;
		int i_c = 0;
		for(f=0;f<16;f++){
			for(c=0;c<16;c++){
				x[f][c] = cad[i_c];
				i_c++;
			}
		}


		return x;
	}

	public int[][] conversiosam(int[] cad){
		int[][] x = new int [21][21];
		int c = 0;
		int f = 0;
		int i_c = 0;
		for(f=0;f<21;f++){
			for(c=0;c<21;c++){
				x[f][c] = cad[i_c];
				//System.out.print(x[f][c]+" ");
				i_c++;
			}
			//System.out.println();
		}


		return x;
	}


	public boolean bona(int f,int c,int x[][],boolean[][] marcf,boolean[][] marcc,boolean[][] marcq){
		boolean ok;
		int i_f=0;
		int i_c=0;
		int i=1,num=0,j=0;

		ok = true;
		if(i==0){
			//primer mirem la columna i que en tota ella no estigui el nombre
			for(i_f =0; i_f<9;i_f++){
				if(x[i_f][c] == x[f][c] && i_f!= f){
					return ok=false;
				}
			}
			i_f=0;
			//Ara mirem la fila i que el nombre no es repeteixi en la fila
			for(i_c =0; i_c<9;i_c++){
				if(x[f][i_c] == x[f][c] && i_c!= c){
					return ok=false;
				}
			}
			i_c=0;
			//Ara comprovem que no estigui en el quadrant
			//Primer ho comprovem si esta en un cuadrant pertenyent a les tres primeres files
			if(f<3){
				for(i_f=0;i_f<3;i_f++){
					if(c<3){

						for(i_c=0;i_c<3;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=3&&c<6){

						for(i_c=3;i_c<6;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=6){

						for(i_c=6;i_c<9;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
				}
			}
			//les files del mig
			if(f>=3&&f<6){
				for(i_f=3;i_f<6;i_f++){
					if(c<3){

						for(i_c=0;i_c<3;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=3&&c<6){

						for(i_c=3;i_c<6;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=6){

						for(i_c=6;i_c<9;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
				}
			}
			//les ultimes 3 files
			if(f>=6){
				for(i_f=6;i_f<9;i_f++){
					if(c<3){

						for(i_c=0;i_c<3;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=3&&c<6){

						for(i_c=3;i_c<6;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=6){

						for(i_c=6;i_c<9;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
				}
			}
		}else{
			num=x[f][c];
			if(marcf[f][num-1]==true){ok=false;}
			if(marcc[num-1][c]==true){ok=false;}
			j=Index(f,c);
			if(marcq[j][num-1]==true){ok=false;}

		}

		return ok;
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

	public boolean bona16(int f,int c,int x[][],boolean[][] marcf,boolean[][] marcc,boolean[][] marcq){
		boolean ok;
		int i_f=0;
		int i_c=0;
		int ferMarc=1,j=0,num=0;
		ok = true;

		if(ferMarc==0){
			//primer mirem la columna i que en tota ella no estigui el nombre
			for(i_f =0; i_f<16;i_f++){
				if(x[i_f][c] == x[f][c] && i_f!= f){
					return ok=false;
				}
			}
			i_f=0;
			//Ara mirem la fila i que el nombre no es repeteixi en la fila
			for(i_c =0; i_c<16;i_c++){
				if(x[f][i_c] == x[f][c] && i_c!= c){
					return ok=false;
				}
			}
			i_c=0;
			//Ara comprovem que no estigui en el quadrant
			//Primer ho comprovem si esta en un cuadrant pertenyent a les tres primeres files
			if(f<4){
				for(i_f=0;i_f<4;i_f++){
					if(c<4){

						for(i_c=0;i_c<4;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=4&&c<8){

						for(i_c=4;i_c<8;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=8 && c<12){

						for(i_c=8;i_c<12;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
					if(c>=12 && c<16){
						for(i_c=12;i_c<16;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
				}
			}
			//la 2n fila
			if(f>=4 && f<8){
				for(i_f=4;i_f<8;i_f++){
					if(c<4){

						for(i_c=0;i_c<4;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=4&&c<8){

						for(i_c=4;i_c<8;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=8 && c<12){

						for(i_c=8;i_c<12;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
					if(c>=12 && c<16){
						for(i_c=12;i_c<16;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
				}
			}
			//la3r fila
			if(f>=8&&f<12){
				for(i_f=8;i_f<12;i_f++){
					if(c<4){

						for(i_c=0;i_c<4;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=4&&c<8){

						for(i_c=4;i_c<8;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=8 && c<12){

						for(i_c=8;i_c<12;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
					if(c>=12 && c<16){
						for(i_c=12;i_c<16;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
				}
			}
			//la ultima fila
			if(f>=12&&f<16){
				for(i_f=12;i_f<16;i_f++){
					if(c<4){

						for(i_c=0;i_c<4;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=4&&c<8){

						for(i_c=4;i_c<8;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}

					}
					if(c>=8 && c<12){

						for(i_c=8;i_c<12;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
					if(c>=12 && c<16){
						for(i_c=12;i_c<16;i_c++){
							if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
								return ok=false;
							}
						}
					}
				}
			}
		}else{
			num=x[f][c];
			if(marcf[f][num-1]==true){ok=false;}
			if(marcc[num-1][c]==true){ok=false;}
			j=Index16x16(f,c);
			if(marcq[j][num-1]==true){ok=false;}
		}
		return ok;
	}

	public boolean HiHaSuccessor(int f,int c,int x[][], int[][] aux){
		boolean ok;
		//Si contemplem que sigui mes gran a 0 limitem a que  sigui un numero i ignori el caracter '-'

		if(aux[f][c]>0 && aux[f][c]<=9 ){
			return ok=false;
		}
		if(x[f][c]<=9 && aux[f][c]== 0){
			return ok=true;
		}
		return false;
	}

	public boolean HiHaSuc(int f,int c,int x[][], int[][] aux){
		boolean ok;
		//Si contemplem que sigui mes gran a 0 limitem a que  sigui un numero i ignori el caracter '-'

		if(aux[f][c]>0 && aux[f][c]<=16 ){
			return ok=false;
		}
		if(x[f][c]<=16 && aux[f][c]== 0){
			return ok=true;
		}
		return false;
	}


	public boolean SeguentGermaF(int f){
		boolean ok;
		if(f<9){
			return ok=true;
		}else{
			return ok=false;
		}
	}
	public boolean SeguentGermaC(int c){
		boolean ok;
		if(c<9){
			return ok=true;
		}else{
			return ok=false;
		}
	}

	public boolean Solucio(int f,int c, int x[][]){
		boolean ok;
		ok=true;
		return ok;
	}

	public boolean FiSudoku(int f, int c){
		return (f==9 && c==9);
	}
}

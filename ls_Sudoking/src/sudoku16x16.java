import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import Gui.SudokuGUI;

public class sudoku16x16 {
	public sudoku16x16(){}
	private SudokuGUI interficie;
	public sudoku16x16(boolean[][] t){
		interficie = new SudokuGUI("Sudoku",800,900,t);
	}
	
	public int[][] sudoku16x16(int f, int c,int[][] x ,int[][] aux,boolean[][] marcf, boolean[][] marcc,boolean[][] marcq) throws IOException{
		boolean[][] marcatge= new boolean[16][16];//Matriu encarregada de  emmagatzemar el recorregut per el que el programa  ha passat.
	
		int indexc=0, indexf=0;
		boolean bona= true;
		main m = new main();
		marcatge marc = new marcatge();//Demanem memoria per l'objecte amb els metodes necessaris per aplicar marcatge
		Func_Auxiliar fa = new Func_Auxiliar();
		if(c<16 && f<16){
		//comprovem que podem escriure en la posicio en la que estem
			if(fa.HiHaSuc(f, c, x,aux)){
				
				//possem el valor a 0
				x[f][c]=0;
				//mirem que hi hagi "germans"(mes valors)
				while (x[f][c]<16){
					
					//incrementem el valor
					if(x[f][c]<16){
						x[f][c]++;
					}
										
					//tindrem 2 grans ifs, el primer si no estam a la ultima fila ni a la ultima columna
					if(c<15){//recordem que va de 0 a 8
						if(bona = fa.bona16(f, c, x,marcf,marcc,marcq)){
							marcf=marc.marcar16x16(f, x[f][c]-1, marcf);
							marcc=marc.marcar16x16(x[f][c]-1, c, marcc);
							marcq=marc.marcar16x16q(x[f][c]-1,f,c,marcq);
							c++;
							x=sudoku16x16(f, c, x,aux,marcf,marcc,marcq);
							c--;
							marcf=marc.desmarcar16x16(f, x[f][c]-1, marcf);
							marcc=marc.desmarcar16x16(x[f][c]-1, c, marcc);
							marcq=marc.desmarcar16x16q(x[f][c]-1,f,c,marcq);
						}
					}
					
					//Si estem a la ultima columna
					if(c==15&&f!=15){
						if(fa.bona16(f, c, x,marcf,marcc,marcq)){
							marcf=marc.marcar16x16(f, x[f][c]-1, marcf);
							marcc=marc.marcar16x16(x[f][c]-1, c, marcc);
							marcq=marc.marcar16x16q(x[f][c]-1,f,c,marcq);
							f++;
							c=0;
							x=sudoku16x16(f, c, x,aux,marcf,marcc,marcq);
							f--;
							c=15;
							marcf=marc.desmarcar16x16(f, x[f][c]-1, marcf);
							marcc=marc.desmarcar16x16(x[f][c]-1, c, marcc);
							marcq=marc.desmarcar16x16q(x[f][c]-1,f,c,marcq);
						}
					}
					
					if(c==15 && f==15){
						if(fa.bona16(f, c, x,marcf,marcc,marcq)){
							m.setTFin(0);
							m.setTFin(System.currentTimeMillis());
							String ruta = "Solucio_16x16.txt";
							File archivo = new File(ruta);
							marcf=marc.marcar16x16(f, x[f][c]-1, marcf);
							marcc=marc.marcar16x16(x[f][c]-1, c, marcc);
							marcq=marc.marcar16x16q(x[f][c]-1,f,c,marcq);
							BufferedWriter bw;
							int af=0;
							int ac=0;
							char ch;
							// El fichero ya existe
							bw = new BufferedWriter(new FileWriter(archivo));
							if(archivo.exists()) {
							      // El fichero ya existe
							      bw = new BufferedWriter(new FileWriter(archivo));
							      String auxX;
							      while(af<16){
							    	  auxX= new String(Arrays.toString(x[af]));
							    	  char[] auxXX =  auxX.toCharArray();
							    	  ac=0;
							    	  while(ac<auxXX.length){
							    		  bw.write(auxXX[ac]);
							    		  ac++;	
							    	  }
							    	  bw.write("\n");
							    	  af++;
							      }
							}
							
							
							m.setTiempo(m.getTFin()-m.getTInicio()); //Calculamos los milisegundos de diferencia
							float sec = m.getTiempo()/1000;
							System.out.println("Temps d'execució " +sec+ " seconds" ); 
							System.out.println();
							bw.write("Temps d'execució " +sec+ " seconds" );
							bw.close();
							interficie.updateBoard(x);
							//System.out.println("Arribo");
							try {
								Thread.sleep(20000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				x[f][c]=0;
				
			}else{
				if(c==15){
					f++;
					c=0;
					x=sudoku16x16(f,c,x,aux,marcf,marcc,marcq);
					f--;
					c=15;
				}else{
					c++;
					x=sudoku16x16(f, c,x,aux,marcf,marcc,marcq);
					c--;
				}
				if(c==15 && f==15){
					if(fa.bona16(f, c, x,marcf,marcc,marcq)){
						m.setTFin(System.currentTimeMillis());
						String ruta = "Solucio_16x16.txt";
						File archivo = new File(ruta);
						BufferedWriter bw;
						marcf=marc.marcar16x16(f, x[f][c]-1, marcf);
						marcc=marc.marcar16x16(x[f][c]-1, c, marcc);
						marcq=marc.marcar16x16q(x[f][c]-1,f,c,marcq);
						int af=0;
						int ac=0;
						char ch;
						// El fichero ya existe
						bw = new BufferedWriter(new FileWriter(archivo));
					    if(archivo.exists()) {
						      // El fichero ya existe
						      bw = new BufferedWriter(new FileWriter(archivo));
						      String auxX;
						      while(af<16){
						    	  auxX= new String(Arrays.toString(x[af]));
						    	  char[] auxXX =  auxX.toCharArray();
						    	  ac=0;
						    	  while(ac<auxXX.length){
						    		  bw.write(auxXX[ac]);
						    		  ac++;	
						    	  }
						    	  bw.write("\n");
						    	  af++;
						      }
						}
						
						m.setTiempo(m.getTFin()-m.getTInicio()); //Calculamos los milisegundos de diferencia
						float sec = m.getTiempo()/1000;
						System.out.println("Temps d'execució " +sec+ " seconds" ); 
						System.out.println();
						bw.write("Temps d'execució " +sec+ " seconds" );
						bw.close();
						interficie.updateBoard(x);
						
						try {
							Thread.sleep(20000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
	}
	return x;
	}
}

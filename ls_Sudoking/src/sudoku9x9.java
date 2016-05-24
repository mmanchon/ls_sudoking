import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Gui.SudokuGUI;

public class sudoku9x9 {
	public sudoku9x9(){}
	private SudokuGUI interficie;
	public sudoku9x9(boolean[][] t){
		interficie = new SudokuGUI("Sudoku",800,900,t);
	}
	
	public int[][] sudoku9x9(int f, int c,int[][] x ,int[][] aux,boolean[][] marcatgef,boolean[][] marcatgec,boolean[][] marcatgeq,String pathOutput) throws IOException{
		boolean bona = true;
		marcatge marc = new marcatge();//Demanem memoria per un objecte que  ens permetra marcar i desmarcar.
		main m = new main();
		Func_Auxiliar fa = new Func_Auxiliar();
		
		if(c<9 && f<9){
		//comprovem que podem escriure en la posicio en la que estem
			if(fa.HiHaSuccessor(f, c, x,aux)){
				//possem el valor a 0
				x[f][c]=0;
				//mirem que hi hagi "germans"(mes valors)
				while (x[f][c]<9 ){
					//incrementem el valor
					x[f][c]++;
					
					//Marquern i actualitzem la matriu de marcatge.
					//marcatge=marc.marcar9x9(f,c,marcatge);
					//marcatge=marc.getM9x9();
					//System.out.println(provaM[f][c]);
					
					//tindrem 2 grans ifs, el primer si no estam a la ultima fila ni a la ultima columna
					if(c<8){//recordem que va de 0 a 8
						if(bona = fa.bona(f, c, x,marcatgef,marcatgec,marcatgeq)){
							marcatgef=marc.marcar9x9(f, x[f][c]-1, marcatgef);
							marcatgec=marc.marcar9x9(x[f][c]-1, c, marcatgec);
							marcatgeq=marc.marcar9x9q(x[f][c]-1,f,c,marcatgeq);
							c++;
							x=sudoku9x9(f, c, x,aux,marcatgef,marcatgec,marcatgeq,pathOutput);
							c--;
							marcatgef=marc.desmarcar9x9(f, x[f][c]-1, marcatgef);
							marcatgec=marc.desmarcar9x9(x[f][c]-1, c, marcatgec);
							marcatgeq=marc.desmarcar9x9q(x[f][c]-1,f,c,marcatgeq);
						}
					}
					
					//Si estem a la ultima columna
					if(c==8){
						if(fa.bona(f, c, x,marcatgef,marcatgec,marcatgeq)){
							marcatgef=marc.marcar9x9(f, x[f][c]-1, marcatgef);
							marcatgec=marc.marcar9x9(x[f][c]-1, c, marcatgec);
							marcatgeq=marc.marcar9x9q(x[f][c]-1,f,c,marcatgeq);			
							f++;
							c=0;
							x=sudoku9x9(f, c, x,aux,marcatgef,marcatgec,marcatgeq,pathOutput);
							f--;
							c=8;
							marcatgef=marc.desmarcar9x9(f, x[f][c]-1, marcatgef);
							marcatgec=marc.desmarcar9x9(x[f][c]-1, c, marcatgec);
							marcatgeq=marc.desmarcar9x9q(x[f][c]-1,f,c,marcatgeq);						}
					}
					
					if(c==8 && f==8){
						if(fa.bona(f, c, x,marcatgef,marcatgec,marcatgeq)){
							m.setTFin(System.currentTimeMillis());
							File archivo = new File(pathOutput);
							BufferedWriter bw;
							marcatgef=marc.marcar9x9(f, x[f][c]-1, marcatgef);
							marcatgec=marc.marcar9x9(x[f][c]-1, c, marcatgec);
							marcatgeq=marc.marcar9x9q(x[f][c]-1,f,c,marcatgeq);	
							int af=0;
							int ac=0;
							char ch;
							// El fichero ya existe
							bw = new BufferedWriter(new FileWriter(archivo));
							if(archivo.exists()) {
							      // El fichero ya existe
							      while(af<9){
						    	  	ac=0;
									while(ac<9){
										ch =(char)('0'+x[af][ac]);
							    		  bw.write(ch);
										ac++;
									}
									bw.write('\n');
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
						}
					}
				}
				x[f][c]=0;
				
			}else{
				if(c==8){
					f++;
					c=0;
					x=sudoku9x9(f,c,x,aux,marcatgef,marcatgec,marcatgeq,pathOutput);
					f--;
					c=8;
				}else{
					c++;
					x=sudoku9x9(f, c,x,aux,marcatgef,marcatgec,marcatgeq,pathOutput);
					c--;
				}
				if(c==8 && f==8){
					if(fa.bona(f, c, x,marcatgef,marcatgec,marcatgeq)){
						m.setTFin(System.currentTimeMillis());
						File archivo = new File(pathOutput);
						BufferedWriter bw;
						int af=0;
						int ac=0;
						char ch;
						marcatgef=marc.marcar9x9(f, x[f][c]-1, marcatgef);
						marcatgec=marc.marcar9x9(x[f][c]-1, c, marcatgec);
						marcatgeq=marc.marcar9x9q(x[f][c]-1,f,c,marcatgeq);	
						// El fichero ya existe
						bw = new BufferedWriter(new FileWriter(archivo));
						if(archivo.exists()) {
						      while(af<9){
					    	  	ac=0;
								while(ac<9){
									ch =(char)('0'+x[af][ac]);
						    		  bw.write(ch);
									ac++;
								}
								bw.write('\n');
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
					}
					
				}
			}
	}
	return x;
	}

}

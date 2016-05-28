import javax.swing.SwingUtilities;

import Gui.SudokuGUI;

public class Samurai {
	
	static int fi =0;
	
	public Samurai(){}
	private SudokuGUI interficie;
	public Samurai(boolean[][] t, int mode){
		if(mode == 2)interficie = new SudokuGUI("Sudoku",800,900,t);
	}

	public int[][] resoldre(int[][] s,int mode, String pathOutput){
		int[][] x1 = new int[9][9];
		int[][] x2 = new int[9][9];
		int[][] x3 = new int[9][9];
		int[][] x4 = new int[9][9];
		int[][] x5 = new int[9][9];
		int[][] aux= new int[21][21];

		int[][] marcatgef = new int[9][9];
		int[][] marcatgec = new int[9][9];
		int[][] marcatgeq = new int[9][9];

		int[][] marcatgef2 = new int[9][9];
		int[][] marcatgec2 = new int[9][9];
		int[][] marcatgeq2 = new int[9][9];
		
		int[][] marcatgef3 = new int[9][9];
		int[][] marcatgec3 = new int[9][9];
		int[][] marcatgeq3 = new int[9][9];
		
		int[][] marcatgef4 = new int[9][9];
		int[][] marcatgec4 = new int[9][9];
		int[][] marcatgeq4 = new int[9][9];
		
		int[][] marcatgef5 = new int[9][9];
		int[][] marcatgec5 = new int[9][9];
		int[][] marcatgeq5 = new int[9][9];

		int ic=0, inf=0, indexf=0, indexc=0, ind=0;

		marcatgeSamu[] marc = new marcatgeSamu[5];
		matrius[] m = new matrius[5];

		for(int i=0;i<5;i++){
			m[i] = new matrius();
			marc[i]=new marcatgeSamu();
		}

		//omplim la 1r matriu
		for(int f=0;f<9;f++){
			for(int c=0;c<9;c++){
				x1[f][c]=s[f][c];
				if(x1[f][c]!=0){
					marcatgef=marc[1].marcarSamu(f,x1[f][c]-1,marcatgef);
					marcatgec=marc[1].marcarSamu(x1[f][c]-1, c, marcatgec);
					marcatgeq=marc[1].marcarQuadrantSamu(x1[f][c]-1,f,c,marcatgeq);
				}
			}
		}
		marc[1].setMarcatge(marcatgef,marcatgec,marcatgeq);


		//omplim la 2n matriu
		for(int f=0;f<9;f++){
			ic=0;
			for(int c=12;c<21;c++){
				x2[f][ic]=s[f][c];
				if(x2[f][ic]!=0){
					marcatgef2=marc[2].marcarSamu(f,s[f][c]-1,marcatgef2);
					marcatgec2=marc[2].marcarSamu(s[f][c]-1, ic, marcatgec2);
					marcatgeq2=marc[2].marcarQuadrantSamu(s[f][c]-1,f,ic,marcatgeq2);

				}

				ic++;
			}

		}

		marc[2].setMarcatge(marcatgef2,marcatgec2,marcatgeq2);


		//omplim la 3r matriu baix esquerra
		inf=0;
		for(int f=12;f<21;f++){
			for(int c=0;c<9;c++){
				x3[inf][c]=s[f][c];
				if(x3[inf][c]!=0){
					marcatgef3=marc[3].marcarSamu(inf,s[f][c]-1,marcatgef3);
					marcatgec3=marc[3].marcarSamu(s[f][c]-1, c, marcatgec3);
					marcatgeq3=marc[3].marcarQuadrantSamu(s[f][c]-1,inf,c,marcatgeq3);

				}

			}

			inf++;
		}
		
		marc[3].setMarcatge(marcatgef3,marcatgec3,marcatgeq3);


		//omplim la 4
		inf=0;
		for(int f=12;f<21;f++){
			ic=0;
			for(int c=12;c<21;c++){
				x4[inf][ic]=s[f][c];
				if(x4[inf][ic]!=0){
					marcatgef4=marc[4].marcarSamu(inf,s[f][c]-1,marcatgef4);
					marcatgec4=marc[4].marcarSamu(s[f][c]-1, ic, marcatgec4);
					marcatgeq4=marc[4].marcarQuadrantSamu(s[f][c]-1,inf,ic,marcatgeq4);

				}

				ic++;
			}

			inf++;
		}

		marc[4].setMarcatge(marcatgef4,marcatgec4,marcatgeq4);



		//finalment la central
		inf=0;
		for(int f=6;f<15;f++){
			ic=0;
			for(int c=6;c<15;c++){
				x5[inf][ic]=s[f][c];
				if(x5[inf][ic]!=0){
					marcatgef5=marc[0].marcarSamu(inf,s[f][c]-1,marcatgef5);
					marcatgec5=marc[0].marcarSamu(s[f][c]-1, ic, marcatgec5);
					marcatgeq5=marc[0].marcarQuadrantSamu(s[f][c]-1,inf,ic,marcatgeq5);

				}

				ic++;
			}

			inf++;
		}
		marc[0].setMarcatge(marcatgef5,marcatgec5,marcatgeq5);

		m[0].setMatriu(x5);
		m[0].omple(x5);
		m[1].setMatriu(x1);
		m[1].omple(x1);
		m[2].setMatriu(x2);
		m[2].omple(x2);
		m[3].setMatriu(x3);
		m[3].omple(x3);
		m[4].setMatriu(x4);
		m[4].omple(x4);
		/*int[][] matriu = new int[9][9];
		for(int i =0; i<m.length;i++){
			matriu = marc[i].getMarcatgef();
			indexf=0;
			while(indexf<9){
				indexc=0;
				while(indexc<9){
					System.out.print(matriu[indexf][indexc]+" ");

					indexc++;
				}
				System.out.println();
				indexf++;
			}
			System.out.println();
		}*/

		/*	boolean[][] matriu = new boolean[9][9];
		for(int t=0;t<5;t++){
			matriu = marc[t].getMarcatgef();
			System.out.println(t);
			for(int i =0;i<9;i++){
				for(int j=0;j<9;j++){
					System.out.print(matriu[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}*/
		s = solucionar(0, 0, m, s, 0, marc,mode,pathOutput);

		return s;
	}

	public int[][] buida(int[][] marc){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				marc[i][j]=0;
			}
		}
		return marc;
	}
	public int[][] omple(int[][] s, int[][] x, int ind,matrius[] m,int mode, String pathOutput){
		int c=0, f=0, c2=0, f2=0;

		if(ind==0){
			int ic=0, iff=0;

			for(f2=6; f2<15; f2++){
				ic=0;
				for(c2 =6; c2<15; c2++){
					s[f2][c2]=x[iff][ic];
					ic++;
				}
				iff++;
			}
		}
		boolean[][] aux = m[1].getEsc();
		boolean[][] aux2 = m[2].getEsc();
		boolean[][] aux3 = m[3].getEsc();
		boolean[][] aux4 = m[4].getEsc();
		if(ind == 1){
			for(f2=0; f2<9; f2++){
				for(c2 =0; c2<9; c2++){
					if(aux[f2][c2]!=true){
						s[f2][c2]=x[f2][c2];
					}
				}
			}
		}
		if(ind ==2){
			int ic=0,iff=0;
			for(f2=0; f2<9; f2++){
				ic=0;
				for(c2 =12; c2<21; c2++){
					if(aux2[f2][ic]!=true){
						s[f2][c2]=x[iff][ic];
					}
					ic++;
				}
				iff++;
			}
		}
		if(ind ==3){
			int ic=0, iff=0;

			for(f2=12; f2<21; f2++){
				ic=0;
				for(c2 =0; c2<9; c2++){
					if(aux3[iff][ic]!=true){
						s[f2][c2]=x[iff][ic];
					}
					ic++;
				}
				iff++;
			}			
		}
		if(ind == 4){
			int ic=0,iff=0;

			for(f2=12; f2<21; f2++){
				ic=0;
				for(c2 =12; c2<21; c2++){
					if(aux4[iff][ic]!=true){
						s[f2][c2]=x[iff][ic];
					}
					ic++;
				}
				iff++;
			}
			new Visualitzacio().visualitza(mode,pathOutput,s,interficie);
		}
		
		return s;
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


	public int[][] solucionar(int f, int c, matrius[] m, int[][] s, int ind,marcatgeSamu[] marc,int mode, String pathOutput){

		Fun_Samu fs = new Fun_Samu();
		boolean bona = true;
		int f2=0, c2=0;
		int[][] x= new int [9][9];
		//if(ind==5)ind--;//Amb aquest condicional evitem que el indicador de matrius surti de marge.
		if(ind!=5){
			x=m[ind].getMatriu();
		}//Evitem que asigni a x una matriu fora del domini de la varibale de matrius

		if(c<9 && f<9 && ind<5){
			
			int[][] matriuf = marc[ind].getMarcatgef();
			int[][] matriuc = marc[ind].getMarcatgec();
			int[][] matriuq = marc[ind].getMarcatgeq();
			//System.out.println(ind);
			
			if(fs.HiHaSamu(f,c,m[ind])){
				//possem el valor a 0
				x[f][c]=0;
				//mirem que hi hagi "germans"(mes valors)
				while (x[f][c]<9){

					//incrementem el valor
					if(x[f][c]<9){
						x[f][c]++;
						//s = omple(s,x,ind);
						//interficie.updateBoard(s);
					}
					m[ind].setMatriu(x);
					
					matriuf=marc[ind].marcarSamu(f, x[f][c]-1, matriuf);
					matriuc=marc[ind].marcarSamu(x[f][c]-1, c, matriuc);
					matriuq=marc[ind].marcarQuadrantSamu(x[f][c]-1, f, c, matriuq);
					marc[ind].setMarcatge(matriuf,matriuc,matriuq);

					if(c<8){//recordem que va de 0 a 8

						if(bona = fs.bonasamu(f, c, m, ind,marc)){
							c++;
							s = solucionar(f, c, m, s, ind,marc,mode,pathOutput);
							c--;

						}
					}
					//Si estem a la ultima columna
					if(c==8){
						if(fs.bonasamu(f, c, m, ind,marc)){

							f++;
							c=0;
							s = solucionar(f, c, m, s, ind,marc,mode,pathOutput);
							f--;
							c=8;
						}
					}
					if(c==8 && f==8){

						if(fs.bonasamu(f, c, m, ind,marc) && totOk(marc,x,ind,m)){
							
							if(ind==0){
								marc = marcar(marc,x,m);
								m = fs.uns(m);

							}
							s = omple(s,x,ind,m,mode,pathOutput);
							if(ind<4){
								//interficie.updateBoard(s);
								//if(ind ==0){
									//m = afegirValors(x,m);
								//}
								s = solucionar(0, 0, m, s, ind+1,marc,mode,pathOutput);
								if(ind==0){
									marc = desmarcar(marc,x,m);
									//m = treureValors(x,m);
								}

							}
						}//bonasamu
					}
					matriuf=marc[ind].desmarcarSamu(f, x[f][c]-1, matriuf);
					matriuc=marc[ind].desmarcarSamu(x[f][c]-1, c, matriuc);
					matriuq=marc[ind].desmarcarQuadrantSamu(x[f][c]-1, f, c, matriuq);
					marc[ind].setMarcatgef(matriuf);
					marc[ind].setMarcatgec(matriuc);
					marc[ind].setMarcatgeq(matriuq);
				}
				x[f][c]=0;

			}else{//hihasucc

				if(c==8){
					f++;
					c=0;
					s = solucionar(f,c, m, s, ind,marc,mode,pathOutput);
					f--;
					c=8;
				}else{
					c++;
					s = solucionar(f, c, m, s, ind,marc,mode,pathOutput);
					c--;
				}
				if(c==8 && f==8){
					
					if(fs.bonasamu(f, c, m, ind,marc) && totOk(marc,x,ind,m)){
						
						if(ind==0){
							marc = marcar(marc,x,m);
							m = fs.uns(m);

						}
						

						s = omple(s,x,ind,m,mode,pathOutput);
						/*if(ind==4){
							fi=fi+1;
						}*/
						if(ind<4){
							//if(ind ==0){
								//m = afegirValors(x,m);
							//}
							s = solucionar(0, 0, m, s, ind+1,marc,mode,pathOutput);
							if(ind==0){
								marc = desmarcar(marc,x,m);
							//	m=treureValors(x,m);
							}
						}
					}//bonasamu
				}
			}
		}
		return s;
	}

	public boolean totOk(marcatgeSamu[] marc, int[][] x, int ind, matrius[] m){
		//System.out.println("Hola");
		if(ind == 0){
			int[][] matriuf = new int[9][9];
			int[][] matriuc = new int[9][9];
			boolean[][] fixa = m[0].getEsc();
			int i_c=0,i_f=0;
			//System.out.println("Esntro");
			for(int i=1;i<5;i++){

				switch(i){
				case 1:
					for(int f=0; f<3; f++){
						for(int c=0; c<3; c++){
							if(c==0){i_c=6;}
							if(c==1){i_c=7;}
							if(c==2){i_c=8;}
							if(f==0){i_f=6;}
							if(f==1){i_f=7;}
							if(f==2){i_f=8;}
							matriuf=marc[i].getMarcatgef();
							matriuc=marc[i].getMarcatgec();
							if((matriuf[i_f][x[f][c]-1] == 1 || matriuc[x[f][c]-1][i_c] == 1) && fixa[f][c]==false){
								//System.out.println("mIERDA");
								return false;
							}
						}
					}
					break;
				case 2:
					for(int f=0; f<3; f++){
						for(int c=6; c<9; c++){
							if(c==6){i_c=0;}
							if(c==7){i_c=1;}
							if(c==8){i_c=2;}
							if(f==0){i_f=6;}
							if(f==1){i_f=7;}
							if(f==2){i_f=8;}
							matriuf=marc[i].getMarcatgef();
							matriuc=marc[i].getMarcatgec();
							if((matriuf[i_f][x[f][c]-1] == 1 || matriuc[x[f][c]-1][i_c] == 1) && fixa[f][c]==false){
								return false;
							}
						}
					}
					break;
				case 3:
					for(int f=6; f<9; f++){
						for(int c=0; c<3; c++){
							if(c==0){i_c=6;}
							if(c==1){i_c=7;}
							if(c==2){i_c=8;}
							if(f==6){i_f=0;}
							if(f==7){i_f=1;}
							if(f==8){i_f=2;}
							matriuf=marc[i].getMarcatgef();
							matriuc=marc[i].getMarcatgec();
							if((matriuf[i_f][x[f][c]-1] == 1 || matriuc[x[f][c]-1][i_c] == 1) && fixa[f][c]==false){
								return false;
							}						
						}
					}
					break;
				case 4:
					for(int f=6; f<9; f++){
						for(int c=6; c<9; c++){
							if(c==6){i_c=0;}
							if(c==7){i_c=1;}
							if(c==8){i_c=2;}
							if(f==6){i_f=0;}
							if(f==7){i_f=1;}
							if(f==8){i_f=2;}
							matriuf=marc[i].getMarcatgef();
							matriuc=marc[i].getMarcatgec();
							if((matriuf[i_f][x[f][c]-1] == 1 || matriuc[x[f][c]-1][i_c] == 1) && fixa[f][c]==false){
								return false;
							}								
						}
					}
					break;
				}
			}

		}
		//System.out.println("Es true");
		return true;
	}

	public marcatgeSamu[] marcar(marcatgeSamu[] m, int[][] x, matrius[] matrius){
		//System.out.println("Entro a marcar");
		int[][] matriuf = m[1].getMarcatgef();
		int[][] matriuc = m[1].getMarcatgec();
		int[][] matriuq = m[1].getMarcatgeq();

		int i_c=0,i_f=0;

		for(int f=0; f<3; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[1].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[1].marcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[1].marcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[1].marcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}

		m[1].setMarcatgef(matriuf);
		m[1].setMarcatgec(matriuc);
		m[1].setMarcatgeq(matriuq);

		matriuf = m[2].getMarcatgef();
		matriuc = m[2].getMarcatgec();
		matriuq = m[2].getMarcatgeq();

		for(int f=0; f<3; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[2].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[2].marcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[2].marcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[2].marcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}

		m[2].setMarcatgef(matriuf);
		m[2].setMarcatgec(matriuc);
		m[2].setMarcatgeq(matriuq);

		matriuf = m[3].getMarcatgef();
		matriuc = m[3].getMarcatgec();
		matriuq = m[3].getMarcatgeq();

		for(int f=6; f<9; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[3].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[3].marcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[3].marcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[3].marcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}

		m[3].setMarcatgef(matriuf);
		m[3].setMarcatgec(matriuc);
		m[3].setMarcatgeq(matriuq);

		matriuf = m[4].getMarcatgef();
		matriuc = m[4].getMarcatgec();
		matriuq = m[4].getMarcatgeq();

		for(int f=6; f<9; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[4].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[4].marcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[4].marcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[4].marcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}

		m[4].setMarcatgef(matriuf);
		m[4].setMarcatgec(matriuc);
		m[4].setMarcatgeq(matriuq);


		return m;
	}

	public marcatgeSamu[] desmarcar(marcatgeSamu[] m,int[][] x,matrius[] matrius){

		int[][] matriuf = m[1].getMarcatgef();
		int[][] matriuc = m[1].getMarcatgec();
		int[][] matriuq = m[1].getMarcatgeq();

		int i_c=0,i_f=0;

		for(int f=0; f<3; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[1].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[1].desmarcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[1].desmarcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[1].desmarcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}


		m[1].setMarcatgef(matriuf);
		m[1].setMarcatgec(matriuc);
		m[1].setMarcatgeq(matriuq);

		matriuf = m[2].getMarcatgef();
		matriuc = m[2].getMarcatgec();
		matriuq = m[2].getMarcatgeq();

		for(int f=0; f<3; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[2].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[2].desmarcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[2].desmarcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[2].desmarcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}

		m[2].setMarcatgef(matriuf);
		m[2].setMarcatgec(matriuc);
		m[2].setMarcatgeq(matriuq);

		matriuf = m[3].getMarcatgef();
		matriuc = m[3].getMarcatgec();
		matriuq = m[3].getMarcatgeq();

		for(int f=6; f<9; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[3].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[3].desmarcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[3].desmarcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[3].desmarcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}

		m[3].setMarcatgef(matriuf);
		m[3].setMarcatgec(matriuc);
		m[3].setMarcatgeq(matriuq);

		matriuf = m[4].getMarcatgef();
		matriuc = m[4].getMarcatgec();
		matriuq = m[4].getMarcatgeq();

		for(int f=6; f<9; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[4].getEsc();
				if(fixa[f][c] == false){
					matriuf=m[4].desmarcarSamu(i_f, x[f][c]-1, matriuf);
					matriuc=m[4].desmarcarSamu(x[f][c]-1, i_c, matriuc);
					matriuq=m[4].desmarcarQuadrantSamu(x[f][c]-1, i_f, i_c, matriuq);
				}
			}
		}

		m[4].setMarcatgef(matriuf);
		m[4].setMarcatgec(matriuc);
		m[4].setMarcatgeq(matriuq);

		return m;
	}
	
	public matrius[] afegirValors(int[][] x, matrius[] matrius){
		//System.out.println("Entro a marcar");
		int[][] matriuAux = new int[9][9];
		int i_c=0,i_f=0;

		for(int f=0; f<3; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[1].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[1].getMatriu();
					matriuAux[i_f][i_c]=x[f][c];
				}
			}
		}

		matrius[1].setMatriu(matriuAux);

		for(int f=0; f<3; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[2].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[2].getMatriu();
					matriuAux[i_f][i_c]=x[f][c];
				}
			}
		}

		matrius[2].setMatriu(matriuAux);

		for(int f=6; f<9; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[3].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[3].getMatriu();
					matriuAux[i_f][i_c]=x[f][c];
				}
			}
		}

		matrius[3].setMatriu(matriuAux);

		for(int f=6; f<9; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[4].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[4].getMatriu();
					matriuAux[i_f][i_c]=x[f][c];
				}
			}
		}

		matrius[4].setMatriu(matriuAux);

		return matrius;
	}
	
	public matrius[] treureValors(int[][] x, matrius[] matrius){
		//System.out.println("Entro a marcar");
		int[][] matriuAux = new int[9][9];
		int i_c=0,i_f=0;

		for(int f=0; f<3; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[1].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[1].getMatriu();
					matriuAux[i_f][i_c]=0;
				}
			}
		}

		matrius[1].setMatriu(matriuAux);

		for(int f=0; f<3; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==0){i_f=6;}
				if(f==1){i_f=7;}
				if(f==2){i_f=8;}
				boolean[][] fixa = matrius[2].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[2].getMatriu();
					matriuAux[i_f][i_c]=0;
				}
			}
		}

		matrius[2].setMatriu(matriuAux);

		for(int f=6; f<9; f++){
			for(int c=0; c<3; c++){
				if(c==0){i_c=6;}
				if(c==1){i_c=7;}
				if(c==2){i_c=8;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[3].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[3].getMatriu();
					matriuAux[i_f][i_c]=0;
				}
			}
		}

		matrius[3].setMatriu(matriuAux);

		for(int f=6; f<9; f++){
			for(int c=6; c<9; c++){
				if(c==6){i_c=0;}
				if(c==7){i_c=1;}
				if(c==8){i_c=2;}
				if(f==6){i_f=0;}
				if(f==7){i_f=1;}
				if(f==8){i_f=2;}
				boolean[][] fixa = matrius[4].getEsc();
				if(fixa[f][c] == false){
					matriuAux = matrius[4].getMatriu();
					matriuAux[i_f][i_c]=0;
				}
			}
		}

		matrius[4].setMatriu(matriuAux);

		return matrius;
	}
}

public class Fun_Samu {
	public Fun_Samu(){}

	public boolean HiHaSamu(int f, int c, matrius m){
		boolean ok=false;
		boolean[][] aux = new boolean [9][9];
		aux=m.getEsc();
		//Si contemplem que sigui mes gran a 0 limitem a que  sigui un numero i ignori el caracter '-'

		if(aux[f][c]==true ){
			return false;
		}else{
			return true;
		}

	}

	public boolean bonasamu(int f, int c, matrius[] m, int ind,marcatgeSamu[] marc){
		boolean ok = true;
		int i_f=0;
		int i_c=0,femMarc=1,num=0,j=0;
		Fun_Samu fu = new Fun_Samu();

		int[][] x= m[ind].getMatriu();
		int[][] matriuf = new int[9][9];
		int[][] matriuc = new int[9][9];
		int[][] matriuq= new int[9][9];

		if(femMarc==0){

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

						if(ind==0){
							for(i_c=0;i_c<3;i_c++){
								if(!quadrant1(f,c, m)||(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f)){
									return ok=false;
								}
							}
						}else{
							for(i_c=0;i_c<3;i_c++){
								if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
									return ok=false;
								}
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
						if(ind==0){
							for(i_c=6;i_c<9;i_c++){
								if((x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f) || !quadrant2(f,c,m)){
									return ok=false;
								}
							}
						}else{
							for(i_c=6;i_c<9;i_c++){
								if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
									return ok=false;
								}
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
						if(ind==0){
							for(i_c=0;i_c<3;i_c++){
								if((x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f) || !quadrant3(f,c,m)){
									return ok=false;
								}
							}
						}else{
							for(i_c=0;i_c<3;i_c++){
								if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
									return ok=false;
								}
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
						if(ind==0){
							for(i_c=6;i_c<9;i_c++){
								if((x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f)||!quadrant4(f,c,m)){
									return ok=false;
								}
							}
						}else{
							for(i_c=6;i_c<9;i_c++){
								if(x[i_f][i_c] == x[f][c] && i_c!= c && i_f!=f){
									return ok=false;
								}
							}
						}
					}
				}						
			}
		}else{
			num=m[ind].getNum(f,c,m[ind].getMatriu());
			if(num!=0){
				matriuf=marc[ind].getMarcatgef();
				if(matriuf[f][num-1]>1){return false;}

				matriuc=marc[ind].getMarcatgec();
				if(matriuc[num-1][c]>1){return false;}

				matriuq=marc[ind].getMarcatgeq();
				j=Index(f,c);
				if(matriuq[j][num-1]>1){return false;}
			}

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

	public boolean quadrant1(int f, int c, matrius[] m){
		boolean ok=true;
		int f1=0, c1=0;
		int[][] x1 = m[1].getMatriu();
		int[][] x5 = m[0].getMatriu();
		f1=f+6;
		c1=c+6;

		int f2=0,c2=0;
		f2=6;
		for(int iff=0;iff<3;iff++){
			c2=6;
			for(int ic=0;ic<3;ic++){
				x1[f2][c2]=x5[iff][ic];
				c2++;
			}
			f2++;
		}
		m[1].setMatriu(x1);

		//mantenim la fila i movem les columnes
		for(int i_c=0;i_c<9;i_c++){
			if(x5[f][c] == x1[f1][i_c] && i_c != c1){
				return ok=false;
			}
		}
		//mantenim la columna i movem les files
		for(int i_f=0; i_f<9;i_f++){
			if(x5[f][c] == x1[i_f][c1] && i_f != f1){
				return ok=false;
			}
		}

		return ok;
	}

	public boolean quadrant2(int f, int c, matrius[] m){
		boolean ok=true;
		int f1=0, c1=0;
		int[][] x2 = m[2].getMatriu();
		int[][] x5 = m[0].getMatriu();
		f1=f+6;
		c1=c-6;

		int f2=0,c2=0;
		f2=6;
		for(int iff=0;iff<3;iff++){
			c2=0;
			for(int ic=6;ic<9;ic++){
				x2[f2][c2]=x5[iff][ic];
				c2++;
			}
			f2++;
		}
		m[2].setMatriu(x2);

		//mantenim la fila i movem les columnes
		for(int i_c=0;i_c<9;i_c++){
			if(x5[f][c] == x2[f1][i_c] && i_c != c1){
				return ok=false;
			}
		}
		//mantenim la columna i movem les files
		for(int i_f=0; i_f<9;i_f++){
			if(x5[f][c] == x2[i_f][c1] && i_f != f1){
				return ok=false;
			}
		}

		return ok;
	}

	public boolean quadrant3(int f, int c, matrius[] m){
		boolean ok=true;
		int f1=0, c1=0;
		int[][] x3 = m[3].getMatriu();
		int[][] x5 = m[0].getMatriu();
		f1=f-6;
		c1=c+6;

		int f2=0,c2=0;
		f2=0;
		for(int iff=6;iff<9;iff++){
			c2=6;
			for(int ic=0;ic<3;ic++){
				x3[f2][c2]=x5[iff][ic];
				c2++;
			}
			f2++;
		}
		m[3].setMatriu(x3);

		//mantenim la fila i movem les columnes
		for(int i_c=0;i_c<9;i_c++){
			if(x5[f][c] == x3[f1][i_c] && i_c != c1){
				return ok=false;
			}
		}
		//mantenim la columna i movem les files
		for(int i_f=0; i_f<9;i_f++){
			if(x5[f][c] == x3[i_f][c1] && i_f != f1){
				return ok=false;
			}
		}


		return ok;
	}

	public boolean quadrant4(int f, int c, matrius[] m){
		boolean ok=true;
		int f1=0, c1=0;
		int[][] x4 = m[4].getMatriu();
		int[][] x5 = m[0].getMatriu();
		f1=f-6;
		c1=c-6;

		int f2=0,c2=0;
		f2=0;
		for(int iff=6;iff<9;iff++){
			c2=0;
			for(int ic=6;ic<9;ic++){
				x4[f2][c2]=x5[iff][ic];
				c2++;
			}
			f2++;
		}
		m[4].setMatriu(x4);

		//mantenim la fila i movem les columnes
		for(int i_c=0;i_c<9;i_c++){
			if(x5[f][c] == x4[f1][i_c] && i_c != c1){
				return ok=false;
			}
		}
		//mantenim la columna i movem les files
		for(int i_f=0; i_f<9;i_f++){
			if(x5[f][c] == x4[i_f][c1] && i_f != f1){
				return ok=false;
			}
		}


		return ok;
	}

	public matrius[] uns(matrius [] m){
		boolean[][] esc = new boolean[9][9];
		for(int i=1; i<5; i++){
			esc = m[i].getEsc();

			switch(i){
			case 1:
				for(int f=6; f<9; f++){
					for(int c=6; c<9; c++){
						esc[f][c]= true;
					}
				}
				m[i].setEsc(esc);
				break;

			case 2:
				for(int f=6; f<9; f++){
					for(int c=0; c<3; c++){
						esc[f][c]= true;
					}
				}
				m[i].setEsc(esc);
				break;

			case 3:
				for(int f=0; f<3; f++){
					for(int c=6; c<9; c++){
						esc[f][c]= true;
					}
				}
				m[i].setEsc(esc);
				break;
			case 4:
				for(int f=0; f<3; f++){
					for(int c=0; c<3; c++){
						esc[f][c]= true;
					}
				}
				m[i].setEsc(esc);
				break;
			}
		}
		return m;
	}
}

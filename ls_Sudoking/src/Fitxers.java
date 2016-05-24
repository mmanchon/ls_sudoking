import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fitxers {

	public void Fitxers(){}
	
	public int comprovacioFitxerUser(String path){
		String cadena=null;
		String[] ct = null;
		int iCount = 0;
		boolean sortir =false;
		try {
			FileReader f = new FileReader(path);
			BufferedReader b = new BufferedReader(f);
			cadena = b.readLine();
			ct = cadena.split(" ");
			iCount = ct.length;
			b.close();
			
			switch(iCount){
			case 9: return 1;
			case 16: return 2;
			case 21: return 3;
			default: return -1;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String read9x9(String path){
		String content = null;
		File file = new File(path); 
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public String readSolutionFile(){
		String content = null;
		File file = new File("Solucio9x9_2.txt"); 
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public String read16x16(String path){
		String cadena=null;
		String ct=" ";
		try {

			FileReader f = new FileReader(path);
			BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine())!=null) {
				ct = ct +  cadena+" ";
			}
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  ct;
	}

	public String readsamurai(String path){
		String cadena=null;
		String ct=" ";
		try {
			FileReader f = new FileReader(path);
			BufferedReader b = new BufferedReader(f);
			while((cadena = b.readLine())!=null) {
				ct = ct + cadena+" ";
			}
			b.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return  ct;
	}	

}



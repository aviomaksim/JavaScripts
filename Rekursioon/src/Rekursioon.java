import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Rekursioon {

	public static double x;
	public static double e;

	public static double[] masiv;

	private static double prevValue = 0;

	public static final int L = 15;
	public static int workDoneIndx = L;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		x = getDoubleFromCommand("Sissestatakse reaalar X (|X|<1) :", -1, 1);
		e = getDoubleFromCommand("Sissestatakse reaalar E (0<E<1) :", 0, 1);

		
		System.out.println("X="+x+" E="+e+" L="+L);
		genMasiv(L);

				
		writeArrayToFile(masiv, workDoneIndx);
	}
	
	//-------------write ti file---------
	public static void writeArrayToFile(double[] mas, int limit) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("F.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		String tmp;
		for (int i = 0; i < mas.length; i++){
			if(i>limit) break;
			
			tmp = "A["+(i+1)+"]="+Double.toString(masiv[i]);
			System.out.println(tmp);

			writer.println(tmp);
		}
		
		writer.close();
	}
	
	
	//-------------function work-------
	
	/**
	 * 
	 * @param indx
	 * @param x
	 * A1 = X,
	 * A2 = -(X^2)/3
	 * A3 = (X^4)/5
	 * ...
	 * kuni massiivi A elementide arv L kas vastab tingimusele |AL – AL-1| ≤ e voi
	 * (kui see tingimus ei ole rahuldatud) L = 15;
	 */
	public static void genMasiv(int indx) {
		System.out.println("num="+indx);
		masiv = new double[indx];
		
		double d = getAntiRoot(indx) ;
		
	}
	
	public static double getAntiRoot(int indx) {
		double curValue = (indx == 1) ? x : Math.pow(-1, indx - 1)* Math.pow(getAntiRoot(indx - 1), 2)/ (indx + (indx - 1));

		//System.out.println("A"+indx+" = "+curValue+" prevValue="+prevValue+" workDoneIndx="+workDoneIndx);
		
		if(indx > 1 && Math.abs(curValue - prevValue)>e && workDoneIndx==L){
			workDoneIndx = indx;
		}else{
			masiv[indx-1] = curValue;
		}
		prevValue = curValue;
		return  curValue;
	}
	
	//---------read command promt-----------
	
	public static double getDoubleFromCommand(String title, double min, double max){
		
		boolean found = false;
		double number = 0;
		while(!found){
			String txt = readCommandLine(title);
			
			try {
				number = Double.parseDouble(txt);
				if(number>min && number<max ){
					found = true;			
				}else{
					System.out.println("Vale number! Palun, kontrollige piirkond.");
				}
			} catch (Exception e) {
				System.out.println("Pole reaalarv!");
			}
		}
		return number;
		
	}
	
	public static String readCommandLine(String title){
		//  prompt the user to enter something
	      System.out.print(title);

	      //  open up standard input
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      String result = null;

	      //  read text from the command-line; need to use try/catch with the
	      //  readLine() method
	      try {
	    	  result = br.readLine();
	      } catch (IOException ioe) {
	         System.out.println("IO error");
	         System.exit(1);
	      }

	      return result;
		
	}

}

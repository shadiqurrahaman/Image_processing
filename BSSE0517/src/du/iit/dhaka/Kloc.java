package du.iit.dhaka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kloc {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("D:/number/Kloc.java"));
		int count=0;
		while(scanner.hasNext()){
			String line=scanner.nextLine();
			if(!line.equals("")&&!line.contains("*")&&!line.contains("/*")&&!line.contains("*/")&&!line.contains("//"))
	           System.out.println(count++ +" "+ line); 
	           }
	}

}

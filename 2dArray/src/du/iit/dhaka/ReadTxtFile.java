package du.iit.dhaka;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class ReadTxtFile {
	
//    File file=new File("what.txt");
//    
//   String[][] number=new String[10][10];

	public int[][] arr(){
int [][] number = new int [10][10];
   try {
      //FileReader fr=new FileReader(file);
      // BufferedReader bf=new BufferedReader(fr);
	   //InputStream scanner=new BufferedInputStream(new FileInputStream("what.txt"));
       Scanner scanner = new Scanner(new File("what.txt"));
       int data;
        
       int j=0;
       while(scanner.hasNext()){
           //String[] parts=data.split(",");
           //String[][]pa = null;
           for(int i=0;i<10;i++){
           	number[j][i] = scanner.nextInt();
             
               //System.out.println(parts[i]);
                
           }
           j++;
       }
        
       
       //bf.close();
   } catch (FileNotFoundException e) {
        
       e.printStackTrace();
   }
return number;
   
   
	}
}

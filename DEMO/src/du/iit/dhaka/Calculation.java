package du.iit.dhaka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculation {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
	
		 Scanner input = new Scanner (new File("C:/Users/Shaon/Desktop/Data_Set/LBP/LBPcal.txt"));
	        int m = 4;
	        int n = 4;
	        int[][] a = new int [m][n];
	        while (input.hasNextInt()){
	            for (int i=0;i<m;i++){
	                for (int j=0;j<n;j++)
	                    a[i][j]= input.nextInt();
	            }   

	        }
	        //print the input matrix
	        System.out.println("The input sorted matrix is : ");
	        for(int i=0;i<m;i++){
	        	String s ="";
	            for(int j=0;j<n;j++){
	             s=s+" "+a[i][j];  
	             }
	        System.out.println(s);
	        }
	        //average calculate
	        int average=0;
	        for(int i=0;i<m;i++){
	        	
	            for(int j=0;j<n;j++){
	               
	            	if(i==j){
	            		average=average+a[i][j];
	            	}
	             }
	            
	       
	        }
	        System.out.println("Accuracy for LBP:= "+average/4);
	        
	        //precision calculate
	        System.out.println("Precision : ");
	        double precision;
	        
	        for(int i=0;i<m;i++){
	        	int total=0;
	            for(int j=0;j<n;j++){
	               
	            	total=total+a[j][i];
	            	
	            }
	            precision= (double)a[i][i]/total;
	          
	           System.out.println("For Feature  "+i+" precision "+precision);
	        }
	        
	        System.out.println("Recall : ");
	        double recall;
	        
	        for(int i=0;i<m;i++){
	        	int total=0;
	            for(int j=0;j<n;j++){
	               
	            	total=total+a[i][j];
	            	
	            }
	            recall= (double)a[i][i]/total;
	          
	           System.out.println("For Feature "+i+" recall "+recall);
	        }
	       
	        
}
}
package du.iit.dhaka;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class LbpMain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> histogram = new ArrayList<Integer>();
		File folder = new File("D:/number/stripe");
		File[] listOfFiles = folder.listFiles();
		for (int index = 0; index < listOfFiles.length; index++) {
			  File file = listOfFiles[index];
		BufferedImage image;
		   int width;
		   int height;
		   
		   
		   image = ImageIO.read(file);
	         width = image.getWidth();
	         height = image.getHeight();
	         
	         int[][] imgval=new int[width][height];
	         int[][] imagefile=new int[width][height];
	         for(int i=0; i<height; i++){
	             
	             for(int j=0; j<width; j++){
	             
	                Color c = new Color(image.getRGB(j, i));
	                //System.out.println("S.No: " +count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
	                
	                int red = (int)(c.getRed() * 0.299);
	                 int green = (int)(c.getGreen() * 0.587);
	                 int blue = (int)(c.getBlue() *0.114);
	                 Color newColor = new Color(red+green+blue,
	                         
	                         red+green+blue,red+green+blue);
	                int tem=newColor.getRGB();
	                imgval[j][i]=tem;
	               // arr.add(imageVlaue/3);
	               // System.out.println(tem);
	             }
	          }
	         
	         
	         
	         //this part is for binary calculation
	         for (int i = 0; i < height-2; i++) {
				for (int j = 0; j < width-2; j++) {
					//System.out.println(imgval[i][j]);
					
					//int[ ][ ] aryNumbers = new int[3][3];
					int[ ][ ] binary = new int[3][3];
						int bin1=0;
						
					for (int i1 = i; i1 < i+3; i1++) {
						int bin2=0;
						for (int j1 = j; j1 <j+3; j1++) {
							
							if(!(i1==i+1&&j1==j+1)){
								//System.out.println(i+""+j+" "+aryNumbers[i][j]);
								if(imgval[j1][i1]>=imgval[j+1][i+1]){
									binary[bin1][bin2]=1;
								}else{binary[bin1][bin2]=0;}
								
							}else{binary[1][1]=imgval[j][i];}
							
							bin2++;
						}
					bin1++;
						
					}
					
					
					int[] binaryarray=new int[8];
					int flag=0;
			for (int i1 = 0; i1 < 3; i1++) {
				for (int j1 = 0; j1 < 3; j1++) {
					//System.out.println(i1+""+j1+" "+binary[i][j]);
					if(!(i1==1&&j1==1)){
					
						binaryarray[flag]=binary[j1][i1];
						flag++;
					}
				}
				
			}
			
			String s=null;
			String y = "0";
			for(int i1=0;i1<binaryarray.length;i1++){
			s=String.valueOf(binaryarray[i1]);
			
			 y=y+s;
			
			}
			 int decimalNumber = Integer.parseInt(y,2);
			
			 imagefile[j][i]=decimalNumber;
			
			//System.out.println(decimalNumber);
				}
			}
	         
	         
	         
	         //this part is for print image
	         BufferedImage bufferImage2=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
	         
	         int cou=0;
	         for (int k = 0; k < height; k++) {
				for (int k2 = 0; k2 < width; k2++) {
					//System.out.println(imgval[k][k2]);
					
					int Pixel=imagefile[k2][k];
					//int Pixel=imgval[k2][k];
					Color cl=new Color(Pixel,Pixel,Pixel);
					Pixel=cl.getRGB();
					//System.out.println(Pixel);
					bufferImage2.setRGB(k2, k,Pixel);
					cou++;
				}
				cou++;
			}
	         System.out.println(cou);
	         File outputfile = new File("D:/number/hull.jpg");
	         ImageIO.write(bufferImage2, "jpg", outputfile);
	         
	         
	         //this part is for count histogram
	         for (int k = 0; k < 256; k++) {
	        	 
	        	 int count=0;
				for (int k2 = 0; k2 < imagefile.length; k2++) {
					for (int l = 0; l < imagefile.length; l++) {
						if(k==imagefile[l][k2]){
							count++;
						}
						
					}
					
				}
				histogram.add(count);
			}
	         Writer writer = new BufferedWriter(new OutputStreamWriter(
				        new FileOutputStream("D:/number/main/set.txt", true), "UTF-8"));
	        String s=null;
	         for (int k = 0; k < histogram.size(); k++) {
				//System.out.println(k+" "+histogram.get(k));
	        	 s=s+k+"#"+histogram.get(k)+" ";
	        	 
			}
	         writer.append(s+"\n");
	   		  writer.close();

		}
	}

}

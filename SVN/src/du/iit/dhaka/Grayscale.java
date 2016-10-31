package du.iit.dhaka;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Grayscale {

	
	public static void main(String[] args) throws IOException {
		
//		File[] listOfFiles = folder.listFiles();
//		for (int index = 0; index < listOfFiles.length; index++) {
//			  File file = listOfFiles[index];
			  
		BufferedImage image;
		   int width;
		   int height;
		   
		   File file=new File("D:/number/hog.png");
		   image = ImageIO.read(file);
	         width = image.getWidth();
	         height = image.getHeight();
	         
	         int[][] imgval=new int[width][height];
	         
	         for(int i=0; i<width; i++){
	             
	             for(int j=0; j<height; j++){
	             
	                Color c = new Color(image.getRGB(i, j));
	               
	                
	                int red = (int)(c.getRed() * 0.299);
	                 int green = (int)(c.getGreen() * 0.587);
	                 int blue = (int)(c.getBlue() *0.114);
	                 Color newColor = new Color(red+green+blue,
	                         
	                         red+green+blue,red+green+blue);
	                int tem=newColor.getRGB();
	                int tem2=(c.getRed()+c.getGreen()+c.getBlue())/3;
	                // int tem= (int) (0.2989 * c.getRed() + 0.5870 * c.getGreen() + 0.1140 * c.getBlue()); 
	                imgval[i][j]=tem;
	                System.out.println(tem2);
	              
	             }
	          }
	         
	         
	         
	        
	         
	         
	         //this part is for print image
	         BufferedImage bufferImage2=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
	         
	         
	         for (int k = 0; k < height; k++) {
				for (int k2 = 0; k2 < width; k2++) {
					
					int Pixel=imgval[k2][k];
					//System.out.println(Pixel);
					bufferImage2.setRGB(k2, k,Pixel);
					
				}
			
			}
	         
	         String s=file.getName();
	         System.out.println(s);
	         String[] result = s.split("\\.(?=[^\\.]+$)");
	         s=result[0]+"newddd"+".jpg";
	        
	         File outputfile = new File("D:/number/"+s);
	         ImageIO.write(bufferImage2, "jpg", outputfile);
	         
	         
	        
			  }
			  
		}
			//  }



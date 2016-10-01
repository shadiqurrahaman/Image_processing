package ltp.feature.extract;


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
import javax.swing.JFileChooser;



public class LtpTrain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public void LTP() throws IOException {
		//ArrayList<Integer> histogram = new ArrayList<Integer>();

		JFileChooser fc=new JFileChooser();
		 fc.showOpenDialog(fc);
		//File folder = new File("D:/Image/bubbly1");
		 File folder =fc.getCurrentDirectory();
		File[] listOfFiles = folder.listFiles();
		
		for (int index = 0; index < listOfFiles.length; index++) {
			
			
			  File file = listOfFiles[index];
			  System.out.println(file.getName());
		BufferedImage image;
		int width;
		int height;
//		JFileChooser fc=new JFileChooser();
//		 	fc.showOpenDialog(fc);
//		 	
//     File file = fc.getSelectedFile();
		//File file=new File(pictureName);
		int[] histogramuppar=new int[256];
		int[] histogramloar=new int[256];
		image = ImageIO.read(file);
		width = image.getWidth();
		height = image.getHeight();

		int[][] imgval=new int[width][height];
		int[][] imagefileuppar=new int[width][height];
		int[][] imagefileloar=new int[width][height];
		int[][] gray=new int[width][height];
        
        
//        for(int i=0; i<height; i++){
//
//       	 for(int j=0; j<width; j++){
//
//       		 Color c = new Color(image.getRGB(j, i));
//
//
//       		 int red = c.getRed();
//       		 int green = c.getGreen();
//       		 int blue = c.getBlue();
//       		 
//       		 int tem=(red+green+blue)/3;
//       		imgval[j][i]=tem;
//				System.out.println(tem);
//       	 }
//        }
        
        
		for(int i=0; i<height; i++){

			for(int j=0; j<width; j++){

				Color c = new Color(image.getRGB(j, i));
				//System.out.println("S.No: " +count + " Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());

				int red = (int)(c.getRed() * 0.299);
				int green = (int)(c.getGreen() * 0.587);
				int blue = (int)(c.getBlue() *0.114);
				Color newColor = new Color(red+green+blue,

						red+green+blue,red+green+blue);
				int tem=(newColor.getRed()+newColor.getGreen()+newColor.getBlue())/3;
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

						if(!(i1==i+1&&j1==j+1)){                //mask middle pixel
							//System.out.println(i+""+j+" "+aryNumbers[i][j]);
							if(imgval[j1][i1]>=imgval[j+1][i+1]+5){
								binary[bin1][bin2]=1;
							}else if(Math.abs(imgval[j1][i1]-imgval[j+1][i+1])<5){binary[bin1][bin2]=0;}
							else if(imgval[j1][i1]-5<imgval[j+1][i+1]){
								binary[bin1][bin2]=-1;
							}

						}else{binary[1][1]=imgval[j][i];}

						bin2++;
					}
					bin1++;

				}


				int[] binaryarrayuppar=new int[8];
				int[] binaryarrayloar=new int[8];
				int flag=0;
				int flag1=0;
				for (int i1 = 0; i1 < 3; i1++) {
					for (int j1 = 0; j1 < 3; j1++) {
						//System.out.println(i1+""+j1+" "+binary[i][j]);
						if(!(i1==1&&j1==1)){
							if(binary[j1][i1]==-1){
							binaryarrayuppar[flag]=0;
							flag++;}else{
								binaryarrayuppar[flag]=binary[j1][i1];
								flag++;
							}
							
							if(binary[j1][i1]==-1){
								binaryarrayloar[flag1]=1;
								flag1++;}else{
									binaryarrayloar[flag1]=0;
									flag1++;
								}
						}
					}

				}

				String s=null;
				String y = "0";
				for(int i1=0;i1<binaryarrayuppar.length;i1++){
					s=String.valueOf(binaryarrayuppar[i1]);

					y=y+s;

				}
				int decimalNumberuppar = Integer.parseInt(y,2);

				imagefileuppar[j][i]=decimalNumberuppar;
				System.out.println(decimalNumberuppar);
				String s1=null;
				String y1 = "0";
				for(int i1=0;i1<binaryarrayloar.length;i1++){
					s1=String.valueOf(binaryarrayloar[i1]);

					y1=y1+s1;

				}
				int decimalNumberloar = Integer.parseInt(y1,2);

				imagefileloar[j][i]=decimalNumberloar;
				System.out.println(decimalNumberloar);
			}
		}



		//this part is for print image
		//	         BufferedImage bufferImage2=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		//	         
		//	         int cou=0;
		//	         for (int k = 0; k < height; k++) {
		//				for (int k2 = 0; k2 < width; k2++) {
		//					//System.out.println(imgval[k][k2]);
		//					
		//					int Pixel=imagefile[k2][k];
		//					//int Pixel=imgval[k2][k];
		//					Color cl=new Color(Pixel,Pixel,Pixel);
		//					Pixel=cl.getRGB();
		//					//System.out.println(Pixel);
		//					bufferImage2.setRGB(k2, k,Pixel);
		//					cou++;
		//				}
		//				cou++;
		//			}
		//	         System.out.println(cou);
		//	         File outputfile = new File("D:/number/hull.jpg");
		//	         ImageIO.write(bufferImage2, "jpg", outputfile);


		//this part is for count histogram
		for (int k = 0; k <256; k++) {

			int count=0;
			int count1=0;
			for (int k2 = 0; k2 < height; k2++) {
				for (int l = 0; l < width; l++) {
					if(k==imagefileuppar[l][k2]){
						count++;
					}

				}

			}
			
			histogramuppar[k]=count;
			
			for (int k2 = 0; k2 < height; k2++) {
				for (int l = 0; l < width; l++) {
					if(k==imagefileloar[l][k2]){
						count1++;
					}

				}

			}
			histogramloar[k]=count1;
			
		}
		//PrintWriter writer = new PrintWriter("D:/image/test.txt", "UTF-8");
//		Writer writer = new BufferedWriter(new OutputStreamWriter(
//				new FileOutputStream("D:/image/test.txt", true), "UTF-8"));
		Writer writer = new BufferedWriter(new OutputStreamWriter(
		        new FileOutputStream("D:/image/train.txt", true), "UTF-8"));
		String s="";
		for (int k = 0; k < 256; k++) {
			//System.out.println(k+" "+histogram.get(k));
			s=s+k+"#"+histogramuppar[k]+" ";

		}
		String s1="";
		for (int k = 0; k < 256; k++) {
			//System.out.println(k+" "+histogram.get(k));
				int i=k+256;
			s1=s1+i+"#"+histogramloar[k]+" ";

		}
		String S=s+" "+s1;
		 writer.append(S+"\n");
		 //writer.append(s1);
		writer.close();


	}
	}
}

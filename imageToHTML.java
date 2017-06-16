/* *****************************************************************************************************
 * Name: imageToHTML
 * Author: Tony Jiang
 * Description: This program is to transform a picture into the code of a html page consist of colorful 
 * characters(function as pixel). The users are able to see the vague version of the picture through the 
 * characters of different colors. The idea and algorithm is credit to @xlzd on ZhiHu.
 * 
 *******************************************************************************************************/

import images.APImage;
import images.Pixel;


public class imageToHTML{
	public static void main(String args[]){
		
		APImage image = new APImage("jessie.jpg");  // image 
	    int height = image.getHeight();           // actual sizes
		int width = image.getWidth();
		int x = 0;   // position variable
		int y = 0;	 // position variable
		
		// parameters Ё§
		int times = 5;  // how many times smaller
		
		
		Pixel[][] picture = new Pixel[height][width];
		
		for (int i = 0 ; i < height; i ++){       // input the Pixel information into an Pixel array
			for (int j = 0; j < width; j ++){
				picture[i][j] = image.getPixel(i+1,j+1);
			}
		}
		
		int hHeight = image.getHeight() / times;   // set html size 5 ( multiple parameter) times smaller 
		int hWidth = image.getWidth() /times;
		
		pixel[][] html = new pixel[hHeight][hWidth]; 
		// the pixel class is created with three public variables r(red),g(green) and b(blue).
		for (int i = 0; i < hHeight; i ++){  // fill the array with objects
			for (int j = 0; j < hWidth; j ++){
				html[i][j] = new pixel();
			}
		}
		
		while  (y< height){
			x = 0;
				while(x < width){
						// adding the numbers together, and will divide them up later to get the average
				    	html[y/times][x/times].r += picture[y][x].getRed();
						html[y/times][x/times].g += picture[y][x].getGreen();
						html[y/times][x/times].b += picture[y][x].getBlue();
						
						x ++;
					}
				y ++;
				}
		
		
		for (int i = 0; i < hHeight; i ++){
			
			for ( int j = 0; j < hWidth; j ++){
				// to get the average RGB number of the area
			    html[i][j].r = html[i][j].r / (times * times);
				html[i][j].g = html[i][j].g / (times * times);
				html[i][j].b = html[i][j].b / (times * times);  

				String rgb =  decimal2hex(html[i][j].r) + decimal2hex(html[i][j].g)+ decimal2hex(html[i][j].b);
				System.out.print("<font color =\"" + rgb + "\">еб</font> ");   // еб is the character 
			}
			
			System.out.println("<br>"); 
		}
		
		
	}
	
	//for that HTML uses hex for color format, this method is needed. it is to convert decimal to hex 
	//Also, this is copy and paste from Internet, I am too lazy to write one.  :)
	public static String decimal2hex(int d) {
	    String digits = "0123456789abcdef";
	    if (d <= 0) return "0";
	    int base = 16;   
	    String hex = "";
	    while (d > 0) {
	        int digit = d % base;        
	        hex = digits.charAt(digit) + hex;  
	        d = d / base;
	    }
	    
	    if (hex.length() == 1){     //to fit the format of Html, I added this part.
	    	hex = "0" + hex;
	    }
	    
	    return hex;
	}
	
	

	
}
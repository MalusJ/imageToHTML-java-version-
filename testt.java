import images.APImage;
import images.Pixel;
import java.util.Scanner;

public class testt{
	public static void main(String args[]){
		Scanner reader = new Scanner(System.in);
		APImage image = new APImage (150,150);
		image.draw();
		int y = 75;
		for (int i  = 0 ; i <= image.getWidth(); i ++){
			image.setPixel(i, y, new Pixel (550,0,0));
		}
		for (int i  = 0 ; i <= image.getWidth(); i ++){
			System.out.println(image.getPixel(i, y).getRed());
		}
	
	}
}
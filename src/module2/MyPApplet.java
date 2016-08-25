package module2;


import java.time.LocalTime;

import processing.core.PApplet;
import processing.core.PImage;

public class MyPApplet extends PApplet {
	
	String URL = "http://g02.a.alicdn.com/kf/HTB1Ya4UIpXXXXXLXXXXq6xXFXXX0/"
			+ "300CM-200CM-10ft-6-5f-Photography-Prop-Backdrops-font-b-Setting-b-font-Sun-beach-Sea.jpg";
	String LOCAL = "palmTrees.jpg";
	private PImage img;

	public void setup(){
		size(200, 200);
		img = loadImage(URL, "jpg");
		img.resize(width, height);
		
	}
	
	public void draw(){
//		background(img);
		img.resize(width, height);
		image(img, 0, 0);
		int rgb[] = sunColorSec(second());
		fill(rgb[0], rgb[1], rgb[2]);
		ellipse(width/2, height/4, width/5, height/5);
	}
	
	public void changeSunColor(){
		LocalTime now = LocalTime.now();
		if (now.getHour() < 18) {
			fill(0, 0, 0);
		}
	}
	
	public int[] sunColorSec(float seconds){
		int rgb[] = new int[3];
		float diff30 = Math.abs(seconds-30);
		float ratio = diff30/30;
		
		float diff60 =  seconds / 60;System.out.println(seconds);// change the color in 60 seconds
		
		rgb[0] = (int)(255 * ratio);
		rgb[1] = (int)(255 * ratio);
		rgb[2] = 0;
		
		return rgb;
	}
}

package guimodule;

import processing.core.PApplet;

// Drawing a Happy Face
public class MyDisplay extends PApplet{

	public void setup(){
		size(400, 400);
		background(0, 100, 0);
	}
	
	public void draw(){
		fill(255, 255, 0);
		ellipse(200, 200, 390, 390);
		fill(0, 0, 0);
		ellipse(120, 130, 50, 70);
		ellipse(280, 130, 50, 70);
		
		noFill();
		arc(200, 250, 300, 150, 0.5F, PI-0.5F, OPEN);
		arc(200, 249, 300, 150, 0.5F, PI-0.5F, OPEN);
		arc(200, 248, 300, 150, 0.5F, PI-0.5F, OPEN);
		arc(200, 247, 300, 150, 0.5F, PI-0.5F, OPEN);
	}

}

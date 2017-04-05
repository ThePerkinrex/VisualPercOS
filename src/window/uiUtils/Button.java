package window.uiUtils;

import processing.core.PApplet;

public class Button {
	
	private PApplet sketch;
	private int x;
	private int y;
	private int height;
	private int width;
	
	public Button(PApplet sketch, int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public boolean isHovered(){
		boolean r = false;
		if(sketch.mouseX>x && sketch.mouseX<x+width && sketch.mouseY>y && sketch.mouseY<y+height){
			r = true;
		}
		return r;
	}
	
	public boolean isPressed(){
		boolean r = false;
		if(isHovered() && sketch.mousePressed){
			r = true;
		}
		return r;
	}
	
	public void setPos(float x, float y){
		this.x = PApplet.round(x);
		this.y = PApplet.round(y);
	}
}

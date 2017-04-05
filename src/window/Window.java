package window;

import processing.core.PApplet;

public abstract class Window {
	protected int width;
	protected int height;
	protected int x;
	protected int gy;
	private int y;
	
	private String name;
	
	protected PApplet sketch;
	
	public Window(PApplet sketch, int width, int height, int x, int y, String name) {
		this.sketch = sketch;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.gy = y+20;
		this.name = name;
	}
	
	public void setup(){
		
	}
	
	protected abstract void updateApp();
	
	protected abstract void displayApp();
	
	private void displayWindow(){
		sketch.pushStyle();
		sketch.fill(50, 175);
		sketch.stroke(50);
		sketch.rect(x, y, width, 20);
		sketch.fill(255);
		sketch.stroke(255);
		sketch.textSize(16);
		sketch.text(name, x+((width/2)-(sketch.textWidth(name)/2)), y+18);
		sketch.textSize(14);
		sketch.popStyle();
	}
	
	public void mouseDragged(){
		mouseDraggedApp();
		if(sketch.mouseX>x && sketch.mouseX<x+width && sketch.mouseY>y && sketch.mouseY<y+20){
			int nX = x-(sketch.pmouseX-sketch.mouseX);
			int nY = y-(sketch.pmouseY-sketch.mouseY);
			if(nY>20){
				x=nX;
				y=nY;
				gy = y+20;
			}
		}
	}
	
	protected void mouseDraggedApp(){
		
	}
	
	public void keyTyped(){
		
	}
	
	public void update(){
		displayWindow();
		displayApp();
		updateApp();
	}
	
}

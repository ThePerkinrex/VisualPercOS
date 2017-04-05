package window.uiUtils;

import processing.core.PApplet;
import processing.core.PConstants;

public class TextInput {
	private PApplet sketch;
	
	public float x;
	public float y;
	private int width;
	private int height;
	
	private boolean focused;
	
	private String value;

	public TextInput(PApplet sketch, float f, float g, int width) {
		this.sketch = sketch;
		
		this.x = f;
		this.y = g;
		this.width = width;
		this.height = 18;
		
		this.focused = false;
		
		this.value = "";
	}
	
	public void update(){
		isFocused();
		//setValue();
		show();
	}
	
	public void keyTyped(){
		setValue();
	}
	
	private void isFocused(){
		if(sketch.mousePressed){
			if((sketch.mouseX > x && sketch.mouseX < x+width && sketch.mouseY > y && sketch.mouseY < y+height)){
				System.out.println(this + " is focused");
				focused = true;
			}else{
				focused = false;
			}
		}
	}
	
	private void setValue(){
		if(focused && sketch.keyPressed){
			System.out.println("Key Pressed: " + sketch.key);
			if(sketch.key != PConstants.CODED){
				if(sketch.key != '\b' && (sketch.key != PConstants.ENTER && sketch.key != PConstants.RETURN)){
					value+=sketch.key;
					System.out.println(this);
				}else{
					if(sketch.key=='\b'){
						try {
							value = value.substring(0, value.length()-1);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		}
	}
	
	private void show(){
		sketch.rect(x, y, width, height);
		sketch.pushStyle();
		sketch.fill(0);
		sketch.stroke(0);
		sketch.text(value, x+5, y+height-2);
		sketch.popStyle();
	}
	
	public String getValue(){
		return value;
	}

	@Override
	public String toString() {
		return "TextInput [value = " + value + "]";
	}
}

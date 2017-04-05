package defaultApps;

import org.percot.helpers.Button;
import org.percot.helpers.Color;

import processing.core.PApplet;
import processing.core.PVector;
import window.Window;
import window.uiUtils.TextInput;

public class CreateUser extends Window {
	
	private TextInput user;
	private TextInput pass;
	private TextInput conpass;
	private PVector uPos;
	private PVector pPos;
	private PVector cpPos;
	
	private Button crea;
	private PVector crPos;

	public CreateUser(PApplet sketch) {
		super(sketch, 400, 600, 100, 100, "Create User");
		uPos = new PVector(10,30);
		pPos = new PVector(10,80);
		cpPos = new PVector(10,120);
		user = new TextInput(sketch, x+uPos.x,gy+uPos.y, width-20);
		pass = new TextInput(sketch, x+pPos.x,gy+pPos.y, width-20);
		conpass = new TextInput(sketch, x+cpPos.x,gy+cpPos.y, width-20);
		
		crPos = new PVector(40,140);
		crea = new Button(sketch,PApplet.round(x+crPos.x),PApplet.round(gy+crPos.y), 18, 40, "Create");
	}

	@Override
	protected void updateApp() {
	}

	@Override
	protected void displayApp() {
		user.x = x+uPos.x;
		user.y = gy+uPos.y;
		pass.x = x+pPos.x;
		pass.y = gy+pPos.y;
		conpass.x = x+cpPos.x;
		conpass.y = gy+cpPos.y;
		
		//crea.setPos(x+crPos.x, gy+crPos.y);
		
		sketch.fill(255);
		sketch.rect(x,gy,width,height);
		sketch.fill(0);
		sketch.text("Username", x+10, gy+20);
		sketch.text("Password", x+10, gy+70);
		sketch.text("Confirm password", x+10, gy+112);
		sketch.fill(255);
		user.update();
		pass.update();
		conpass.update();
		crea.show(new Color(245), new Color(0));
	}
	
	@Override
	public void setup() {
	}
	
	@Override
	public void keyTyped(){
		user.keyTyped();
		pass.keyTyped();
		conpass.keyTyped();
	}

}

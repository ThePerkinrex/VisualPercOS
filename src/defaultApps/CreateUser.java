package defaultApps;

import java.io.IOException;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.percot.helpers.Button;
import org.percot.helpers.Color;

import processing.core.PApplet;
import processing.core.PVector;
import utils.EncryptionUtils;
import window.Window;
import window.uiUtils.TextInput;

public class CreateUser extends Window {
	
	
	
	private TextInput user;
	private TextInput pass;
	private TextInput conpass;
	private PVector uPos;
	private PVector pPos;
	private PVector cpPos;
	
	private PVector crPos;

	public CreateUser(PApplet sketch) {
		super(sketch, 400, 180, 100, 100, "Create User");
		uPos = new PVector(10,30);
		pPos = new PVector(10,80);
		cpPos = new PVector(10,120);
		user = new TextInput(sketch, x+uPos.x,gy+uPos.y, width-20);
		pass = new TextInput(sketch, x+pPos.x,gy+pPos.y, width-20);
		conpass = new TextInput(sketch, x+cpPos.x,gy+cpPos.y, width-20);
		
		crPos = new PVector(10,150);
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
		sketch.rect(x+crPos.x, gy+crPos.y, width-20, 20);
		sketch.fill(0);
		sketch.text("Username", x+10, gy+20);
		sketch.text("Password", x+10, gy+70);
		sketch.text("Confirm password", x+10, gy+112);
		sketch.text("Create", x+(width/2-sketch.textWidth("Create")/2), (float) (gy+18+crPos.y));
		sketch.fill(255);
		user.update();
		pass.update();
		conpass.update();
		
		if(sketch.mouseX>x+crPos.x && sketch.mouseX>x+crPos.x+(width-20) && sketch.mouseY>gy+crPos.y && sketch.mouseY<gy+crPos.y+20){
			System.out.println("Create user button pressed");
			if(pass.getValue().equals(conpass.getValue())){
				System.out.println("Both passes match");
				EncryptionUtils.createUser(sketch, user.getValue(), pass.getValue());
			}
		}
		
		sketch.rect(x+crPos.x,gy + crPos.y+width-20, width-20, 20);
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

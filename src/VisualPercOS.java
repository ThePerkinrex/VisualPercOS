// 2/3/17 - 280 lines of code

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.percot.helpers.Button;

import defaultApps.Calculator;
import defaultApps.CreateUser;
import processing.core.PApplet;
import processing.core.PImage;
import window.uiUtils.TextInput;

public class VisualPercOS extends PApplet{
	
	private int state;
	
	private PImage bg;
	private PImage logo;
	
	private String user;
	@SuppressWarnings("unused")
	private int userIndex;
	
	private TextInput userInput;
	private TextInput passInput;
	
	private Calculator test;
	private CreateUser creUs;
	
	private String topApp;
	
	private BufferedReader uPF;
	private ArrayList<String> users;
	private ArrayList<String> passes;
	private ArrayList<String> perms;

	public static void main(String[] args) {
		main("VisualPercOS");
	}
	
	public void settings(){
		size(1280,720);
		smooth();
	}
	
	public void setup(){
		state = 0;
		
		bg = loadImage("http://hghazni.com/v2/img/flat_mountain_bg.jpg");
		if(bg == null){
			exit();
		}
		logo = loadImage("SimpleVisualPercOSLogo.png");
		
		test = new Calculator(this);
		
		creUs = new CreateUser(this);
		
		topApp = creUs.toString();
		
		uPF = createReader("usrPass.prc");
		
		users = new ArrayList<String>();
		passes = new ArrayList<String>();
		perms = new ArrayList<String>();
		
		userInput = new TextInput(this, 100, 100, 100);
		passInput = new TextInput(this, 100, 130, 100);
		
		while (true){
			String line[];
			try {
				line = PApplet.split(uPF.readLine(),'-');
				System.out.println(line);
				if(line==null){
					break;
				}
				users.add(line[0]);
				passes.add(line[1]);
				perms.add(line[2]);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		
		user = users.get(0);
		
		test.setup();
	}
	
	public void draw(){
		// TODO Add login
		drawBg();
		if(state==0){
			//Introduction
			image(logo,width/2-200,height/2-200,400,400);
			if(frameCount>10){
				state=1;
			}
		}else if(state==1){
			//Login
			userInput.update();
			passInput.update();
			if(userInput.getValue().equals("Yo") && passInput.getValue().equals("Pass")){
				state=2;
			}
		}else if(state==2){
			//Main Loop
			drawMenuBar();

			test.update();
			
			creUs.update();
		}
	}
	
	public void mouseDragged(){
		if(topApp.equals(test.toString())){
		test.mouseDragged();
		}else if(topApp.equals(creUs.toString())){
		creUs.mouseDragged();
		}
	}
	
	public void keyTyped(){
		userInput.keyTyped();
		passInput.keyTyped();
		creUs.keyTyped();
	}
	
	private void drawBg(){
		image(bg, 0, 0, width, height);
	}
	
	private void drawMenuBar(){
		pushStyle();
		fill(255,255,255,125);
		noStroke();
		rect(0,0,width,20);
		fill(0);
		stroke(0);
		textSize(16);
		text(user, width-10-textWidth(user),17);
		textSize(14);
		image(logo,5,2,16,16);
		popStyle();
	}

}

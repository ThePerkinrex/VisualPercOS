package defaultApps;

import processing.core.PApplet;
import processing.core.PVector;
import window.Window;
import window.uiUtils.TextInput;

public class CreateUser extends Window {
	
	private TextInput user;
	private PVector uPos;

	public CreateUser(PApplet sketch) {
		super(sketch, 400, 600, 100, 100, "Create User");
		uPos = new PVector(10,10);
		user = new TextInput(sketch, x+uPos.x,gy+uPos.y, width-20);
	}

	@Override
	protected void updateApp() {
	}

	@Override
	protected void displayApp() {
		user.x = x+uPos.x;
		user.y = gy+uPos.y;
		sketch.rect(x,gy,width,height);
		user.update();
	}
	
	@Override
	public void setup() {
	}

}

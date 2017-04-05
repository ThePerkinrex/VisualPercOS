package testPercOSApp;

import processing.core.PApplet;
import window.Window;

public class TestPercOSApp extends Window {

	public TestPercOSApp(PApplet sketch) {
		super(sketch, 400, 400, 100, 100, "Test");
	}

	@Override
	protected void updateApp() {
		//For non graphic updates
	}

	@Override
	protected void displayApp() {
		//For display updates also
	}

	@Override
	public void setup() {
		//First time the OS runs
	}
	
	

}

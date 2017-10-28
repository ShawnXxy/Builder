package pattern.factory.shape;

import java.awt.Button;

class Application {
	private final GUIFactory factory;
	
	Application (GUIFactory f) {
		this.factory = f;
	}
	
	void run() { // input: the GUIFactory factory used to create buttons
		Button button = factory.createButton();
		button.paint();
	}
}

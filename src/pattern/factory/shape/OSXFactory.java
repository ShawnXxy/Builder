package pattern.factory.shape;

class OSXFactory implements GUIFactory {
	
	public Button createButton() {
		return new MacButton(); // suppose MacButton is a derived class of Button
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

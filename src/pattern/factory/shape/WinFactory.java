package pattern.factory.shape;

class WinFactory  implements GUIFactory {
	
	public Button createButton(); {
		return new WindowsButton(0); // suppose WindowsButton is a derived class of Button
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

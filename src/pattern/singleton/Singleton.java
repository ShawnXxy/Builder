package pattern.singleton;

public class Singleton {
	
	private static final Singleton INSTANCE = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return INSTANCE;
	}
	
	public void print() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton.getInstance().print();
	}

}



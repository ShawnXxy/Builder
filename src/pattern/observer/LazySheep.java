package pattern.observer;

public class LazySheep implements Observer {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Lazie";
	}

	@Override
	public void update(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Lazie is notified: " + msg);
	}

}

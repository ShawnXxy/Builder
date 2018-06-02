package pattern.observer;

public class HappySheep implements Observer{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Happy";
	}

	@Override
	public void update(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Happy is notified: " + msg);
	}

}

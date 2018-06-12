package pattern.templateMethod;

public class Password extends ShareBike {

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		System.out.println("Use password to unlock");
	}

	@Override
	public void ride() {
		// TODO Auto-generated method stub
		System.out.println("Ready to ride");
	}

	@Override
	public void lock() {
		// TODO Auto-generated method stub
		System.out.println("Use password to lock");
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Please pay");
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		unlock();
		ride();
		lock();
		pay();
	}

}

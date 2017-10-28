package observer.wolfNsheep;

public class Wolf extends Subject {
	
	public void invade() {
		System.out.println("Wolf: I am coming to you!");
		notifyObserver();
	}
}

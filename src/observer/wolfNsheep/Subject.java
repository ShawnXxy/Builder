package observer.wolfNsheep;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	/**
	 * 	Set for all observers
	 * @param args
	 */
	private List<Observer> observerList = new ArrayList<>();
	
	/**
	 * 	Register observers
	 * @param lazySheep
	 */
	public void attach(observer.wolfNsheep.Observer lazySheep) {
		observerList.add(lazySheep);
		System.out.println("New observer added: " + lazySheep.getName());
	}

	/**
	 * 	 Remove observers
	 * @param args
	 */
	public void dettach(observer.wolfNsheep.Observer happySheep) {
		observerList.remove(happySheep);
		System.out.println("Observer removed: " +  happySheep.getName());
	}
	
	/**
	 * 	Notification for all observers
	 * @param args
	 */
	public void notifyObserver() {
		for (Observer observer : observerList) {
			observer.update("Wolf is coming!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

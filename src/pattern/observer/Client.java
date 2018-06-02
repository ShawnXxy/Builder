package pattern.observer;

public class Client {

	public static void main(String[] args) {
		Wolf wolf = new Wolf();
		
		Observer happySheep = new HappySheep();
		wolf.attach(happySheep);
		
		Observer lazySheep = new LazySheep();
		wolf.attach(lazySheep);
		
		wolf.invade();
		
//		wolf.dettach(happySheep);
//		wolf.invade();
	}
}

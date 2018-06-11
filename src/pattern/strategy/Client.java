package pattern.strategy;

public class Client {

	public static void main(String[] args) {
		Context context = new Context(new StrategicB());
		context.contextInterface();
	}
}

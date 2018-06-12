package pattern.templateMethod;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scan scan = new Scan();
		scan.use();
		
		Password psw = new Password();
		psw.use();
	}

}

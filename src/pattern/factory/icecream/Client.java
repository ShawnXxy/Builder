package pattern.factory.icecream;

public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Factory iceCreamFactory = new IceCreamFactory();
        Product iceCream = iceCreamFactory.factory();
        iceCream.product();
    }

}

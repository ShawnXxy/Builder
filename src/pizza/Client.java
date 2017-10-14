package pizza;

public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Factory pizzaFactory = new PizzaFactory();
        Product pizza = pizzaFactory.factory();
        pizza.product();
    }

}

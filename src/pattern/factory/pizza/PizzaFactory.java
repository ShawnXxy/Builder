package pattern.factory.pizza;

public class PizzaFactory implements Factory {
    @Override
    public Product factory() {
        return new Pizza();
    }
}

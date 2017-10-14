package icecream;

public class IceCreamFactory implements Factory {

    @Override
    public Product factory() {
        // TODO Auto-generated method stub
        return new IceCream();
    }

   
}

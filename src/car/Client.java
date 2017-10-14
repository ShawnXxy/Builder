package car;

public class Client {
    
    public static void main(String[] args) {
        
        IBuilder builderA = new BuilderA();
        Director directorA = new Director(builderA);
        directorA.construct();
    }
}

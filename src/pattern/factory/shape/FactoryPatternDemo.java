package pattern.factory.shape;

public class FactoryPatternDemo {
	
	private final ShapeFactory shapeFactory = new ShapeFactory();
	
	public void demo (String[] args) {
		// get an object of Circl and call its draw method
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		// call draw method of Circle
		shape1.draw();
		
		// get an object of Rectangle and call its draw method
		Shape shape2 = shapeFactory.getShape("RENCTANGE");
		// call draw method of Rectangle
		shape2.draw();
		
		// get an object of Square and call its draw method
		Shape shape3 = shapeFactory.getShape("SQUARE");
		// call draw method of Square
		shape3.draw();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

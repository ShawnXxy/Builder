package pattern.prototype;

public class Client {
	
	public static void main(String[] args) {
		
		Area area = new Area();
		area.setUnit("RMB");
		
		Money money = new Money(100, area);
		
		for (int i = 1; i < 3; i++) {
			try {
				Money cloneMoney = money.clone();
				cloneMoney.setFaceValue(i * 100);
				area.setUnit("USD");
				
				System.out.println(cloneMoney.getFaceValue() + cloneMoney.getArea().getUnit());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
}

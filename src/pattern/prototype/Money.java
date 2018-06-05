package pattern.prototype;

import java.io.Serializable;

public class Money implements Cloneable, Serializable { // deep copy implements Serializable
	
	private int faceValue;
	
	private Area area;
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public Money(int faceValue, Area area) {
		this.faceValue = faceValue;
		this.area = area;
	}
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	@Override
	protected Money clone() throws CloneNotSupportedException {
		// deep copy
		Money cloneMoney = (Money) super.clone();
		cloneMoney.area = this.area.clone();
		return cloneMoney;
		
		// shallow copy
		// return (Money) super.clone();
	}
}

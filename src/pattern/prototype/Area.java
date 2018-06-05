package pattern.prototype;

public class Area implements Cloneable { // deep copy implements Cloneable
	
	private String unit;
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	// deep copy
	@Override
	protected Area clone() throws CloneNotSupportedException {
		Area cloneArea;
		cloneArea = (Area) super.clone();
		return cloneArea;
	}
}

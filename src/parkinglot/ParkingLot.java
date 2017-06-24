package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private final Level[] levels;
	
	public ParkingLot (int numLevels, int numSpotsPerLevel) {
		levels = new Level[numLevels];
		for (int i = 0; i < numLevels; i++) {
			levels[i] = new Level(numSpotsPerLevel);
		}
	}
	
	public boolean hasSpot(Vehicle v) {
		for (Level l: levels) {
			if (l.hasSpot(v)) {
				return true;
			}
		}
		return false;
	}
	public boolean park (Vehicle v) {
		for (Level l: levels) {
			if (l.park(v)) {
				return true;
			}
		}
		return false;
	}
	public boolean leave (Vehicle v) {
		for (Level l: levels) {
			if (l.leave(v)) {
				return true;
			}
		}
		return false;
	}
}

class Test {
	public static void main (String[] args) {
		ParkingLot lot = new ParkingLot(4, 10);
		List<Vehicle> list = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			final Vehicle v = i % 2 == 0 ? new Car() : new Truck();
			list.add(v);
			boolean hasSpot = lot.hasSpot(v);
			if (i < 40) {
				// make sure you enable assert if using for test
				assert hasSpot;
				assert lot.park(v);
			} else {
				assert !hasSpot;
				assert !lot.park(v);
			}
		}
		assert list.size() == 50;
		int i = 0;
		for (Vehicle v: list) {
			assert i >= 40 || lot.leave(v);
			i++;
		}
	}
}

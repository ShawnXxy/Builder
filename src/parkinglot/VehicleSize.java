package parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum VehicleSize {
	Compact(1);
	Large(2);
	
	private final int size;
	
	VehicleSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
}



class ParkingSpot {
	private final VehicleSize size;
	private Vehicle currentVehicle;
	
	ParkingSpot (VehicleSize size) {
		this.size = size;
	}
	
	boolean fit (Vehicle v) {
		return currentVehicle == null && size.getSize() >= v.getSize().getSize(); // ?????????????????
	}
	
	// record a vehicle is parked in by updating the currentVehicle field
	void park (Vehicle v) {
		currentVehicle = v;
	}
	void leave() {
		currentVehicle = null;
	}
	
	Vehicle getVehicle() {
		return currentVehicle;
	}
}

class Level {
	private final List<ParkingSpot> spots;
	
	Level (int numOfSpots) {
		List<ParkingSpot> list = new ArrayList<>();
//		int i = 0;
		for (int i = 0; i < numOfSpots; i++) {
			list.add(new ParkingSpot(VehicleSize.Compact));
		}
		for (int i = 0; i < numOfSpots; i++) {
			list.add(new ParkingSpot(VehicleSize.Large));
		}
		spots = Collections.unmodifiableList(list);
	}
	
	boolean hasSpot (Vehicle v) {
		for (ParkingSpot s: spots) {
			if (s.fit(v)) {
				return true;
			}
		}
		return false;
	}
	boolean park (Vehicle v) {
		for (ParkingSpot s: spots) {
			if (s.fit(v)) {
				s.park(v);
				return true;
			}
		}
		return false;
	}
	boolean leave (Vehicle v) {
		for (ParkingSpot s: spots) {
			if (s.getVehicle() == v) {
				s.leave();
				return true;
			}
		}
		return false;
	}
}



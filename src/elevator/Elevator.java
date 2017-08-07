package elevator;

import java.util.Queue;

public class Elevator {
	public static final int DEFAULT_ELEVATOR_MAX_CAPACITY = 14;
	public static final int DEFAULT_ELEVATOR_MAX_FLOOR = 10;
	public static final int DEFAULT_INITIAL_LOCATION = 1;

	// Maximum capacity of this elevator
	private final int maxCapacity;
	// how many floors in this simulation
	private final int maxFloor;
	// current load of the elevator
	private int load;
	// current location of the elevator
	private int location;
	// current direction of the elevator
	private boolean isGoingUp;

	// all requests loaded onto this elevator
	private int[] requests;

	public Elevator(int maxCapacity, int maxFloor) {
		this.maxCapacity = maxCapacity;
		this.maxFloor = maxFloor;
		load = 0;
		location = DEFAULT_INITIAL_LOCATION;
		isGoingUp = true;
		requests = new int[maxFloor];
	}

	public Elevator() {
		this(DEFAULT_ELEVATOR_MAX_CAPACITY, DEFAULT_ELEVATOR_MAX_FLOOR);
	}

	// returns true if the elevator's load is 0, otherwise false
	public boolean isEmpty() {
		return load == 0;
	}

	// returns true if load == max, otherwise false
	public boolean isFull() {
		return load >= maxCapacity;
	}

	// returns the current location of the elevator
	public int getLocation() {
		return location;
	}

	// change the elevator's location by on floor according to the direction,
	// return new location
	public int move() {
		if (isGoingUp) {
			return (location + 1 <= maxFloor) ? ++location : location;
		} else {
			return (location - 1 >= 0) ? --location : location;
		}
	}

	// reverse direction
	public boolean changeMovingDirection() {
		isGoingUp = !isGoingUp;
		return isGoingUp;
	}

	// if the elevator has enough capacity, load all requests in the given queue
	public int load(Queue<Integer> curQueue) {
		int numNewLoad = curQueue.size();
		if (load + numNewLoad > maxCapacity) {
			return 0;
		}
		for (int requestedFloor : curQueue) {
			requests[requestedFloor - 1] += 1;
		}
		load += numNewLoad;
		curQueue.clear();
		return numNewLoad;
	}

	// unload all requests on the floor the elevator is currently on
	public int unload() {
		int numRequests = requests[location - 1];
		if (numRequests > 0) {
			load -= numRequests;
			requests[location - 1] = 0;
			return numRequests;
		}
		return 0;
	}
}

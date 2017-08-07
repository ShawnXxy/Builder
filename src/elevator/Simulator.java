package elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Simulator {
	// how many floors we are simulating
	private final int floors;
	// all user requests
	private List<Queue<Integer>> requests;
	// all elevators in the system
	private List<Elevator> elevators;
	// current elevator scheduler we use
	private Scheduler scheduler;

	public Simulator(int floors, int numElevators, Scheduler scheduler, List<Queue<Integer>> initialRequests,
			int elevatorCapacity) {
		this.floors = floors;
		this.scheduler = scheduler;
		requests = initialRequests;
		elevators = new ArrayList<Elevator>();
		for (int i = 0; i < numElevators; i++) {
			Elevator ele = new Elevator(elevatorCapacity, floors);
			elevators.add(ele);
		}
	}

	private void generateRequest() {

	}

	private void schedule() {
		scheduler.schedule(requests, elevators, floors);
	}

	private void elevatorOp() {
		for (Elevator e : elevators) {
			if (!e.isEmpty()) {
				e.unload();
			}
			if (!e.isFull()) {
				int location = e.getLocation();
				e.load(requests.get(location - 1));
			}
			e.move();
		}
	}

	// handle to start the simulation
	public void simulate(int steps) throws InterruptedException {
		for (int i = 0; i < steps; i++) {
			generateRequest();
			schedule();
			elevatorOp();
			Thread.sleep(10);
		}
	}

	// entry point of the simulation program
	public static void main(String[] args) throws InterruptedException {
		SimpleScheduler scheduler = new SimpleScheduler();
		int floors = 10;
		int numElevators = 1;
		List<Queue<Integer>> initialRequests = new ArrayList<>();
		for (int i = 0; i < floors; i++) {
			Queue<Integer> curQueue = new LinkedList<>();
			Random generator = new Random();
			int req = generator.nextInt(10);
			curQueue.offer(req);
			initialRequests.add(curQueue);
		}
		Simulator mySimulator = new Simulator(floors, numElevators, scheduler, initialRequests, 14);
		mySimulator.simulate(10);
	}

	private static class SimpleScheduler implements Scheduler {

		@Override
		public void schedule(List<Queue<Integer>> request, List<Elevator> elevators, int floors) {
			// TODO Auto-generated method stub
			for (Elevator e : elevators) {
				if (e.getLocation() == 0 || e.getLocation() == floors) {
					e.changeMovingDirection();
				}
			}
		}

	}
}

package elevator;

import java.util.List;
import java.util.Queue;

public interface Scheduler {
	// given the state of the system, update elevator states
	void schedule(List<Queue<Integer>> request, List<Elevator> elevators, int floors);
}

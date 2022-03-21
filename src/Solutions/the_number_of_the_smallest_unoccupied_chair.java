package Solutions;
import java.util.Comparator;
import java.util.PriorityQueue;


public class the_number_of_the_smallest_unoccupied_chair {
	public int smallestChair(int[][] times, int targetFriend) {
		// PriorityQueue<Pair<Integer, Integer>> arrives = new PriorityQueue<>((a, b)->a.getValue() - b.getValue());
		// PriorityQueue<Pair<Integer, Integer>> arrives = new PriorityQueue<>((a, b)->a.getKey() - b.getKey());
		// PriorityQueue<Pair> arrives = new PriorityQueue<>();
		PriorityQueue<int[]> arrives = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		// PriorityQueue<Pair> leaves = new PriorityQueue<>();
		int chairs = 0;
		for (int i = 0; i < times.length; ++i) {
			// arrives.add(new Pair(i, times[i][0]));
			arrives.offer(new int[]{i, times[i][0]});
			// arrives.add(new Pair<Integer, Integer>(times[i][0], i));
		}

//		int a = 0;
		// while (arrives.peek().seatNo != targetFriend) {
		//     int friend = arrives.poll().seatNo;
		//     leaves.add(new Pair(friend, times[friend][1]));
		//     chairs += 1;
		// }
		// leaves.add(new Pair(targetFriend, times[targetFriend][1]));

		// while (leaves.poll().seatNo != targetFriend) {
		//     chairs -= 1;
		// }

		return chairs;
	}

	class Pair implements Comparable<Pair> {
		int seatNo;
		int leavingTime;

		Pair(int seatNo, int leavingTime){
			this.seatNo = seatNo;
			this.leavingTime = leavingTime;
		}

		public int compareTo(Pair o){
			return this.leavingTime - o.leavingTime;
		}
	}

	public static void main(String[] args) {
		// Create a new Solution instance
		the_number_of_the_smallest_unoccupied_chair solution = new the_number_of_the_smallest_unoccupied_chair();
		// Create a test case
		int[][] times = {{3,10},{1,5},{2,6}};
		int targetFriend = 0;
		// Get the answer
		int answer = solution.smallestChair(times, targetFriend);
		// Print the answer
		System.out.println(answer);
	}
}
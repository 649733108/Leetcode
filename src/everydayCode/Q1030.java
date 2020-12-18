package everydayCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wxn
 * 2020/11/17 21:50
 */


public class Q1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int d1 = Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0);
				int d2 = Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0);
				return d1-d2;
			}
		});
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				queue.add(new int[]{r,c});
			}
		}
		int[][] ret = new int[R*C][];
		for (int i = 0; i < R * C; i++) {
			ret[i] = queue.poll();
		}
		return ret;
	}

	public static void main(String[] args) {
		new Q1030().allCellsDistOrder(2, 2, 0, 1);
	}
}

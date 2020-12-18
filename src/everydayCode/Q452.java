package everydayCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wxn
 * 2020/11/23 19:08
 */


public class Q452 {

	public int findMinArrowShots(int[][] points) {

		if (points.length<=1){
			return points.length;
		}

		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1],o2[1]);
			}
		});
		int x = points[0][1];
		int ret = 1;
		for (int i = 1; i < points.length; i++) {
			if (points[i][0]>x){
				ret++;
				x = points[i][1];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		System.out.println(new Q452().findMinArrowShots(points));
	}
}

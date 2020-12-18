package everydayCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wxn
 * 2020/11/16 21:37
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Q406 {

	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if (p1[0]!=p2[0]){
					return p2[0]-p1[0];
				}else {
					return p1[1]-p2[1];
				}
			}
		});

		List<int[]> list = new ArrayList<>();
		for (int[] person : people) {
			list.add(person[1],person);
		}
		return list.toArray(people);
	}
}

import javafx.util.Pair;

import java.util.*;

/**
 * Created by wxn
 * 2019/6/27 18:34
 * <p>
 * 347. 前K个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */


public class Solution347 {

	public List<Integer> topKFrequent(int[] nums, int k) {


		//统计每个元素出现的频率
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		//扫描map 维护当前出现频率最高的k个元素
		//在优先队列中,按照频率排序,所以数据对是(频率,元素)的形式
		Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.getKey() < o2.getKey())
				return -1;
			else if (o1.getKey().equals(o2.getKey()))
				return 0;
			if (o1.getKey() > o2.getKey())
				return 1;
			return 0;
		});

		for (Integer num : map.keySet()) {
			int freq = map.get(num);
			if (pq.size()==k){
				Pair<Integer, Integer> pair = pq.peek();
				if (pair.getKey()<freq){
					pq.remove();
					pq.add(new Pair<>(freq, num));
				}
			}else {
				pq.add(new Pair<>(freq, num));
			}
		}

		List<Integer> res = new ArrayList<>();
		while (!pq.isEmpty()) {
			res.add(pq.remove().getValue());
		}
		return res;
	}
}

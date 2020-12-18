package everydayCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2020/12/4 20:55
 */


public class Q659 {

	public boolean isPossible(int[] nums){
		Map<Integer,Integer> countMap = new HashMap<>();
		Map<Integer,Integer> endMap = new HashMap<>();
		for (int num : nums) {
			int count = countMap.getOrDefault(num, 0);
			countMap.put(num,count+1);
		}
		for (int num : nums) {
			int count = countMap.getOrDefault(num,0);
			if (count>0){
				int prevEndCount = endMap.getOrDefault(num-1,0);
				if (prevEndCount>0){
					countMap.put(num,count-1);
					endMap.put(num-1, prevEndCount-1);
					endMap.put(num, endMap.getOrDefault(num, 0)+1);
				}else {
					int count1 = countMap.getOrDefault(num+1, 0);
					int count2 = countMap.getOrDefault(num+2, 0);
					if (count1>0 && count2>0){
						countMap.put(num, count-1);
						countMap.put(num+1, count1-1);
						countMap.put(num+2, count2-1);
						endMap.put(num+2, endMap.getOrDefault(num+2, 0)+1);
					}else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,3,3,4,4,5,5};
		System.out.println(new Q659().isPossible(nums));
	}

}

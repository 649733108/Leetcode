package everydayCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wxn
 * 2020/11/3 10:16
 */


public class Q349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums1) {
			set.add(i);
		}
		Set<Integer> retSet = new HashSet<>();
		for (int i : nums2) {
			if (set.contains(i)){
				retSet.add(i);
			}
		}
		int[]ret = new int[retSet.size()];
		int i = 0;
		for (Integer integer : retSet) {
			ret[i] = integer;
			i++;
		}
		return ret;
	}
}

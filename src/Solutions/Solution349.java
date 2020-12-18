package Solutions;
/*
 * Created by wxn
 * 2019/3/19 20:59
 */

import java.util.*;

/**
 * 349.两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Solution349 {

    public int[] intersection(int[] nums1, int[] nums2) {
	Set<Integer> set = new HashSet<>();

	for (int i : nums1) {
	    set.add(i);
	}

	List<Integer>list = new ArrayList<>();
	for (int i : nums2) {
	    if (set.contains(i)){
	        set.remove(i);
	        list.add(i);
	    }
	}
	int[] ret = new int[list.size()];
	int index = 0;
	for (Integer integer : list) {
	    ret[index++] = integer;
	}
	return ret;
    }
}

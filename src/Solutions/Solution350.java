package Solutions;
/*
 * Created by wxn
 * 2019/3/19 21:32
 */

import java.util.*;

/**
 * 350.两个数组的交集 II
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Solution350 {

    public int[] intersect2(int[] nums1, int[] nums2) {

	Map<Integer, Integer> map = new HashMap<>();
	for (int i : nums1) {
	    if (!map.containsKey(i)) {
		map.put(i, 1);
	    } else {
		map.put(i, map.get(i) + 1);
	    }
	}
	List<Integer> list = new ArrayList<>();
	for (int i : nums2) {
	    if (map.get(i) != null && map.get(i) > 0) {
		list.add(i);
		map.put(i, map.get(i) - 1);
	    }
	}
	int[] ret = new int[list.size()];
	int count = 0;
	for (Integer integer : list) {
	    ret[count++] = integer;
	}
	return ret;

    }

    public int[] intersect(int[] nums1, int[] nums2){
	Arrays.sort(nums1);
	Arrays.sort(nums2);
        return intersect1(nums1,nums2);
    }

    //如果给定的数组是有序的
    private int[] intersect1(int[] nums1, int[] nums2) {

	int i = 0;
	int j = 0;
	List<Integer> list = new ArrayList<>();
	while (i < nums1.length && j < nums2.length) {
            if (nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
		j++;
	    }else if (nums1[i]<nums2[j]){
                i++;
	    }else {
                j++;
	    }
	}
	int[] ret = new int[list.size()];
	int count = 0;
	for (Integer integer : list) {
	    ret[count++] = integer;
	}
	return ret;
    }


}

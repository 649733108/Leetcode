
/*
 * Created by wxn
 * 2019/3/25 21:46
 */

import java.util.*;

/**
 * 15.3sum
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution15 {

    //1.暴力法
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>ret = new ArrayList<>();

        int length = nums.length;
	for (int i = 0; i < length; i++) {
	    for (int j = i+1; j < length; j++) {
		for (int k = j+1; k < length; k++) {
		    if (nums[i] + nums[j] + nums[k] == 0) {
		        List<Integer> temp = new ArrayList<>();
			temp.add(nums[i]);
			temp.add(nums[j]);
			temp.add(nums[k]);
			if (!contains(ret,temp)){
			    ret.add(temp);
			}
		    }
		}
	    }
	}
	return ret;
    }

    //判断ret中是否包含temp
    private boolean contains(List<List<Integer>> ret, List<Integer> temp) {

	for (List<Integer> list : ret) {
	    if (isSame(list,temp)){
	        return true;
	    }
	}
	return false;
    }

    //判断两个list是否相同
    private boolean isSame(List<Integer> list, List<Integer> temp) {
        if (list.size()!=temp.size()){
            return false;
	}
	Collections.sort(list);
        Collections.sort(temp);
	for (int i = 0; i < list.size(); i++) {
	    if (!list.get(i).equals(temp.get(i))){
	        return false;
	    }
	}
	return true;
    }

    //2.用set解决重复的问题
    public List<List<Integer>> threeSum2(int[] nums){
	List<List<Integer>>ret = new ArrayList<>();
	Set<List<Integer>> set = new HashSet<>();
	int length = nums.length;
	for (int i = 0; i < length; i++) {
	    for (int j = i+1; j < length; j++) {
		for (int k = j+1; k < length; k++) {
		    if (nums[i] + nums[j] + nums[k] == 0) {
			List<Integer> temp = new ArrayList<>();
			temp.add(nums[i]);
			temp.add(nums[j]);
			temp.add(nums[k]);
			Collections.sort(temp);
			if (!set.contains(temp)){
			    set.add(temp);
			    ret.add(temp);
			}
		    }
		}
	    }
	}
	return ret;
    }

    //解法3
    public List<List<Integer>> threeSum3(int[] nums) {

	List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
	    if (i == 0 || nums[i] != nums[i - 1]) {
	        int left = i+1 ;
	        int right = nums.length-1;
	        int sum = 0-nums[i];
	        while (left<right){
	            if (nums[left]+nums[right]==sum){
			ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
			while (left<right && nums[left+1]==nums[left]){
			    left++;
			}
			while (left<right && nums[right-1]==nums[right]){
			    right--;
			}
			left++;
			right--;
		    }else if (nums[left]+nums[right]<sum){
	                left++;
		    }else {
	                right--;
		    }
		}
	    }
	}
	return ret;
    }


    public static void main(String args[]) {
	System.out.println(new Solution15().threeSum3(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}

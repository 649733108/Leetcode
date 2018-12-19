
/*
 * Created by wxn
 * 2018/12/19 20:28
 */

/**
 * 26.从排序数组中删除重复项
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution26 {

    //解法1 暴力两重循环
    public int removeDuplicates(int[] nums) {
	int n = nums.length;
	for (int i = 1; i < n; i++) {
	    while (nums[i] == nums[i - 1]) {
		if (i==n-1){
		    n--;
		    break;
		}
		for (int j = i; j < n; j++) {
		    if (j != n - 1)
			nums[j] = nums[j + 1];
		}
		n--;


	    }
	}
	return n;
    }

    //解法2 两个游标,一次循环
    public int removeDuplicates2(int[] nums){
        int i = 0;
        for (int j = 1 ; j<nums.length;j++){
            if (nums[j]!=nums[i]){
                nums[++i] = nums[j];
	    }
	}
	return i+1;
    }

    public static void main(String args[]) {
	int[] nums = {0,0,1,1,1,2,2,3,3,4};
	int n = new Solution26().removeDuplicates2(nums);

//	for (int i = 0; i < nums.length; i++) {
//	    System.out.print(nums[i]+ " ");
//	}
	System.out.println(n);
    }

}


/*
 * Created by wxn
 * 2018/12/20 22:03
 */

/**
 * 283.移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Solution283 {

    //解法1 设置一个指针i指示当前非0元素应该放的位置
    //从头遍历数组 每扫描到一个非0元素 将这个元素放i的位置,i++
    //最后将0补齐
    public void moveZeroes(int[] nums) {

        int i = 0;
	for (int j = 0; j < nums.length; j++) {
	    if (nums[j]!=0){
	        nums[i++] = nums[j];
	    }
	}
	for (;i<nums.length;i++){
	    nums[i] = 0;
	}
    }

    //解法2 将非0元素与i位置的元素交换 i++
    public void moveZeroes2(int[] nums){
	int i = 0;
	for (int j = 0; j < nums.length; j++) {
	    if (nums[j]!=0){
		swap(nums,i,j);
		i++;
	    }
	}
    }

    private void swap(int[] nums,int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
    }

}

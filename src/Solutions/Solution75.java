package Solutions;
/*
 * Created by wxn
 * 2018/12/24 23:05
 */


/**
 * 75.颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Solution75 {

    //解法1. 计数排序
    public void sortColors(int[] nums) {
	int red = 0;
	int white = 0;
	int blue = 0;
	for (int num : nums) {
	    switch (num) {
		case 0:
		    red++;
		    break;
		case 1:
		    white++;
		    break;
		case 2:
		    blue++;
		    break;
	    }
	}
	for (int i = 0; i < nums.length; i++) {
	    if (red != 0) {
		nums[i] = 0;
		red--;
	    } else if (white != 0) {
		nums[i] = 1;
		white--;
	    } else {
		nums[i] = 2;
		blue--;
	    }
	}
    }

    //解法2. 利用三路快排
    public void sortColors2(int[] nums) {
	int zero = -1 ; 	//nums[0...zero]=0
	int two = nums.length;	//nums[two...nums.length-1]=2
	for (int i = 0 ; i<two ;){
	    if (nums[i]==1){
	        i++;
	    }else if (nums[i]==0){
	        zero++;
		swap(nums,zero,i);
		i++;
	    }else {
	        two--;
	        swap(nums,two,i);
	    }
	}
    }

    private void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
    }

    public static void main(String args[]) {
	int[] arr = {2,0,2,1,1,0};
	new Solution75().sortColors2(arr);
    }

}

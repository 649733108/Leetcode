package Solutions;
/*
 * Created by wxn
 * 2018/12/20 22:45
 */


/**
 * 27.移除元素
 * <p>
 * 给定一个数组 nums 和一个值 val，你需要**原地**移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * >示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * >示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution27 {

    //解法1
    public int removeElement(int[] nums, int val) {

	int n = nums.length;
	int k = n - 1;
	for (int i = 0; i < n; i++) {
	    if (nums[i] == val) {
		while (k >= 0 && nums[k] == val) {
		    k--;
		    n--;
		}
		if (k>=i){
		    swap(nums,i,k);
		    k--;
		    n--;
		}
	    }
	}
	return n;
    }

    private void swap(int[] nums, int i, int k) {
	int temp = nums[i];
	nums[i] = nums[k];
	nums[k] = temp;
    }

    //解法2 我们只需要一个变量用来计数，然后遍历原数组，
    //如果当前的值和给定值不同，我们就把当前值覆盖计数变量的位置，并将计数变量加1。
    public int removeElement2(int[] nums, int val){
        int res = 0;
        for (int i = 0 ; i<nums.length;i++){
            if (nums[i]!=val){
                nums[res] = nums[i];
                res++;
	    }
	}
	return res;
    }

    public static void main(String args[]) {
	int[] nums = {4,5};
	int i = new Solution27().removeElement(nums, 5);
	System.out.println(i);

	    System.out.println("123");
    }



}

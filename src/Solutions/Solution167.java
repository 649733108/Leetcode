package Solutions;
/*
 * Created by wxn
 * 2018/12/25 18:54
 */


/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution167 {

    //解法1 暴力求解
    public int[] twoSum(int[] numbers, int target) {

        int[] indexes = new int[2];
	for (int i = 0; i < numbers.length-1; i++) {
	    for (int j = i+1; j<numbers.length;j++){
	        if (numbers[i]+numbers[j]==target){
	            indexes[0] = i+1;
	            indexes[1] = j+1;
	            return indexes;
		}
	    }
	}
	return indexes;
    }

    //解法2 二分搜索法
    public int[] twoSum2(int[] numbers, int target) {
	int[] indexes = new int[2];
	for (int i = 0; i < numbers.length-1; i++) {
	    int index2 = binarySearch(numbers,i+1,numbers.length-1,target-numbers[i]);
	    if (index2>-1){
	        indexes[0] = i+1;
	        indexes[1] = index2+1;
	        return indexes;
	    }
	}
	return indexes;

    }
    private int binarySearch(int[] nums , int l , int r , int target){
        if (l>=r){
            if (nums[l]==target){
                return l;
	    }else {
                return -1;
	    }
	}else {
            int mid = l+(r-l)/2;
            if (nums[mid]==target){
                return mid;
	    }else if (nums[mid]>target){
                return binarySearch(nums,l,mid-1,target);
	    }else {
                return binarySearch(nums,mid+1,r,target);
	    }
	}
    }

    //解法3 对撞指针
    public int[] twoSum3(int[] numbers, int target){
	int[] indexes = new int[2];
	int l = 0;
	int r = numbers.length-1;
	while (l<=r){
	    if (numbers[l]+numbers[r]==target){
	        indexes[0] = l+1;
	        indexes[1] = r+1;
	        return indexes;
	    }else if (numbers[l]+numbers[r]>target){
	        r--;
	    }else {
	        l++;
	    }
	}
	return indexes;
    }

    public static void main(String args[]) {
	int [] numbers = {12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
	int[] ints = new Solution167().twoSum3(numbers, 542);
    }

}

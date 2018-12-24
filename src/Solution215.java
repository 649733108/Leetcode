
/*
 * Created by wxn
 * 2018/12/25 0:59
 */



import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Solution215 {

    //解法1 快排
    public int findKthLargest(int[] nums, int k) {

	Arrays.sort(nums);
	//第k大就是第n-k+1小
	return nums[nums.length-k];
    }

    //解法2 最大堆
    class MaxHeap{
        int[] data;
        int count;
        int capacity;

        MaxHeap(int capacity){
            this.capacity = capacity;
            count = 0;
            data = new int[capacity+1];
	}

	boolean isEmpty(){
            return count==0;
	}

	void insert(int e){
            data[++count] = e;
            shiftUp(count);
	}
	int extract(){
            int ret = data[1];
            swap(1,count--);
            shiftDown(1);
            return ret;
	}
	private void shiftUp(int k){
            while (k/2>0){
                if (data[k]>data[k/2]){
                    swap(k,k/2);
                    k/=2;
		}else {
                    break;
		}
	    }
	}
	private void shiftDown(int k){
            while (k*2<=count){
                int j = k*2;
                if (j+1<=count && data[j+1]>data[j]){
                    j++;
		}
		if (data[j]>data[k]){
		    swap(k,j);
		    k=j;
		}else {
		    break;
		}
	    }
	}

	private void swap(int i, int j) {
	    int temp = data[i];
	    data[i] = data[j];
	    data[j] = temp;
	}
    }



    public int findKthLargest2(int[] nums, int k) {

	MaxHeap maxHeap = new MaxHeap(nums.length);
	for (int num : nums) {
	    maxHeap.insert(num);
	}
	int ret = 0;
	for (int i = 0; i < k; i++) {
	    ret = maxHeap.extract();
	}
	return ret;
    }

    //解法3 快排的思想 只需一次遍历
    public int findKthLargest3(int[] nums, int k) {
        int l = 0 ;
        int r = nums.length-1;
        int n = nums.length;
        while (true){
            int pos = partition(nums,l,r);
            if (pos==n-k){
                return nums[pos];
	    }else if (pos>n-k){
                r = pos-1;
	    }else {
                l = pos+1;
	    }
	}
    }



    private int partition(int[] nums , int l , int r){
        int pivot = nums[l];
        int i = l+1;
        int j = r;
        while (i<=j){
            while (i<=r && nums[i]<=pivot){
                i++;
	    }
	    while (j>=l+1 && nums[j]>=pivot){
	        j--;
	    }
	    if (i>j){
	        break;
	    }
	    swap(nums,i,j);
	    i++;
	    j--;
	}
	swap(nums,l,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //解法4 优先队列
    public int findKthLargest4(int[] nums, int k) {
	PriorityQueue<Integer>queue = new PriorityQueue<>();
	for (int i = 0; i < nums.length; i++) {
	    queue.add(nums[i]);
	}
	int ret = 0;
	for (int i = 0; i <= nums.length-k; i++) {
	    ret = queue.remove();
	}
	return ret;
    }


    public static void main(String args[]) {
	int[] nums = {3,2,3,1,2,4,5,5,6};
	System.out.println(new Solution215().findKthLargest4(nums,4));
    }

}

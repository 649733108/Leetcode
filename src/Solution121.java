
/*
 * Created by wxn
 * 2018/12/19 22:03
 */


/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Solution121 {

    //解法1 暴力法
    public int maxProfit(int[] prices) {
        int max = 0;
        int n = prices.length;
        for (int i = 0 ; i<n-1 ; i++){
	    for (int j = i+1; j < n; j++) {
		if (prices[j]-prices[i]>max){
		    max = prices[j]-prices[i];
		}
	    }
	}
	return max;
    }

    //解法2 遍历一遍数组,用一个变量记录当前遍历到的最小值
    //再将当前元素与最小值的差与记录的最大利润比较 取最大值
    public int maxProfit2(int[] prices) {
        if (prices.length<2)
            return 0;
        int max = 0;
        int min = prices[0];
	for (int i = 1; i < prices.length; i++) {
	    max = Math.max(max,prices[i]-min);
	    min = Math.min(min,prices[i]);
	}
	return max;
    }

    public static void main(String args[]) {
	int[] prices = {7,1,5,3,6,4};
	int max = new Solution121().maxProfit2(prices);
	System.out.println(max);
    }

}

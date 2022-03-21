package Solutions;

import java.util.Arrays;

/**
 * Created by wxn
 * 2019/6/19 9:57
 *
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 */


public class Solution66 {

	public int[] plusOne(int[] digits) {

		if (digits[digits.length-1]!=9){
			digits[digits.length-1]++;
			return digits;
		}else {
			//尾数为'9'
			boolean flag = true;//标识是否全为9
			for (int i = 0 ; i<digits.length ; i++){
				if (digits[i]!=9){
					flag = false;
				}
			}
			if (flag) {
				//全为9的情况
				int[] ret = new int[digits.length+1];
				ret[0] = 1;
				for (int i = 1 ; i<ret.length ; i++){
					ret[i] = 0;
				}
				return ret;
			}else {
				//尾数为9且不全为9
				boolean jinwei = true; //是否进位
				digits[digits.length-1] = 0;
				for (int i = digits.length-2 ; i>=0 ; i--){
					if (jinwei){
						if (digits[i]+1==10){
							digits[i]=0;
							jinwei = true;
						}else {
							digits[i]++;
							jinwei = false;
						}
					}else {
						break;
					}
				}
				return digits;
			}

		}
	}

	public int[] plusOne2(int[] digits) {
		//处理全9的情况
		if (isAllNine(digits)) {
			int[] ret = new int[digits.length+1];
			ret[0] = 1;
			return ret;
		}

		int[] ret = new int[digits.length];
		int jinwei = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + jinwei == 10) {
				ret[i] = 0;
			}else {
				ret[i] = digits[i]+jinwei;
				jinwei=0;
			}
		}
		return ret;
	}

	private boolean isAllNine(int[] digits) {
		for (int digit : digits) {
			if (digit != 9) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution66().plusOne2(new int[]{1,2,3})));
	}

}

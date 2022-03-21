package Solutions;

/**
 * Created by wxn
 * 2021/9/3 11:20
 * <p>
 * 371. 两整数之和
 * 不使用运算符 + 和 - ，计算两整数 a 、b之和 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 */


public class Solution371 {

	public int getSum(int a, int b) {
		while (b != 0) {
			int eor = a^b;
			b = (a&b)<<1;
			a = eor;
		}
		return a;
	}

	public static void main(String[] args) {
		Solution371 s = new Solution371();
		System.out.println(s.getSum(3, 5));
	}

}

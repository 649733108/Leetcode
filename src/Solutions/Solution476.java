package Solutions;

/**
 * Created by wxn
 * 2021/10/18 11:02
 *
 * 476. 数字的补数
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 *
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 *
 * 提示：
 *
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 */


public class Solution476 {

	public int findComplement(int num) {
		int n = 0;
		int copyNum = num;
		while (copyNum != 0) {
			copyNum/=2;
			n++;
		}


		return num^((1<<n)-1);
	}

	public static void main(String[] args) {
		Solution476 s = new Solution476();
		System.out.println(s.findComplement(5));
	}
}

package Solutions;

/**
 * Created by wxn
 * 2022/2/25 10:31
 *
 * 537. 复数乘法
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 *
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 *
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 *
 *
 * 提示：
 *
 * num1 和 num2 都是有效的复数表示。
 */


public class Solution537 {

	public String complexNumberMultiply(String num1, String num2) {

		int real1 = Integer.parseInt(num1.split("\\+")[0]);
		int virtual1 = Integer.parseInt(num1.split("\\+")[1].split("i")[0]);
		int real2 = Integer.parseInt(num2.split("\\+")[0]);
		int virtual2 = Integer.parseInt(num2.split("\\+")[1].split("i")[0]);

		int real3 = real1*real2 - virtual1*virtual2;
		int virtual3 = real1*virtual2 + real2*virtual1;

		System.out.println(real1);
		System.out.println(virtual1);
		System.out.println(real2);
		System.out.println(virtual2);

		return real3+"+"+virtual3+"i";
	}

	public static void main(String[] args) {
		Solution537 s = new Solution537();
		System.out.println(s.complexNumberMultiply("1+1i", "1+-1i"));
	}
}

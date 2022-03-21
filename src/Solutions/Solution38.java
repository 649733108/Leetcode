package Solutions;

/**
 * Created by wxn
 * 2019/6/26 14:43
 *
 * 38. 报数
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */


public class Solution38 {

	// 尝试用递归
	public String countAndSay(int n) {

		if (n == 1) {
			return "1";
		}
		String s = countAndSay(n-1);
		StringBuilder sb = new StringBuilder();
		char curChar = s.charAt(0);
		int curNum = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == curChar) {
				curNum++;
			}else {
				sb.append(curNum).append(curChar);
				curChar = s.charAt(i);
				curNum = 1;
			}
		}
		sb.append(curNum).append(curChar);
		return sb.toString();
	}



	public String countAndSay2(int n) {

		if (n == 1) {
			return "1";
		}

		String ret = "1";
		for (int i = 2; i <= n; i++) {
			int count = 1;
			StringBuilder sb = new StringBuilder();
			char temp = ret.charAt(0);
			for (int j = 1 ; j<ret.length() ; j++){
				char c = ret.charAt(j);
				if (c==temp){
					count++;
				}else {
					sb.append(count).append(temp);
					count = 1;
					temp = c;
				}
			}
			sb.append(count).append(temp);
			ret = sb.toString();
		}

		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new Solution38().countAndSay(5));
	}

}

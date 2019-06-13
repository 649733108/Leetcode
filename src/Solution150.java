import java.util.Stack;

/**
 * Created by wxn
 * 2019/6/12 22:01
 * <p>
 * 150. 逆波兰表达式求值
 * <p>
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */


public class Solution150 {

	public int evalRPN(String[] tokens) {

		Stack<String> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			if (isNum(s)) {
				stack.push(s);
			} else {
				switch (s) {
					case "+":
						stack.push(String.valueOf(Integer.parseInt(stack.pop())+Integer.parseInt(stack.pop())));
						break;
					case "-":
						int d = Integer.parseInt(stack.pop());
						int c = Integer.parseInt(stack.pop());
						stack.push(String.valueOf(c-d));
						break;
					case "*":
						stack.push(String.valueOf(Integer.parseInt(stack.pop())*Integer.parseInt(stack.pop())));
						break;
					case "/":
						int b = Integer.parseInt(stack.pop());
						int a = Integer.parseInt(stack.pop());
						stack.push(String.valueOf(a/b));
						break;
				}
			}
		}
		if (!stack.empty()) {
			return Integer.parseInt(stack.pop());
		}
		return 0;
	}

	private boolean isNum(String s) {
		if (s.charAt(0) == '-' && s.length() > 1 || s.charAt(0) >= '0' && s.charAt(0) <= '9') {
			int i = s.charAt(0) == '-' ? 1 : 0;
			for (; i < s.length(); i++) {
				if (s.charAt(i) < '0' || s.charAt(i) > '9') {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(new Solution150().evalRPN(tokens));
	}

}

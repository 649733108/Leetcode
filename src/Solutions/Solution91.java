package Solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2019/7/14 15:20
 * <p>
 * 91. 解码方法
 * <p>
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */


public class Solution91 {

	private static final Map<String, String> dictionary = new HashMap<>();
	private int res = 0;

	static {
		for (int i = 1; i <= 26; i++) {
			char c = (char) ('A' + i - 1);
			dictionary.put(String.valueOf(i), String.valueOf(c));
		}
	}

	//解法1 回溯法 (超时)
	public int numDecodings(String s) {

		numDecodings(s, 0);
		return res;
	}

	//从s的第index位置开始解码
	private void numDecodings(String s, int index) {
		if (index >= s.length()) {
			res++;
			return;
		}
		for (int i = 1; i <= 2 && index + i <= s.length(); i++) {
			String temp = s.substring(index, index + i);
			if (dictionary.containsKey(temp)) {
				numDecodings(s, index + i);
			}
		}
	}

	//解法2 递归法 (超时)
	public int numDecodings2(String s) {

		if (s.length() == 0) {
			return 1;
		}
		if (s.length() == 1) {
			if (dictionary.containsKey(s))
				return 1;
			else
				return 0;
		}

		String temp = s.substring(0, 2);
		if (dictionary.containsKey(temp)) {
			return numDecodings2(s.substring(1)) + numDecodings2(s.substring(2));
		} else {
			if (temp.charAt(0)=='0'){
				return 0;
			}
			return numDecodings2(s.substring(1));
		}
	}

	//解法3 记忆搜索法
	public int numDecodings3(String s){
		Map<String,Integer> map = new HashMap<>();
		return numDecodings3(s,map);
	}

	private int numDecodings3(String s, Map<String, Integer> map) {

		if (s.length() == 0) {
			return 1;
		}
		if (s.length() == 1) {
			if (dictionary.containsKey(s))
				return 1;
			else
				return 0;
		}

		if (!map.containsKey(s)) {
			String temp = s.substring(0, 2);
			if (dictionary.containsKey(temp)){
				map.put(s, numDecodings3(s.substring(1), map) + numDecodings3(s.substring(2), map));
			}else {
				if (temp.charAt(0)=='0'){
					map.put(s, 0);
				}else {
					map.put(s, numDecodings3(s.substring(1),map));
				}
			}
		}
		return map.get(s);
	}

	//解法4 动态规划
	public int numDecodings4(String s){
		if (s.length()==1){
			if (s.charAt(0)=='0'){
				return 0;
			}else {
				return 1;
			}
		}
		int n = s.length();
		//mem[i]表示s的第i个位置到最后表示的字符串可以解码的方法总数
		int[] mem = new int[n + 1];
		if (s.charAt(n-1)=='0'){
			mem[n] = 0;
		}else {
			mem[n] = 1;
		}
		if (s.charAt(n - 2) == '0') {
			mem[n-1] = 0;
		}else {
			String temp = s.substring(n-2 );
			if (dictionary.containsKey(temp)){
				mem[n-1] = mem[n]+1;
			}else {
				mem[n-1] = mem[n];
			}
		}

		for (int i = n - 3; i >= 0; i--) {
			String temp = s.substring(i, i+2);
			if (dictionary.containsKey(temp)){
				mem[i+1] = mem[i+2]+mem[i+3];
			}else {
				if (temp.charAt(0)=='0'){
					mem[i+1] = 0;
				}else {
					mem[i+1] = mem[i+2];
				}
			}
		}

		return mem[1];
	}

	public static void main(String args[]) {
		System.out.println(new Solution91().numDecodings4("10"));
	}

}

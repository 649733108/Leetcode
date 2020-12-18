package Solutions;

/**
 * Created by wxn
 * 2019/6/11 16:38
 * <p>
 * 28. 实现strStr()
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */


public class Solution28 {

	public int strStr(String haystack, String needle) {

		if (needle == null || needle.length() == 0) {
			return 0;
		}
		if (haystack == null || haystack.length() == 0 ||haystack.length()<needle.length()) {
			return -1;
		}
		for (int i = 0; i <= haystack.length()-needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = i;
				int k = 0;
				while (k < needle.length()) {
					if (j < haystack.length() && haystack.charAt(j) == needle.charAt(k)) {
						j++;
						k++;
					}else {
						break;
					}
				}
				if (k==needle.length()){
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution28().strStr("", "aa"));
	}

}

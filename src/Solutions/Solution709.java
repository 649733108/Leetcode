package Solutions;
/*
 * Created by wxn
 * 2018/8/17 11:23
 */

/**
 * 709. 转换成小写字母
 *
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "Hello"
 * 输出: "hello"
 * 示例 2：
 *
 * 输入: "here"
 * 输出: "here"
 * 示例 3：
 *
 * 输入: "LOVELY"
 * 输出: "lovely"
 */
public class Solution709 {
	public String toLowerCase(String str) {
		StringBuilder res = new StringBuilder();
		for(int i = 0 ; i< str.length(); i++){
			if(str.charAt(i)<'a' && str.charAt(i)>='A'){
				res.append((char)(str.charAt(i)+'a'-'A'));
			}
			else{
				res.append(str.charAt(i));
			}
		}
		return res.toString();
	}
}

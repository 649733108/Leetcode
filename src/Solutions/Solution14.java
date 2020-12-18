package Solutions;

/**
 * Created by wxn
 * 2019/5/28 15:29
 *
 * 14.最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */


public class Solution14 {

	//暴力求解
	public String longestCommonPrefix(String[] strs) {

		if (strs==null || strs.length==0){
			return "";
		}

		StringBuilder sb = new StringBuilder();
		int index = 0;//记录遍历到字符串的第几个位置

		while (index<strs[0].length()){
			char c = strs[0].charAt(index);
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length()<index+1 || strs[i].charAt(index)!=c){
					return sb.toString();
				}
			}
			sb.append(c);
			index++;
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		String[] strs = {"","aaabbbddd","aaab"};
		System.out.println(new Solution14().longestCommonPrefix(strs));
	}
}

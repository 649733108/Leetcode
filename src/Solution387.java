
/*
 * Created by wxn
 * 2018/8/17 10:09
 */

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Solution387 {

//	public int firstUniqChar(String s) {
//		HashMap<Character,Integer> map = new HashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			if (map.containsKey(s.charAt(i))){
//				map.put(s.charAt(i),map.get(s.charAt(i))+1);
//			}
//			else {
//				map.put(s.charAt(i),1);
//			}
//		}
//		for (char c : s.toCharArray()){
//			if (map.get(c)==1)
//				return s.indexOf(c);
//		}
//		return -1;
//	}

public int firstUniqChar(String s) {
	int[] freq = new int[26];
	for (int i = 0; i < s.length(); i++) {
		freq[s.charAt(i)-'a']++;
	}
	for (int i = 0; i < s.length(); i++){
		if (freq[s.charAt(i)-'a'] == 1)
			return i;
	}
	return -1;
}

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

	public static void main(String args[]) {
		Solution387 solution = new Solution387();
		String s = "loveleetcode";
		System.out.println(solution.firstUniqChar(s));

		String str = "Hello";
		System.out.println(solution.toLowerCase(str));
	}

}

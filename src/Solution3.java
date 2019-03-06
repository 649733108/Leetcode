
/*
 * Created by wxn
 * 2018/8/20 12:21
 */

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */
public class Solution3 {

//	public int lengthOfLongestSubstring(String s) {
////		int ret = 0;
////		int p = 0, q = 0;
////
////		while (q < s.length()) {
////			int length = 0;
////			HashSet<Character> set = new HashSet<>();
////			for (; q < s.length(); q++) {
////				if (!set.contains(s.charAt(q))) {
////					set.add(s.charAt(q));
////					length++;
////				} else {
////					ret = length > ret ? length : ret;
////					p++;
////					q = p;
////					break;
////				}
////				ret = length > ret ? length : ret;
////			}
////		}
////		return ret;
////
////	}

//	public int lengthOfLongestSubstring(String s) {
//		int ret = 0;
//		int p = 0, q = 0;
//
//		while (q < s.length()) {
//
//			HashSet<Character> set = new HashSet<>();
//			int length = set.size();
//
//			for (; q < s.length(); q++) {
//				if (!set.add(s.charAt(q))) {
//					ret = length > ret ? length : ret;
//					p++;
//					q = p;
//					break;
//				}
//				length++;
//				ret = length > ret ? length : ret;
//			}
//		}
//		return ret;
//
//	}


    /**
     * 高效的方法
     */
    public int lengthOfLongestSubstring(String s) {
	int ret = 0;

	Map<Character, Integer> map = new HashMap<>();

	for (int j = 0, i = 0; j < s.length(); j++) {
	    if (map.containsKey(s.charAt(j))) {
		i = Math.max(map.get(s.charAt(j)), i);
	    }
	    ret = Math.max(ret, j - i + 1);
	    map.put(s.charAt(j), j + 1);
	}
	return ret;

    }

    //滑动窗口 用set存是否出现过
    public int lengthOfLongestSubstring2(String s) {
	int ret = 0;
	int p = 0, q = 0;
	Set<Character> set = new HashSet<>();
	while (q<s.length()){
	    if (!set.contains(s.charAt(q))){
	        set.add(s.charAt(q++));
	        ret = Math.max(ret,q-p);
	    }else {
	        set.remove(s.charAt(p++));
	    }
	}
	return ret;
    }

    //滑动窗口 用数组存放是否出现过
    public int lengthOfLongestSubstring3(String s){
        int ret = 0;
        int p = 0;
        int q = 0;
        int[] freq = new int[128];

        while (q<s.length()){
            if (freq[s.charAt(q)]==0){
                freq[s.charAt(q++)]++;
                ret = Math.max(ret,q-p);
	    }else {
                freq[s.charAt(p++)]--;
	    }
	}
        return ret;
    }

    public static void main(String args[]) {
	Solution3 solution3 = new Solution3();

	String str = "aabc";
	System.out.println(solution3.lengthOfLongestSubstring3(str));

    }


}

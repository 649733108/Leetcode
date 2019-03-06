
/*
 * Created by wxn
 * 2019/3/6 22:30
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 438.找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Solution438 {

    //解法1.滑动窗口
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
	int[] freq_p = new int[128];
	int[] freq_s = new int[128];
	int left = 0;
	int right = 0;
	for (int i = 0; i < p.length(); i++) {
	    freq_p[p.charAt(i)]++;
	}
	while (right<s.length()){
	    freq_s[s.charAt(right++)]++;
	    if (right-left>p.length()){
	        freq_s[s.charAt(left++)]--;
	    }
	    if (right-left==p.length() && same(freq_s,freq_p)){
	        ret.add(left);
	    }
	}
	return ret;
    }

    private boolean same(int[] freq_s, int[] freq_p) {
	for (int i = 0 ; i< freq_p.length ; i++){
	    if (freq_p[i]!=freq_s[i])
	        return false;
	}
	return true;
    }

    public static void main(String[] args) {
	String s = "cbaebabacd";
	String p = "abc";
	Solution438 solution438 = new Solution438();
	System.out.println(solution438.findAnagrams(s, p));
    }

}

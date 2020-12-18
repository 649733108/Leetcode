package Solutions;
/*
 * Created by wxn
 * 2019/3/12 21:08
 */

/**
 * 76.最小覆盖子串
 *
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Solution76 {

    /*
    首先想到使用滑动窗口
     */
    public String minWindow(String s, String t) {

        int[] freq = new int[128];
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        String ret = "";
        for (int i = 0 ; i< t.length(); i++){
            freq[t.charAt(i)]++;
	}
	while (right<s.length()){
	    if (--freq[s.charAt(right++)]>=0){
	        count++;
	    }
	    while (count==t.length()){
	        if (minLen>right-left){
	            minLen = right-left;
		    ret = s.substring(left,right);
		}
	        if (++freq[s.charAt(left++)]>0){
	            count--;
		}
	    }
	}
        return ret;
    }

    public static void main(String args[]) {
	System.out.println(new Solution76().minWindow("ADOBECODEBANC","ABC"));
    }

}

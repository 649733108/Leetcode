
/*
 * Created by wxn
 * 2019/3/12 21:52
 */

/**
 * 5.最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution5 {

    //解法1 暴力求解
    public String longestPalindrome(String s) {

        if (s.length()<2) {
	    return s;
	}
	int maxLength = 0;
        String ret = "";
        for (int i = 0 ; i<s.length() ; i++){
            String tempStr = getPalindrome(s,i,i);
            if (tempStr.length()>maxLength){
                maxLength = tempStr.length();
                ret = tempStr;
	    }
	    tempStr = getPalindrome(s,i,i+1);
	    if (tempStr.length()>maxLength){
		maxLength = tempStr.length();
		ret = tempStr;
	    }
	}
	return ret;
    }

    //在s中以start 和 end 为中心 寻找最长的回文子串
    private String getPalindrome(String s, int start , int end){

        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
	}
	return s.substring(start+1,end);
    }

    public static void main(String args[]) {
	System.out.println(new Solution5().longestPalindrome("aba"));
    }

}

package Solutions;
/*
 * Created by wxn
 * 2018/12/25 21:43
 */


/**
 * 125:验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * >示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * >示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Solution125 {

    //解法1 对撞指针
    public boolean isPalindrome(String s) {
	if (s.length() <= 1)
	    return true;
	int i = 0;
	int j = s.length() - 1;
	while (i < j) {
	    while (i < s.length() && (s.charAt(i) < '0' || s.charAt(i) > '9' && s.charAt(i) < 'A' || s.charAt(i) > 'Z' && s.charAt(i) < 'a' || s.charAt(i) > 'z')) {
		i++;
	    }
	    while (j >= 0 && (s.charAt(j) < '0' || s.charAt(j) > '9' && s.charAt(j) < 'A' || s.charAt(j) > 'Z' && s.charAt(j) < 'a' || s.charAt(j) > 'z')) {
		j--;
	    }
	    if (i < s.length() && j >= 0 && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
		return false;
	    } else {
		i++;
		j--;
	    }
	}
	return true;
    }

    public static void main(String args[]) {
	System.out.println(new Solution125().isPalindrome("0P"));
    }

}

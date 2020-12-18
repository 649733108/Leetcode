package Solutions;
/*
 * Created by wxn
 * 2019/3/3 18:58
 */

import java.util.*;

/**
 * 345.反转字符串中的元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
public class Solution345 {

    public String reverseVowels(String s) {

	Character[] yuanyin = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

	Set<Character> set = new HashSet<>();
	Collections.addAll(set, yuanyin);

	char[] c = s.toCharArray();
	int i = 0;
	int j = s.length() - 1;
	while (i < j) {
	    while (i < j && !set.contains(c[i])) {
		i++;
	    }
	    while (i < j && !set.contains(c[j])) {
		j--;
	    }
	    swap(c, i, j);
	    i++;
	    j--;
	}
	return String.valueOf(c);
    }

    private void swap(char[] s, int i, int j) {
	char temp = s[i];
	s[i] = s[j];
	s[j] = temp;
    }

    public static void main(String args[]) {
	String s = "hello";
	Solution345 solution345 = new Solution345();
	solution345.reverseVowels(s);
    }

}

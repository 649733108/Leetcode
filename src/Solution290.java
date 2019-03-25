
/*
 * Created by wxn
 * 2019/3/24 17:32
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290.单词模式
 * <p>
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * <p>
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Solution290 {

    public boolean wordPattern(String pattern, String str) {

	char[] chars = pattern.toCharArray();
	String[] s = str.split(" ");
	if (chars.length != s.length)
	    return false;

	Map<Character, String> map = new HashMap<>();
	for (int i = 0; i < chars.length; i++) {
	    if (map.containsKey(chars[i])) {
		if (!map.get(chars[i]).equals(s[i]))
		    return false;
	    } else if (map.containsValue(s[i])) {
		return false;
	    } else {
		map.put(chars[i], s[i]);
	    }
	}
	return true;
    }

    public static void main(String args[]) {
	System.out.println(new Solution290().wordPattern("abba", "dog dog dog dog"));
    }

}

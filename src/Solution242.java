
/*
 * Created by wxn
 * 2019/3/19 22:39
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242.有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Solution242 {

    public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length())
            return false;

	Map<Character,Integer> map = new HashMap<>();
	for (int i = 0; i < s.length(); i++) {
	    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
	}
	for (int i = 0; i < t.length(); i++) {
	    if (map.get(t.charAt(i))!=null && map.get(t.charAt(i))>0){
	        map.put(t.charAt(i),map.get(t.charAt(i))-1);
	    }else {
	        return false;
	    }
	}
	return true;
    }

    public boolean isAnagram1(String s, String t){

	if (s.length()!=t.length())
	    return false;

	char[] sChar = s.toCharArray();
	char[] tChar = t.toCharArray();
	Arrays.sort(sChar);
	Arrays.sort(tChar);
	for (int i = 0; i < s.length(); i++) {
	    if (sChar[i]!=tChar[i])
	        return false;
	}
	return true;
    }
}


package Solutions;
/*
 * Created by wxn
 * 2019/3/27 22:20
 */

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class Solution49 {

	//解法1
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>>ret = new ArrayList<>();

		Map<Map<Character,Integer>,List<String>>stringMap = new HashMap<>();
		for (String str : strs) {
			Map<Character,Integer>letterMap = new HashMap<>();

			for (int i = 0; i < str.length(); i++) {
				letterMap.put(str.charAt(i),letterMap.getOrDefault(str.charAt(i),0)+1);
			}
			List<String>stringList = stringMap.getOrDefault(letterMap, new ArrayList<>());
			stringList.add(str);
			stringMap.put(letterMap,stringList);
		}
		for (Map<Character, Integer> map : stringMap.keySet()) {
			ret.add(stringMap.get(map));
		}
		return ret;
	}

	//解法2 优化的解法1
	public List<List<String>> groupAnagrams2(String[] strs){

		List<List<String>>ret = new ArrayList<>();
		Map<String,List<String>>map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sortedStr = String.valueOf(chars);
			List<String>list = map.getOrDefault(sortedStr,new ArrayList<>());
			list.add(str);
			map.put(sortedStr,list);
		}
		for (String s : map.keySet()) {
			ret.add(map.get(s));
		}
		return ret;
	}

	public static void main(String args[]) {
		System.out.println(new Solution49().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}

}

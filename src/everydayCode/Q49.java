package everydayCode;

import java.util.*;

/**
 * Created by wxn
 * 2020/12/14 10:41
 */


public class Q49 {
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> ret = new ArrayList<>();
		Map<String, List<String>>map = new HashMap<>();
		for (String str : strs) {
			String sortedString = sortString(str);
			List<String> list = map.getOrDefault(sortedString, new ArrayList<>());
			list.add(str);
			map.put(sortedString, list);
		}
		for (List<String> value : map.values()) {
			ret.add(new ArrayList<>(value));
		}
		return ret;
	}

	private String sortString(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		StringBuilder sb = new StringBuilder();
		for (char aChar : chars) {
			sb.append(aChar);
		}
		return sb.toString();
	}
}

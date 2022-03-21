package Solutions;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by wxn
 * 2021/9/14 14:59
 *
 * 524. 通过删除字母匹配到字典里最长单词
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 */


public class Solution524 {

	public String findLongestWord(String s, List<String> dictionary) {


		PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o2.length()-o1.length();
				}else {
					return o1.compareTo(o2);
				}
			}
		});
		q.addAll(dictionary);
		while (!q.isEmpty()) {
			String word = q.poll();
			int i = 0;
			int j = 0;
			while (i < s.length() && j < word.length()) {
				if (s.charAt(i) == word.charAt(j)) {
					i++;
					j++;
				}else {
					i++;
				}
			}
			if (j == word.length()) {
				return word;
			}
		}
		return "";
	}
}

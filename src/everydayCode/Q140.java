package everydayCode;

import java.util.*;

/**
 * Created by wxn
 * 2020/11/3 11:17
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Q140 {

	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<Integer,List<List<String>>>map = new HashMap<>();
		List<List<String>> wordBreaks = wordBreak(s, wordDict, 0, map);
		List<String>breakList = new LinkedList<>();
		for (List<String> wordBreak : wordBreaks) {
			breakList.add(String.join(" ", wordBreak));
		}
		return breakList;
	}

	private List<List<String>> wordBreak(String s, List<String> wordDict, int start, Map<Integer, List<List<String>>> map) {

		if (!map.containsKey(start)){

			List<List<String>> wordBreaks = new LinkedList<>();
			if (start == s.length()) {
				wordBreaks.add(new ArrayList<>());
			}
			for (int i = start+1; i<=s.length(); i++){
				String word = s.substring(start,i);
				if (wordDict.contains(word)){
					List<List<String>> nextWordBreaks = wordBreak(s,wordDict, i, map);
					for (List<String> nextWordBreak : nextWordBreaks) {
						List<String> wordBreak = new LinkedList<>(nextWordBreak);
						wordBreak.add(0, word);
						wordBreaks.add(wordBreak);
					}
				}
			}
			map.put(start, wordBreaks);
		}
		return map.get(start);
	}

	public static void main(String[] args) {
		List<String>list = new ArrayList<>();
		list.add("s");

		System.out.println(new Q140().wordBreak("sa", list));
	}
}

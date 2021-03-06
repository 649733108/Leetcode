package Solutions;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by wxn
 * 2019/6/27 17:24
 *
 * 127. 单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */


public class Solution127 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		int L = beginWord.length();

		//记录一个单词改变一个字母后可以转换成的单词列表
		Map<String,List<String>> allComboDict = new HashMap<>();

		//对wordList进行预处理
		for (String word : wordList) {
			for (int i = 0; i < L; i++) {
				String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
				List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
				transformations.add(word);
				allComboDict.put(newWord, transformations);
			}
		}

		//使用队列进行广度优先遍历
		Queue<Pair<String,Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(beginWord, 1));
		//使用visited映射来保证不会扫描重复的单词
		Map<String,Boolean> visited = new HashMap<>();
		visited.put(beginWord, true);

		while (!queue.isEmpty()) {
			Pair<String, Integer> pair = queue.remove();
			String word = pair.getKey();
			int level = pair.getValue();
			for (int i = 0; i < L; i++) {
				String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
				for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
					if (adjacentWord.equals(endWord)) {
						return level+1;
					}
					if (!visited.containsKey(adjacentWord)) {
						visited.put(adjacentWord, true);
						queue.add(new Pair<>(adjacentWord, level + 1));
					}
				}
			}
		}

		return 0;

	}

	public static void main(String args[]) {
		new Solution127().ladderLength("abc", "qwe", Arrays.asList("hot", "dot", "dog", "lot", "log"));
	}

}

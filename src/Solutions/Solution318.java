package Solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wxn
 * 2021/11/17 19:34
 *
 * 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 */


public class Solution318 {

	public int maxProduct(String[] words) {

		Map<String,Set<Character>> map = new HashMap<>();
		for (String word : words) {
			map.put(word,getCharSet(word));
		}
		int ret = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				Set<Character> set1 = new HashSet<>(map.get(words[i]));
				set1.retainAll(map.get(words[j]));
				if (set1.size()==0){
					//没有交集
					ret = Math.max(ret,words[i].length()*words[j].length());
				}
			}
		}
		return ret;
	}

	private Set<Character> getCharSet(String word) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < word.length(); i++) {
			set.add(word.charAt(i));
		}
		return set;
	}

	//使用位运算计算掩码
	public int maxProduct2(String[] words) {
		int[] mask = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				mask[i] |= 1 << (words[i].charAt(j)-'a');
			}
		}
		int ret = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i+1; j < words.length; j++) {
				if ((mask[i] & mask[j]) == 0) {
					ret = Math.max(ret,words[i].length()*words[j].length());
				}
			}
		}
		return ret;
	}
}

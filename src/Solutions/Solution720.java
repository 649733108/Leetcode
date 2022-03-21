package Solutions;

/**
 * Created by wxn
 * 2022/3/17 20:03
 * <p>
 * 720. 词典中最长的单词
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 * <p>
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * 示例 2：
 * <p>
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * 所有输入的字符串 words[i] 都只包含小写字母。
 */


public class Solution720 {

	public String longestWord(String[] words) {

		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}
		String ans = "";
		for (String word : words) {
			if (word.length()<ans.length()){
				continue;
			}
			if (word.length()==ans.length() && word.compareTo(ans)>0){
				continue;
			}
			boolean good = true;
			for (int i = 0; i < word.length(); i++) {
				if (!trie.search(word.substring(0, i + 1))){
					good = false;
					break;
				}
			}
			if (good){
				ans = word;
			}
		}
		return ans;

	}

	class TrieNode {
		TrieNode[] trieNodes;
		boolean end;

		TrieNode() {
			trieNodes = new TrieNode[26];
			end = false;
		}
	}

	class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		void insert(String s){
			TrieNode node = root;
			for (int i = 0; i < s.length(); i++) {
				int u = s.charAt(i) - 'a';
				if (node.trieNodes[u] == null) {
					node.trieNodes[u] = new TrieNode();
				}
				node = node.trieNodes[u];
			}
			node.end = true;
		}

		boolean search(String s){
			TrieNode node = root;
			for (int i = 0; i < s.length(); i++) {
				int u = s.charAt(i) - 'a';
				if (node.trieNodes[u]==null){
					return false;
				}
				node = node.trieNodes[u];
			}
			return node.end;
		}
	}

	public static void main(String[] args) {
		Solution720 s = new Solution720();
		System.out.println(s.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
	}
}

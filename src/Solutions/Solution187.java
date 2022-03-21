package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wxn
 * 2021/10/8 19:53
 * <p>
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 */


public class Solution187 {

	//方法1 哈希表
	public List<String> findRepeatedDnaSequences(String s) {

		Map<String, Integer> map = new HashMap<>();
		List<String> ret = new ArrayList<>();

		for (int i = 0; i <= s.length() - 10; i++) {
			String s1 = s.substring(i, i + 10);
			map.put(s1, map.getOrDefault(s1, 0) + 1);
			if (map.get(s1) == 2) {
				ret.add(s1);
			}
		}
		return ret;
	}

	//方法2 哈希表+位运算+滑动窗口
	public List<String> findRepeatedDnaSequences2(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>() {
			{
				put('A', 0);
				put('C', 1);
				put('G', 2);
				put('T', 3);
			}
		};
		List<String> ret = new ArrayList<>();
		if (s.length() < 10) {
			return ret;
		}
		int n = 0;
		for (int i = 0; i < 10; i++) {
			n = (n<<2) | map.get(s.charAt(i));
		}
		Map<Integer,Integer> map2 = new HashMap<>();
		map2.put(n,1);
		for (int i = 10; i < s.length(); i++) {
			//序列向左移动1位
			n = n<<2;
			//或运算新来的字符
			n = n | map.get(s.charAt(i));
			//取后20位
			n = n & ((1<<20)-1);
			map2.put(n,map2.getOrDefault(n,0)+1);
			if (map2.get(n) == 2) {
				ret.add(s.substring(i-9,i+1));
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution187 s = new Solution187();
		s.findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	}
}

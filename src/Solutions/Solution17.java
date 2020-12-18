package Solutions;

import java.util.*;

/**
 * Created by wxn
 * 2019/5/28 15:57
 *
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 2->abc 3->def 4->ghi 5->jkl 6->mno 7->pqrs 8->tuv 9->wxyz
 */


public class Solution17 {

	private ArrayList<String> res;

	//用一个长度为10的桶装每个数字对应的字母
	private final String[] dictionary = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	//回溯法
	public List<String> letterCombinations(String digits) {

		res = new ArrayList<>();
		if (digits.equals("")){
			return res;
		}

		findCombination(digits,0,"");

		return res;


	}

	private void findCombination(String digits , int index , String s){
		System.out.println(index+" : " +s);
		if (index==digits.length()){
			res.add(s);
			return;
		}

		char c = digits.charAt(index);
		String letters = dictionary[c-'0'];
		for (int i = 0; i < letters.length(); i++) {
			System.out.println("digits["+index+"] = "+c + " , use " + letters.charAt(i));
			findCombination(digits, index+1, s+letters.charAt(i));
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution17().letterCombinations("234"));
	}

}

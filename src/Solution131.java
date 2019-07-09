import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/8 16:22
 *
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 */


public class Solution131 {

	public List<List<String>> partition(String s) {

		List<List<String>> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		partition(s, 0, new ArrayList<>(), res);
		return res;

	}

	//index表示当前应该处理s的第index个位置
	//list保存当前已经获得的回文字符串
	private void partition(String s , int index , List<String> list , List<List<String>> res){
		if (index==s.length()){
			res.add(new ArrayList<>(list));
		}
		for (int i = 1 ; index+i<=s.length() ; i++){
			String temp = s.substring(index, index+i);
			if (isPalindrome(temp)){
				list.add(temp);
				partition(s,index+i,list,res);
				list.remove(list.size()-1);
			}
		}
	}

	private boolean isPalindrome(String s){
		if (s == null || s.length() == 0) {
			return false;
		}
		int i = 0 ;
		int j = s.length()-1;
		while (i<j){
			if (s.charAt(i)!=s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<String>> aab = new Solution131().partition("aab");
		System.out.println(aab);
	}

}

package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/8 15:37
 *
 * 93. 复原IP地址
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 */


public class Solution93 {

	public List<String> restoreIpAddresses(String s) {

		List<String> res = new ArrayList<>();
		if (s==null || s.length()<4){
			return res;
		}
		restoreIpAddresses(s, 0, new ArrayList<>(), res);
		return res;
	}

	private void restoreIpAddresses(String s , int index , List<String> list ,List<String> res){
		if (list.size()>4 || list.size()==4&&index<s.length()){
			return;
		}
		if (index == s.length() && list.size()==4){
			StringBuilder sb = new StringBuilder();
			for (String s1 : list) {
				sb.append(s1).append(".");
			}
			sb.deleteCharAt(sb.length()-1);
			res.add(sb.toString());
			return;
		}
		for (int i = 1 ; i<=3 && index+i<=s.length() ; i++){
			int num = Integer.valueOf(s.substring(index, index + i));
			if (num>255 || String.valueOf(num).length()!=i){
				break;
			}
			list.add(s.substring(index, index + i));
			restoreIpAddresses(s, index+i, list, res);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		List<String> strings = new Solution93().restoreIpAddresses("010010");
		System.out.println(strings);
	}


}

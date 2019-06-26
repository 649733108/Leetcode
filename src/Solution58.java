/**
 * Created by wxn
 * 2019/6/26 15:08
 *
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */


public class Solution58 {

	public int lengthOfLastWord(String s) {

		int ret = 0;
		int p = s.length()-1;
		//找到最后一个不为空的位置p
		while (p>=0){
			if (s.charAt(p)==' '){
				p--;
			}else {
				break;
			}
		}
		while (p >= 0) {
			if (s.charAt(p) != ' ') {
				p--;
				ret++;
			}else {
				break;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(new Solution58().lengthOfLastWord("   Hello    Wo rld   "));
	}

}

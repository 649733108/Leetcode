package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2021/9/9 20:09
 * <p>
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */


public class Solution68 {

	public List<String> fullJustify(String[] words, int maxWidth) {
		int n = words.length;
		List<String> res = new ArrayList<>();

		int right = 0;//当前行右边单词的index


		while (right < n) {
			int left = right;//当前行最左边单词的index
			int width = 0;//当前行的长度
			//首先判断当前行单词数量
			while (right < n && (width + words[right].length() + right - left <= maxWidth)) {
				//right单词能放到当前行
				width+=words[right++].length();
			}
			//判断当前行是否是最后一行
			if (right == n) {
				//最后一行左对齐，右边补空格
				StringBuilder sb = new StringBuilder();
				sb.append(words[left]);
				for (int i = left + 1; i < right; i++) {
					sb.append(" ");
					sb.append(words[i]);
				}
				sb.append(blank(maxWidth-sb.length()));
				res.add(sb.toString());
				return res;
			}
			//不是最后一行，判断是否当前行只有一个单词，是的话需要左对齐
			if (right - left == 1) {
				String sb = words[left] +
						blank(maxWidth - width);
				res.add(sb);
			}else {
				//不是最后一行，且当前行有多个单词
				int numWord = right-left; //当前行单词数
				int numSpace = maxWidth- width;//总空格数
				int avgSpace = numSpace/(numWord-1);
				int extraSpace = numSpace % (numWord - 1);

				StringBuilder sb = new StringBuilder();
				sb.append(words[left]);
				for (int i = left+1 ; i<left+extraSpace+1;i++){
					sb.append(blank(avgSpace + 1));
					sb.append(words[i]);
				}
				for (int i = left + extraSpace + 1; i < right; i++) {
					sb.append(blank(avgSpace));
					sb.append(words[i]);
				}
				res.add(sb.toString());
			}
		}
		return res;

	}

	private String blank(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = {"What","must","be","acknowledgment","shall","be"};
		Solution68 s = new Solution68();
		for (String s1 : s.fullJustify(words, 16)) {
			System.out.println(s1);
		}
	}


}

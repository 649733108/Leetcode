package Solutions;

import java.util.Map;

/**
 * Created by wxn
 * 2021/9/30 14:39
 * <p>
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 * <p>
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * <p>
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 * <p>
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *  
 * <p>
 * 提示：
 * <p>
 * -104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution223 {

	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

		int bothSquare;
		if (ax2 <= bx1 || bx2 <= ax1 || ay2 <= by1 || by2 <= ay1) {
			bothSquare = 0;
		} else {
			int width = Math.min(Math.min(Math.abs(bx1 - ax2), Math.abs(ax1 - bx2)),
					Math.min(Math.abs(ax1 - ax2), Math.abs(bx1 - bx2)));
			int height = Math.min(Math.min(Math.abs(by1 - ay2), Math.abs(ay1 - by2)),
					Math.min(Math.abs(ay1 - ay2), Math.abs(by1 - by2)));
			bothSquare = width * height;
		}
		int square1 = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
		int square2 = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
		return square1 + square2 - bothSquare;
	}

	public static void main(String[] args) {
		System.out.println(new Solution223().computeArea(0,0,0,0,-1,-1,1,1));
	}

}


/*
 * Created by wxn
 * 2019/3/28 22:45
 */

import java.math.BigDecimal;
import java.util.*;

/**
 * 149.直线上最多的点数
 * <p>
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class Solution149 {

	public int maxPoints(Point[] points) {

		int ret = 0;
		for (int i = 0; i < points.length; i++) {
			//map记录与i点连成的线斜率为key的点的个数
			Map<BigDecimal, Integer> map = new HashMap<>();
			for (int j = i + 1; j < points.length; j++) {
				//两点确定一条直线 ,确定两点后,斜率也随之确定了
				BigDecimal slope = getSlope(points[i], points[j]);
				map.put(slope, map.getOrDefault(slope, 0) + 1);
			}
			for (BigDecimal slope : map.keySet()) {
				if (slope!=null){
					ret = map.get(slope)+map.getOrDefault(null,0)>ret?map.get(slope)+map.getOrDefault(null,0):ret;
				}else {
					ret = map.get(slope)>ret?map.get(slope):ret;
				}
			}
		}
		return points.length > 0 ? ret + 1 : 0;
	}

	//得到两点连线的斜率
	private BigDecimal getSlope(Point p1, Point p2) {
		//两点为同一点的情况
		if (p1.x == p2.x && p1.y == p2.y) {
			return null;
		}
		//斜率不存在的情况
		if (p1.x == p2.x) {
			return BigDecimal.valueOf(Double.MAX_VALUE);
		}
		//斜率为0的情况
		if (p1.y == p2.y) {
			return BigDecimal.valueOf(0);
		}
		return BigDecimal.valueOf (p1.y - p2.y).divide(BigDecimal.valueOf(p1.x - p2.x),20,BigDecimal.ROUND_HALF_DOWN);

	}

	public static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}

	}

	public static void main(String args[]) {
		List<Point> list = Arrays.asList(new Point(1, 0),new Point(1,1), new Point(0, 0));
		Point[] points = (Point[]) list.toArray();
		System.out.println(new Solution149().maxPoints(points));
	}

}

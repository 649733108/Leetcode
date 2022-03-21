package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by wxn
 * 2021/11/16 17:14
 * 391. 完美矩形
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 *
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 * 示例 2：
 *
 *
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 * 示例 3：
 *
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
 * 输出：false
 * 解释：图形顶端留有空缺，无法覆盖成一个矩形。
 * 示例 4：
 *
 *
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 *
 *
 * 提示：
 *
 * 1 <= rectangles.length <= 2 * 104
 * rectangles[i].length == 4
 * -105 <= xi, yi, ai, bi <= 105
 */


public class Solution391 {

	/*
	满足两个条件:
	1. 每个矩形面积相加等于大矩形的面积
	2. 大矩形的顶点只能出现1次,其他顶点只能出现2次或4次
	 */
	public boolean isRectangleCover(int[][] rectangles) {

		int xMin = Integer.MAX_VALUE;
		int yMin = Integer.MAX_VALUE;
		int xMax = Integer.MIN_VALUE;
		int yMax = Integer.MIN_VALUE;
		int squareSum = 0;
		Map<Point,Integer>pointMap = new HashMap<>();
		for (int[] rectangle : rectangles) {
			xMin = Math.min(xMin,rectangle[0]);
			yMin = Math.min(yMin,rectangle[1]);
			xMax = Math.max(xMax,rectangle[2]);
			yMax = Math.max(yMax,rectangle[3]);
			squareSum+=getSquare(rectangle);
			Point p1 = new Point(rectangle[0],rectangle[1]);
			Point p2 = new Point(rectangle[0],rectangle[3]);
			Point p3 = new Point(rectangle[2],rectangle[1]);
			Point p4 = new Point(rectangle[2],rectangle[3]);
			pointMap.put(p1,pointMap.getOrDefault(p1,0)+1);
			pointMap.put(p2,pointMap.getOrDefault(p2,0)+1);
			pointMap.put(p3,pointMap.getOrDefault(p3,0)+1);
			pointMap.put(p4,pointMap.getOrDefault(p4,0)+1);
		}
		if (squareSum!=getSquare(new int[]{xMin,yMin,xMax,yMax})) {
			return false;
		}
		Point p1 = new Point(xMin,yMin);
		Point p2 = new Point(xMin,yMax);
		Point p3 = new Point(xMax,yMin);
		Point p4 = new Point(xMax,yMax);
		if (pointMap.getOrDefault(p1, 0) != 1 ||
				pointMap.getOrDefault(p2, 0) != 1 ||
				pointMap.getOrDefault(p3, 0) != 1 ||
				pointMap.getOrDefault(p4, 0) != 1) {
			return false;
		}
		pointMap.remove(p1);
		pointMap.remove(p2);
		pointMap.remove(p3);
		pointMap.remove(p4);
		for (Integer value : pointMap.values()) {
			if (value!=2 && value!=4){
				return false;
			}
		}
		return true;
	}

	private int getSquare(int[]rectangle){
		return (rectangle[2]-rectangle[0]) * (rectangle[3]-rectangle[1]);
	}

	private class Point {
		int x;
		int y;
		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return x == point.x && y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}


	public static void main(String[] args) {
		Solution391 s = new Solution391();
		int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		System.out.println(s.isRectangleCover(rectangles));
	}
}

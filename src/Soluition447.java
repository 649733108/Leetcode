
/*
 * Created by wxn
 * 2019/3/28 22:20
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 447.回旋镖的数量
 *
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class Soluition447 {

	//解法1 暴力求解
	public int numberOfBoomerangs(int[][] points) {

		int ret = 0;
		for (int[] i : points) {
			for (int[] j : points) {
				for (int[] k : points) {
					if (i!=j && i!=k && j!=k){
						if (distance(i,j)==distance(i,k)){
							ret++;
						}
					}
				}
			}
		}
		return ret;

	}

	//解法2 查找表
	public int numberOfBoomerangs2(int[][] points){
		int ret = 0;
		for (int[] i : points) {
			//key:某个点与i的距离的平方 value:距离为key的点的个数
			Map<Integer, Integer> map = new HashMap<>();
			for (int[] point : points) {
				if (point!=i){
					int dis = distance(i,point);
					map.put(dis,map.getOrDefault(dis,0)+1);
				}
			}
			for (Integer integer : map.keySet()) {
				ret+=map.get(integer)*(map.get(integer)-1);
			}
		}
		return ret;
	}

	//计算两个点距离的平方
	private int distance(int[] a , int[] b){
		return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
	}

	public static void main(String args[]) {
		int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
		System.out.println(new Soluition447().numberOfBoomerangs2(points));
	}

}



/*
 * Created by wxn
 * 2019/3/27 21:52
 */


import java.util.HashMap;
import java.util.Map;

/**
 * 454.四数相加 II
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Solution454 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

		int ret = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i : D) {
			map.put(i,map.getOrDefault(i,0)+1);
		}

		//三重循环
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				for (int k = 0; k < C.length; k++) {
					if (map.containsKey(0-A[i]-B[j]-C[k]) && map.get(0-A[i]-B[j]-C[k])>0){
						ret+=map.get(0-A[i]-B[j]-C[k]);
					}
				}
			}
		}
		return ret;
	}

	//解法3
	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D){
		int ret = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for (int c : C) {
			for (int d : D) {
				map.put(c+d,map.getOrDefault(c+d,0)+1);
			}
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (map.containsKey(0-A[i]-B[j])){
					ret+=map.get(0-A[i]-B[j]);
				}
			}
		}
		return ret;
	}

	public static void main(String args[]) {
		System.out.println(new Solution454().fourSumCount2(new int[]{-1, -1}, new int[]{-1,1}, new int[]{-1, 1}, new int[]{1, -1}));
	}

}

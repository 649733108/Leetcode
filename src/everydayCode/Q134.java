package everydayCode;

/**
 * Created by wxn
 * 2020/11/18 21:53
 */


public class Q134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		int curSum = 0;
		int totalSum = 0;
		for (int i = 0; i < gas.length; i++) {
			curSum+=gas[i]-cost[i];
			totalSum+=gas[i]-cost[i];
			if (curSum<0){
				start = i+1;
				curSum = 0;
			}
		}
		return totalSum<0?-1:start;

	}
}

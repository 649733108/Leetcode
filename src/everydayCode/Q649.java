package everydayCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wxn
 * 2020/12/12 13:29
 */


public class Q649 {
	public String predictPartyVictory(String senate) {

		int n = senate.length();
		Queue<Integer> R = new LinkedList<>();
		Queue<Integer> D = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (senate.charAt(i)=='R'){
				R.offer(i);
			}else {
				D.offer(i);
			}
		}
		while (!R.isEmpty() && !D.isEmpty()){
			int r = R.poll();
			int d = D.poll();
			if (r<d){
				R.offer(r+n);
			}else {
				D.offer(d+n);
			}
		}
		return R.isEmpty()?"Dire":"Radiant";
	}
}

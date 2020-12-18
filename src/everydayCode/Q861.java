package everydayCode;

/**
 * Created by wxn
 * 2020/12/7 20:15
 */


public class Q861 {

	public int matrixScore(int[][] A) {

		int m = A.length;
		int n = A[0].length;
		int ret = m*(1<<(n-1));
		for (int j = 1; j < n; j++) {
			int nOnes = 0;
			for (int i = 0; i<m; i++){
				if (A[i][0]==1){
					nOnes+=A[i][j];
				}else {
					nOnes+=1-A[i][j];
				}
			}
			ret+=Math.max(nOnes, m-nOnes)*(1<<(n-j-1));
		}
		return ret;
	}
}

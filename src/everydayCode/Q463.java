package everydayCode;

/**
 * Created by wxn
 * 2020/10/30 10:42
 */


public class Q463 {

	//只要1旁边是0或者边界，ret就+1
	public int islandPerimeter(int[][] grid) {
		int ret = 0;
		int[][] d = {
				{-1, 0},//上
				{0, 1},//右
				{1, 0},//下
				{0, -1}//左
		};
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[0].length; y++) {
				if (grid[x][y]==0){
					continue;
				}else {
					for (int k = 0; k < 4; k++) {
						int newX = x + d[k][0];
						int newY = y + d[k][1];
						if (!isInArea(newX, newY, grid) || grid[newX][newY]==0){
							ret++;
						}
					}
				}
			}
		}
		return ret;
	}

	private boolean isInArea(int x, int y, int[][] grid) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}

	public static void main(String[] args) {
		int[][] grid = {
				{0,1,0,0},
				{1,1,1,0},
				{0,1,0,0},
				{1,1,0,0}
		};
		System.out.println(new Q463().islandPerimeter(grid));
	}
}

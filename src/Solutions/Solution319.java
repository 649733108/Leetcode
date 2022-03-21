package Solutions;

/**
 * Created by wxn
 * 2021/11/15 14:13
 *
 * 319. 灯泡开关
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
 *
 * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 *
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 *
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= n <= 109
 */


public class Solution319 {

	//暴力法超时
	public int bulbSwitch(int n) {

		//0:关闭 1:打开
		int[] lights = new int[n];
		for (int i = 0; i < n; i++) {
			//第i轮
			for (int j = i ; j<n;j+=i+1){
				lights[j] = lights[j]==0?1:0;
			}
		}

		int ret = 0;
		for (int i = 0; i < n; i++) {
			if (lights[i]==1){
				ret++;
			}
		}
		return ret;
	}

	public int bulbSwitch2(int n) {
		return (int) Math.sqrt(n);
	}
}

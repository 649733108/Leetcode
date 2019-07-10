import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/10 13:25
 *
 * 401. 二进制手表
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 * 案例:
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *  
 *
 * 注意事项:
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 *
 */


public class Solution401 {

	private int[] hours = {8,4,2,1};
	private int[] minutes = {32,16,8,4,2,1};

	public List<String> readBinaryWatch(int num) {

		List<String> res = new ArrayList<>();
		if (num < 0 || num >= 10) {
			return res;
		}
		//时针亮个个数
		int hourNum = 0;
		//分针亮的个数
		int minNum = 0;
		for (int i = 0 ; i<=num ; i++){
			if (i<=3){
				//时针最多亮3个灯
				//分针最多亮5个灯
				hourNum = i;
				minNum = num-i;
				if (minNum>5){
					continue;
				}
				readBinaryWatch(hourNum,minNum,res);
			}
		}
		return res;
	}

	private void readBinaryWatch(int hourNum, int minNum , List<String> res) {
		List<String> hourList = new ArrayList<>();
		getHour(hourNum,0,new ArrayList<>() , hourList);
		List<String> minList = new ArrayList<>();
		getMin(minNum,0,new ArrayList<>(),minList);

		for (String hour : hourList) {
			for (String min : minList) {
				res.add(hour+":"+min);
			}
		}
	}

	private void getHour(int hourNum , int index ,List<Integer>list , List<String> hourList) {
		if (list.size() == hourNum){
			int sum = 0;
			for (Integer integer : list) {
				sum+=integer;
			}
			if (sum<=11){
				hourList.add(String.valueOf(sum));
			}
			return;
		}
		for (int i = index; i <= 3; i++) {
			list.add(hours[i]);
			getHour(hourNum, i + 1, list, hourList);
			list.remove(list.size() - 1);
		}
	}

	private void getMin(int minNum , int index ,List<Integer>list , List<String> minList) {
		if (list.size() == minNum){
			int sum = 0;
			for (Integer integer : list) {
				sum+=integer;
			}
			if (sum>=0 && sum<=9){
				minList.add("0" + sum);
			}else if (sum<=59){
				minList.add(String.valueOf(sum));
			}
			return;
		}
		for (int i = index; i <= 5; i++) {
			list.add(minutes[i]);
			getMin(minNum, i + 1, list, minList);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<String> strings = new Solution401().readBinaryWatch(4);
		System.out.println(strings);
	}

}

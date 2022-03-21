package Solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2021/12/21 19:46
 *
 * 1154. 一年中的第几天
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 *
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 *
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 *
 * 输入：date = "2004-03-01"
 * 输出：61
 *
 *
 * 提示：
 *
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 *
 */


public class Solution1154 {

	Map<Integer,Integer>dayMap = new HashMap<Integer,Integer>(){
		{
			put(1,31);
			put(2,28);
			put(3,31);
			put(4,30);
			put(5,31);
			put(6,30);
			put(7,31);
			put(8,31);
			put(9,30);
			put(10,31);
			put(11,30);
			put(12,31);
		}
	};

	public int dayOfYear(String date) {
		String[] split = date.split("-");
		String year = split[0];
		String month = split[1];
		String day = split[2];
		if (is_leap_year(year)) {
			this.dayMap.put(2,29);
		}
		int ret = 0;
		for (int m = 1;m<Integer.parseInt(month);m++){
			ret+=dayMap.get(m);
		}
		ret+=Integer.parseInt(day);
		return ret;
	}

	private boolean is_leap_year(String year){
		int yearN = Integer.parseInt(year);
		return yearN % 4 == 0 && yearN % 100 != 0 || yearN % 400 == 0;
	}

	public static void main(String[] args) {
		Solution1154 s = new Solution1154();
		System.out.println(s.dayOfYear("2003-03-01"));
	}
}

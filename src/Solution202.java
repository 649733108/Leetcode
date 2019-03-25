
/*
 * Created by wxn
 * 2019/3/24 16:46
 */


import java.util.HashSet;
import java.util.Set;

/**
 * 202.快乐数
 * <p>
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Solution202 {

    public boolean isHappy(int n) {

	Set<Integer> set = new HashSet<>();
	while (true) {
	    int sum = 0;
	    while (n > 0) {
		sum += (n % 10) * (n % 10);
		n /= 10;
	    }
	    if (sum == 1) {
		return true;
	    } else if (set.contains(sum)) {
		return false;
	    } else {
		set.add(sum);
		n = sum;
	    }
	}
    }

    

    public static void main(String args[]) {
	System.out.println(new Solution202().isHappy(1001));
    }

}

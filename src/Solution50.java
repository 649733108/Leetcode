
/*
 * Created by wxn
 * 2018/12/20 18:30
 */


/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class Solution50 {

    //解法1 暴力法
    public double myPow(double x, int n) {

	if (n == 0)
	    return 1;
	if (n == 1)
	    return x;
	if (x == 0 || x == 1)
	    return x;

	double res = 1;
	boolean isNeg = n < 0;
	if (isNeg) {
	    n *= -1;
	}
	for (int i = 0; i < n; i++) {
	    res *= x;
	}
	if (isNeg) {
	    res = 1 / res;
	}
	return res;
    }

    //解法2 二分递归
    public double myPow2(double x, int n) {

	if (n == 0)
	    return 1;
	if (n == 1)
	    return x;
	if (x == 0 || x == 1)
	    return x;

	if (n < 0)
	    return 1 / power(x, -1 * n);
	else
	    return power(x, n);
    }

    //此方法n>=0
    private double power(double x, int n) {
	if (n == 0)
	    return 1;
	double temp = power(x, n / 2);
	if (n % 2 == 0)
	    return temp * temp;
	else {
	    return x * temp * temp;
	}
    }

    //解法3 在递归中处理n的正负
    double myPow3(double x, int n) {
	if (n == 0)
	    return 1;
	double half = myPow3(x, n / 2);
	if (n % 2 == 0)
	    return half * half;
	else if (n > 0)
	    return half * half * x;
	else
	    return half * half / x;
    }

    //解法4 奇淫技巧
    public double myPow4(double x, int n) {
	return Math.pow(x, n);
    }

    public static void main(String args[]) {
	double v = new Solution50().myPow3(2.000000, -2);
	System.out.println(v);
    }

}

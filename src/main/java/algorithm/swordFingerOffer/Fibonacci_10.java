package algorithm.swordFingerOffer;

/**
 * 斐波那契数列
 * @Author: Xiongyy
 * @Date: 2021/2/14 10:51
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class Fibonacci_10 {

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(numWays(7));
    }

    public static int fib(int n) {
        int fibOne = 1;
        int fibTwo = 0;
        int fibN = 0;
        for (int i = 0; i < n; i++) {
            fibN = (fibOne + fibTwo) % 1000000007;

            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibTwo;
    }

    /**
     * 题目二
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
     * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * @param n
     * @return
     */
    public static int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;

            a = b;
            b = sum;
        }
        return a;
    }
}

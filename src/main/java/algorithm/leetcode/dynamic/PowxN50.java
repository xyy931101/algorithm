package algorithm.leetcode.dynamic;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）
 * @Author: Xiongyy
 * @Date: 2021/4/11 17:18
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class PowxN50 {

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 2));
    }

    public static double myPow(double x, int n) {
        if (n == 0 ) {
            return 1;
        }
        double result = x;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                result *= x;
            }
            x *= x;
        }
        if (n < 0) {
            result = 1 / result;
        }
        return result;
    }

}

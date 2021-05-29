package algorithm.leetcode.array;

/**
 * @Author: Xiongyy
 * @Date: 2021/4/10 15:03
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class UglyNumber263 {

    public static void main(String[] args) {
        System.out.println(isUgly(-2147483648));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}

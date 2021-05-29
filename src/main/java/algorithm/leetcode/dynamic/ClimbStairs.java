package algorithm.leetcode.dynamic;

/**
 * @Author: Xiongyy
 * @Date: 2021/3/9 22:16
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {

        int p = 0, q= 0, result = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = result;
            result = p + q;
        }
        return result;
    }
}

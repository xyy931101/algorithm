package algorithm.leetcode.integer;

/**
 * 172. 阶乘后的零
 * @author: xiongyayun
 * @date: 2021/9/16 10:59 下午
 */
public class FactorialTrailingZeroes172 {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            n = n /5;
            res += n;
        }
        return res;
    }
}

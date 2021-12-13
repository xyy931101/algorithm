package algorithm.leetcode.integer;

/**
 * 29. 两数相除
 *
 * @author: xiongyayun
 * @date: 2021/12/13 11:05 下午
 */
public class DivideTwoIntegers29 {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) return 0;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        boolean flag = false;
        long a = dividend;
        long b = divisor;
        if (dividend < 0) {
            flag = !flag;
            a = -a;
        }
        if (divisor < 0) {
            flag = !flag;
            b = -b;
        }
        int res = div(a, b);

        return flag ? -res : res;
    }

    private int div(long a, long b) {
        if (a < b) return 0;
        int count = 1;
        long tb = b;
        while (tb + tb < a) {
            tb += tb;
            count += count;
        }
        return div(a - tb, b) + count;
    }

    //个人认为这个应该比上面的更好一点
    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                res += 1 << i;
                a -= b << i;
            }
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}

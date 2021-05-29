package algorithm.leetcode;

/**
 * 整数反转
 * @Author: Xiongyy
 * @Date: 2021/2/2 23:40
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ReverseInteger_7 {


    public static void main(String[] args) {
        System.out.println(-1 / 10);
        System.out.println(reverse(463847412));
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


}

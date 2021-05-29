package algorithm.leetcode.integer;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * @Author: Xiongyy
 * @Date: 2021/4/28 8:30
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class SumOfSquareNumbers633 {

    public static void main(String[] args) {
        SumOfSquareNumbers633 s = new SumOfSquareNumbers633();
        System.out.println(s.judgeSquareSum(5));
    }

    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        int left = 0, right = (int)Math.sqrt(c);

        while (left <= right) {
            int square = left * left + right * right;
            if (square == c) {
                return true;
            }
            if (square < c) {
                left ++;
            }else {
                right --;
            }
        }
        return false;
    }
}

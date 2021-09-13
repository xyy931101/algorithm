package algorithm.leetcode.array;

/**
 * @author: xiongyayun
 * @date: 2021/9/13 9:35 下午
 */
public class PlusOne66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

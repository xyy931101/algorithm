package algorithm.leetcode.stirng;

/**
 * 541. 反转字符串 II
 * @author: xiongyayun
 * @date: 2021/8/20 10:12 下午
 */
public class ReverseStringII541 {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1 || k < 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int start = 0; start < len; start += 2 * k) {
            reverse(chars, start, start + k >= len ? len - 1 : start + k - 1);
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

package algorithm.leetcode.stirng;

/**
 * 345. 反转字符串中的元音字母
 * @author: xiongyayun
 * @date: 2021/8/19 8:35
 */
public class ReverseVowelsOfAString345 {

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));

    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;

        String vowels = "aeiouAEIOU";

        // 将字符串转化成char类型数组
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && vowels.indexOf(chars[start]) < 0) {
                start++;
            }

            while (start < end && vowels.indexOf(chars[end]) < 0) {
                end--;
            }
            if (start < end) {
                swap(chars, start, end);
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

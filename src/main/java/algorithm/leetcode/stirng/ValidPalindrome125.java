package algorithm.leetcode.stirng;

/**
 * 125. 验证回文串
 * @author xiongyayun
 * @description
 * @date 2021/5/6 15:47
 */
public class ValidPalindrome125 {
    public static void main(String[] args) {
        ValidPalindrome125 c = new ValidPalindrome125();
        System.out.println(c.isPalindrome("A man, a plan, a canal: Panama"));
    }


    public boolean isPalindrome(String s) {
        //处理边界值
        if (s == null || s.length() == 0) return false;

        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (left < right && Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

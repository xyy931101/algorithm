package algorithm.swordFingerOffer.ii;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * @author: xiongyayun
 * @date: 2022/12/11 13:40
 */
public class ValidPalindrome19 {

    public boolean validPalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        int left = 0, right = s.length() - 1;
        while(left < right){
            if (s.charAt(left) != s.charAt(right))
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            left++;
            right--;
        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

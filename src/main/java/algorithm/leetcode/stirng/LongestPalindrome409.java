package algorithm.leetcode.stirng;

/**
 * @author: xiongyayun
 * @date: 2021/8/2 10:40 下午
 */
public class LongestPalindrome409 {

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0)return 0;
        int[] count  = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int i : count) {
            if (i % 2 == 0) ans += i;
        }
        return ans == s.length() ? ans : ans + 1;
    }
}

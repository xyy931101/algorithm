package algorithm.leetcode.stirng;

/**
 * 3. 无重复字符的最长子串
 * @author: xiongyayun
 * @date: 2021/8/21 11:03 下午
 */
public class LongestSubstringWithoutRepeatingCharacters3 {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] str = s.toCharArray();
        int[] map = new int[256];
        //因为第一个是为0的(也就是说  无论如何,第一个字符都是在0位的)
        for (int i = 1; i < 256; i++) {
            map[i] = -1;
        }
        int N = str.length;
        int ans = 1;
        int pre = 1;
        for (int i = 1; i < N; i++) {
            pre = Math.min(pre, i - map[str[i]]);
            ans = Math.max(pre, ans);
            map[str[i]] = i;
        }
        return ans;
    }

}

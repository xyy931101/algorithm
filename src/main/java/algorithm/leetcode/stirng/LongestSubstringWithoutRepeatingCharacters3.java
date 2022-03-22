package algorithm.leetcode.stirng;

import java.util.Arrays;

/**
 * 3. 无重复字符的最长子串
 * @author: xiongyayun
 * @date: 2021/8/21 11:03 下午
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] str = s.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int res = 0, left = 0;
        for(int i = 0; i < str.length; i++){
            char c = str[i];
            if(map[c] != -1){
                left = Math.max(map[c] + 1, left);
            }
            map[c] = i;
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

}

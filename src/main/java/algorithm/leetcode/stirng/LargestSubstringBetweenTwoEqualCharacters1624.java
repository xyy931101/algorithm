package algorithm.leetcode.stirng;

import java.util.Arrays;

/**
 * 1624. 两个相同字符之间的最长子字符串
 * @author: xiongyayun
 * @date: 2022/9/17 10:48
 */
public class LargestSubstringBetweenTwoEqualCharacters1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] index = new int[26];
        int ans = -1;
        Arrays.fill(index, -1);
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if(index[c] != -1){
                ans = Math.max(i - index[c], ans);
            }else {
                index[c] = i;
            }
        }
        return ans;
    }
}

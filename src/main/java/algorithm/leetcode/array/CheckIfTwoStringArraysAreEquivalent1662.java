package algorithm.leetcode.array;

/**
 * 1662. 检查两个字符串数组是否相等
 * @author: xiongyayun
 * @date: 2022/11/1 21:20
 */
public class CheckIfTwoStringArraysAreEquivalent1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int m = word1.length, n = word2.length;
        int i = 0, j = 0, p = 0, q = 0;
        while(i < m && j < n){
            if(word1[i].charAt(p++) != word2[j].charAt(q++)) return false;
            if(p == word1[i].length()) {
                i++;
                p = 0;
            }
            if(q == word2[j].length()) {
                j++;
                q = 0;
            }
        }
        return i == m && j == n;
    }
}

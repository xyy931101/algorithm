package algorithm.leetcode.stirng;

/**
 * 383. 赎金信
 * @author: xiongyayun
 * @date: 2021/12/4 12:27 下午
 */
public class RansomNote383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count  = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            count[c -'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

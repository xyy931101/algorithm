package algorithm.leetcode.stirng;

import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/9/14 8:18
 */
public class LongestWordInDictionaryThroughDeleting524 {

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        char[] chars = s.toCharArray();
        for (String str : dictionary) {
            char[] chs = str.toCharArray();
            for (int i = 0, j = 0; i < s.length() && j < str.length(); i++) {
                if (chars[i] == chs[j]) {
                    j++;
                }
                if (j == str.length()) {
                    if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) > 0)) {
                        res = str;
                    }
                }
            }

        }
        return res;
    }
}

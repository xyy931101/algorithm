package algorithm.leetcode.stirng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * @author: xiongyayun
 * @date: 2021/11/28 21:36
 */
public class FindAllAnagramsInAString438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        List<Integer> ans = new ArrayList<>();
        int a = 0;
        for (int i = 0; i < 26; i++) if (count[i] != 0) a++;

        for (int l = 0, r = 0, b = 0; r < s.length(); r++) {
            if (--count[s.charAt(r) - 'a'] == 0) b++;
            if (r - l + 1 > p.length() && ++count[s.charAt(l++) - 'a'] == 1) b--;
            if (a == b) ans.add(l);
        }
        return ans;
    }
}

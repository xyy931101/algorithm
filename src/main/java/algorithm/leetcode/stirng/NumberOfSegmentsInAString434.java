package algorithm.leetcode.stirng;

/**
 * 434. 字符串中的单词数
 * @author: xiongyayun
 * @date: 2021/10/7 15:03
 */
public class NumberOfSegmentsInAString434 {

    public int countSegments(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < s.length();) {

            if (s.charAt(i) == ' ' && i++ >= 0) continue;
            while (i < n && s.charAt(i) != ' ') i++;
            ans++;
        }
        return ans;
    }

}

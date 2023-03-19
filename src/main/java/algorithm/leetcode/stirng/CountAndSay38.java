package algorithm.leetcode.stirng;

/**
 * 38. 外观数列
 * @author: xiongyayun
 * @date: 2021/10/18 8:21
 */
public class CountAndSay38 {

    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder cur = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < ans.length()) {
                while (pos < ans.length() && ans.charAt(pos) == ans.charAt(start)) {
                    pos ++;
                }
                cur.append(pos - start).append(ans.charAt(start));
                start = pos;
            }
            ans = cur.toString();
        }
        ans.toCharArray()
        return ans;
    }
}

package algorithm.leetcode.stirng;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. 删除无效的括号
 *
 * @author: xiongyayun
 * @date: 2021/10/30 14:31
 */
public class RemoveInvalidParentheses301 {

    Set<String> set = new HashSet<>();
    int n, max, len;
    String str;

    public static void main(String[] args) {
        RemoveInvalidParentheses301 s = new RemoveInvalidParentheses301();
        System.out.println(s.removeInvalidParentheses("()())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return new ArrayList<>();
        }
        n = s.length();
        str = s;
        int l = 0, r = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                l++;
            } else if (ch == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        len = n - l - r;

        int c1 = 0, c2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') c1++;
            else if (c == ')') c2++;
        }
        max = Math.min(c1, c2);
        String cur = "";
        dfs(cur, 0, l, r, 0);
        return new ArrayList<>(set);
    }

    private void dfs(String cur, int index, int l, int r, int score) {
        if (l < 0 || r < 0 || score > max || score < 0) return;
        if (l == 0 && r == 0) {
            if (cur.length() == len) set.add(cur);
        }
        if (index >= n) return;
        char c = str.charAt(index);
        if (c == '(') {
            dfs(cur + c, index + 1, l, r, score + 1);
            dfs(cur, index + 1, l - 1, r, score);
        } else if (c == ')') {
            dfs(cur + c, index + 1, l, r, score - 1);
            dfs(cur, index + 1, l, r - 1, score);
        } else {
            dfs(cur + c, index + 1, l, r, score);
        }
    }
}

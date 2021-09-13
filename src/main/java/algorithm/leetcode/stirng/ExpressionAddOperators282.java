package algorithm.leetcode.stirng;

import java.util.LinkedList;
import java.util.List;

/**
 * 282. 给表达式添加运算符
 * 给定一个仅包含数字0-9的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、-或 *，
 * 返回所有能够得到目标值的表达式。
 * @author: xiongyayun
 * @date: 2021/9/12 8:08 下午
 */
public class ExpressionAddOperators282 {

    public List<String> addOperators(String num, int target) {
        //边界值判断
        List<String> ret = new LinkedList<>();
        if (num.length() == 0) {
            return ret;
        }
        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];

            dfs(ret, path, i + 1, 0, n, digits, i + 1, target); // 后续过程
            if (n == 0) {
                break;
            }
        }
        return ret;
    }

    public static void dfs(List<String> res, char[] path, int len,
                           long left, long cur,
                           char[] num, int index, int aim) {
        if (index == num.length) {
            if (left + cur == aim) {
                res.add(new String(path, 0, len));
            }
            return;
        }
        long n = 0;
        int j = len + 1;
        for (int i = index; i < num.length; i++) {
            n = n * 10 + num[i] - '0';
            path[j++] = num[i];
            path[len] = '+';
            dfs(res, path, j, left + cur, n, num, i + 1, aim);
            path[len] = '-';
            dfs(res, path, j, left + cur, -n, num, i + 1, aim);
            path[len] = '*';
            dfs(res, path, j, left, cur * n, num, i + 1, aim);
            if (num[index] == '0') {
                break;
            }
        }
    }
}

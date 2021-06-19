package algorithm.leetcode.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * @author: xiongyayun
 * @date: 2021/6/18 8:36
 */
public class RestoreIpAddresses93 {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        //已经递归到最后一个字符了
        if (begin == len) {
            //若可以构成ip,则加入res
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            //后面的ip段即使全部是3位，s还是会有剩下的，因此剪枝。
            if (residue * 3 < len - i) {
                continue;
            }

            //判断是否能构成IP地址段
            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);
                //继续进行递归
                dfs(s, len, i + 1, residue - 1, path, res);
                //移除当前字符,方便下次递归
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        //为0的开始的时候,进行剪枝
        if (len > 1 && s.charAt(left) == '0') {
            return false;
            //试试这次
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

}

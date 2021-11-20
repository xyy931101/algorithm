package algorithm.leetcode.stirng;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * @author: xiongyayun
 * @date: 2021/11/20 2:46 下午
 */
public class ZigzagConversion6 {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> strs = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            strs.add(new StringBuilder());
        }
        int flag = -1;
        int curRow = 0;
        for (char ch : s.toCharArray()) {
            strs.get(curRow).append(ch);
            if (curRow == 0 || curRow == numRows - 1) {
                flag = -flag;
            }
            curRow += flag;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder str : strs) {
            ans = ans.append(str);
        }
        return ans.toString();
    }
}

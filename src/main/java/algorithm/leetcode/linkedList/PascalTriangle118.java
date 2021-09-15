package algorithm.leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * @author: xiongyayun
 * @date: 2021/9/14 11:32 下午
 */
public class PascalTriangle118 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>());
            res.get(i).add(1);
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> rows = res.get(i);
            for (int j = 1; j < i; j++) {
                rows.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            rows.add(1);
        }
        return res;
    }
}

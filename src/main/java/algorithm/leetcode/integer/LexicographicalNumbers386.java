package algorithm.leetcode.integer;

import java.util.LinkedList;
import java.util.List;

/**
 * 386. 字典序排数
 * @author: xiongyayun
 * @date: 2022/4/18 22:39
 */
public class LexicographicalNumbers386 {


    public static void main(String[] args) {
        lexicalOrder(123);
    }
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0, j = 1; i < n; i++) {
            res.add(j);
            if (j * 10 < n) j *= 10;
            else {
                while (j % 10 == 9 || j + 1 > n) j /= 10;

                j++;
            }
        }

        return res;
    }
}

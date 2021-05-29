package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xiongyy
 * @Date: 2021/3/29 8:25
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class Permute_46 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        if (nums.length == 1) {
            return new ArrayList<>(new ArrayList<>(nums[1]));
        }
        return new ArrayList<>();
    }
}

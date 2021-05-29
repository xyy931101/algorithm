package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * @Author: Xiongyy
 * @Date: 2021/3/10 23:52
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class CombinationSum {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<Integer>();
        process(candidates, combine, 0, target);
        return ans;
    }

    private void process(int[] candidates, List<Integer> combine, int index, int target) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过(先直接递归找到最后的成员)
        process(candidates, combine, index + 1, target);
        if (target >= candidates[index]) {
            //如果还能继续加的话,先把当前元素加上
            combine.add(candidates[index]);
            process(candidates, combine, index, target - candidates[index]);
            combine.remove(combine.size() - 1);
        }
    }
}

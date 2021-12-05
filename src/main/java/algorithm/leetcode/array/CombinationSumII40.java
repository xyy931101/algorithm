package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/12/5 10:56 下午
 */
public class CombinationSumII40 {

    int len;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        len = candidates.length;
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        List<List<Integer>> res = new ArrayList<>();

        dfs(new ArrayList<Integer>(), res, 0, target);
        return res;
    }

    private void dfs(List<Integer> path, List<List<Integer>> res, int begin, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(path, res, i + 1, target - candidates[i]);
            path.remove(path.size() -  1);
        }
    }

}

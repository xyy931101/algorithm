package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));;
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new LinkedList<>(), 0);
        return res;
    }

    public void dfs(int[] candidates, int target, Deque<Integer> path, int index) {
        if(target < 0 || index >= candidates.length) return;
        if(target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            int num = candidates[i];
            if (target - num < 0) {
                break;
            }
            path.addLast(num);
            dfs(candidates, target - num, path, i);
            path.removeLast();
        }
    }
}

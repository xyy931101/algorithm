package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/12/5 10:56 下午
 */
public class CombinationSumII40 {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        dfs(candidates, new LinkedList<Integer>(), res, 0, target);
        return res;
    }

    public static void dfs(int[] candidates, List<Integer> path, List<List<Integer>> res, int index, int target){
        if(target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                return;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, path, res, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    /*private void dfs(List<Integer> path, List<List<Integer>> res, int begin, int target) {
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
    }*/

}

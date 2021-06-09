package algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 * @author: xiongyayun
 * @date: 2021/6/8 10:27 下午
 */
public class PathSumIII437 {

    Map<Integer, Integer> prefixSumCount = new HashMap<>();

        int targetSum;

        public int pathSum(TreeNode root, int targetSum) {
            // 前缀和为0的一条路径
            this.targetSum = targetSum;
            prefixSumCount.put(0, 1);

            return recursionPathSum(root, 0);
    }

    public int recursionPathSum(TreeNode root, int curSum) {
        if (root == null) return 0;

        //做本层做的事情
        int res = 0;
        //包含本节点的值
        curSum = curSum + root.val;
        //两个节点之前的总sum相减为target,则认为两点之前的和为target
        res += prefixSumCount.getOrDefault(curSum - targetSum, 0);
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        res += recursionPathSum(root.left, curSum);

        res += recursionPathSum(root.right, curSum);

        //减掉当前层,避免影响上一层的回溯(因为路径和的前提条件是,必须是其中的路径上面)
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);

        return res;
    }
}

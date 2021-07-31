package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * @author: xiongyayun
 * @date: 2021/7/28 8:25
 */
public class AllNodesDistanceKInBinaryTree863 {

    private List<Integer> res = new ArrayList<>();
    private TreeNode newTree;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) return new ArrayList<>();
        dfs(root, target, null);
        collect(target, 0, k);
        collect(newTree, 0, k - 1);
        return res;
    }

    private void collect(TreeNode root, int level, int k) {
        if (root == null) {
            return;
        }
        // 如果达到指定搜索深度，返回搜寻结果
        if (level == k) {
            res.add(root.val);
        }else {
            collect(root.left, level + 1, k);
            collect(root.right, level + 1, k);
        }
    }

    private boolean dfs(TreeNode root, TreeNode target, TreeNode farther) {
        //baseCase
        if (root == null) {
            return false;
        }

        if (target == root) {
            newTree = farther;
            return true;
        }
        //如果目标节点是在左树,则
        if (dfs(root.left, target, root)) {
            root.left = farther;
            return true;
        }
        if (dfs(root.right, target, root)) {
            root.right = farther;
            return true;
        }
        return false;
    }

}

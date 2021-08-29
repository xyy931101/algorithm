package algorithm.leetcode.tree;

import java.util.Stack;

/**
 * @author: xiongyayun
 * @date: 2021/8/29 11:23 下午
 */
public class RecoverBinarySearchTree99 {


    public static void recoverTree(TreeNode root) {
        if (root == null) return;
        TreeNode[] errors = twoErrors(root);
        if (errors[0] != null && errors[1] != null) {
            int tmp = errors[0].val;
            errors[0].val = errors[1].val;
            errors[1].val = tmp;
        }
    }


    //查找出二叉搜索数中乱序的两个数
    private static TreeNode[] twoErrors(TreeNode root) {

        TreeNode[] errs = new TreeNode[2];
        if (root == null) {
            return errs;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null && pre.val > root.val) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = root;
                }
                pre = root;
                root = root.right;
            }
        }
        return errs;
    }
}

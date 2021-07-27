package algorithm.leetcode.tree;

/**
 * 110. 平衡二叉树
 * @author: xiongyayun
 * @date: 2021/7/27 9:01 下午
 */
public class BalancedBinaryTree110 {
    public static class Info{
        boolean isBalance;
        int height;

        public Info(boolean isBalance, int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public Info process(TreeNode root) {
        if (root == null) return new Info(true, 0);
        Info left = process(root.left);
        Info right = process(root.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalance = true;
        if (!left.isBalance || !right.isBalance || Math.abs(left.height - right.height) > 2) {
            isBalance = false;
        }
        return new Info(isBalance, height);
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }
}

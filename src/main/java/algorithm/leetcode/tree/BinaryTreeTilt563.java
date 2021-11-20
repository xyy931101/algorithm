package algorithm.leetcode.tree;

/**
 * 563. 二叉树的坡度
 * @author: xiongyayun
 * @date: 2021/11/18 19:52
 */
public class BinaryTreeTilt563 {
    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans += Math.abs(left - right);
        return left + root.val + right;
    }
}

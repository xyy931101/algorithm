package algorithm.leetcode.tree;

/**
 * @author xiongyayun
 * @date 2021/5/15 22:51
 */
public class MergeTwoBinaryTrees617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        return process(root1, root2);
    }

    private TreeNode process(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1== null? root2 : root1;
        }
        root1.val += root2.val;
        root1.left = process(root1.left, root2.left);
        root1.right = process(root1.right, root2.right);
        return root1;
    }
}

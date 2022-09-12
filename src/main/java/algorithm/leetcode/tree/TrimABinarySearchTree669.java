package algorithm.leetcode.tree;

/**
 * 669. 修剪二叉搜索树
 * @author: xiongyayun
 * @date: 2022/9/12 11:02
 */
public class TrimABinarySearchTree669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        if(root.val < low) return right;
        if(root.val > high) return left;
        root.left = left;
        root.right = right;
        return root;
    }

}

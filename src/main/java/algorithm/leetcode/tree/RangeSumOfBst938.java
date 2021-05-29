package algorithm.leetcode.tree;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * @Author: Xiongyy
 * @Date: 2021/4/27 21:37
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RangeSumOfBst938 {

    public static void main(String[] args) {
        RangeSumOfBst938 r = new RangeSumOfBst938();
        System.out.println(r.rangeSumBST(TreeNode.getHead(), 0, 5));
    }

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        //处理边界值
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

}

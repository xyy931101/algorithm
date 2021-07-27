package algorithm.leetcode.tree;

/**
 * 671. 二叉树中第二小的节点
 *
 * @author: xiongyayun
 * @date: 2021/7/27 8:12
 */
public class SecondMinimumNodeInABinarTree671 {


    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }

    public int helper(TreeNode root, int minVal) {
        //叶子端点
        if (root == null) {
            return -1;
        }
        //如果当前结点值>根节点，那么不用再遍历它的子节点，直接返回该值
        if (root.val > minVal) {
            return root.val;
        }

        //否则，即当前结点值==根节点,则需要在两棵子树找目标值结点
        int l = helper(root.left, minVal);
        int r = helper(root.right, minVal);

        if (l != -1 && r != -1) {
            return Math.min(l, r);
        } else {//否则，其余情况均返回较大的那一个
            return Math.max(l, r);
        }
    }
}

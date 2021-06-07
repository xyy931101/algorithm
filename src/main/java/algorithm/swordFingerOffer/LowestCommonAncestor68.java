package algorithm.swordFingerOffer;

import algorithm.leetcode.tree.TreeNode;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * @Author: Xiongyy
 * @Date: 2021/4/17 17:58
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LowestCommonAncestor68 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当节点为空，或者有其中一个节点时,返回
        if (root == null || root == p || root == q) {
            return root;
        }

        //先向下取左节点的公共树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        //此时左节点为空,右节点不为空,返回右节点
        if (left == null) {
            return right;
        }
        //此时右节点为空,左节点不为空,则返回左节点
        if (right == null) {
            return left;
        }
        //此时左右节点都不为空,为最近公共祖先
        return root;

    }
}

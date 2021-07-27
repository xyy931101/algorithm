package algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * @author: xiongyayun
 * @date: 2021/7/27 11:05 下午
 */
public class LowestCommonAncestorOfABinarySearchTree235 {

    public class Info{
        boolean hasP;
        boolean hasQ;
        TreeNode node;

        public Info(boolean hasP, boolean hasQ, TreeNode node){
            this.hasP = hasP;
            this.hasQ = hasQ;
            this.node = node;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        return process(root, p, q).node;
    }

    public Info process(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(root.left, p, q);
        Info rightInfo = process(root.right, p, q);

        boolean hasP = root == p || leftInfo.hasP || rightInfo.hasP;
        boolean hasQ = root == q || leftInfo.hasQ || rightInfo.hasQ;

        TreeNode node = null;
        if (leftInfo.node != null) node = leftInfo.node;
        else if (rightInfo.node != null) node = rightInfo.node;
        else if (hasP && hasQ) node = root;
        return new Info(hasP, hasQ, node);

    }
}

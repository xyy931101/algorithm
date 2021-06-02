package algorithm.swordFingerOffer;

import algorithm.leetcode.tree.TreeNode;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/19 22:29
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MirrorTree_27 {

    public static void main(String[] args) {
        TreeNode head = TreeNode.getHead();
        mirrorTree(head);
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root != null){
            TreeNode leftRoot = mirrorTree(root.right);
            TreeNode rightRoot = mirrorTree(root.left);
            root.left = leftRoot;
            root.right = rightRoot;
        }
        return root;
    }

}

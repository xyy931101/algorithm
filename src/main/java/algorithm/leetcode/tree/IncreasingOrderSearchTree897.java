package algorithm.leetcode.tree;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点。
 * @Author: Xiongyy
 * @Date: 2021/4/25 8:27
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class IncreasingOrderSearchTree897 {

    TreeNode prev;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        prev = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    /**
     * 深度优先,先处理完左树
     * @param node
     */
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        //将前一个node的右节点赋值(因为是深度优先的关系,所以不存在覆盖的情况)
        prev.right = node;
        //将左节点值设置为空
        node.left = null;
        //将前置node设置为当前节点
        prev = node;
        //深度遍历右节点
        inorder(node.right);
    }
}

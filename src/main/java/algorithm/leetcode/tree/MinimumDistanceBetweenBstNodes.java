package algorithm.leetcode.tree;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * @Author: Xiongyy
 * @Date: 2021/4/13 10:40
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MinimumDistanceBetweenBstNodes {

    int res;
    int prev;

    public static void main(String[] args) {
        MinimumDistanceBetweenBstNodes s = new MinimumDistanceBetweenBstNodes();
        System.out.println(s.minDiffInBST(TreeNode.getHead()));
    }


    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        res = Integer.MAX_VALUE;
        prev = -1;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev == -1) {
            prev = root.val;
        }else {
            res = Math.min(res, root.val - prev);
            prev = root.val;
        }
        dfs(root.right);
    }

}

package algorithm.leetcode.tree;

/**
 * 230. 二叉搜索树中第K小的元素
 * @author: xiongyayun
 * @date: 2021/7/28 12:14 上午
 */
public class KthSmallestElementInABst230 {

    int res;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return res;
    }

    public void dfs(TreeNode root, int k){
        if (root == null) return;

        dfs(root.left, k);
        count++;
        if (count == k){
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}

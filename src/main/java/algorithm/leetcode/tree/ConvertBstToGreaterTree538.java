package algorithm.leetcode.tree;

/**
 * 538. 把二叉搜索树转换为累加树
 * @author: xiongyayun
 * @date: 2021/6/20 8:58 下午
 */
public class ConvertBstToGreaterTree538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}

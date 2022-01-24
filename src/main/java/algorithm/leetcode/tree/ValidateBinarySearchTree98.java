package algorithm.leetcode.tree;

/**
 * 98. 验证二叉搜索树
 * @author: xiongyayun
 * @date: 2022/1/9 14:12
 */
public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root).isBst;
    }

    public TreeInfo dfs(TreeNode root) {
        if(root == null){
            return new TreeInfo(true, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        TreeInfo leftInfo = dfs(root.left);
        TreeInfo rightInfo = dfs(root.right);
        boolean isBst = leftInfo.isBst && rightInfo.isBst && leftInfo.maxValue < root.val && rightInfo.minValue > root.val;
        long maxValue = Math.max(Long.valueOf(root.val), rightInfo.maxValue);
        long minValue = Math.min(root.val, leftInfo.minValue);
        return new TreeInfo(isBst, maxValue, minValue);
    }

    class TreeInfo{
        boolean isBst;
        Long maxValue;
        Long minValue;

        public TreeInfo(boolean isBst, long maxValue, long minValue){
            this.isBst = isBst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
}

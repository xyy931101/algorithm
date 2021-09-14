package algorithm.leetcode.tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * @author: xiongyayun
 * @date: 2021/9/14 10:44 下午
 */
public class ConvertSortedArrayToBinarySearchTree108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return toBst(nums, 0, nums.length - 1);
    }

    public TreeNode toBst(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        if (L == R) {
            return new TreeNode(nums[L]);
        }
        int mid = (R + L) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toBst(nums, L, mid - 1);
        node.right = toBst(nums, mid + 1, R);
        return node;
    }
}

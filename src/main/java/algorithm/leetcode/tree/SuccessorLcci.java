package algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiongyayun
 * @date: 2022/5/16 21:50
 */
public class SuccessorLcci {

    TreeNode next = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;
    }
}

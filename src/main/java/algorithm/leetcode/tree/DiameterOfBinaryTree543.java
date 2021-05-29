package algorithm.leetcode.tree;

/**
 * @author xiongyayun
 * @date 2021/5/20 23:50
 */
public class DiameterOfBinaryTree543 {

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        //返回左子树的最大深度
        int L = depth(root.left);
        //返回右子树的最大深度
        int R = depth(root.right);
        //更新最大直径
        ans = Math.max(ans, L + R);
        //返回根几点作为子树的最大深度(因为要包含本身,所以要加1)
        return Math.max(L, R) + 1;
    }
}

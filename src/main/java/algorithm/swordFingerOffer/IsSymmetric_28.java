package algorithm.swordFingerOffer;

import com.examplexyy.demo.algorithm.leetcode.tree.IsSymmetric;
import com.examplexyy.demo.algorithm.leetcode.tree.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * @Author: Xiongyy
 * @Date: 2021/2/19 22:48
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class IsSymmetric_28 {

    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.getHead()));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if(p == null && q == null ){
            return true;
        }
        if(p == null || q == null ){
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

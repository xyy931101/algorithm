package algorithm.swordFingerOffer;

import algorithm.leetcode.tree.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @Author: Xiongyy
 * @Date: 2021/2/19 21:47
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class IsSubStructure_26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
       if((A != null && B != null)){
            return  recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
       }
       return  false;
    }

    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


}

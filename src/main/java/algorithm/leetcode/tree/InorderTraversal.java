package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历
 * @Author: Xiongyy
 * @Date: 2021/3/10 8:27
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        process(result, root);
        return result;

    }

    public void process(List<Integer> result, TreeNode root){
        if(root == null){
            return;
        }
        process(result, root.left);
        result.add(root.val);
        process(result, root.right);
    }
}

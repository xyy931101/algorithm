package algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: xiongyayun
 * @date: 2022/8/17 20:43
 */
public class DeepestLeavesSum1302 {

    public static void main(String[] args) {
        System.out.println(deepestLeavesSum(TreeNode.getHead()));
    }

    public static int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        int result = 0;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.push(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            int level = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = deque.pollFirst();
                level += node.val;
                if(node.left != null){
                    deque.add(node.left);
                }
                if(node.right != null){
                    deque.add(node.right);
                }
            }
            result = level;
        }
        return result;
    }
}

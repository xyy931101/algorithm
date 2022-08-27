package algorithm.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: xiongyayun
 * @date: 2022/8/19 8:33
 */
public class AddOneRowToTree623 {

    public static void main(String[] args) {
        System.out.println(addOneRow(TreeNode.getHead(), 100, 2));
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return null;
        if(depth == 1) return new TreeNode(val, root, null);
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.add(root);
        while(--depth > 1){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.pollFirst();
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }
        }
        for( TreeNode node : deque){
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        }
        return root;
    }


}

package algorithm.swordFingerOffer.ii;

import algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 046. 二叉树的右侧视图
 */
public class RightSideView46 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            res.add(deque.peek().val);
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode node = deque.poll();
                if(node.right != null) deque.addLast(node.right);
                if(node.left != null) deque.addLast(node.left);
            }
        }
        return res;
    }

}

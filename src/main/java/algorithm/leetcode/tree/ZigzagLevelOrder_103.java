package algorithm.leetcode.tree;

import java.util.*;

/**
 * @Author: Xiongyy
 * @Date: 2021/3/13 16:46
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ZigzagLevelOrder_103 {
    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeNode.getHead()));
    }


    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {

                TreeNode curNode = nodeQueue.poll();
                levelList.addFirst(curNode.val);
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;

    }
}

package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: xiongyayun
 * @date: 2021/9/14 10:59 下午
 */
public class PopulatingNextRightPointersInEachNode116 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (i < size - 1) {
                    poll.next = queue.peek();
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
}

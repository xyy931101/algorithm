package algorithm.leetcode.common;

/**
 * @author: xiongyayun
 * @date: 2021/6/6 13:53
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node getInstance() {
        Node seven = new Node(7);
        Node three = new Node(13);
        seven.next = three;
        three.random = seven;
        return seven;
    }
}

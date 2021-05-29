package algorithm.bilibili;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/6 15:33
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class Node{

    public int value;
    public Node left;
    public Node right;

    public Node(int v){
        this.value = v;
    }

    public static Node getHead(){
        Node head = new Node(1);
        Node head2 = new Node(2);
        head.left = head2;
        Node head3 = new Node(3);
        head.right = head3;
        Node head4 = new Node(4);
        head2.left = head4;
        Node head5 = new Node(5);
        head2.right = head5;
        head5.right = new Node(8);
        Node head6 = new Node(6);
        head3.left = head6;
        head6.left = new Node(9);
        Node head7 = new Node(7);
        head3.right = head7;
        return head;
    }
}

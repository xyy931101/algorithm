package algorithm.bilibili;

import java.util.Stack;

/**
 * 二叉树的先序，中序，后序遍历
 * @Author: Xiongyy
 * @Date: 2021/2/6 13:31
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class TwoTree {

    public static void main(String[] args) {
        Node head = Node.getHead();
        System.out.print("prd-order:");
        pre(head);
        System.out.println();
        preByStack(head);
        System.out.println("==============");

        System.out.print("in-order:");
        in(head);
        System.out.println();
        inByStack(head);
        System.out.println();

        System.out.println("==============");

        System.out.print("pos-order:");

        pos(head);
        System.out.println();

        posByStack(head);
    }

    /**
     * 先序遍历
     * @param head
     */
    public static void pre(Node head){
        if (head == null){
            return ;
        }
        System.out.print(head.value + ", ");
        pre(head.left);
        pre(head.right);
    }

    public static void preByStack(Node head){
        System.out.print("prd-order:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + ", ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历
     */
    public static void in(Node head){
        if (head == null){
            return ;
        }
        in(head.left);
        System.out.print(head.value + ", ");
        in(head.right);
    }

    public static void inByStack(Node head){
        System.out.print("in-order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value + ", ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void pos(Node head){
        if (head == null){
            return ;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + ", ");
    }

    public static void posByStack(Node head){
        System.out.print("pos-order:");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            Node c = null;
            stack.push(head);
            while (!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && c.left != head && c.right != head){
                    stack.push(c.left);
                }else if(c.right != null && c.right != head){
                    stack.push(c.right);
                }else{
                    System.out.print(stack.pop().value + ", ");
                    head = c;
                }
            }
        }
    }
}




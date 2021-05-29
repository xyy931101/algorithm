package algorithm.bilibili;

/**
 * 打印二叉树
 * @Author: Xiongyy
 * @Date: 2021/2/7 19:23
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class PrintTwoTree {


    public static void main(String[] args) {
        Node head = Node.getHead();
        printInOrder(head, 0, "H", 17);
    }

    public static void printInOrder(Node head, int height, String to, int len){
        if(head == null){
            return;
        }
        //打印右节点
        printInOrder(head.right, height+1, "^", len);

        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        //打印左节点
        printInOrder(head.left, height + 1, "v", len);
    }

    private static String getSpace(int len) {
        String space = " ";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < len; i++) {
            buf.append(space);
        }
        return  buf.toString();
    }
}

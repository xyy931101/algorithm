package algorithm.bilibili;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 判断一个节点是不是平衡二叉树
 * @Author: Xiongyy
 * @Date: 2021/2/7 21:02
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        System.out.println(isBalanced(Node.getHead()));
    }

    public static boolean isBalanced(Node X){
        return process2(X).isBalanced;
    }

    /**
     * 左右树返回的信息，
     */
    @Data
    @AllArgsConstructor
    public static class Info{
        /**
         * 是否是平衡树
         */
        public boolean isBalanced;
        /**
         * 节点高度
         */
        public int height;
    }


    public static Info process2(Node X){
        if(X == null){
            return new Info(true, 0);
        }

        Info leftInfo = process2(X.left);
        Info rightInfo = process2(X.right);

        int height = Math.max(leftInfo.height, rightInfo.height) +1;

        boolean isBalanced = true;
        if(!leftInfo.isBalanced || !rightInfo.isBalanced() || Math.abs(leftInfo.height - rightInfo.height) > 1){
            isBalanced = false;
        }
        return new Info(isBalanced, height);
    }
}

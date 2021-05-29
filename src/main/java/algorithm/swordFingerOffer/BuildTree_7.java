package algorithm.swordFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @Author: Xiongyy
 * @Date: 2021/2/9 19:59
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class BuildTree_7 {


    /**
     *   缓存中序遍历数组每个值对应的索引
     */
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public BinaryTreeNode buildTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++){
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     *
     * @param pre 前序的所有数值
     * @param preL 前序遍历中,左边界的值
     * @param preR 前序遍历中,右边界的值
     * @param inL  中序遍历中,左边界的值
     * @return
     */
    private BinaryTreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        //如果达到了边界,则返回空
        if (preL > preR){
            return null;
        }
        //在前序遍历中的第一个值,是其根根节点
        BinaryTreeNode root = new BinaryTreeNode(pre[preL]);
        //得到根节点在中序遍历中的index
        int inIndex = indexForInOrders.get(root.val);
        //那么在中序遍历中,根节点到中序遍历的左边界,就是整个左子树的所有数值
        int leftTreeSize = inIndex - inL;
        //同理可得,在前序遍历中的根节点的下一个节点就是左子树的根节点,
        //上一次的左边界+整个左子树的范围就是在前序遍历中的左子树的边界
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        //在右子树中,跟节点的值的下标 + 左子树 + 1  就是右子树的左边界, 右边界永远都是之前右边,
        //中序遍历中的左边界 +
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}

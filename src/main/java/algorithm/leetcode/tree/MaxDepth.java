package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author: Xiongyy
 * @Date: 2021/2/7 22:45
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MaxDepth {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {

        return process(root).maxLevel;


    }

    public static NodeInfo process(TreeNode root){
        if (root == null){
            return new NodeInfo(0);
        }
        NodeInfo leftInfo = process(root.left);
        NodeInfo rightInfo = process(root.right);
        return new NodeInfo(Math.max(leftInfo.maxLevel, rightInfo.maxLevel) + 1);
    }

}

class NodeInfo{
    /**
     * 左节点层级
     */
    int maxLevel;


    public NodeInfo(int leftLevel){
        this.maxLevel = leftLevel;
    }
}

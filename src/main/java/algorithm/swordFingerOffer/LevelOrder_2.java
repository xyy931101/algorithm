package algorithm.swordFingerOffer;

import algorithm.leetcode.tree.TreeNode;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * @Author: Xiongyy
 * @Date: 2021/2/22 23:21
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LevelOrder_2 {

    public static void main(String[] args) {
        LevelOrder_2 order = new LevelOrder_2();
        System.out.println(JSONObject.toJSONString(order.levelOrder(TreeNode.getHead())));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }
}

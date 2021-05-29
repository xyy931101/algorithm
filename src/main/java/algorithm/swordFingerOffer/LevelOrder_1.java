package algorithm.swordFingerOffer;

import com.alibaba.fastjson.JSONObject;
import com.examplexyy.demo.algorithm.bilibili.Node;
import com.examplexyy.demo.algorithm.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @Author: Xiongyy
 * @Date: 2021/2/22 22:52
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LevelOrder_1 {

    public static void main(String[] args) {
        TreeNode head = TreeNode.getHead();
        LevelOrder_1 level = new LevelOrder_1();
        System.out.println(JSONObject.toJSONString(level.levelOrder(head)));
    }

    public  int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            ans.add(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
        int [] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public void addQueQue(TreeNode root, Queue queque){
        if(root == null){
            return;
        }
        queque.add(root);
        addQueQue(root.left, queque);
        addQueQue(root.right, queque);
    }

}

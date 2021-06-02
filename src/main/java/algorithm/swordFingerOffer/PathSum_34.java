package algorithm.swordFingerOffer;

import algorithm.leetcode.tree.TreeNode;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * @Author: Xiongyy
 * @Date: 2021/2/24 22:04
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class PathSum_34 {

    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode head = TreeNode.getHead();
        System.out.println(JSONObject.toJSONString(pathSum(head, 6)));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        process(root, sum);
        return res;
    }

    public static void process(TreeNode root, int tar){
        if(root == null){
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null){
            res.add(new LinkedList(path));
        }
        process(root.left, tar);
        process(root.right, tar);
        path.removeLast();
    }


}

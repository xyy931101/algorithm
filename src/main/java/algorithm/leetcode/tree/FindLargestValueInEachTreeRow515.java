package algorithm.leetcode.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Xiongyy
 * @Date: 2021/4/22 8:48
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FindLargestValueInEachTreeRow515 {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(largestValues(TreeNode.getHead())));
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largest = new LinkedList<>();
        if (root == null) {
            return largest;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.removeLast();
                max = Math.max(node.val, max);
                if (node.left !=null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            largest.add(max);
        }

        return largest;
    }

}

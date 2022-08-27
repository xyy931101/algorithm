package algorithm.leetcode.tree;

import java.util.*;

/**
 * 662. 二叉树最大宽度
 * @author: xiongyayun
 * @date: 2022/3/3 1:52 下午
 */
public class MaximumWidthOfBinaryTree662 {

    public static void main(String[] args) {
        System.out.println(widthOfBinaryTree(TreeNode.getHead()));
    }
    //记录每层最左的下标
    public Map<Integer, Integer> map = new HashMap<>();
    private int ans = 0;

    //这个是最好理解的
    public int widthOfBinaryTree1(TreeNode root) {
        dfs(root, 1, 0);
        return  ans;
    }

    private void dfs(TreeNode root, int index, int depth) {
        if (root == null) return;
        if (!map.containsKey(depth)) map.put(depth, index);
        ans = Math.max(ans, index - map.get(depth) + 1);
        dfs(root.left, index << 1, depth + 1);
        dfs(root.right, index << 1 | 1, depth + 1);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.offer(root);
        list.add(1);
        int res = 1;
        while (!q.isEmpty()) {
            int count = q.size();
            for(int i =count; i> 0; i--) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                if(cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 +1);
                }
            }
            // list 中 size 为 1 的情况下，宽度也为 1，没有必要计算。
            if(list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }

        return res;
    }
}

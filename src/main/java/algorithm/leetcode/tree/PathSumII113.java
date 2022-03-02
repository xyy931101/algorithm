package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2022/2/28 9:46 下午
 */
public class PathSumII113 {

    public static void main(String[] args) {
        PathSumII113 p = new PathSumII113();
        System.out.println(p.pathSum(TreeNode.getHead(), 7));
    }


    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<Integer>(), targetSum);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> path, int targetSum) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if (targetSum == root.val){
                path.add(root.val);
                res.add(new ArrayList(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        dfs(root.left, path, targetSum);
        dfs(root.right, path, targetSum);
        path.remove(path.size() - 1);
    }
}

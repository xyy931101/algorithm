package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2022/5/30 21:30
 */
public class BinaryTreePaths257 {

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        List<String> result = new LinkedList<String>();
        if(root == null) return result;
        dfs(root, path, result);
        return result;
    }

    public void dfs(TreeNode root, StringBuilder path, List<String> result){
        if (root == null) return;
        int cur = path.length();
        path.append(root.val);
        if(root.left == null && root.right == null){
            result.add(path.toString());
            path.delete(cur, path.length());
            return;
        }
        path.append("->");
        dfs(root.left, path, result);
        dfs(root.right, path, result);
        path.delete(cur, path.length());
    }
}

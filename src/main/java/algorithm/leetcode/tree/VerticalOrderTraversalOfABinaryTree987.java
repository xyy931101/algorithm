package algorithm.leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 987. 二叉树的垂序遍历
 * @author: xiongyayun
 * @date: 2021/7/31 17:48
 */
public class VerticalOrderTraversalOfABinaryTree987 {

    public static void main(String[] args) {
        VerticalOrderTraversalOfABinaryTree987 v =new VerticalOrderTraversalOfABinaryTree987();
        System.out.println(v.verticalTraversal(TreeNode.getHead()));
    }

    Integer minRow = 0;
    Integer maxRow = 0;
    Map<Integer, List<Integer[]>> levelMap = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = minRow; i <= maxRow; i++) {
            List<Integer[]> levelValue = levelMap.get(i);
            List<Integer> list = levelValue.stream().sorted(((o1, o2) -> {
                if (o1[1] == o2[1]){
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            })).map(arr -> arr[0]).collect(Collectors.toList());
           res.add(list);
        }
        return res;
    }

    private void dfs(TreeNode root, int row, int cell) {
        if (root == null) return;
        List<Integer[]> levelValues = levelMap.getOrDefault(row, new ArrayList<>());
        levelValues.add(new Integer[]{root.val, cell});
        levelMap.put(row, levelValues);
        minRow = Math.min(minRow, row);
        maxRow = Math.max(maxRow, row);
        dfs(root.left, row - 1, cell + 1);
        dfs(root.right, row + 1, cell + 1);
    }
}

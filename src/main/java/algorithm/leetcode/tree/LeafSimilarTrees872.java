package algorithm.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiongyayun
 * @date 2021/5/10 8:31
 */
public class LeafSimilarTrees872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> leaf1 = new LinkedList<>();
        List<Integer> leaf2= new LinkedList<>();
        getLeaf(root1, leaf1);
        getLeaf(root2, leaf2);

        if (leaf1.size() != leaf2.size()) {
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            if (leaf1.get(i) != leaf2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void getLeaf(TreeNode root, List<Integer> leaf) {
        if (root == null) {
            return;
        }
        getLeaf(root.left, leaf);
        getLeaf(root.right, leaf);
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
        }
    }
}

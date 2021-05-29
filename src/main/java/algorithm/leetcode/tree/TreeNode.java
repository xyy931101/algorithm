package algorithm.leetcode.tree;

/**
 * 二叉树结构
 * @Author: Xiongyy
 * @Date: 2021/2/7 23:07
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode getHead(){
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.left = four;
        two.right = five;
        TreeNode six = new TreeNode(6);
        TreeNode se = new TreeNode(7);
        three.left = six;
        three.right = se;
        return one;
    }
}

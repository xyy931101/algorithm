package algorithm.leetcode.tree;

/**
 * 450. 删除二叉搜索树中的节点
 * @author: xiongyayun
 * @date: 2022/3/5 7:36 下午
 */
public class DeleteNodeInABst450 {

    public static void main(String[] args) {
        Integer a = 1000, b = 1000;
        Integer c = 100, d = 100;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            //root就是要删除的节点
            if(root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }else {
                TreeNode node = root.right;
                while (node.left != null){
                    node = node.left;
                }
                node.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}

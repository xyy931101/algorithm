package algorithm.leetcode.tree;

/**
 * 222. 完全二叉树的节点个数
 * @author: xiongyayun
 * @date: 2022/11/21 21:39
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        //如果左树和右树层级相同，则证明左树是被完全填满的，则左树的个数是2^n - 1
        //然后加上当前节点，则为2^n + 右树节点
        //反之，则证明左树没有填满。则右树是满的
        if(left == right) return countNodes(root.right) + (1 << left);
        else return countNodes(root.left) + (1 << right);
    }

    //计算二叉树的层数
    public int countLevel(TreeNode root){
        int res = 0;
        while(root != null){
            root = root.left;
            res++;
        }
        return res;
    }
}

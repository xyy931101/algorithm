package algorithm.leetcode.tree;

/**
 * 337. 打家劫舍 III
 * @author: xiongyayun
 * @date: 2021/6/9 9:39 下午
 */
public class HouseRobberIII337 {

    public int rob(TreeNode root) {
        ReturnInfo process = process(root);
        return Math.max(process.maxChild, process.maxSelf);
    }

    private ReturnInfo process(TreeNode root) {
        if (root == null) return new ReturnInfo(0, 0);
        //处理左子树
        ReturnInfo leftInfo = process(root.left);
        //处理右子树
        ReturnInfo rightInfo = process(root.right);
        //获取子节点的最大值
        int childMax = Math.max(leftInfo.maxChild, leftInfo.maxSelf) + Math.max(rightInfo.maxChild, rightInfo.maxSelf);
        return new ReturnInfo(childMax, root.val + leftInfo.maxChild + rightInfo.maxChild);
    }
}

class ReturnInfo{
    //子节点的最大和(这里是子节点本身或节点的子节点的最大值)
    public int maxChild;
    //选择本身的最大和
    public int maxSelf;

    public ReturnInfo(int maxChild, int maxSelf) {
        this.maxChild = maxChild;
        this.maxSelf = maxSelf;
    }
}

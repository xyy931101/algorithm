package algorithm.leetcode.tree;

import java.util.Stack;

/**
 * 1008. 前序遍历构造二叉搜索树
 * @author: xiongyayun
 * @date: 2021/8/22 17:12
 */
public class ConstructBinarySearchTreeFromPreorderTraversal1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;

        int N = preorder.length;
        //构建辅助数组(即:往右第一个比当前数字大的下标)
        int[] nearBig = new int[N];
        for (int i = 0; i < N; i++) {
            nearBig[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && preorder[stack.peek()] < preorder[i]) {
                nearBig[stack.pop()] = i;
            }
            stack.push(i);
        }
        return process(preorder, 0, N - 1, nearBig);
    }

    private TreeNode process(int[] preorder, int L, int R, int[] nearBig) {
        if (L > R) {
            return null;
        }

        TreeNode cur = new TreeNode(preorder[L]);
        int firstBig = (nearBig[L] == -1 || nearBig[L] > R) ? R + 1 : nearBig[L];
        cur.left =  process(preorder, L + 1, firstBig - 1, nearBig);
        cur.right = process(preorder, firstBig, R, nearBig);
        return cur;
    }

}

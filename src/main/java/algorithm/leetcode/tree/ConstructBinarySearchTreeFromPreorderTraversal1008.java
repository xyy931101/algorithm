package algorithm.leetcode.tree;

import java.util.HashMap;
import java.util.Map;
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

    int [] preorder = new int[1];
    Map<Integer, Integer> hash = new HashMap<>();
    private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight) {
        // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的起点元素很重要
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = hash.get(pivot);
        int size = pivotIndex - inLeft;
        root.left = buildTree(preLeft + 1, preLeft + size,
                inLeft, pivotIndex - 1);
        root.right = buildTree(size + preLeft + 1, preRight,
                pivotIndex + 1, inRight);
        return root;
    }
}

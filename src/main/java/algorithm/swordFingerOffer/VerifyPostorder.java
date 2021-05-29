package algorithm.swordFingerOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * !!!注意,搜索二叉树是左节点比根节点小,右节点比根节点大
 * @Author: Xiongyy
 * @Date: 2021/2/22 23:50
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class VerifyPostorder {


    public static void main(String[] args) {
        VerifyPostorder postorder = new VerifyPostorder();
        int [] order = new int[]{1,6,3,2,5};
        System.out.println(postorder.verifyPostorder(order));
    }

    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null){
            return false;
        }
        return isPostorder(postorder, 0, postorder.length -1);
    }

    public boolean isPostorder(int[] postorder, int leftIndex, int rightIndex){
        if(rightIndex - leftIndex <= 1){
            return true;
        }
        int root = postorder[rightIndex];
        int i = leftIndex;
        for (; i < rightIndex; i++){
            if(postorder[i] >= root){
                break;
            }
        }
        int j = rightIndex;
        for (; j > i; j--) {
            if(postorder[j] < root){
                return false;
            }
        }
        return isPostorder(postorder, leftIndex, i -1) && isPostorder(postorder, j, rightIndex -1);
    }
}

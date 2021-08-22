package algorithm.leetcode.tree;

/**
 * 968. 监控二叉树
 * @author: xiongyayun
 * @date: 2021/8/22 17:24
 */
public class Binarytreecameras968 {

    public static enum StateInfo {
        //没有覆盖
        UNCOVERED,
        //覆盖了,但是没有相机
        COVERED_NO_CAMERA,
        //覆盖了有相机
        COVERED_HAS_CAMERA
    }

    public static class Data {
        public Integer cameras;
        public StateInfo state;

        public Data(int cameras, StateInfo state){
            this.cameras = cameras;
            this.state = state;
        }
    }

    public static int minCameraCover(TreeNode root) {
        Data data = process(root);
        return data.state == StateInfo.UNCOVERED ? data.cameras + 1: data.cameras;
    }

    public static Data process(TreeNode root){
        if (root == null) {
            return new Data(0, StateInfo.COVERED_NO_CAMERA);
        }

        Data leftData = process(root.left);
        Data rightData = process(root.right);

        if (leftData.state == StateInfo.UNCOVERED || rightData.state == StateInfo.UNCOVERED){
            return new Data(leftData.cameras + rightData.cameras + 1, StateInfo.COVERED_HAS_CAMERA);
        }else if (leftData.state == StateInfo.COVERED_HAS_CAMERA || rightData.state == StateInfo.COVERED_HAS_CAMERA){
            return new Data(leftData.cameras + rightData.cameras, StateInfo.COVERED_NO_CAMERA);
        }else {
            return new Data(leftData.cameras + rightData.cameras, StateInfo.UNCOVERED);
        }
    }
}

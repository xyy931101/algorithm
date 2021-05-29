package algorithm.leetcode.array;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @Author: Xiongyy
 * @Date: 2021/3/30 8:27
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class SearchMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int val = matrix[i][j];
            if(val == target){
                return true;
            }else if (val < target){
                i++;
            }else {
                j--;
            }

        }
        return false;
    }

}

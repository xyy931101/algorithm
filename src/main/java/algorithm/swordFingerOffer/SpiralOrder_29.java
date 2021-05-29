package algorithm.swordFingerOffer;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * @Author: Xiongyy
 * @Date: 2021/2/19 23:17
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class SpiralOrder_29 {

    // 1  2  3  4  5
    // 5  6  7  8  9
    // 9  10 11 12 13

    public static void main(String[] args) {
        int[][] board = {{1, 2, 3, 4, 5, 6}, {5, 6, 7, 8, 9 ,10}, {9, 10, 11, 12, 13, 14}};
        System.out.println(JSONObject.toJSONString(spiralOrder(board)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        int[] order = new int[rows * columns];
        int index = 0;
        while (left <= right && top <= bottom){
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }


}

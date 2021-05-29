package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 48. 旋转图像
 * @author xiongyayun
 * @date 2021/5/15 22:16
 */
public class RotateImage48 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(JSONObject.toJSONString(matrix));
    }

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int time = 0;
        int length = matrix.length;

        while (time <= (length >> 1)) {
            int len = length - (time << 1);
            for (int i = 0; i < len - 1; i++) {
                int start = matrix[time][time + i];
                matrix[time][time + i] = matrix[time + len - i - 1][time];
                matrix[time + len - i - 1][time] = matrix[time + len - 1][time + len - 1 - i];
                matrix[time + len - 1][time + len - 1 - i] = matrix[time + i][time + len - 1];
                matrix[time + i][time + len - 1] = start;
            }
            time++;
        }
    }
}

package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 * @Author: Xiongyy
 * @Date: 2021/3/16 8:16
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(generateMatrix(5)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int cur = 1;
        int i = 0;
        while (i < (n /2 + n %2)){
            //生成上面的行
            int top = i;
            while (top  < n - i){
                matrix[i][top] = cur++;
                top++;
            }

            int right = i + 1;
            while (right <= n - i -1){
                matrix[right][n - i -1] = cur++;
                right++;
            }

            int bottom = n-i-2;
            while (bottom >= i){
                matrix[n- i -1][bottom] = cur++;
                bottom--;
            }

            int left = n-i -2;
            while (left > i){
                matrix[left][i] = cur++;
                left--;
            }
            i++;
        }
        return matrix;
    }


}

package algorithm.leetcode.matrix;

/**
 * 59. 螺旋矩阵 II
 * @author: xiongyayun
 * @date: 2022/4/18 23:04
 */
public class SpiralMatrixII59 {

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int len = n * n;
        int index = 1;
        int top = 0, down = n - 1, left = 0, right = n - 1;
        while(true){
            for(int i = left; i <= right; i++) res[top][i] = index++;
            if(++top > down) break;
            for(int i = top; i <= down; i++) res[i][right] = index++;
            if(--right < left) break;
            for(int i = right; i >= left; i--) res[down][i] = index++;
            if(--down < top) break;
            for(int i = down; i >= top; i--)
                res[i][left] = index++;
            if(++left > right) break;
        }
        return res;
    }
}

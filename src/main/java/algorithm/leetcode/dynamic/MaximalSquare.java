package algorithm.leetcode.dynamic;

/**
 * 221. 最大正方形
 * @author xiongyayun
 * @date 2021/5/9 23:13
 */
public class MaximalSquare {


    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0'},
                                       {'1','0','1','1'},
                                       {'1','0','1','1'},
                                       {'1','1','1','1'}};
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0) System.out.println("0");
        int maxSide  = 0, m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    dp[j + 1] = Math.min(dp[j], dp[j + 1]) + 1;
                    maxSide = Math.max(dp[j +1], maxSide);
                }else dp[j + 1] = 0;
            }
        }
        System.out.println( maxSide * maxSide);
    }

    public int maximalSquare(char[][] matrix) {
        //边界值判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int height = matrix.length;
        int width = matrix[0].length;
        //为了做i,j越界
        int[][] dp = new int[height + 1][width + 1];
        //最大正方形的长度
        int maxSide = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i][j]), dp[i + 1][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }

        return maxSide * maxSide;
    }

    // 这个是最最优
    public int maximalSquare2(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        //因为正方形的长度不可能打过其中任一边界
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
        int[] dp = new int[width + 1];
        int northwest = 0; // 西北角、左上角

        for (char[] chars : matrix) {
            northwest = 0; // 遍历每行时，还原回辅助的原值0
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;

                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else {
                    dp[col + 1] = 0;
                }
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }
}

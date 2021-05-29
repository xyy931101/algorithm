package algorithm.leetcode.array;

/**
 * 240. 搜索二维矩阵 II
 * @author xiongyayun
 * @description
 * @date 2021/5/6 18:52
 */
public class SearchA2DMatrixII240 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        SearchA2DMatrixII240 s = new SearchA2DMatrixII240();
        System.out.println(s.searchMatrix(matrix, 20));;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //边界值判断
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = 0, cells = matrix[0].length - 1;
        while (rows < matrix.length && cells >= 0) {
            if (matrix[rows][cells] == target) {
                return true;
            }
            while (rows < matrix.length && cells >= 0 && matrix[rows][cells] < target) {
                rows++;
            }
            while (cells >= 0 && rows < matrix.length && matrix[rows][cells] > target) {
                cells --;
            }

        }
        return false;
    }

    public boolean search(int[][] matrix, int target){
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}

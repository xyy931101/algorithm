package algorithm.swordFingerOffer;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/6 12:05
 * .............................................
 * 佛祖保佑             永无BUG
    [
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
    ]
 */
public class TwoDimensionalArray_4 {


    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                          {2, 5, 8, 12, 19},
                          {3, 6, 9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}};
        System.out.println(Find(55, matrix));

    }

    public static boolean Find(int target, int[][] matrix) {
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
       }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;
       while (c >= 0 && r <= rows-1){
           if(target == matrix[r][c]){
               return true;
           } else if (target > matrix[r][c]){
               r++;
           }else{
               c--;
           }
       }
       return false;
    }

}

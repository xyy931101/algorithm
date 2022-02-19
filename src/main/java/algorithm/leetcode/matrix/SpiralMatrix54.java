package algorithm.leetcode.matrix;

import algorithm.leetcode.array.WordLadder127;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/6/20 11:01 下午
 */
public class SpiralMatrix54 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //边界值判断
        if(matrix == null || matrix.length == 0)
            return res;
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while(true){
            for (int i = left; i <= right; i++) res.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i <= down; i++) res.add(matrix[i][right]);
            if (--right < left) break;;
            for (int i = right; i >= left ; i--) res.add(matrix[i][down]);
            if (--down < up) break;
            for (int i = down; i >= up ; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }

        return res;
    }

}

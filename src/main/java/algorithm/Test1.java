package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2022/12/5 20:00
 */
public class Test1 {

    /**
     * 合并区间（Merge Intervals）题干给出一个区间的集合，请合并所有重叠的区间。
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     */


    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6}, {8, 10}, {15, 18}};

        System.out.println(merger(nums));
    }


    public static int[][] merger(int[][] nums){
        if(nums == null || nums.length == 0) return null;
//        sort(nums, 0, nums.length - 1);
        Arrays.sort(nums, Comparator.comparingInt(v -> v[0]));
        List<int[]> res = new ArrayList<>();
        int end = nums[0][1];
        int start = nums[0][0];
        for(int i = 0; i < nums.length; i++){
            if(end < nums[i][0]){
                res.add(new int[]{start, end});
                start = nums[i][0];
                end = nums[i][1];
            }else {
                end = nums[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[][]{});
    }


    public static void sort(int[][] array, int start, int end){
        if(start >= end) return;
        int right = end;
        int left = start;
        int[] temp = array[right];
        while(left < right){
            while(left < right && array[left][0] <= temp[0]){
                left++;
            }
            array[right] = array[left];
            while(left < right && array[right][0] >= temp[0]){
                right--;
            }
            array[left] = array[right];
        }
        array[left] = temp;
        sort(array, start, left - 1);
        sort(array, left + 1, end);
    }


}

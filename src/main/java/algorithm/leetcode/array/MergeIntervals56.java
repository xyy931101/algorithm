package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * 56. 合并区间
 * @author xiongyayun
 * @date 2021/5/14 22:54
 */
public class MergeIntervals56 {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(merge2(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }

    public static int[][] merge(int[][] intervals) {
        //先按照结束时间排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] res = new int[intervals.length][2];
        int idx = 0;
        int i = 0;
        while (i < intervals.length) {

            int left = intervals[i][0];
            int right = intervals[i][1];

            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res[idx] = new int[] {left, right};
            i++;
            idx++;
        }
        return Arrays.copyOf(res, idx);
    }


    public static int[][] merge2(int[][] intervals) {
        //先按照结束时间排序
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int N = intervals.length;
        int index = 0;
        int newIndex = 0;
        while (newIndex < N) {

            int left = intervals[newIndex][0];
            int right = intervals[newIndex][1];
            while (newIndex < N -1 && intervals[newIndex + 1][0] <= right) {
                right = Math.max(right, intervals[++newIndex][1]);
            }
            intervals[index++] = new int[]{left, right};
            newIndex++;
        }

        return Arrays.copyOf(intervals, index);
    }

}

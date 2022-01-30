package algorithm.leetcode.dynamic;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 * @author: xiongyayun
 * @date: 2022/1/22 3:14 下午
 */
public class SplitArraylargestSum410 {

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,2,5,10,8}, 2));
    }


    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int left = max, right = sum;
        while (left < right){
            int mid = left + (right - left) / 2;
            int splits = split(nums, mid);
            if(splits > m){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    //连续区间之和maxIntervalSum的分割份数
    private static int split(int[] nums, int maxIntervalSum) {
        int splits = 1;
        int curIntervalSum = 0;
        for(int num : nums){
            if(curIntervalSum + num > maxIntervalSum){
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }
}

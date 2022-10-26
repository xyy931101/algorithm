package algorithm.leetcode.array;

/**
 * 862. 和至少为 K 的最短子数组
 * @author: xiongyayun
 * @date: 2022/10/26 21:02
 */
public class ShortestSubarrayWithSumAtLeastK862 {

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{1}, 1));
    }

    public static int shortestSubarray(int[] nums, int k) {
        int[] sumArr = new int[nums.length + 1];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sumArr[i + 1] = sum;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j < i; j++){
                if(sumArr[i] - sumArr[j] >= k) res = Math.min(res, i - j);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}

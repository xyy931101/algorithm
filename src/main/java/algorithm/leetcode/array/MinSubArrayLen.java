package algorithm.leetcode.array;

/**
 * https://leetcode.cn/problems/2VG8Kg/description/
 * @author: xiongyayun
 * @date: 2022/11/28 21:36
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0, pre = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum - nums[pre] >= target){
                sum -= nums[pre];
                pre++;
            }
            if(sum >= target) res = Math.min(res, i - pre + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

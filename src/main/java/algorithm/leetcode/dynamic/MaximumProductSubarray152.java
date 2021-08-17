package algorithm.leetcode.dynamic;

/**
 * 152. 乘积最大子数组
 * @author: xiongyayun
 * @date: 2021/8/17 11:48 下午
 */
public class MaximumProductSubarray152 {


    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {2,3,-2,4}));
    }

    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length ==0) {
            return 0;
        }
        int ans = nums[0];
        int preMax = nums[0];
        int preMin = nums[0];
        for(int i = 1; i < nums.length; i++){
            int p1 = nums[i];
            int p2 = preMin * nums[i];
            int p3 = nums[i] * preMax;
            preMax = Math.max(Math.max(p1, p2), p3);
            preMin = Math.min(Math.min(p1, p2), p3);
            ans = Math.max(ans, preMax);
        }
        return ans;
    }
}

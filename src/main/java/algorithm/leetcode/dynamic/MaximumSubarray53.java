package algorithm.leetcode.dynamic;

/**
 * @Author: Xiongyy
 * @Date: 2021/5/2 23:06
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MaximumSubarray53 {

    public static void main(String[] args) {
        MaximumSubarray53 m = new MaximumSubarray53();
        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

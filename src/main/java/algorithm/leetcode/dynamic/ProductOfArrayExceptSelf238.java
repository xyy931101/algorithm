package algorithm.leetcode.dynamic;

/**
 * 238. 除自身以外数组的乘积
 * @author: xiongyayun
 * @date: 2021/7/17 10:11 下午
 */
public class ProductOfArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        int[] res = new int[len];
        //先吧0号位置的res置为1,避免后期循环的时候判断
        int pre = 1;
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            pre *= nums[i - 1];
            res[i] = pre;
        }
        int after = 1;
        for (int i = len - 2; i >= 0; i--) {
            after = after * nums[i + 1];
            res[i] *= after;
        }
        return res;
    }
}

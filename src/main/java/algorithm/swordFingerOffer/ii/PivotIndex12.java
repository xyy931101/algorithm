package algorithm.swordFingerOffer.ii;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * @author: xiongyayun
 * @date: 2022/12/10 14:19
 */
public class PivotIndex12 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int preSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(preSum * 2 + nums[i] == sum) return i;

            preSum += nums[i];
        }
        return -1;
    }
}

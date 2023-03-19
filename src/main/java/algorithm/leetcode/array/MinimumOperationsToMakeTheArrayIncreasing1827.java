package algorithm.leetcode.array;

/**
 * 1827. 最少操作使数组递增
 * @author: xiongyayun
 * @date: 2022/12/11 10:19
 */
public class MinimumOperationsToMakeTheArrayIncreasing1827 {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,1}));
    }

    public static int minOperations(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}

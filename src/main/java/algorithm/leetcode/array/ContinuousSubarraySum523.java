package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * @author: xiongyayun
 * @date: 2021/6/2 8:17
 */
public class ContinuousSubarraySum523 {

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        //边界值判断
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Map<Integer, Integer> remMap = new HashMap<>();
        //构建第一个元素的pre
        remMap.put(0, -1);
        int rem = 0;
        for (int i = 0; i < nums.length; i++) {
            rem = (rem + nums[i]) % k;
            if (remMap.containsKey(rem)) {
                int prevIndex = remMap.get(rem);
                if ( i - prevIndex >= 2) {
                    return true;
                }
            }
//            else {
            //这里leetcode的题解有问题,应当是直接塞得
            remMap.put(rem, i);

//            }

        }
        return false;
    }

}

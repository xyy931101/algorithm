package algorithm.leetcode.dynamic;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * @author: xiongyayun
 * @date: 2021/8/4 10:28 下午
 */
public class ValidTriangleNumber611 {

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }

    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3);

        Arrays.sort(nums);
        int ans = 0;
        int N = nums.length;
        for (int i = N - 1; i >= 2; i--) {
            int left = 0;
            int right = i -1;
            while (left < right) {
                if (nums[i] < nums[left] + nums[right]) {
                    ans += right - left;
                    right --;
                }else {
                    left++;
                }
            }
        }
        return ans;
    }
}

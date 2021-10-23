package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. 求众数 II
 * @author: xiongyayun
 * @date: 2021/10/23 13:25
 */
public class MajorityElementII229 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int num1 = 0, num2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (count1 != 0 && num == num1) {
                count1 ++;
            }else if (count2 != 0 && num == num2) {
                count2 ++;
            }else if (count1 == 0) {
                count1++;
                num1 = num;
            }else if (count2 == 0){
                count2++;
                num2 = num;
            }else {
                count1 --;
                count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) count1++;
            else if (num == num2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);
        return res;
    }
}

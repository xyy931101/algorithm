package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/6/23 11:41 下午
 */
public class FIndAllNumbersDisappearedInAnArray448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null | nums.length == 0) return null;
        int n = nums.length;
        for(int num : nums) {
            //取到当前数字作为下标(%n是因为作为下标的数字之前可能加过n)
            int index = (num - 1) % n;
            nums[index] = nums[index] + n;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] < n){
                res.add(i);
            }
        }

        return res;
    }
}

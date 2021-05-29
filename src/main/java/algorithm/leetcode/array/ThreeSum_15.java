package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Medium
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * @Author: Xiongyy
 * @Date: 2021/3/13 14:19
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ThreeSum_15 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        //如果数组长度小于3,则就返回空数组
        if(nums == null || nums.length < 3){
            return Collections.emptyList();
        }
        int length = nums.length;
        //因为要去重,所以,先对数组进行牌程序
        Arrays.sort(nums);
        //遍历数组,找出符合条件的数组
        for (int first = 0; first < length; first++) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = length - 1;
            int target = -nums[first];
            //枚举第二个元素
            for (int second  = first + 1; second  < length -1; second ++) {
                //如果第二个元素存在相同的,直接跳过
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                //需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target){
                    third --;
                }
                if (second == third) {
                    break;
                }
                //如果符合条件,就把3个元素加上
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

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

    public static void main(String[] args) {
        System.out.println(threeSum3(new int[]{-1,0,1,2,-1,-4}));
    }

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

    public static List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        //如果数组长度小于3,则就返回空数组
        if(nums == null || nums.length < 3){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
            int one = nums[i];
            if(one > 0) break;
            if(i > 0 && one == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            int target = - one;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    res.add(Arrays.asList(one, nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }else if(sum < target) left++;
                else right--;
            }
        }
        return res;
    }
}

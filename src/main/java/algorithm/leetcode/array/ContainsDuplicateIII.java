package algorithm.leetcode.array;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 * @Author: Xiongyy
 * @Date: 2021/4/18 14:21
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ContainsDuplicateIII {

    public static void main(String[] args) {
        ContainsDuplicateIII c = new ContainsDuplicateIII();
        System.out.println(c.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int n = nums.length;
        //防止int溢出
        TreeSet<Long> set = new TreeSet<Long>();

        for (int i = 0; i < n; i++) {
            //利用treeSet的返回靠近目标的最小值
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            //这里再判断下是否符合条件
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            //保持treeSet中最多只有k个元素
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}

package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * @Author: Xiongyy
 * @Date: 2021/3/31 8:32
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            //先加之前的
            temp.add(nums[i]);
            backtrack(i + 1, nums, ans, temp);
            //加完所有可能之后然后在移除最后一个元素
            temp.remove(temp.size() - 1);
        }
    }

}

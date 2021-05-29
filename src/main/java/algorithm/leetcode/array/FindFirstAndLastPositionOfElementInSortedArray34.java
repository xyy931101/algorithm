package algorithm.leetcode.array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * @Author: Xiongyy
 * @Date: 2021/4/18 16:31
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray34 f = new FindFirstAndLastPositionOfElementInSortedArray34();
        System.out.println(f.searchRange(new int[]{1}, 1));
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[] {-1, -1};
        }
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return new int[] {-1, -1};
        }
        if (nums.length == 1 && nums[0] == target) {
            return new int[] {0, 0};
        }

        int[] res = new int[] {-1, -1};
        boolean exists = false;
        for (int i = 0; i < nums.length; i++) {
               if (nums[i] == target) {
                   if (!exists) {
                       res[0] = i;
                       exists = true;
                   }
                   res[1] = i;
               }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int n = nums.length;
        if (n == 0) {
            return ans;
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return ans;
        } else {
            ans[0] = l;
            l = 0; r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ans[1] = l;
            return ans;
        }
    }
}

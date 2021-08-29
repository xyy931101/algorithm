package algorithm.leetcode.array;

/**
 * 41. 缺失的第一个正数
 * @author: xiongyayun
 * @date: 2021/8/29 10:54 下午
 */
public class FirstMissingPositive41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2, 1}));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        int N = nums.length;
        int L = 0, R = N;
        while (L != R) {
            //如果符合规则,则挪动L边界
            if (nums[L] == L + 1) {
                L++;
            } else if(nums[L] < L + 1 || //已经再左边界出现过得值
                    nums[L] > R || //超过右边界
                    nums[nums[L] - 1] == nums[L]) { //与要更换的位置的值相等
                swap(nums, L, --R);
            }else {
                swap(nums, L, nums[L] - 1);
            }
        }
        return L + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

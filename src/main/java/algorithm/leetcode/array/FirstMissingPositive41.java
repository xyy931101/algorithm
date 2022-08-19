package algorithm.leetcode.array;

/**
 * 41. 缺失的第一个正数
 * @author: xiongyayun
 * @date: 2021/8/29 10:54 下午
 */
public class FirstMissingPositive41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive2(new int[]{1}));
    }


    public static int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            while(nums[i] != i + 1 && nums[i] <= len && nums[i] > 0){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
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

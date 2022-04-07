package algorithm.swordFingerOffer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @author: xiongyayun
 * @date: 2022/4/7 10:07 下午
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof_53 {


    public static void main(String[] args) {
        search(new int[]{5,7,7,8,8,10},8);
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        int left  = getLeft(nums, target);
        System.out.println(left);
        if (left == -1) return 0;
        int right  = getRight(nums, target);
        return right - left + 1;
    }

    public static int getLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return nums[left] == target ? left : -1;
    }


    public static int getRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}

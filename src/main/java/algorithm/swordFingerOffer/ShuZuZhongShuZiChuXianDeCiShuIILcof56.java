package algorithm.swordFingerOffer;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其
 * 他数字都出现了三次。请找出那个只出现一次的数字。
 * @author: xiongyayun
 * @date: 2021/7/17 17:04
 */
public class ShuZuZhongShuZiChuXianDeCiShuIILcof56 {


    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        //主要用来记录每个位置上的1
        int[] count = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) count[i] ++;
            }
        }
        int ans = 0;
        //如果其中1的为数不为3的倍数,则证明位1次数的数在这个位置位1
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 != 0)
                ans = ans | 1 << i;
        }
        return ans;
    }
}

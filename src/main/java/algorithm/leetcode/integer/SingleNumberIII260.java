package algorithm.leetcode.integer;

/**
 * 260. 只出现一次的数字 III
 * @author: xiongyayun
 * @date: 2021/10/30 12:49
 */
public class SingleNumberIII260 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int k = -1;
        for (int i = 0; i < 32; i++) {
            if (((xor >> i) & 1) == 1) {
                k = i;
                break;
            }
        }
        int[] ans = new int[2];
        for (int num : nums) {
            if (((num >> k) & 1) == 1) ans[0] ^= num;
            else ans[1] ^= num;
        }
        return ans;
    }
}

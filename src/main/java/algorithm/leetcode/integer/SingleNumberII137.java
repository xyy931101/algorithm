package algorithm.leetcode.integer;

/**
 * @author: xiongyayun
 * @date: 2021/10/30 13:10
 */
public class SingleNumberII137 {

    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) cnt[i] ++;
            }
        }

        int ans = 0;
        for (int i = 0; i <32; i++) {
            if (cnt[i] % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}

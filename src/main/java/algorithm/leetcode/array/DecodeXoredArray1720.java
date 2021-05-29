package algorithm.leetcode.array;

/**
 * 1720. 解码异或后的数组
 * @author xiongyayun
 * @description
 * @date 2021/5/6 11:13
 */
public class DecodeXoredArray1720 {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}

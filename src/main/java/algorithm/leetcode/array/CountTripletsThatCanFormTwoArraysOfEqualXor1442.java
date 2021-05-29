package algorithm.leetcode.array;

/**
 * @author xiongyayun
 * @date 2021/5/18 8:27
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXor1442 {

    public int countTriplets(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int []sum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] ^ arr[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sum[i] == sum[j + 1]) {
                    ans += j - i;
                }
            }
        }
        return ans;
    }
}

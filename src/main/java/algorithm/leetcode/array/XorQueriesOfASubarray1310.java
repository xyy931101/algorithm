package algorithm.leetcode.array;

/**
 * @author xiongyayun
 * @date 2021/5/12 19:56
 */
public class XorQueriesOfASubarray1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null){
            return arr;
        }
        int len = queries.length;
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int[] query = queries[i];

            res[i] = dp[query[0]] ^ dp[query[1]  + 1];

        }

        return  res;
    }
    
}

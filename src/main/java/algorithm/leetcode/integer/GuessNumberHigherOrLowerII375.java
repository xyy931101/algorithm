package algorithm.leetcode.integer;

/**
 * @author: xiongyayun
 * @date: 2021/11/12 10:05 下午
 */
public class GuessNumberHigherOrLowerII375 {

    public static void main(String[] args) {
        System.out.println(getMoneyAmount(10));
    }

    //题目限定了小于200
    static int[][] cache = new int[201][201];


    public static int getMoneyAmount(int n) {
        return dfs(1, n);
    }

    public static int dfs(int l, int r){
        if (l >= r) return 0;
        if (cache[l][r] != 0) return cache[l][r];
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int cur = Math.max(dfs(l, i - 1), dfs(i + 1, r)) + i;
            ans = Math.min(cur, ans);
        }
        cache[l][r] = ans;
        return ans;
    }
}

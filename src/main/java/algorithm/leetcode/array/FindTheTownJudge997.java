package algorithm.leetcode.array;

/**
 * 997. 找到小镇的法官
 * @author: xiongyayun
 * @date: 2021/12/19 12:33
 */
public class FindTheTownJudge997 {

    public int findJudge(int n, int[][] trust) {
        //被多少人信任
        int[] in = new int[n + 1];
        //信任多少人
        int[] out = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            in[trust[i][1]]++;
            out[trust[i][0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}

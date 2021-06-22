package algorithm.swordFingerOffer;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * @author: xiongyayun
 * @date: 2021/6/23 12:52 上午
 */
public class JiQiRenDeYunDongFanWeiLcof13 {

    int k;
    int m;
    int n;
    public int movingCount(int m, int n, int k) {
        if (k < 0 ) return 0;
        this.k = k;
        this.m = m;
        this.n = n;
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, visited);
    }

    public int dfs (int i, int j, boolean[][] visited){
        if(i >= m || j >= n || visited[i][j] || bitSum(i) + bitSum(j) > k) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, visited) + dfs(i, j + 1, visited);
    }

    private int bitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

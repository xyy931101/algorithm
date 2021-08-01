package algorithm.msb.class18;

/**
 * 假设有排成一行的N个位置，记为1~N，N 一定大于或等于 2
 * 开始时机器人在其中的M位置上(M 一定是 1~N 中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置；
 * 如果机器人来到N位置，那么下一步只能往左来到 N-1 位置；
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走 K 步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数 N、M、K、P，返回方法数。
 *
 * @author: xiongyayun
 * @date: 2021/8/1 8:33 下午
 */
public class RobotWalk {


    public static int ways1(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        return process1(start, K, aim, N);

    }

    // 机器人当前来到的位置是cur，
    // 机器人还有rest步需要去走，
    // 最终的目标是aim，
    // 有哪些位置？1~N
    // 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
    private static int process1(int cur, int rest, int aim, int N) {
        //如果指只剩0步了,则只有再当前位置再目标位置上才算一个正确解
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }

        if (cur == 0) {
            return process1(2, rest - 1, aim, N);
        } else if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        return process1(cur + 1, rest - 1, aim, N) + process1(cur - 1, rest - 1, aim, N);
    }


    //动态规划求出解
    public static int waysDp(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;

        for (int i = 1; i < K + 1; i++) {
            dp[1][i] = dp[2][i - 1];
            for (int j = 2; j < N; j++) {
                dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
            }
            dp[N][i] = dp[N - 1][i - 1];
        }

        return dp[start][K];
    }

    public static void main(String[] args) {
        System.out.println(ways1(7, 2, 4, 6));
        System.out.println(waysDp(7, 2, 4, 6));
//        System.out.println(ways3(5, 2, 4, 6));
    }

}

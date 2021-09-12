package algorithm.leetcode.array;

/**
 * 134. 加油站
 * @author: xiongyayun
 * @date: 2021/9/12 12:17
 */
public class GasStation134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;

        for (int i = 0; i < N; i++) {

            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                remain = remain - cost[j] + gas[(j + 1) % N];
                j = (j + 1) % N;
                if (j == i) return i;
            }
            if (j < i) {
                return -1;
            }
            i = j;
        }
        return -1;
    }

}

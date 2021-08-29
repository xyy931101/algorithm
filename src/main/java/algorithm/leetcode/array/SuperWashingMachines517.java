package algorithm.leetcode.array;

/**
 * 517. 超级洗衣机
 * @author: xiongyayun
 * @date: 2021/8/29 11:47 下午
 */
public class SuperWashingMachines517 {



    public int findMinMoves(int[] machines) {
        int sum = 0;
        int N = machines.length;
        for (int i = 0; i < N ; i++) {
            sum += machines[i];
        }
        if (sum % N != 0) return -1;

        int avg = sum / N;

        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < machines.length; i++) {
            //左边洗衣机的需要的总衣服数
            int leftRest = leftSum - i * avg;
            //右边需要的总的衣服数
            int rightRest = (sum - leftSum - machines[i]) - (N - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += machines[i];
        }
        return ans;
    }
}

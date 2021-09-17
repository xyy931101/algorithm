package algorithm.leetcode.integer;

/**
 * 204. 计数质数
 * @author: xiongyayun
 * @date: 2021/9/16 11:32 下午
 */
public class CountPrimes204 {

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }

        int count = n / 2;

        boolean[] f = new boolean[n];

        for (int i = 3; i * i < n; i += 2) {
            if (f[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }

}

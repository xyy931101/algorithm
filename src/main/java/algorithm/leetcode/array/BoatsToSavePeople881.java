package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 881. 救生艇
 * @author: xiongyayun
 * @date: 2021/8/26 8:34
 */
public class BoatsToSavePeople881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int L = 0, R = people.length - 1;
        int ans = 0;
        while (L <= R) {
            if (people[L] + people[R] > limit) {
                R--;
            } else {
                L++;
                R--;
            }
            ans++;
        }
        return ans;
    }
}

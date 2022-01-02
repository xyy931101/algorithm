package algorithm.leetcode.trie;

/**
 * 825. 适龄的朋友
 * @author: xiongyayun
 * @date: 2021/12/27 7:58 下午
 */
public class FriendsOfAppropriateAges825 {

    public int numFriendRequests(int[] ages) {
        //因为1 <= ages[i] <= 120
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        //这里已经作为前缀和了
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + count[i];
        }

        int ans = 0;

        for (int i = 15; i <= 120; ++i) {
            if (count[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                ans += count[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }
}

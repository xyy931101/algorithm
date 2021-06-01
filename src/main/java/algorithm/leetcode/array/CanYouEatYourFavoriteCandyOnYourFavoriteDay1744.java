package algorithm.leetcode.array;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗
 * @author: xiongyayun
 * @date: 2021/6/1 8:30
 */
public class CanYouEatYourFavoriteCandyOnYourFavoriteDay1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        boolean[] res = new boolean[queries.length];

        //所有种类前面的糖果数
        int[] sum = new int[candiesCount.length];
        //这里需要手工设置base
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int favoriteType = queries[i][0];
            int favoriteDay = queries[i][1];
            int dailyCap = queries[i][2];

            //每天吃一颗的糖果数(也就是最少的糖果数)
            long eatMin = favoriteDay + 1;
            //最多能吃得糖果数
            long eatMax = (favoriteDay + 1) * dailyCap;
            //在需要把前面的全部吃完，然后 +1
            long canMin = favoriteType == 0 ? 1 : sum[favoriteType -1] + 1;
            //能吃到的最大值
            long canMax = sum[favoriteType];
            //判断能吃的区间跟要能吃到最喜欢的糖果的区间之间有没有交集
            res[i] = !(eatMin > canMax || eatMax < canMin);
        }
        return res;
    }
}

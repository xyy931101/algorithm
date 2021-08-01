package algorithm.msb.class18;

/**
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线，   玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数
 *
 * @author xiongyayun
 * @date 2021/5/10 22:52
 */
public class CardInLine {

    public static int win(int[] arr) {
        //边界值
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int first = first(arr, 0, arr.length - 1);
        int second = g(arr, 0, arr.length - 1);
        return Math.max(first, second);

    }

    //先手拿
    public static int first(int[] arr, int left, int right) {
        //先手拿的时候,如果只剩一张牌了,那么就是自己拿
        if (left == right) {
            return arr[left];
        }

        int p1 = arr[left] + g(arr, left + 1, right);
        int p2 = arr[right] + g(arr, left, right - 1);
        //先手拿,取左边或者右边的最大值
        return Math.max(p1, p2);
    }

    //后手拿
    public static int g(int[] arr, int left, int right) {
        //因为后手拿,只剩一张牌的时候,这张牌要被先手拿走
        if (left == right) {
            return 0;
        }

        int p1 = first(arr, left + 1, right);
        int p2 = first(arr, left, right - 1);
        //因为是后手拿,所以先手肯定会把比较小的值给到自己
        return Math.min(p1, p2);
    }

    public static int dp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        //再先手map中,当左边界=有边界的时候,当前值为先手的值
        for (int i = 0; i < N; i++) {
            fmap[i][i] = arr[i];
        }

        for (int i = 1; i < N; i++) {
            int L = 0;
            int R = i;
            while (R < N) {
                fmap[L][R] = Math.max(arr[L] + gmap[L + 1][R], arr[R] + gmap[L][R - 1]);
                gmap[L][R] = Math.min(fmap[L + 1][R], fmap[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fmap[0][N - 1], gmap[0][N - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
        System.out.println(win(arr));
        System.out.println(dp(arr));
    }
}

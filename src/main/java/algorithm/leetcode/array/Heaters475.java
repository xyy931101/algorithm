package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author: xiongyayun
 * @date: 2021/10/19 10:48 下午
 */
public class Heaters475 {

    public static void main(String[] args) {
        System.out.println(findRadius(new int[] {1,1,1,1,1,1,999,999,999,999,999}, new int[] {499, 500, 501}));
    }

    /*public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int hIndex = 0;
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            while (!isBest(houses, heaters, i, hIndex)) {
                hIndex++;
            }
            res = Math.max(res, Math.abs(houses[i] - heaters[hIndex]));
        }
        return res;
    }

    private static boolean isBest(int[] houses, int[] heaters, int i, int hIndex) {
        return hIndex == heaters.length - 1 || Math.abs(houses[i] - heaters[hIndex]) < Math.abs(houses[i] - heaters[hIndex + 1]);
    }*/

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int hIndex = 0;
        int ans = 0;
        for (int i = 0; i < houses.length; i++) {
            while (!isBest(houses, heaters, i, hIndex)) {
                hIndex++;
            }
            ans = Math.max(ans, Math.abs(houses[i] - heaters[hIndex]));
        }
        return ans;
    }

    private static boolean isBest(int[] houses, int[] heaters, int i, int hIndex) {
        return hIndex == heaters.length - 1 || Math.abs(houses[i] - heaters[hIndex]) < Math.abs(houses[i] - heaters[hIndex + 1]);
    }

}

package algorithm.leetcode.stirng;

/**
 * 1154. 一年中的第几天
 * @author: xiongyayun
 * @date: 2021/12/21 8:31
 */
public class DayOfTheYear1154 {
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int[] f = new int[13];
    static {
        for (int i = 1; i <= 12; i++) f[i] = f[i - 1] + nums[i - 1];
    }

    public int dayOfYear(String date) {
        String[] split = date.split("-");
        Integer year = Integer.valueOf(split[0]);
        Integer mouth = Integer.valueOf(split[1]);
        Integer day = Integer.valueOf(split[2]);
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        int ans = mouth > 2 && isLeap ? f[mouth - 1] + 1 : f[mouth - 1];
        return ans + day;
    }
}

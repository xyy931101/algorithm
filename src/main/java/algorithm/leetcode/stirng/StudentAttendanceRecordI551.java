package algorithm.leetcode.stirng;

/**
 * 551. 学生出勤记录 I
 * @author: xiongyayun
 * @date: 2021/8/17 11:22 下午
 */
public class StudentAttendanceRecordI551 {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
    }

    public static boolean checkRecord(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;
        int absentCount = 0;

        for (int i = 0; i < len; i++) {
            if (chars[i] == 'A') {
                absentCount++;
                if (absentCount >= 2) return false;
            }
            if (chars[i] == 'L') {
                int lIndex = i + 1;
                while (lIndex < len && chars[lIndex] == 'L') {
                    lIndex++;
                    if (lIndex - i >= 3) return  false;
                }
            }
        }

        return true;
    }
}

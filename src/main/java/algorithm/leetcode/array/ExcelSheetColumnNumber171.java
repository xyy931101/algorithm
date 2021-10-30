package algorithm.leetcode.array;

/**
 * 171. Excel 表列序号
 * @author: xiongyayun
 * @date: 2021/9/16 10:48 下午
 */
public class ExcelSheetColumnNumber171 {


    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String columnTitle) {
        int N = columnTitle.length();

        String s = "";
        s.intern();
        char[] chars = columnTitle.toCharArray();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = ans * 26 + chars[i] -'A' + 1;
        }
        return ans;
    }
}

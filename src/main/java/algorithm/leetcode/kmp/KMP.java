package algorithm.leetcode.kmp;

/**
 * @author: xiongyayun
 * @date: 2022/1/3 14:17
 */
public class KMP {

    public static void main(String[] args) {
        System.out.println(getNextArray(new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b'}));
    }

    public static int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int x = 0;
        int y = 0;
        // 获取str2的next数组
        int[] next = getNextArray(str2);
        // O(N)
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // y == 0
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }

    public static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2; // 目前在哪个位置上求next数组的值
        int cn = 0; // 当前是哪个位置的值再和i-1位置的字符比较
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) { // 配成功的时候
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


    public static int[] getNextArray1(char[] str2) {
        int[] res = new int[str2.length];
        res[0] = -1;
        res[1] = 0;
        int i = 2, cn = 0;
        while (i < str2.length){
            if (str2[i - 1] == str2[cn]){
                res[i++] = ++cn;
            }else if(cn > 0){
                cn = res[cn];
            }else {
                res[i++] = 0;
            }
        }
        return res;
    }
}

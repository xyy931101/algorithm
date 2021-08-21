package algorithm.leetcode.stirng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 443. 压缩字符串
 * @author: xiongyayun
 * @date: 2021/8/21 10:32 下午
 */
public class StringCompression443 {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int fast = 1;
        char cur = chars[0];
        int index = 0;
        int N = chars.length;
        for (int start = 0; start < N; ) {
            while (fast < N && cur == chars[fast]){
                fast++;
            }
            int len = fast - start;
            start = fast;
            chars[index++] = cur;
            if (len > 1) {
                char[] lenC = String.valueOf(len).toCharArray();
                for (char c : lenC) {
                    chars[index++] = c;
                }
            }
            if (fast < N){

                cur = chars[fast];
            }
            fast++;
        }
        return index;
    }
}

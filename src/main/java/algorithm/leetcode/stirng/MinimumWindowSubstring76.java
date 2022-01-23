package algorithm.leetcode.stirng;

/**
 *
 * 76. 最小覆盖子串
 * @author: xiongyayun
 * @date: 2022/1/22 16:21
 */
public class MinimumWindowSubstring76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }


    public static String minWindow(String s, String t) {
        int [] need = new int[128];
        char[] str = t.toCharArray();
        for(char c : str){
            need[c]++;
        }
        char[] sChar = s.toCharArray();
        int left = 0, right = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (right < s.length()) {
            char c = sChar[right];
            if(need[c] > 0){
                count--;
            }
            need[c] --;
            if (count == 0) {
                while (left < right && need[sChar[left]] < 0) {
                    need[sChar[left]]++;
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                //开始一轮新的循环;
                need[sChar[left]]++;
                left++;
                count++;

            }
            right++;
        }
        return size < Integer.MAX_VALUE ? s.substring(start, start + size) : "";
    }
}

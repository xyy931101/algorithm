package algorithm.leetcode.array;

/**
 * 316. 去除重复字母
 * @author: xiongyayun
 * @date: 2021/9/11 12:37
 */
public class RemoveDuplicateLetters316 {


    public String removeDuplicateLetters(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minACSIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            minACSIndex = str.charAt(minACSIndex) > str.charAt(i) ? i : minACSIndex;
            if (--map[str.charAt(i)] == 0) {
                break;
            }
        }
        return str.charAt(minACSIndex) + removeDuplicateLetters(str.substring(minACSIndex + 1).replace(String.valueOf(str.charAt(minACSIndex)), ""));
    }


}

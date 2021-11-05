package algorithm.leetcode.stirng;

import java.util.ArrayList;
import java.util.List;

/**
 * 500. 键盘行
 * @author: xiongyayun
 * @date: 2021/10/31 14:02
 */
public class KeyboardRow500 {

    static String [] s = new String[] {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static int[] hash = new int[26];
    static {
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            for (char c : str.toCharArray()) {
                hash[c - 'a'] = i;
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int row = -1;
            char[] chars = word.toLowerCase().toCharArray();
            for (char ch : chars) {
                if (row == -1) {
                    row = hash[ch - 'a'];
                }else {
                    if (row != hash[ch - 'a']){
                        row = -1;
                        break;
                    }

                }
            }
            if (row != -1) list.add(word);

        }
        return list.toArray(new String[list.size()]);
    }
}

package algorithm.leetcode.stirng;

import java.util.*;

/**
 * 17.电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Author: Xiongyy
 * @Date: 2021/3/30 8:38
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LetterCombinations_17 {

    private static Map<Character, String> phoneMap = new HashMap<>(100);
    static {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        backtrack(combinations, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            //这里是会重新生成一个String对象的
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}

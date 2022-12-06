package algorithm.leetcode.stirng;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. 字符串中不同整数的数目
 * @author: xiongyayun
 * @date: 2022/12/6 21:31
 */
public class NumberOfDifferentIntegersInAString1805 {


    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
    }

    public static int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= '9') {
                int j = i;
                while (j < word.length() && word.charAt(j) <= '9') j++;
                while (i < j && word.charAt(i) == '0') i++;
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }
}

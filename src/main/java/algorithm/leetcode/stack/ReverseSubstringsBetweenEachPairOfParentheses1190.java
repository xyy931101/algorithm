package algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class ReverseSubstringsBetweenEachPairOfParentheses1190 {

    public String reverseParentheses(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Deque<Integer> stack = new LinkedList<Integer>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            }
        }

        return s;
    }

    public void reverse (String s, Integer start, Integer end){

    }

}

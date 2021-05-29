package algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: Xiongyy
 * @Date: 2021/3/9 8:14
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String S) {
        LinkedList<Character> buffer = new LinkedList();
        buffer.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            //如果栈顶元素跟字符串当前元素相等
            if(!buffer.isEmpty() && buffer.peek() == S.charAt(i)){
                buffer.pop();
            }else {
                buffer.push(S.charAt(i));
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!buffer.isEmpty()){
            stringBuffer.append(buffer.pollLast());
        }
        return stringBuffer.toString();
    }

}

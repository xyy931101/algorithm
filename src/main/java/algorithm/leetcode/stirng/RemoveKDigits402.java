package algorithm.leetcode.stirng;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 * @author: xiongyayun
 * @date: 2022/3/3 2:47 下午
 */
public class RemoveKDigits402 {

    public String removeKdigits(String num, int k) {
        if(num == null || num.length() <= k){
            return "0";
        }
        Deque<Character> deque = new LinkedList<Character>();
        for(char c : num.toCharArray()){
            while(k > 0 && !deque.isEmpty() && deque.peek() > c){
                deque.pop();
                k--;
            }
            if(!deque.isEmpty() || c != '0'){
                deque.push(c);
            }
        }
        while(k > 0 && !deque.isEmpty()){
            deque.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        return sb.length() > 0 ? sb.toString(): "0";
    }
}

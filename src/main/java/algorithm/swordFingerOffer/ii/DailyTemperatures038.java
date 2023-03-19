package algorithm.swordFingerOffer.ii;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 038. 每日温度
 * @author: xiongyayun
 * @date: 2023/2/8 21:26
 */
public class DailyTemperatures038 {

    public static void main(String[] args) {
        System.out.println(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> deque = new LinkedList<Integer>();

        for(int i = 0; i < len; i++){
            while(!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]){
                int last = deque.pollLast();
                res[last] = i - last;
            }

            deque.add(i);
        }
        return res;
    }
}

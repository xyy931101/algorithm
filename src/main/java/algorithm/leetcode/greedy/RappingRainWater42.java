package algorithm.leetcode.greedy;

import java.util.LinkedList;

/**
 * @author: xiongyayun
 * @date: 2022/1/7 12:05 上午
 */
public class RappingRainWater42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int len = height.length;
        LinkedList<Integer> deque = new LinkedList();
        int res = 0;
        for(int i = 0; i < len; i++){
            if(deque.isEmpty() || height[i] <= height[deque.peekLast()]){
                deque.push(i);
            }else {
                int h = height[deque.pollLast()];
                while(!deque.isEmpty()) {
                    res += h - height[deque.poll()];
                }
                deque.push(i);
            }
        }
        return res;
    }
}

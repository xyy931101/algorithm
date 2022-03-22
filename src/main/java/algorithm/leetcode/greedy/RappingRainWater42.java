package algorithm.leetcode.greedy;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: xiongyayun
 * @date: 2022/1/7 12:05 上午
 */
public class RappingRainWater42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int right = stack.poll();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                res += (Math.min(height[left], height[i]) - height[right]) * (i - left - 1);
            }
            stack.push(i);
        }
        return res;
    }
}

package algorithm.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 * @author: xiongyayun
 * @date: 2021/6/26 11:21 下午
 */
public class LargestRectangleInHistogram84 {

    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stk = new ArrayDeque();
        int ret = 0;
        for (int i = 0; i <= heights.length; i++){
            while (!stk.isEmpty() && (i == heights.length || heights[i] < heights[stk.peek()])){
                int ind = stk.pop();
                int lastInd = stk.isEmpty() ? -1 : stk.peek();
                ret = Math.max(ret, heights[ind] * (i - lastInd - 1));
            }
            if (i < heights.length) stk.push(i);
        }
        return ret;
    }

}

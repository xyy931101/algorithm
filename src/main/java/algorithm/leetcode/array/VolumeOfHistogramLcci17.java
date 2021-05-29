package algorithm.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 17.21. 直方图的水量
 *
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * @Author: Xiongyy
 * @Date: 2021/4/5 22:00
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class VolumeOfHistogramLcci17 {

    public int trap(int[] height) {
        int ans = 0;
        //处理边界值(没有3条数据不可能形成容器)
        if (height == null || height.length < 3) {
            return ans;
        }

        //维护单调增加的栈(栈元素是数组的下标)
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                // 如果栈内没有元素，说明当前位置左边没有比其高的柱子，跳过
                if (stack.isEmpty()) {
                    continue;
                }
                //之前的栈顶元素(可以理解为左边比当前元素大的值)
                int left = stack.peek();
                //增加区间的宽度
                int currWidth = i - left - 1;
                //左右两边高度最小值,减去之前的最大值,就是增加的高度
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans = ans + currHeight * currWidth;
            }
            //保证当前值在栈顶
            stack.push(i);
        }

        return ans;
    }

    public int trapBy2Point(int[] height) {
        int sum = 0;
        //求数组总和
        for(int i = 0; i < height.length; i++) {
            sum += height[i];
        }
        // 总体积和高度初始化
        int volume = 0;
        //高度为0的时候没有意义
        int high = 1;
        // 双指针初始化
        int left = 0, right = height.length - 1;
        while (left < right) {
            //找到比之前高度还大的值
            while (left <= right && height[left] < high) {
                left++;
            }

            while (left <= right && height[right] < high) {
                right--;
            }
            // 每一层的容量都加起来
            volume += right - left + 1;
            // 高度加一
            high++;
        }
        // 总体积减去柱子体积，即雨水总量
        return volume -sum;
    }
}

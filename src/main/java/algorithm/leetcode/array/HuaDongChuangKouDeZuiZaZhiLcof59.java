package algorithm.leetcode.array;

import java.util.LinkedList;

/**
 * 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @Author: Xiongyy
 * @Date: 2021/4/8 22:41
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class HuaDongChuangKouDeZuiZaZhiLcof59 {

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[0], 0));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 0 || nums.length < k) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        //先构建数组的长度
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //保证
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            //将当前元素加入队列
            queue.addLast(i);

            // 判断当前队列中队首的值是否有效(因为队列是从大大小排的,所以队首是最大的,但是又可能是无效的,所以要先提出)
            //其实这里可以用if.因为上次是有效的,这次理论上只要挪动一个就行了
            if (queue.peek() <= i-k){
                queue.poll();
            }

            // 当窗口长度为k时 保存当前窗口中最大值
            if(i + 1 >= k){
                //这里只能用peek,因为这一次的有效值,可能在下一次中还是有效的
                res[i + 1- k] = nums[queue.peek()];
            }
        }
        return res;
    }
}

package algorithm.leetcode.greedy;

import java.util.*;

/**
 * 218. 天际线问题
 * @author: xiongyayun
 * @date: 2021/7/13 8:04
 */
public class TheSkylineProblem218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return Collections.emptyList();
        }
        //先将建筑物按照右边界升序排列
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            pq.offer(new int[] { building[0], -building[2] });
            pq.offer(new int[] { building[1], building[2] });
        }

        LinkedList<List<Integer>> res = new LinkedList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);

        int left, height = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[1] < 0) {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } else {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0) heights.remove(arr[1]);
            }
            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }

        return res;
    }

}

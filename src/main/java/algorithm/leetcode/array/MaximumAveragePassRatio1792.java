package algorithm.leetcode.array;

import java.util.PriorityQueue;

/**
 * 1792. 最大平均通过率
 */
public class MaximumAveragePassRatio1792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> {

            double x = ((o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1]);
            double y = ((o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1]);
            if (x > y) return 1;
            if (x < y) return -1;
            return 0;
        });

        for (int[] c: classes) {
            queue.add(new double[]{c[0], c[1]});
        }

        while(extraStudents > 0){
            double[] maxClass = queue.poll(); //取出能够产生最大影响的班级
            maxClass[0] += 1.0; //通过的人数
            maxClass[1] += 1.0; //班级总人数
            queue.add(maxClass);
            extraStudents--;
        }
        double res = 0.0;
        while (!queue.isEmpty()) {
            double[] poll = queue.poll();
            res += poll[0] / poll[1];
        }
        return res / classes.length;
    }

}

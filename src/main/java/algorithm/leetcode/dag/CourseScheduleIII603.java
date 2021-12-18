package algorithm.leetcode.dag;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: xiongyayun
 * @date: 2021/12/14 8:30
 */
public class CourseScheduleIII603 {

    public int scheduleCourse(int[][] courses) {
        //按照最晚结束时间排序
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (ti + total <= di){
                total += ti;
                q.offer(ti);
            }else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }
        return q.size();
    }

}

package algorithm.leetcode.dag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 * @author: xiongyayun
 * @date: 2021/12/14 20:57
 */
public class CourseScheduleII210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        //构建入度表
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        //初始化,把没有依赖的课程加进去
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        int[] res = new int[numCourses];  // 可以学完的课程
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[i++] = pre;
            //所有依赖当前课程前置的课程
            for(int cur : adjacency.get(pre)) {
                if(--indegrees[cur] == 0) queue.add(cur);
            }
        }
        if (i == numCourses) {
            return res;
        }
        return new int[0];
    }

}

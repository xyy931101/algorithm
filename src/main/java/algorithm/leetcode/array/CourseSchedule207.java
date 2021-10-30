package algorithm.leetcode.array;

import java.util.*;

/**
 * @author: xiongyayun
 * @date: 2021/10/30 15:14
 */
public class CourseSchedule207 {


    public static void main(String[] args) {
        CourseSchedule207 c = new CourseSchedule207();
        System.out.println(c.canFinish(2, new int[][]{{1, 0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        // 一个编号 对应 一个课的实例
        HashMap<Integer, Course> nodes = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];
            if (!nodes.containsKey(to)) {
                nodes.put(to, new Course(to));
            }
            if (!nodes.containsKey(from)) {
                nodes.put(from, new Course(from));
            }
            Course t = nodes.get(to);
            Course f = nodes.get(from);
            t.in++;
            f.next.add(t);
        }

        int needPrerequisiteNums = nodes.size();
        Queue<Course> zeroInQueue = new LinkedList<>();

        //先将入度为0的加入队列
        for (Course node : nodes.values()) {
            if (node.in == 0) zeroInQueue.add(node);
        }
        int count = 0;
        while (!zeroInQueue.isEmpty()) {
            count++;
            Course cur = zeroInQueue.poll();
            for (Course course : cur.next) {
                course.in--;
                if (course.in == 0) {
                    zeroInQueue.add(course);
                }
            }
        }
        return count == needPrerequisiteNums;
    }

    //这个相对来说优化了空间复杂度
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        //构建入度表
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // 将入度为0的课程加入队列
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }

    public static class Course {
        public int name;
        public int in;
        public List<Course> next;

        public Course(int n) {
            name = n;
            in = 0;
            next = new ArrayList<>();
        }
    }

}

package algorithm.leetcode.dag;

import java.util.*;

/**
 * @author: xiongyayun
 * @date: 2021/10/30 15:14
 */
public class CourseSchedule207 {


    public static void main(String[] args) {
        CourseSchedule207 c = new CourseSchedule207();
        System.out.println(c.canFinish(5, new int[][] {{1,4}, {2,4},{3,1},{3,2}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        // 一个编号 对应 一个课的实例
        int[] in = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<Integer>());
        }

        for(int[] cp : prerequisites){
            in[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        Deque<Integer> deque = new LinkedList<Integer>();

        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0) deque.add(i);
        }

        while(!deque.isEmpty()){
            int pre = deque.poll();
            numCourses--;
            for(int cur : adjacency.get(pre)) {
                if(--in[cur] == 0) deque.add(cur);
            }
        }
        return numCourses <= 0;
    }

}

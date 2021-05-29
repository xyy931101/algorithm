package algorithm.leetcode.dynamic;

import java.util.Arrays;

/**
 * 621. 任务调度器
 * @author xiongyayun
 * @date 2021/5/9 23:42
 */
public class TaskScheduler621 {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        //构建26个字母的下标
        int[] temp = new int[26];
        //找出出现次数最大的任务
        int maxTask = 0;
        for(char c : tasks){
            temp[c - 'A']++;
            maxTask = Math.max(temp[c - 'A'],maxTask);
        }

        Arrays.sort(temp);
        // bucket size
        int bz = temp[25];
        //
        int cnt = 0;

        for(int i= 25; i >=0; i--){
            if(temp[i] != bz) break;
            cnt++;
        }
        return Math.max(tasks.length , cnt + (n+1) * (bz - 1));
    }

}

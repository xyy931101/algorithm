package algorithm.leetcode.matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author: xiongyayun
 * @date: 2021/6/24 11:29 下午
 */
public class QueueReconstructionByHeight406 {

    public int[][] reconstructQueue(int[][] people) {
        //先按照身高,下标位置进行升序排列
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });

        int n = people.length;
        int[][] ans = new int[n][];

        for (int[] person : people) {
            //获取到当前people前面需要多少个位置
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    spaces--;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int[][] reconstructQueue_best(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }
}

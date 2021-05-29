package algorithm.leetcode.array;

import java.util.*;

/**
 * 554. 砖墙
 * @Author: Xiongyy
 * @Date: 2021/5/2 17:58
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class BrickWall554 {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> one = Arrays.asList(1,1);
        List<Integer> two = Arrays.asList(2);
        List<Integer> three = Arrays.asList(1,1);
        wall.add(one);
        wall.add(two);
        wall.add(three);

        BrickWall554 b = new BrickWall554();
        System.out.println(b.leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {
        //用于记录最大的缝隙值
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        //计算出最多的缝隙的值
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }
}

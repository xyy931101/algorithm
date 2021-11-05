package algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * @author: xiongyayun
 * @date: 2021/11/1 8:29
 */
public class DistributeCandies575 {

    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length == 0) return 0;

        //先将糖果排序,同类型的糖果就是在一起了
        Set<Integer> types = new HashSet<>();
        for (int candy : candyType) {
            types.add(candy);
        }
        return Math.min(candyType.length / 2, types.size());
    }

}

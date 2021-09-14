package algorithm.leetcode.matrix;

import java.util.HashMap;

/**
 * 447. 回旋镖的数量
 * @author: xiongyayun
 * @date: 2021/9/13 8:24
 */
public class NumberOfBoomerangs447 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length; i++){
            //构建所有点到自己这个点的距离表
            HashMap<Integer, Integer> disCount = new HashMap<>();

            for(int j = 0; j < points.length; j++){
                //分别计算出X轴,Y轴的距离,之后求平方和
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int dis = dx * dx + dy * dy;
                //计算距离平方和的个数
                disCount.put(dis, disCount.getOrDefault(dis, 0) +1);
            }
            //得出每个相同的距离的数量(其中也包括自己的为0的数据,但是对结果无影响)
            for(int count : disCount.values()){
                res = res + count * (count -1);
            }
        }
        return res;
    }
}

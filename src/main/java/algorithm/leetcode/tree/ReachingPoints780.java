package algorithm.leetcode.tree;

/**
 * 780. 到达终点
 * @author: xiongyayun
 * @date: 2022/2/13 10:53
 */
public class ReachingPoints780 {


    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while(tx > sx && ty > sy){
            if (tx > ty){
                tx = tx % ty;
            }else {
                ty = ty % tx;
            }
        }
        return (tx == sx && ty >= sy && (ty - sy) % sx == 0) ||
                (ty == sy && tx >= sx && (tx - sx) % ty == 0);
    }

}

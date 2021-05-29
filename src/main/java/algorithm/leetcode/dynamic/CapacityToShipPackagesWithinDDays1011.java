package algorithm.leetcode.dynamic;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * @Author: Xiongyy
 * @Date: 2021/4/26 8:36
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class CapacityToShipPackagesWithinDDays1011 {

    public static void main(String[] args) throws InterruptedException {
        CapacityToShipPackagesWithinDDays1011 c = new CapacityToShipPackagesWithinDDays1011();
        c.shipWithinDays(new int[10], 10);
    }

    public int shipWithinDays(int[] weights, int D) throws InterruptedException {
        int max = Arrays.stream(weights).max().getAsInt();

        int sum = Arrays.stream(weights).sum();
        StringBuffer s = new StringBuffer();
        StringBuilder builder = new StringBuilder();

        CountDownLatch count = new CountDownLatch(3);


        new Thread(() ->{
            for (int i = 0; i < 1000; i++) {
                builder.append("A");
            }
            count.countDown();
        }).start();

        new Thread(() ->{
            for (int i = 0; i < 1000; i++) {
                builder.append("B");
            }
            count.countDown();
        }).start();

        new Thread(() ->{
            for (int i = 0; i < 1000; i++) {
                builder.append("C");
            }
            count.countDown();
        }).start();

        count.await();
        System.out.println(builder.toString());
        return 0;
    }
}

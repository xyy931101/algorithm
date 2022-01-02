package algorithm.limit;

import java.util.stream.IntStream;

/**
 * 限流器
 * @author: xiongyayun
 * @date: 2022/1/2 14:42
 */
public class MyLimiter implements IRateLimiter {

    private static final long oneSecond = 1 * 1000 * 1000 * 1000L;
    private final double qps;
    private final double nanoSecondsPerToken;
    private double tokenBucket;
    private long timeBeginToCreateToken;
    public MyLimiter(double qps) {
        this.qps =  qps;
        //现有的令牌数量
        this.tokenBucket = qps;
        // 生成一个令牌需要的微妙数
        this.nanoSecondsPerToken = oneSecond / qps;
        this.timeBeginToCreateToken = System.nanoTime();
    }

    public static void main(String[] args) {
        MyLimiter limiter = new MyLimiter(2.0);
        StringBrotherLimiter stringBrotherLimiter = new StringBrotherLimiter(2.0);
        IntStream.range(0, 5).forEach(i ->{
            System.out.println("第几个" + i + " and result:" + limiter.tryAcquire());
            System.out.println("第几个" + i + " and result:" + stringBrotherLimiter.tryAcquire());
            System.out.println();
        });
    }

    @Override
    public boolean tryAcquire() {
        synchronized (this) {
            long nanoTime = System.nanoTime();
            //当前时间能有多少令牌
            double newToken = (nanoTime - timeBeginToCreateToken) / nanoSecondsPerToken;
            tokenBucket = Math.min(qps, newToken + tokenBucket);
            //如果已经超过了之前时间的时间间隔,重置
            if (timeBeginToCreateToken + nanoTime < nanoTime) {
                timeBeginToCreateToken = nanoTime;
            }
            if (tokenBucket > 0) {
//                System.out.println("tokenBucket = " + tokenBucket);
                tokenBucket = tokenBucket - 1;
                return true;
            } else {
                return false;
            }
        }
    }
}
